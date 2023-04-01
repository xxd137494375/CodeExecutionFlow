package com.xxd.codeexecutionflow.executionflow.base1.platform.build;

import com.xxd.codeexecutionflow.executionflow.base1.platform.context.BaseContext;
import com.xxd.codeexecutionflow.executionflow.base1.platform.feature.BaseFeature;

public interface ComponentBuilder<T> {

    T bulid(BaseContext baseContext, BaseFeature baseFeature) throws Exception;

    boolean isNeed();
}
