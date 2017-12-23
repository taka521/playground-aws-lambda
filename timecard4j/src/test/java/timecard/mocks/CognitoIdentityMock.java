package timecard.mocks;

import com.amazonaws.services.lambda.runtime.CognitoIdentity;

/**
 * {@link CognitoIdentity} のモッククラスです。
 */
public class CognitoIdentityMock implements CognitoIdentity {

    private String identityId = "identityId";
    private String identityPoolId = "identityPoolId";

    @Override
    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    @Override
    public String getIdentityPoolId() {
        return identityPoolId;
    }

    public void setIdentityPoolId(String identityPoolId) {
        this.identityPoolId = identityPoolId;
    }
}
