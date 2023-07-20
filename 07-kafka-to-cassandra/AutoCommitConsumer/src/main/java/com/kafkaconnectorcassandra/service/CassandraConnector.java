package com.kafkaconnectorcassandra.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.datastax.driver.core.*;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Cluster;
import java.lang.String;
import java.sql.*;
import java.lang.*;
import java.net.*;


public class CassandraConnector {

    private Cluster cluster;

    private Session session;


    //public void connect(String node, String port, String username, String password) {
    public void connect(String node, String port) {
        System.out.println(node);
        System.out.println(port);
        System.out.println("----Cassandra Connect Called--------");
        //Builder b = Cluster.builder().addContactPoint(node).withPort(Integer.parseInt(port)).withCredentials(username, password);
        Builder b = Cluster.builder().addContactPoint(node).withPort(Integer.parseInt(port));

        cluster = b.build();
        session = cluster.connect();
   }

    public Session getSession() {
        return this.session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
