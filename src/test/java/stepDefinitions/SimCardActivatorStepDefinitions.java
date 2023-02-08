package stepDefinitions;

import au.com.telstra.simcardactivator.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.java.en.Given;
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    @Given("Valid SIM Card ID has been provided attempt activation")
    public void validSIMCardIDHasBeenProvided() {
        String validsim;
        validsim = "1255789453849037777";
        String activateurl;
        activateurl = "http://localhost:8080/activate";
        JsonPayload validsimObject = new JsonPayload();
        validsimObject.setIccid(validsim);
        var activate1 = restTemplate.postForObject(activateurl, validsimObject, Void.class);
    }

    @Then("Confirm result of Valid SIM Card activation")
    public void attemptToActivateValidSIMCard() {
        String validsimquery;
        validsimquery = "http://localhost:8080/query?simCardId=1";
        var queryEntry1 = restTemplate.getForObject(validsimquery, ResponseActuator.class);
        System.out.println(queryEntry1);

    }


    @Given("Invalid SIM Card ID has been provided attempt activation")
    public void invalidSIMCardIDHasBeenProvidedAttemptActivation() {
        String invalidsim;
        invalidsim = "8944500102198304826";
        String activateurl;
        activateurl = "http://localhost:8080/activate";
        JsonPayload invalidsimObject = new JsonPayload();
        invalidsimObject.setIccid(invalidsim);
        var activate2 = restTemplate.postForObject(activateurl, invalidsimObject, Void.class);
    }

    @Then("Confirm result of Invalid SIM Card activation")
    public void confirmResultOfInvalidSIMCardActivation() {
        String invalidsimquery;
        invalidsimquery = "http://localhost:8080/query?simCardId=2";
        var queryEntry2 = restTemplate.getForObject(invalidsimquery, ResponseActuator.class);
        System.out.println(queryEntry2);

    }


}