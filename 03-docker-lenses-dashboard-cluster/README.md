# Lenses Dashboard
Kafka Cluster with Lenses

docker pull landoop/fast-data-dev:latest

should start the following container on [localhost:3030](http://localhost:3030/)

<img title="Lenses Dashboard" alt="Kafka Dashboard" src="/images/2023-07-12-Lenses-Dashboard.png">

<p><code>
  docker compose up
  
[+] Running 2/0
 ⠿ Network mydocker_default            Created                                                                                                      0.0s
 ⠿ Container mydocker-kafka-cluster-1  Created                                                                                                      0.0s
Attaching to mydocker-kafka-cluster-1
mydocker-kafka-cluster-1  | Setting advertised host to 127.0.0.1.
mydocker-kafka-cluster-1  | Starting services.
mydocker-kafka-cluster-1  | This is Lenses.io’s fast-data-dev. Kafka 3.3.1-L0 (Lenses.io's Kafka Distribution).
mydocker-kafka-cluster-1  | You may visit http://127.0.0.1:3030 in about a minute.
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,944 INFO Included extra file "/etc/supervisord.d/01-zookeeper.conf" during parsing
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,944 INFO Included extra file "/etc/supervisord.d/02-broker.conf" during parsing
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,944 INFO Included extra file "/etc/supervisord.d/03-schema-registry.conf" during parsing
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,944 INFO Included extra file "/etc/supervisord.d/04-rest-proxy.conf" during parsing
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,944 INFO Included extra file "/etc/supervisord.d/05-connect-distributed.conf" during parsing
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,944 INFO Included extra file "/etc/supervisord.d/06-caddy.conf" during parsing
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,944 INFO Set uid to user 0 succeeded
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,946 INFO RPC interface 'supervisor' initialized
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,946 CRIT Server 'unix_http_server' running without any HTTP authentication checking
mydocker-kafka-cluster-1  | 2023-07-12 14:15:14,946 INFO supervisord started with pid 7
mydocker-kafka-cluster-1  | 2023-07-12 14:15:15,957 INFO spawned: 'broker' with pid 189
mydocker-kafka-cluster-1  | 2023-07-12 14:15:15,966 INFO spawned: 'caddy' with pid 190
mydocker-kafka-cluster-1  | 2023-07-12 14:15:15,972 INFO spawned: 'connect-distributed' with pid 191
mydocker-kafka-cluster-1  | 2023-07-12 14:15:15,975 INFO spawned: 'rest-proxy' with pid 192
mydocker-kafka-cluster-1  | 2023-07-12 14:15:15,978 INFO spawned: 'schema-registry' with pid 194
mydocker-kafka-cluster-1  | 2023-07-12 14:15:15,980 INFO spawned: 'zookeeper' with pid 200
mydocker-kafka-cluster-1  | 2023-07-12 14:15:17,013 INFO success: broker entered RUNNING state, process has stayed up for > than 1 seconds (startsecs)
mydocker-kafka-cluster-1  | 2023-07-12 14:15:17,013 INFO success: caddy entered RUNNING state, process has stayed up for > than 1 seconds (startsecs)
mydocker-kafka-cluster-1  | 2023-07-12 14:15:17,013 INFO success: connect-distributed entered RUNNING state, process has stayed up for > than 1 seconds (startsecs)
mydocker-kafka-cluster-1  | 2023-07-12 14:15:17,013 INFO success: rest-proxy entered RUNNING state, process has stayed up for > than 1 seconds (startsecs)
mydocker-kafka-cluster-1  | 2023-07-12 14:15:17,013 INFO success: schema-registry entered RUNNING state, process has stayed up for > than 1 seconds (startsecs)
mydocker-kafka-cluster-1  | 2023-07-12 14:15:17,013 INFO success: zookeeper entered RUNNING state, process has stayed up for > than 1 seconds (startsecs)


</code></p>

<p><b>And start creating topics and view topics!!</b></p>

<p><code>

bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic perf

Created topic perf.

bin/kafka-topics.sh --list --bootstrap-server localhost:9092
perf
testOne
testTwo

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic perf
>{"emp_id":5,"emp_city":"London","emp_name":"Kafka_01","emp_phone":786222449,"emp_sal":58000}
>{"emp_id":6, "emp_name":"test"}

</code></p>

<img title="View Messages" alt="Kafka Messages" src="/images/2023-07-12-Lenses-messages.png">
