package com.xxd.codeexecutionflow.executionflow.base1;

import com.xxd.codeexecutionflow.executionflow.base1.platform.feature.BaseFeature;
import com.xxd.codeexecutionflow.executionflow.base1.platform.build.ComponentBuilder;
import com.xxd.codeexecutionflow.executionflow.base1.platform.context.BaseContext;

public class TestComponentBuilder implements ComponentBuilder<TestInfo> {
    @Override
    public TestInfo bulid(BaseContext baseContext, BaseFeature baseFeature) throws Exception {
        TestInfo testInfo = new TestInfo();
        return testInfo;
    }

    @Override
    public boolean isNeed() {
        return true;
    }
}
