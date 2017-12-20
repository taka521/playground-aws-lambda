package mocks;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

/**
 * {@link Context} のMockクラスです。<br/>
 * {@link ContextMock#get()} メソッドを使用して、インスタンスを取得してください。
 * なお、当クラスは単なるMockのため、各メソッドを呼び出しても null または 0 しか返りません。
 */
public class ContextMock implements Context {

    private ContextMock() {}

    public static ContextMock get() {
        return new ContextMock();
    }

    @Override
    public String getAwsRequestId() {
        return null;
    }

    @Override
    public String getLogGroupName() {
        return null;
    }

    @Override
    public String getLogStreamName() {
        return null;
    }

    @Override
    public String getFunctionName() {
        return null;
    }

    @Override
    public String getFunctionVersion() {
        return null;
    }

    @Override
    public String getInvokedFunctionArn() {
        return null;
    }

    @Override
    public CognitoIdentity getIdentity() {
        return null;
    }

    @Override
    public ClientContext getClientContext() {
        return null;
    }

    @Override
    public int getRemainingTimeInMillis() {
        return 0;
    }

    @Override
    public int getMemoryLimitInMB() {
        return 0;
    }

    @Override
    public LambdaLogger getLogger() {
        return null;
    }
}
