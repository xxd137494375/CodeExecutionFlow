package com.xxd.codeexecutionflow.executionflow.base1;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.GenericTypeResolver;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public abstract class AbstractBuilderProcess<T, M> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBuilderProcess.class);
    private Map<Class, Field> FIELD_MAP = Maps.newHashMap();
    private final Class<T> genericType;

    public AbstractBuilderProcess() {
        Class<?>[] genericTypes = GenericTypeResolver.resolveTypeArguments(getClass(), AbstractBuilderProcess.class);
        genericType = (Class<T>) genericTypes[0];
        for (Field field : genericType.getDeclaredFields()) {
            field.setAccessible(true);
            FIELD_MAP.put(field.getType(), field);
        }

    }

    public abstract void preProcess(BaseContext baseContext) throws BaseBusinessException;

    public abstract BaseFeature initFeature(BaseContext baseContext);

    public abstract List<ComponentBuilder> getComponentBuilder(BaseContext baseContext, BaseFeature baseFeature);

    public abstract void fetchData(BaseContext baseContext, BaseFeature baseFeature) throws BaseBusinessException;

    public abstract M convertResponse(T t, BaseContext baseContext, BaseFeature baseFeature);

    public abstract void postProcess(M response, T componentData, BaseContext baseContext, BaseFeature baseFeature);

    public M execute(BaseContext baseContext) throws Exception {
        preProcess(baseContext);
        BaseFeature baseFeature = initFeature(baseContext);
        fetchData(baseContext, baseFeature);
        List<ComponentBuilder> componentBuilderList = getComponentBuilder(baseContext, baseFeature);
        T t = getComponentData(componentBuilderList, baseContext, baseFeature);
        M m = convertResponse(t, baseContext, baseFeature);
        postProcess(m, t, baseContext, baseFeature);
        return m;
    }

    private T getComponentData(List<ComponentBuilder> componentBuilderList, BaseContext baseContext, BaseFeature baseFeature) throws Exception {
        T t = genericType.newInstance();
        for (ComponentBuilder componentBuilder : componentBuilderList) {
            Object result = null;
            result = componentBuilder.bulid(baseContext, baseFeature);

            Class<?> aClass = result.getClass();
            Field field = FIELD_MAP.get(aClass);
            if (field != null) {
                ReflectionUtils.setField(field, t, result);
            }
        }
        return t;
    }

    public List<Field> getResultFieldList() {
        return Lists.newArrayList(FIELD_MAP.values());
    }
}