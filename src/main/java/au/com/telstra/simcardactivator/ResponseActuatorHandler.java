package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.ResponseActuator;
import au.com.telstra.simcardactivator.JsonPayload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@Component
public class ResponseActuatorHandler {
    private final RestTemplate restTemplate;
    private final String incentiveApiUrl;

    public ResponseActuatorHandler(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
        this.incentiveApiUrl = "http://localhost:8444/actuate";
    }

    public ResponseActuator actuate(JsonPayload jsonPayload) {
        return restTemplate.postForObject(incentiveApiUrl, jsonPayload, ResponseActuator.class);
    }
}
