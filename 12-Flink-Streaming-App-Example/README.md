# Flink Streaming API Examples
- Full Documentation https://github.com/apache/flink/tree/master/flink-examples/flink-examples-streaming
- Flink Simple [WordCount Example](https://github.com/apache/flink/blob/master/flink-examples/flink-examples-streaming/src/main/java/org/apache/flink/streaming/examples/socket/SocketWindowWordCount.java)
- Flink StockAnalysis Example 

# How To Compile And Run
<p><code>mvn clean package -Dmaven.test.skip=true </code></p>
- <p>Download Flink <a href="https://nightlies.apache.org/flink/flink-docs-master/docs/try-flink/local_installation/#downloading-flink"> HERE </a></p>
- <p>Start Flink Cluster shell script .../Downloads/flink-version/bin/start-cluster.sh or update and run start-flink.sh</p>
- <p>Flink Dashboard = http://localhost:8081/#/overview</p>

# How To Run Word Count
<code>flink-version/bin/flink run -c p1.SocketTextStreamWordCount target/FlinkExamples-1.0-SNAPSHOT.jar Host_IP Host_PORT</code>
- <p>Example - start 'nc -l 9000' on port 9000</p>
- <p><code>flink-version/bin/flink run -c p1.SocketTextStreamWordCount target/FlinkExamples-1.0-SNAPSHOT.jar 127.0.0.1 9000</code></p>
- <p>Should Submit and start job as follows</p>
<p><code>Job has been submitted with JobID 86d75e664b7277d757137205bed7162f
Program execution finished
Job with JobID 86d75e664b7277d757137205bed7162f has finished.
Job Runtime: 2739351 ms
</code></p>
<img title="Flink Dashboard" alt="Flink Job Submitted" src="/images/2023-07-25-Flink-Job-submitted.png">

- <p>Check Result of Word Count</p>
<img title="Flink Dashboard" alt="Flink Job Submitted" src="/images/2023-07-25-Flink-Word-Count.png">

# How To Run StockAnalysis
- <p>copy FUTURES_TRADES.txt to /tmp/. </p>
<code>flink-version/bin/flink run -c p1.StockAnalysis target/FlinkExamples-1.0-SNAPSHOT.jar</code>
- <p>This should submit the job as follows</p>
<p><code>Job has been submitted with JobID 86d75e664b7277d757137205bed7162f
Program execution finished
Job with JobID 86d75e664b7277d757137205bed7162f has finished.
Job Runtime: 2739351 ms
</code></p>

- <p>Check Result of StockAnalysis</p>
<img title="Flink Dashboard" alt="Flink Job Submitted" src="/images/2023-07-25-Flink-Stock-Analysis.png">
<p></p>

# Flink API Imports for WordCount
<code>
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;
</code>

<p></p>
- Flink [Watermarks](https://nightlies.apache.org/flink/flink-docs-master/docs/dev/datastream/event-time/generating_watermarks/)
- Flink Windows and [Tumbling Windows](https://nightlies.apache.org/flink/flink-docs-master/docs/dev/datastream/operators/windows/#tumbling-windows)
<p></p>
# Flink API Imports for StockAnalysis Example
<code>
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.api.functions.AscendingTimestampExtractor;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.api.functions.windowing.ProcessWindowFunction;
</code>
