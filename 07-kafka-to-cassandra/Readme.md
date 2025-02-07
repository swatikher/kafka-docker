# Prerequisites

1. Download Cassandra - https://cassandra.apache.org/_/download.html
2. Start Cassandra

# To start cassandra :

Start with docker
<code>
docker run -p 9042:9042 --rm --name cassandra -d cassandra:4.0.7
<code>
<p></p>
Start cqlsh session

<code>
docker exec -it cassandra bash
cqlsh -u cassandra -p cassandra
</code>
<p></p>
or Locally
<code>
  apache-cassandra-4.1.7$ bin/cqlsh
</code>
<p></p>
Then create keyspace
<code>
  brew services start cassandra
</code>
<p></p>
<p> Or, if you don't want/need a background service you can just run: </p>
<code> /opt/homebrew/opt/cassandra/bin/cassandra -f  </code>

3. Create keyspace
<code>CREATE KEYSPACE TestKeySpace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};</code>

4. Create Table
<code>CREATE TABLE emptest( emp_id int PRIMARY KEY, emp_name text);</code>

5. cqlsh
<code>SELECT * FROM testkeyspace.emptest;</code>

<img title="Apache Cassandra" alt="CQLSH" src="/images/2023-07-18-cqlsh.png">

6. Start Kafka and Create Topic = 'swatitest'
<p>
<code>bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1  --partitions 1 --topic swatiTest </code></p>
<p>
<code> bin/kafka-topics.sh --list --bootstrap-server localhost:9092 </code>
</p>
To confirm 'swatiTest' is created
<code>
__consumer_offsets
swatiTest
</code>
<p></p>
7. Start the Producer
<code>bin/kafka-console-producer --broker-list localhost:9092 --topic swatitest </code>

<p>And populate with tuple {ID, Name}</p>
<code>>1, sktest
>2, anotherTest
>3, customConnectorTest
>4, empNameFour</code>
<p></p>

8. Maven Install to build the connector jar
<p></p>
<code>[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ kafkaconnectorcassandra ---
[INFO] Installing /Users/swatikher/Downloads/07-Connector-Custom-Cassandra/AutoCommitConsumer/target/kafkaconnectorcassandra-0.0.1-SNAPSHOT.jar to /Users/swatikher/.m2/repository/com/kafkaconnectorcassandra/kafkaconnectorcassandra/0.0.1-SNAPSHOT/kafkaconnectorcassandra-0.0.1-SNAPSHOT.jar
[INFO] Installing /Users/swatikher/Downloads/07-Connector-Custom-Cassandra/AutoCommitConsumer/pom.xml to /Users/swatikher/.m2/repository/com/kafkaconnectorcassandra/kafkaconnectorcassandra/0.0.1-SNAPSHOT/kafkaconnectorcassandra-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  26.614 s
[INFO] Finished at: 2023-07-18T06:02:12-07:00
[INFO] ------------------------------------------------------------------------
➜  AutoCommitConsumer 
</code>

<p></p>

9. Start the connector Jar
<code>java -jar target/kafkaconnectorcassandra-0.0.1-SNAPSHOT.jar</code>
<p></p>

10. Messages consumed should be written to Cassandra
<p></p>
<code>----Before committing offset----
*** RECEIVED MESSAGE ****** 
4,empNameFour
4 and empNameFour
record partition = 0
record offset = 6
record key = null
------SENDING TO CASSANDRA------------
localhost
9042
</code>

<img title="Connector Start" alt="Listener" src="/images/2023-07-18-Kafka-Connector-Listening.png">
<p></p>

11. Cassandra table emptest

<img title="Update To Cassandra" alt="Cassandra" src="/images/2023-07-18-New-Messages-From-kafka.png">

<p></p>


# Cassandra Connection Requires Following Imports
<code>
<p>import com.datastax.driver.core.*;</p>
<p>import com.datastax.driver.core.Cluster.Builder;</p>
<p>import com.datastax.driver.core.Cluster;</p>
</code>

# Kafka Consumer 
<code>
<p>import org.apache.kafka.clients.consumer.Consumer;</p>
<p>import org.apache.kafka.clients.consumer.ConsumerRecords;</p>
<p>import org.apache.kafka.clients.consumer.KafkaConsumer;</p>
<p>import org.apache.kafka.clients.consumer.OffsetAndMetadata;</p>
<p>import org.springframework.kafka.core.KafkaTemplate;</p>
<p>import org.apache.kafka.common.serialization.LongDeserializer;</p>
<p>import org.apache.kafka.common.serialization.StringDeserializer;</p>
</code>
