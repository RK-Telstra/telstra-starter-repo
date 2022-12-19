package au.com.telstra.simcardactivator;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimCardController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/activate")
    public JsonPayload activate(@RequestParam(required = false) String iccid, @RequestParam(required = false) String customerEmail) {
        return new JsonPayload(counter.incrementAndGet(), iccid, customerEmail);
    }
}
