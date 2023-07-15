Prerequisites
=============

1. start zookeeper

bin/zookeeper-server-start.sh config/zookeeper.properties 

[2023-07-14 10:37:07,574] INFO zookeeper.snapshot.trust.empty : false (org.apache.zookeeper.server.persistence.FileTxnSnapLog)
[2023-07-14 10:37:07,580] INFO  (org.apache.zookeeper.server.ZooKeeperServer)
[2023-07-14 10:37:07,580] INFO   ______                  _                                           (org.apache.zookeeper.server.ZooKeeperServer)
[2023-07-14 10:37:07,580] INFO  |___  /                 | |                                          (org.apache.zookeeper.server.ZooKeeperServer)
[2023-07-14 10:37:07,580] INFO     / /    ___     ___   | | __   ___    ___   _ __     ___   _ __    (org.apache.zookeeper.server.ZooKeeperServer)
[2023-07-14 10:37:07,580] INFO    / /    / _ \   / _ \  | |/ /  / _ \  / _ \ | '_ \   / _ \ | '__| (org.apache.zookeeper.server.ZooKeeperServer)
[2023-07-14 10:37:07,580] INFO   / /__  | (_) | | (_) | |   <  |  __/ |  __/ | |_) | |  __/ | |     (org.apache.zookeeper.server.ZooKeeperServer)
[2023-07-14 10:37:07,580] INFO  /_____|  \___/   \___/  |_|\_\  \___|  \___| | .__/   \___| |_| (org.apache.zookeeper.server.ZooKeeperServer)
[2023-07-14 10:37:07,580] INFO                                               | |                      (org.apache.zookeeper.server.ZooKeeperServer)
[2023-07-14 10:37:07,580] INFO                                               |_|                      (org.apache.zookeeper.server.ZooKeeperServer)
[2023-07-14 10:37:07,580] INFO  (org.apache.zookeeper.server.ZooKeeperServer)


2. Start Kafka broker

bin/kafka-server-start.sh config/server.properties 

3. Create Topic 'myTopic'

bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic myTopic

Created topic myTopic.

4. Compile and run camel-kafka-1.0-SNAPSHOT.jar


Camel Java Router Project
=========================

To build this project use

    mvn install

To run this project from within Maven use

    mvn exec:java

For more help see the Apache Camel documentation

    http://camel.apache.org/

Tutorial for this example: http://www.masterspringboot.com/various/camel/consuming-and-producing-kafka-messages-from-camel

and https://github.com/fmarchioni/masterspringboot/tree/master/camel/camel-kafka


Produce And Consumer Messages
=============================

From 'data' directory --> consume message1.xml and message2.xml

[ad #1 - KafkaConsumer[myTopic]] SubscriptionState              INFO  [Consumer clientId=consumer-092edd0c-1927-4fb6-a554-f583adcca440-2, groupId=092edd0c-1927-4fb6-a554-f583adcca440] Resetting offset for partition myTopic-0 to position FetchPosition{offset=0, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[localhost:9092 (id: 1 rack: null)], epoch=0}}.
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO  Message received from Kafka : <?xml version="1.0" encoding="UTF-8"?>
<person user="hiram">
  <firstName>Hiram</firstName>
  <lastName>Chirino</lastName>
  <city>Tampa</city>
</person>

[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      on the topic myTopic
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      on the partition 0
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      with the offset 0
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      with the key Camel
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO  Message received from Kafka : <?xml version="1.0" encoding="UTF-8"?>
<person user="james">
  <firstName>James</firstName>
  <lastName>Strachan</lastName>
  <city>London</city>
</person>



2. Consumer from console

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic myTopic --from-beginning

<?xml version="1.0" encoding="UTF-8"?>
<person user="hiram">
  <firstName>Hiram</firstName>
  <lastName>Chirino</lastName>
  <city>Tampa</city>
</person>

<?xml version="1.0" encoding="UTF-8"?>
<person user="james">
  <firstName>James</firstName>
  <lastName>Strachan</lastName>
  <city>London</city>
</person>

3. Produce from console

bin/kafka-console-producer.sh --broker-list localhost:9092 --topic myTopic

><?xml version="1.0" encoding="UTF-8"?><person user="Swati"><firstName>Swati</firstname><lastName>Kher</lastName><city>San Francisco</city></person>

4. And Verify Camel Consumes it

[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      on the topic myTopic
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      on the partition 0
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      with the offset 1
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      with the key Camel
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO  Message received from Kafka : <?xml version="1.0" encoding="UTF-8"?><person user="Swati"><firstName>Swati</firstname><lastName>Kher</lastName><city>San Francisco</city></person>
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      on the topic myTopic
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      on the partition 0
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      with the offset 2
[ad #1 - KafkaConsumer[myTopic]] route2                         INFO      with the key 
