package timecard.mocks;

import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.util.Arrays;

/**
 * {@link LambdaLogger} のモッククラスです。
 */
class LambdaLoggerMock implements LambdaLogger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }

    @Override
    public void log(byte[] message) {
        System.out.println(Arrays.toString(message));
    }
}
