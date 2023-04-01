package com.xxd.codeexecutionflow.executionflow.base1;

public interface ComponentBuilder<T> {

    T bulid(BaseContext baseContext, BaseFeature baseFeature) throws Exception;

    boolean isNeed();
}
