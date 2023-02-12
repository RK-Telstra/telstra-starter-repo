package stepDefinitions;

import au.com.telstra.simcardactivator.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.java.en.Given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;
    private JsonPayload jsonPayload;

    @Given("a valid SIM Card ID has been provided")
    public void aValidSIMCardIDHasBeenProvided() {
        jsonPayload = new JsonPayload("1255789453849037777", "rkvalid@gurumail.com", false);
    }

    @Given("an invalid SIM Card ID has been provided")
    public void anInvalidSIMCardIDHasBeenProvided() {
        jsonPayload = new JsonPayload("8944500102198304826", "rkinvalid@gurumail.com", false);

    }

    @When("a request to activate SIM Card is submitted")
    public void aRequestToActivateSIMCardIsSubmitted() {
        this.restTemplate.postForObject("http://localhost:8080/activate", jsonPayload, String.class);

    }

    @Then("confirm valid SIM Card activation attempt status from database")
    public void confirmValidSIMCardActivationAttemptStatusFromDatabase() {
        var jsonPayload = this.restTemplate.getForObject("http://localhost:8080/query?simCardId={simCardId}", JsonPayload.class, 1);
        assertTrue(jsonPayload.getActive());
    }

    @Then("confirm invalid SIM Card activation attempt status from database")
    public void confirmInvalidSIMCardActivationAttemptStatusFromDatabase() {
        var jsonPayload = this.restTemplate.getForObject("http://localhost:8080/query?simCardId={simCardId}", JsonPayload.class, 2);
        assertFalse(jsonPayload.getActive());
    }
}