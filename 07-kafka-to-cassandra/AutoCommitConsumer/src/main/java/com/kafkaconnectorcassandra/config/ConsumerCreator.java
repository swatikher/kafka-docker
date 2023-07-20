package com.kafkaconnectorcassandra.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.Properties;
import com.kafkaconnectorcassandra.config.IKafkaConstants;

public class ConsumerCreator {

    public static Consumer<String, String> createConsumer() {
        Properties config = new Properties();
        //String kafkaBroker = System.getenv("BROKERURL");
        //String topicName = System.getenv("TOPICNAME");

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKERS);
        //config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBroker);
        //config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, System.getenv("BROKERURL"));
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, IKafkaConstants.GROUP_ID_CONFIG);
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, IKafkaConstants.OFFSET_RESET_EARLIER);
        config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, IKafkaConstants.MAX_POLL_RECORDS);

        Consumer<String, String> consumer = new KafkaConsumer(config);
        //consumer.subscribe(Collections.singletonList(IKafkaConstants.TOPIC_NAME));
        consumer.subscribe(Collections.singletonList("swatiTest"));
        //consumer.subscribe(Collections.singletonList(System.getenv("TOPICNAME")));
        return consumer;
    }

}
