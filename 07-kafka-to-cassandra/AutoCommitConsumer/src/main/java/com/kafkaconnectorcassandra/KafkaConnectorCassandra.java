package com.kafkaconnectorcassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import com.kafkaconnectorcassandra.config.IKafkaConstants;
import com.kafkaconnectorcassandra.config.ConsumerCreator;
import org.apache.kafka.common.TopicPartition;
import java.time.Duration;
import java.util.*;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

import com.datastax.driver.core.*;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Cluster;
import java.lang.String;
import java.sql.*;
import java.lang.*;
import java.net.*;
import java.util.*;
import com.datastax.driver.core.exceptions.*;
import java.io.IOException;
import java.io.*;
import org.json.*;
import com.kafkaconnectorcassandra.service.CassandraConnector;
import com.kafkaconnectorcassandra.config.IKafkaConstants;
import java.util.Arrays;


@SpringBootApplication
public class KafkaConnectorCassandra
{

	public static final CassandraConnector client = new CassandraConnector();

	public static void main(String[] args) throws Exception
	{
     SpringApplication app = new SpringApplication(KafkaConnectorCassandra.class);

		 try {
			 runConsumer();
			 app.run(args);
		 } catch (Exception e)
		 {
			   System.out.println("** Cassandra Exception occurred!!");
		 } finally {
			   System.out.println("closing the connection!");
				 client.close();
		 }

	}

	public static void runConsumer() throws Exception
	{

     Consumer<String, String> consumer = ConsumerCreator.createConsumer();

		 while (true)
		 {

        ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);

				System.out.println("Message Count = " + consumerRecords.count());

				if (consumerRecords.count() == 0)
				{
						System.out.println("Consumer polling for new messages!");

				 }
				 else
					{

							System.out.println("****SKHER CASSANDRA ENV VARS TEST******");
				      System.out.println("localhost");
				 		  System.out.println("9042");
				      System.out.println("----Before committing offset----");
				 			consumerRecords.forEach(record -> {

				 					  System.out.println("*** RECEIVED MESSAGE ****** ");
				 					  System.out.println(record.value());
										String jsonmessage = record.value();
                    String[] values = jsonmessage.split(",");
										System.out.println(values[0] + " and " + values[1]);
										String eID = values[0];
										int iCon=Integer.parseInt(eID);
										String ename = values[1];
				 					  System.out.println("record partition = " + record.partition());
				 					  System.out.println("record offset = " + record.offset());
                    System.out.println("record key = " + record.key());
										//System.out.println("------SENDING TO CASSANDRA------------");
										//System.out.println("-----COMMITTING THE OFFSET-------");
										//consumer.commitSync();
										try {
												System.out.println("------SENDING TO CASSANDRA------------");
											  client.connect("localhost", "9042");
												//client.connect(System.getenv("CASSANDRA_HOST"), System.getenv("CASSANDRA_PORT"));

												client.getSession().execute("use testkeyspace");

                        com.datastax.driver.core.PreparedStatement statement1 = client.getSession().prepare("INSERT INTO testkeyspace.emptest (emp_id, emp_name) VALUES (?, ?)");

	       								client.getSession().execute(statement1.bind(iCon, ename));
												//session.execute(prepared.bind("987274", "Keyboard"));
												System.out.println("execute query done");

												System.out.println("-----COMMITTING THE OFFSET--> " + record.offset());
												consumer.commitSync();
										}	catch (NoHostAvailableException nhae)
										{
										  System.out.println("---Could not update in Cassandra----");
										  System.out.println("--Cassandra Connection HAS FAILED!!!");
										  System.out.println("--OFFSET is not committed!!----");
										} catch (QueryValidationException qve) {
										  System.out.println("---Query failed to validate----");
										  System.out.println("---ignoring this query-----");
										  System.out.println("--Manually committing the offset and processing next message");
										  System.out.println("-----COMMITTING THE OFFSET-------");
										  consumer.commitSync();
										  client.close();
										} catch (QueryExecutionException qee) {
										  System.out.println("---QueryExecutionException occurred----");
										  System.out.println("---OFFSET IS NOT COMMITTED!----");
										  client.close();
										} finally {
											System.out.println("restart the consumer!");
										}

				 			});

				   }

	    }  //end of while loop
  }  //end of method runConsumer
}
