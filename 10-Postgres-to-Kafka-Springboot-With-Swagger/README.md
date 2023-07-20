# Prerequisites
- Sprinboot and Swagger Documentation https://www.springboottutorial.com/spring-boot-swagger-documentation-for-rest-services
- Install and start services for : postgres, pgadmin
- Create postgres table called 'users'

<img title="Postgres Table" alt="Users Table" src="/images/2023-07-20-Postgres-Tables.png">
<img title="Postgres Table" alt="Users Table" src="/images/2023-07-20-Postgres-Query.png">

- Start Kafka and create Topic called 'swatiTest2'
- Start a consumer on 'swatiTest2'

<img title="Kafka Consumer" alt="Messages in Kafka" src="/images/2023-07-20-Kafka-Messages.png">

# How To Compile and Run Springboot Producer with Swagger

<code>
mvn clean package
mvn spring-boot:run 
</code>
<p></p>
<p>It should start your app on the port specified in application.properties</p>
<p>server.port=9090</p>
<p><code>2023-07-20T13:30:29.257-07:00  INFO 44788 --- [  restartedMain] .s.r.e.SpringBoot2RestServiceApplication : Started SpringBoot2RestServiceApplication in 2.256 seconds (process running for 2.416)</code></p>

# Check Swagger-UI and endpoints - update Postgres should produce message to Kafka

<img title="Swagger API-DOC" alt="Swagger-UI" src="/images/2023-07-20-Swagger-UI-Springboot.png">

<p>Endpoint '/details' should retrieve messages from Users table in Postgres and produce to kafka</p>
<img title="Swagger API-DOC" alt="Swagger-UI" src="/images/2023-07-20-Producer-REST-API-to-Kafka.png">

# REST API - Insert into Postgres

<p>/kafka/api/helloworld inserts values 'UserRandomNumber' and 'DepartmentRandomNumber' into postgres table users</p>

<img title="REST API POSTGRES" alt="Swagger-UI" src="/images/2023-07-20-REST-API-Insert-Postgres.png">
