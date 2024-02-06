package com.javainuse.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.FileWriter;
import java.util.List;
import java.io.PrintWriter;
import java.io.File;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.regions.Regions;
import java.sql.Timestamp;
import java.util.Date;
import java.time.Instant;

//@Component
@Service
class KafkaListenerEx {

	private final Logger LOG = LoggerFactory.getLogger(KafkaListenerEx.class);

	@KafkaListener(topics = "swatiTest2")
        public void consume(String message) throws IOException {
		            System.out.println("------Received this MESSAGE FROM KAFKA ===== ");
	            	System.out.println(message);
								System.out.println("-------SENDING TO S3 BUCKET---------------");
                String ts = Instant.now().toString();

                FileWriter fileWriter = new FileWriter("/tmp/Test-S3.txt");
                PrintWriter pw = new PrintWriter(fileWriter);
                pw.print(message);
                pw.close();

                AWSCredentials credentials = new BasicAWSCredentials("PasteHere-mysecret");
                AmazonS3 s3client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.EU_WEST_1).build();
                String bucketName = "skher-workshop";
                String fName = "Test-S3" + ts + ".txt";

                s3client.putObject(bucketName, fName, new File("/tmp/Test-S3.txt"));

                //if (s3client.doesBucketExist(bucketName)) {
                //   System.out.println("Bucket does not exist");
                //} else {
								System.out.println("-----LISTING ALL OF THE S3 BUCKETS------");
                List<Bucket> buckets = s3client.listBuckets();
                   for (Bucket bucket : buckets ) {
                     System.out.println(bucket.getName());
                }
								System.out.println("---------DEMO skher-workshop----------");
                //}

	}

//	void listener(String message) {
//		LOG.info("Listener [{}]", message);
//	}

}
