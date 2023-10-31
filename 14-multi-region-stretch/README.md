
# Overview

This demo showcases Confluent Platform's Multi-Region Cluster capability built directly into Confluent Server.

# Documentation

You can find the documentation and instructions for running this Multi-Region Cluster example at [https://docs.confluent.io/platform/current/tutorials/examples/multiregion/docs/multiregion.html](https://docs.confluent.io/platform/current/tutorials/examples/multiregion/docs/multiregion.html?utm_source=github&utm_medium=demo&utm_campaign=ch.examples_type.community_content.clients-ccloud)

[Git Repo](https://github.com/confluentinc/examples/tree/7.5.0-post/multiregion)

# Services
* zookeeper-west
* zookeeper-central
* zookeeper-east
* zookeeper-ccc
* broker-west-1
* broker-west-2
* broker-east-3
* broker-east-4
* broker-ccc

<p><code>
  ==> Creating topic single-region
Created topic single-region.
 
==> Creating topic multi-region-sync
Created topic multi-region-sync.
 
==> Creating topic multi-region-async
Created topic multi-region-async.
 
==> Creating topic multi-region-default
Created topic multi-region-default.
 
==> Creating topic multi-region-async-op-under-min-isr
Created topic multi-region-async-op-under-min-isr.
 
==> Creating topic multi-region-async-op-under-replicated
Created topic multi-region-async-op-under-replicated.
 
==> Creating topic multi-region-async-op-leader-is-observer
Created topic multi-region-async-op-leader-is-observer.
</code></p>
