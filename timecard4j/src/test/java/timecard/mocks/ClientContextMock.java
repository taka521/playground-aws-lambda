package timecard.mocks;

import com.amazonaws.services.lambda.runtime.Client;
import com.amazonaws.services.lambda.runtime.ClientContext;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link ClientContext} のモッククラスです。
 */
public class ClientContextMock implements ClientContext {

    private Client client = new ClientMock();
    private Map<String, String> custom = new HashMap<>();
    private Map<String, String> environment = new HashMap<>();

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public Map<String, String> getCustom() {
        return custom;
    }

    @Override
    public Map<String, String> getEnvironment() {
        return environment;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCustom(Map<String, String> custom) {
        this.custom = custom;
    }

    public void setEnvironment(Map<String, String> environment) {
        this.environment = environment;
    }
}
