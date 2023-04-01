package com.xxd.codeexecutionflow.executionflow.base1.service;

import com.xxd.codeexecutionflow.executionflow.base1.platform.AbstractBuilderProcess;
import com.xxd.codeexecutionflow.executionflow.base1.platform.build.ComponentBuilder;
import com.xxd.codeexecutionflow.executionflow.base1.platform.context.BaseContext;
import com.xxd.codeexecutionflow.executionflow.base1.platform.exception.BaseBusinessException;
import com.xxd.codeexecutionflow.executionflow.base1.platform.feature.BaseFeature;
import com.xxd.codeexecutionflow.executionflow.base1.service.context.TestContext;

import java.util.List;

public class TestService extends AbstractBuilderProcess<TestVO,TestVO> {

    public TestVO test() throws Exception {
        TestContext testContext = new TestContext();
        TestVO testVO = execute(testContext);
        return testVO;
    }

    @Override
    public void preProcess(BaseContext baseContext) throws BaseBusinessException {

    }

    @Override
    public BaseFeature initFeature(BaseContext baseContext) {
        return null;
    }

    @Override
    public List<ComponentBuilder> getComponentBuilder(BaseContext baseContext, BaseFeature baseFeature) {
        return null;
    }

    @Override
    public void fetchData(BaseContext baseContext, BaseFeature baseFeature) throws BaseBusinessException {

    }

    @Override
    public TestVO convertResponse(TestVO testVO, BaseContext baseContext, BaseFeature baseFeature) {
        return null;
    }

    @Override
    public void postProcess(TestVO response, TestVO componentData, BaseContext baseContext, BaseFeature baseFeature) {

    }
}
