package au.com.telstra.simcardactivator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPayload {
    private String iccid;
    private String customerEmail;
    private boolean active;

    public JsonPayload(){
    }
    public JsonPayload(String iccid, String customerEmail, boolean active){
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;

    }

    public JsonPayload(CustomerData customerData){
        this.iccid = customerData.getIccid();
        this.customerEmail = customerData.getCustomerEmail();
        this.active = customerData.getActive();
    }
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail){
        this.customerEmail = customerEmail;
    }

    public boolean getActive(){
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "JsonPayload {iccid=" + iccid + ", customerEmail=" + customerEmail + ", active=" + active + "}";
    }
}
