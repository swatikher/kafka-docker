package com.example.actuatorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.*;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

@Component
public class ServiceAHealthIndicator   implements HealthIndicator {

  private final String message_key = "Service A";
    
  @Override
  public Health health() {
    if (!isRunningServiceA()) {
      return Health.down().withDetail(message_key, "Not Available").build();
    }
    return Health.up().withDetail(message_key, "Available").build();
  }

  private Boolean isRunningServiceA() {
    Boolean isRunning = true;
    // Logic Skipped

    return isRunning;
  }
}
