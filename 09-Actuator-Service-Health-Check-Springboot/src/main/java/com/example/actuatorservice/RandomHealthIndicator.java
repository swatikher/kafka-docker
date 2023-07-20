package com.example.actuatorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.*;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

@Component
public class RandomHealthIndicator implements HealthIndicator {
 @Override
    public Health health() {
        double chance = ThreadLocalRandom.current().nextDouble();
        //chance = Double.valueOf("4.22");
        //double chance = 5;
        Health.Builder status = Health.up();
        if (chance > 0.9) {
            status = Health.down();
        }

        Map<String, Object> details = new HashMap<>();
        details.put("chance", chance);
        details.put("stragegy", "therad-local");

        return status.withDetails(details).build();
    }
}
