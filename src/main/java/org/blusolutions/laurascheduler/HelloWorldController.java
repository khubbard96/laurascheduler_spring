package org.blusolutions.laurascheduler;

import org.blusolutions.laura_scheduler.scheduler.SchedulerBuilder;
import org.blusolutions.laura_scheduler.scheduler.SchedulerUtil;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {


    @GetMapping(value = "/schedule", produces = "application/json")
    @CrossOrigin(origins = "http://localhost:3000")
    public String postController(
            @RequestParam(value = "benches", defaultValue = "{}") String benchesJson,
            @RequestParam(value = "operators", defaultValue = "{}") String operatorsJson,
            @RequestParam(value = "pins", defaultValue = "{}") String pinsJson
    ) {

        String r = SchedulerUtil
                .toJSON(
                        new SchedulerBuilder()
                                .withBenches(benchesJson)
                                .withOperators(operatorsJson)
                                .withPins(pinsJson)
                                .build()
                                .getOneRandomWeek()
                );

        return r;
    }

}
