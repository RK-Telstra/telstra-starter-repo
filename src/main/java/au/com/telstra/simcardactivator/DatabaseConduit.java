package au.com.telstra.simcardactivator;

import org.springframework.stereotype.Component;

@Component

public class DatabaseConduit {
    private final CustomerDataRepository customerDataRepository;

    public DatabaseConduit(CustomerDataRepository customerDataRepository){
        this.customerDataRepository = customerDataRepository;

    }

    public void save(JsonPayload jsonPayload, ResponseActuator responseActuator) {
        CustomerData customerData = new CustomerData(jsonPayload, responseActuator );
        customerDataRepository.save(customerData);
    }

    public JsonPayload querySimcard(long simCardId) {
        var customerData = customerDataRepository.findById(simCardId).orElse(null);
        if (customerData == null){
            return null;
        }
        return new JsonPayload(customerData);
    }
}
