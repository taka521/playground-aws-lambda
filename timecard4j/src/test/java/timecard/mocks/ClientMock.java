package timecard.mocks;

import com.amazonaws.services.lambda.runtime.Client;

/**
 * {@link Client} のモッククラスです。
 */
public class ClientMock implements Client {

    private String installationId = "installationId";
    private String appTitle = "appTitle";
    private String appVersionName = "appVersionName";
    private String appVersionCode = "appVersionCode";
    private String appPackageName = "appPackageName";

    @Override
    public String getInstallationId() {
        return installationId;
    }

    public void setInstallationId(String installationId) {
        this.installationId = installationId;
    }

    @Override
    public String getAppTitle() {
        return appTitle;
    }

    public void setAppTitle(String appTitle) {
        this.appTitle = appTitle;
    }

    @Override
    public String getAppVersionName() {
        return appVersionName;
    }

    public void setAppVersionName(String appVersionName) {
        this.appVersionName = appVersionName;
    }

    @Override
    public String getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(String appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    @Override
    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }
}
