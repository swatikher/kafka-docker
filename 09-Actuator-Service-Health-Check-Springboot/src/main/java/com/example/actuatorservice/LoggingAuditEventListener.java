package com.example.actuatorservice;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoggingAuditEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger("AuditLogger");

  @EventListener
  public void on(AuditApplicationEvent event) {
    Map<String, String> backup = MDC.getCopyOfContextMap();
    MDC.put("event.type", event.getAuditEvent().getType());
    MDC.put("event.principal", event.getAuditEvent().getPrincipal());

    LOGGER.info("An Audit Event was received: {}", event);

    if (backup != null) {
      MDC.setContextMap(backup);
    }
  }

}
