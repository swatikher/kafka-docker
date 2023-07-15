# Gently Down the Stream
A Gentle Introduction to Apache Kafka

git clone git@github.com:round-robin-books/gently-kafka.git

should start the following container

<p><code>
  docker compose up
[+] Running 2/0
 ⠿ Network gently-kafka_default                                                                                                                             Created 0.0s
 ⠿ Container gently_zookeeper                                                                                                                  [+] Running 3/4eated 0.0s
 ⠿ Network gently-kafka_default                                                                                                                             Created 0.0s
 ⠿ Container gently_zookeeper                                                                                                                               Created 0.0ss
 ⠋ zookeeper The requested image's platform (linux/amd64) does not match the detected host platform (linux/arm64/v8) and no specific platform was requested  0.0s
 ⠿ Container gently_kafka                                                                                                                                   Created 0.0s
 ⠋ kafka The requested image's platform (linux/amd64) does not match the detected host platform (linux/arm64/v8) and no specific platform was requested      0.0s
Attaching to gently_kafka, gently_zookeeper
gently_zookeeper  | ===> User
gently_zookeeper  | uid=1000(appuser) gid=1000(appuser) groups=1000(appuser)
gently_zookeeper  | ===> Configuring ...
gently_kafka      | ===> User
gently_kafka      | uid=1000(appuser) gid=1000(appuser) groups=1000(appuser)
gently_kafka      | ===> Configuring ...
gently_zookeeper  | ===> Running preflight checks ... 
gently_zookeeper  | ===> Check if /var/lib/zookeeper/data is writable ...
gently_zookeeper  | ===> Check if /var/lib/zookeeper/log is writable ...
gently_kafka      | ===> Running preflight checks ... 
gently_kafka      | ===> Check if /var/lib/kafka/data is writable ...
gently_zookeeper  | ===> Launching ... 
gently_zookeeper  | ===> Launching zookeeper ... 
gently_kafka      | ===> Check if Zookeeper is healthy ...
gently_kafka      | [2023-06-29 18:27:14,343] INFO [Broker id=1] Add 1 partitions and deleted 0 partitions from metadata cache in response to UpdateMetadata request sent by controller 1 epoch 1 with correlation id 2 (state.change.logger)
gently_kafka      | [2023-06-29 18:27:14,370] TRACE [Controller id=1 epoch=1] Received response {error_code=0,_tagged_fields={}} for request UPDATE_METADATA with correlation id 2 sent to broker kafka:9092 (id: 1 rack: null) (state.change.logger)
gently_kafka      | [2023-06-29 18:29:37,778] INFO [GroupMetadataManager brokerId=1] Removed 0 expired offsets in 3 milliseconds. (kafka.coordinator.group.GroupMetadataManager)
gently_kafka      | [2023-06-29 18:29:43,424] INFO [Controller id=1] Processing automatic preferred replica leader election (kafka.controller.KafkaController)
gently_kafka      | [2023-06-29 18:29:43,426] TRACE [Controller id=1] Checking need to trigger auto leader balancing (kafka.controller.KafkaController)
gently_kafka      | [2023-06-29 18:29:43,517] DEBUG [Controller id=1] Topics not in preferred replica for broker 1 Map() (kafka.controller.KafkaController)
gently_kafka      | [2023-06-29 18:29:43,582] TRACE [Controller id=1] Leader imbalance ratio for broker 1 is 0.0 (kafka.controller.KafkaController)

</code></p>

<p><b>And start creating topics and view topics!!</b></p>

<p><code>

bin/kafka-topics.sh --create --bootstrap-server localhost:29092 --replication-factor 1 --partitions 1 --topic perf

Created topic perf.

bin/kafka-topics.sh --list --bootstrap-server localhost:29092
perf
testOne
testTwo


</code></p>

