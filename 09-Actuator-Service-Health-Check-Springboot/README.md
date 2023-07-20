# How to Compile 
<p><code>

mvn clean compile install org.springframework.boot:spring-boot-maven-plugin:build-info -DskipTests

mvn clean compile org.springframework.boot:spring-boot-starter-actuator -DskipTests

java -jar target/actuator-service-0.0.1-SNAPSHOT.jar 
</code></p>

# AUDIT LOGS
---------
Documentation https://www.jvt.me/posts/2022/01/13/spring-boot-actuator-audit/
<p><code>
java -Dmanagement.endpoints.web.exposure.include='*' -jar build/libs/boot-audit-actuator-0.1-SNAPSHOT.jar
</code></p>
# or just for the audit events
<p><code>
java -Dmanagement.endpoints.web.exposure.include='auditevents' -jar build/libs/boot-audit-actuator-0.1-SNAPSHOT.jar
</code></p>
<p>This then allows us to send a request to endpoint '/actuator/auditevents'</p>

# Endpoints - Health

<img title="Actuator Health" alt="Health Check Dashboard" src="/images/2023-07-20-actuator-health.png">

# Endpoints - Info

<img title="Actuator Info" alt="Info Dashboard" src="/images/2023-07-20-actuator-info.png">

# Actuator - metrics and threaddump

<img title="Actuator List Metrics" alt="Metrics Dashboard" src="/images/2023-07-20-actuator-metrics.png">


# Read Me First
---------------
The following was discovered as part of building this project:

* The original package name 'com.example.actuator-service' is invalid and this project uses 'com.example.actuatorservice' instead.

# Getting Started
------------------
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#actuator)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

