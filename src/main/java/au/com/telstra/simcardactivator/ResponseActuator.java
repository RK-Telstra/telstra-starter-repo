package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseActuator {
    private boolean success;

    public ResponseActuator(){
    }

    public ResponseActuator(boolean success){
        this.success = success;
    }
    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseActuator {success=" + success + "}";

    }
}
