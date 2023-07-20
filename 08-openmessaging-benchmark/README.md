# Kafka Benchmarks

- Documentation https://github.com/confluentinc/openmessaging-benchmark/blob/master/driver-kafka/README.md

- Confluent Developer https://developer.confluent.io/

- Driver-Kafka https://openmessaging.cloud/docs/benchmarks/kafka/

# How To Compile 

<code><p>
|             Action              |                 Command                  |
|---------------------------------|------------------------------------------|
| Full build and test             | `mvn clean verify`                       |
| Skip tests                      | `mvn clean verify -DskipTests`           |
| Skip Jacoco test coverage check | `mvn clean verify -Djacoco.skip`         |
| Skip Checkstyle standards check | `mvn clean verify -Dcheckstyle.skip`     |
| Skip Spotless formatting check  | `mvn clean verify -Dspotless.check.skip` |
| Format code                     | `mvn spotless:apply`                     |
| Generate license headers        | `mvn license:format`                     |

</code></p>

# Benchmark Workloads

https://openmessaging.cloud/docs/benchmarks/#benchmarking-workloads

Benchmarking workloads are specified in YAML configuration files that are available in the workloads directory. 
The table below describes each workload in terms of the following parameters:
<code><p>
The number of topics
The size of the messages being produced and consumed
The number of subscriptions per topic
The number of producers per topic
The rate at which producers produce messages (per second). Note: a value of 0 means that messages are produced as quickly as possible, with no rate limiting.
The size of the consumer’s backlog (in gigabytes)
The total duration of the test (in minutes)
</code></p>
# Results

<code><p>
Measure |	Meaning	| Units
* Pub rate	| The rate at which messages are published to the topic	| Messages per second / Megabytes per second
* Cons rate |	The rate at which messages are consumed from the topic |	Messages per second / Megabytes per second
* Backlog |	The number of messages in the messaging system’s backlog |	Number of messages (in thousands)
* Pub latency (ms) avg	| The time taken by the producer to publish the message — values >60s are not captured	| Milliseconds (average, 50th percentile, 99th percentile, and 99.9th percentile, and maximum)
* Pub delay (µs) avg	| The time that message production is delayed relative to the ideal throughput — values >60s are not captured	| Microseconds (average, 50th percentile, 99th percentile, and 99.9th percentile, and maximum)
</code></p>
