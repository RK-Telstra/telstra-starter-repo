package au.com.telstra.simcardactivator;


import au.com.telstra.simcardactivator.JsonPayload;
import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class SimCardController {

    private final ResponseActuatorHandler responseActuatorHandler;

    @Autowired
    private CustomerDataRepository customerDataRepository;

    public SimCardController(ResponseActuatorHandler responseActuatorHandler){
        this.responseActuatorHandler = responseActuatorHandler;
    }

    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody JsonPayload jsonPayload) {
        var actuationResult = responseActuatorHandler.actuate(jsonPayload);
        System.out.println(actuationResult.getSuccess());

    customerDataRepository.save(new CustomerData(jsonPayload.getIccid(), jsonPayload.getCustomerEmail(), jsonPayload.getActive()));

    }
    
    @GetMapping("/customerdata/{id}")
    public ResponseEntity < CustomerData > getCustomerDateByID(@PathVariable(value = "id") Long simCardId)
            throws ResourceNotFoundException {
                CustomerData customerData = customerDataRepository.findById(simCardId)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found for this entry :: " + simCardId));
            return ResponseEntity.ok().body(customerData);
    }

    //@GetMapping("/customerdata/{id}")
    //public ResponseEntity<CustomerData> getCustomerDateByID(@PathVariable(value = "id") Long simCardId) {
        //Optional<CustomerData> customerData = customerDataRepository.findById(simCardId);
        //return ResponseEntity.of(customerData);
    //}


}

