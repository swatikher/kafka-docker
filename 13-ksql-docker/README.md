## Clone the Repo

- Confluent KSQL [GIT REPO](https://docs.ksqldb.io/en/latest/operate-and-deploy/installation/installing/#1-clone-the-ksqldb-repository)
- KSQL Quick [Start Guide](https://dcsgcloud.atlassian.net/wiki/spaces/INTSRV/pages/27492762/KSQL+Quickstart+Guide)
- Kafka Stream vs [KSQL](https://www.confluent.io/blog/kafka-streams-vs-ksqldb-compared/)

## Docker Compose

```shell
git clone https://github.com/confluentinc/ksql.git
cd ksql
docker-compose up -d
```

## Following Containers

<img title="Docker Containers" alt="Docker Compose" src="/images/2023-09-15-KSQL-containers.png">
<p></p>
<img title="Docker Containers" alt="Docker Compose" src="/images/2023-09-15-ksql-shell.png">
<p>
</p>
<img title="Docker Containers" alt="Docker Compose" src="/images/2023-09-15-showTopics-create-stream.png">
<p></p>

## KSQL-CLI

```shell
ksql> show topics;

 Kafka Topic | Partitions | Partition Replicas 
-----------------------------------------------
 perf        | 1          | 1                  
 perf2       | 1          | 1                  
-----------------------------------------------
ksql> create stream mydemo (description VARCHAR) with (KAFKA_TOPIC = 'perf', VALUE_FORMAT = 'DELIMITED' );

 Message        
----------------
 Stream created 
----------------
ksql> show streams;

 Stream Name | Kafka Topic | Key Format | Value Format | Windowed 
------------------------------------------------------------------
 MYDEMO      | perf        | KAFKA      | DELIMITED    | false    
------------------------------------------------------------------
ksql> select * from mydemo EMIT CHANGES;
+----------------------------------------------------------------------------------------------------------------------------------------------------------+
|DESCRIPTION                                                                                                                                               |
+----------------------------------------------------------------------------------------------------------------------------------------------------------+
|{'description':'tesst'}                                                                                                                                   |
|{'description':'new message json format'}     
```
<p>
</p>
<img title="JSON PAYLOAD" alt="JSON MESSAGES" src="/images/2023-09-15-ksql-filter-json.png">
<p></p>

```shell
ksql> create stream stocks_stream (side varchar, quantity int, symbol varchar, price int, account varchar, userid varchar) with (kafka_topic='stocks_topic', value_format='JSON');

 Message        
----------------
 Stream created 
----------------
ksql> select * from stocks_stream EMIT CHANGES;
+------------------------+------------------------+------------------------+------------------------+------------------------+------------------------+
|SIDE                    |QUANTITY                |SYMBOL                  |PRICE                   |ACCOUNT                 |USERID                  |
+------------------------+------------------------+------------------------+------------------------+------------------------+------------------------+
|BUY                     |20                      |CSCO                    |32                      |acc                     |user                    |
|SELL                    |4                       |APPL                    |300                     |acc                     |user                    |
|HOLD                    |4                       |CSCO                    |32                      |acc                     |user                    |
^CQuery terminated
ksql> select SYMBOL , count(quantity) AS total_times_bought from STOCKS_STREAM where side = 'BUY' GROUP BY SYMBOL EMIT CHANGES;
+----------------------------------------------------------------------------+----------------------------------------------------------------------------+
|SYMBOL                                                                      |TOTAL_TIMES_BOUGHT                                                          |
+----------------------------------------------------------------------------+----------------------------------------------------------------------------+
|CSCO                                                                        |1                                                                           |
|CSCO                                                                        |2                                                                           |
^CQuery terminated
ksql> select symbol, sum(quantity) as total_quantity from stocks_stream where side = 'BUY' GROUP BY symbol EMIT CHANGES;
+----------------------------------------------------------------------------+----------------------------------------------------------------------------+
|SYMBOL                                                                      |TOTAL_QUANTITY                                                              |
+----------------------------------------------------------------------------+----------------------------------------------------------------------------+
|CSCO                                                                        |20                                                                          |
|CSCO                                                                        |40                                                                          |
^CQuery terminated
ksql> select symbol, count(*) as quantity, WINDOWSTART as window_start, WINDOWEND as window_end from stocks_stream WINDOW TUMBLING (size 5 minutes) GROUP BY symbol EMIT CHANGES;
+-------------------------------------+-------------------------------------+-------------------------------------+-------------------------------------+
|SYMBOL                               |QUANTITY                             |WINDOW_START                         |WINDOW_END                           |
+-------------------------------------+-------------------------------------+-------------------------------------+-------------------------------------+
|CSCO                                 |1                                    |1694800500000                        |1694800800000                        |
|CSCO                                 |2                                    |1694800500000                        |1694800800000                        |
|CSCO                                 |3                                    |1694800500000                        |1694800800000                        |
^CQuery terminated
ksql> 

```
