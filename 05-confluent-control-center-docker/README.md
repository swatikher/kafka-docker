# sk-kafka-examples
Confluent Control Center

https://docs.confluent.io/platform/current/platform-quickstart.html#quickstart

Start by reading our guidelines on contributing to this project found here.

Source Code: https://github.com/confluentinc/cp-docker-images


QuickStart with 

<code> docker compose up </code>

Then Navigate to Control Center at 
http://localhost:9021

It may take a minute or two for Control Center to start and load.

Or

<code>
wget https://raw.githubusercontent.com/confluentinc/cp-all-in-one/7.4.0-post/cp-all-in-one-kraft/docker-compose.yml

docker-compose up -d
</code>

Following containers should start:
<code>
Starting broker ... done
Starting schema-registry ... done
Starting connect         ... done
Starting rest-proxy      ... done
Starting ksqldb-server   ... done
Starting ksql-datagen    ... done
Starting ksqldb-cli      ... done
Starting control-center  ... done
</code>
<p></p>
<p>
<img title="C3 Dashboard" alt="C3 Dashboard" src="/images/2023-07-14-C3-dashboard.png">
</p>
<p>
To stop:
</p>
<code>
 
 docker compose down
 </code>
 <code><p>
 
[+] Running 10/10
 Container ksqldb-cli        Removed                                                                                                   
 Container control-center    Removed                                                                                                   
 Container ksql-datagen      Removed                                                                                                  
 Container rest-proxy        Removed                                                                                                   
 Container ksqldb-server     Removed                                                                                                  
 Container connect           Removed                                                                                                   
 Container schema-registry   Removed                                                                                                   
 Container broker            Removed                                                                                                   
 Container controller        Removed   
 </code></p>
