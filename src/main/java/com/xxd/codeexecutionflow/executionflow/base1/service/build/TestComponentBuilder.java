package com.xxd.codeexecutionflow.executionflow.base1.service.build;

import com.xxd.codeexecutionflow.executionflow.base1.platform.feature.BaseFeature;
import com.xxd.codeexecutionflow.executionflow.base1.platform.build.ComponentBuilder;
import com.xxd.codeexecutionflow.executionflow.base1.platform.context.BaseContext;
import com.xxd.codeexecutionflow.executionflow.base1.service.TestInfo;

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
