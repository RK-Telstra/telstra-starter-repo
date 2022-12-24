package au.com.telstra.simcardactivator;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimCardController {

    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(ResponseActuator.class);

    @GetMapping("/activate")
    public JsonPayload activate(@RequestParam(required = false) String iccid, @RequestParam(required = false) String customerEmail) {
        return new JsonPayload(counter.incrementAndGet(), iccid, customerEmail);

    }
    
    JsonPayload sendInfo = new JsonPayload();
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            ResponseActuator responseActuator = restTemplate.postForObject(
                    "http://localhost:8444/actuate", JsonPayload.iccid, ResponseActuator.class);

            log.info(responseActuator.toString());

        };
    }

}

