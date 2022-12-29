package au.com.telstra.simcardactivator;


import au.com.telstra.simcardactivator.JsonPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SimCardController {

    private final ResponseActuatorHandler responseActuatorHandler;

    public SimCardController(ResponseActuatorHandler responseActuatorHandler){
        this.responseActuatorHandler = responseActuatorHandler;
    }

    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody JsonPayload jsonPayload) {
        var actuationResult = responseActuatorHandler.actuate(jsonPayload);
        System.out.println(actuationResult.getSuccess());

    }
    



}

