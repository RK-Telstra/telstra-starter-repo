package au.com.telstra.simcardactivator;


import org.springframework.web.bind.annotation.*;


@RestController
public class SimCardController {

    private final DatabaseConduit databaseConduit;
    private final ResponseActuatorHandler responseActuatorHandler;


    public SimCardController(DatabaseConduit databaseConduit, ResponseActuatorHandler responseActuatorHandler){
        this.databaseConduit = databaseConduit;
        this.responseActuatorHandler = responseActuatorHandler;
    }

    @PostMapping(value = "/activate")
    public void handleActivationRequest(@RequestBody JsonPayload jsonPayload) {
        var actuationResult = responseActuatorHandler.actuate(jsonPayload);
        System.out.println(actuationResult.getSuccess());
        databaseConduit.save(jsonPayload, actuationResult);

        }
    
    @GetMapping(value = "/query")
    public JsonPayload getCustomerDateByID(@RequestParam Long simCardId){
        return databaseConduit.querySimcard(simCardId);

    }


}

