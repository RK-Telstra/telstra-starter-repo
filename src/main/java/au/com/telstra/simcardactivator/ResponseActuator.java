package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseActuator {
    private boolean success;

    public ResponseActuator(){
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success){
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseActuator{" +
                "success='" + success + '\'' + '}';

    }
}
