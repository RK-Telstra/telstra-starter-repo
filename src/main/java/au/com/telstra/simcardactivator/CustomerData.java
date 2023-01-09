package au.com.telstra.simcardactivator;


import javax.persistence.*;


@Entity
public class CustomerData {

    @Id
    @GeneratedValue()
    private Long id;
    @Column(nullable = false)
    private String iccid;

    @Column(nullable = false)
    private String customerEmail;
    @Column(nullable = false)
    private Boolean active;

    protected CustomerData() {

    }

    public CustomerData(JsonPayload jsonPayload, ResponseActuator responseActuator) {
        this.iccid = jsonPayload.getIccid();
        this.customerEmail = jsonPayload.getCustomerEmail();
        this.active = responseActuator.getSuccess();
    }


    public Long getId() {
        return id;
    }

    public String getIccid() {
        return iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Boolean getActive() {
        return active;
    }

    @Override
    public String toString() {
        return "CustomerData {id=" + id + ", iccid=" + iccid + ", customerEmail=" + customerEmail + ", active=" + active + ")";
    }
}
