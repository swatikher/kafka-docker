<code>
spring:
    kafka:
        consumer:
          bootstrap-servers: localhost:9092
          group-id: mygroup
          auto-offset-reset: earliest
          key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
          value-dserializer: org.apache.kafka.common.serialization.StringDeserializer

topics = "swatiTest2"

java -jar target/SpringBootApacheKafkaHelloWorld-0.0.1-SNAPSHOT.jar
</code>
