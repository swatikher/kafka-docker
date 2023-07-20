package com.example.actuatorservice;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;

public class HttpRequestReceivedEvent extends AuditApplicationEvent {
  public HttpRequestReceivedEvent(HttpServletRequest request, String correlationId) {
    super(principal(request), "HTTP_REQUEST_RECEIVED", details(request, correlationId));
  }

  private static String principal(HttpServletRequest request) {
    return Optional.ofNullable(request.getUserPrincipal())
        .map(Principal::getName)
        .orElse("anonymousUser");
  }

  private static Map<String, Object> details(HttpServletRequest request, String correlationId) {
    Map<String, Object> details = new HashMap<>();
    details.put("http.correlationId", correlationId);
    details.put("http.method", request.getMethod());
    // other details here
    return details;
  }
}
