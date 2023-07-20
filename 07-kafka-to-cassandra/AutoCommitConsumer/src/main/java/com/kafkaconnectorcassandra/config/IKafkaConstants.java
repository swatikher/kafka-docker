package com.kafkaconnectorcassandra.config;

public interface IKafkaConstants {
    public static String KAFKA_BROKERS = "localhost:9092";
    public static Integer MESSAGE_COUNT = 1000;
    public static String CLIENT_ID = "consumer-1";
    public static String TOPIC_NAME = "swatiTest";
    public static String GROUP_ID_CONFIG = "mygroup";
    //public static Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;
    public static Integer MAX_NO_MESSAGE_FOUND_COUNT = 900;
    public static String OFFSET_RESET_LATEST = "latest";
    public static String OFFSET_RESET_EARLIER = "earliest";
    public static Integer MAX_POLL_RECORDS = 500;
    public static String CASSANDRA_PORT = "9042";
    public static String CASSANDRA_HOST = "127.0.0.1";

    public static String ENABLE_AUTO_COMMIT= "false";
    public static String AUTO_OFFSET_RESET= "earliest";
    public static String AUTO_COMMIT_INTERVAL_MS= "5000";
    public static String CHECK_CRCS= "true";

    public static String EXCLUDE_INTERNAL_TOPICS= "true";
    public static String FETCH_MAX_BYTES= "52428800";
    public static String FETCH_MAX_WAIT_MS= "500";
    public static String FETCH_MIN_BYTES= "1";
    public static String GROUP_ID= "mygroup";
    public static String HEARTBEAT_INTERVAL_MS= "3000";
    public static String MAX_PARTITION_FETCH_BYTES= "1048576";
    public static String MAX_POLL_INTERVAL_MS= "300000";

    public static String METADATA_MAX_AGE_MS= "300000";
    public static String METRICS_NUM_SAMPLES= "2";
    public static String METRICS_SAMPLE_WINDOW_MS= "30000";
    public static String RECEIVE_BUFFER_BYTES= "65536";
    public static String RECONNECT_BACKOFF_MS= "50";
    public static String REQUEST_TIMEOUT_MS= "305000";
    public static String RETRY_BACKOFF_MS= "100";
    public static String SESSION_TIMEOUT_MS= "10000";
    public static String SEND_BUFFER_BYTES= "131072";
    public static String SSL_KEY_PASSWORD= "null";
    public static String SSL_KEYSTORE_LOCATION= "null";
    public static String SSL_KEYSTORE_PASSWORD= "null";
    public static String SSL_KEYSTORE_TYPE= "JKS";
    public static String SSL_PROTOCOL= "TLS";
    public static String SSL_PROVIDER= "null";
    public static String SSL_SECURE_RANDOM_IMPLEMENTATION= "null";
    public static String SSL_TRUSTMANAGER_ALGORITHM= "PKIX";
    public static String SSL_TRUSTSTORE_LOCATION= "null";
    public static String SSL_TRUSTSTORE_PASSWORD= "null";
    public static String SSL_TRUSTSTORE_TYPE= "JKS";
    public static String PARTITION_ASSIGNMENT_STRATEGY= "org.apache.kafka.clients.consumer.RangeAssignor";
    public static String KEY_DESERIALIZER= "org.apache.kafka.common.serialozation.StringDeserializer";
}
