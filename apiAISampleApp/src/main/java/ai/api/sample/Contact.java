package ai.api.sample;

/**
 * Created by Samela Candido on 9/26/2017.
 */

public class Contact {
    int id;
    String ParameterValue,ParameterKey;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setParameterKey(String parameterKey) {
        ParameterKey = parameterKey;
    }

    public String getParameterKey() {
        return ParameterKey;
    }

    public void setParameterValue(String parameterValue) {
        ParameterValue = parameterValue;
    }

    public String getParameterValue() {
        return ParameterValue;
    }
}
