package au.com.telstra.simcardactivator;

public class JsonPayload {

    private final long id;
    public final String iccid;
    private final String customerEmail;

    public JsonPayload(long id, String iccid, String customerEmail){
        this.id = id;
        this.iccid = iccid;
        this.customerEmail = customerEmail;

    }

    public long getId() {
        return id;
    }

    public String getIccid() {
        return iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}
