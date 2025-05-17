from confluent_kafka import Consumer, KafkaError


def publish():

    # Configuration for the consumer
    conf = {
        'bootstrap.servers': 'localhost:9092',  # Replace with your Kafka broker address
        'group.id': 'my-consumer-group',  # Replace with your consumer group ID
        'auto.offset.reset': 'earliest'  # Read from beginning if no previous offset exists
    }

    # Create the consumer instance
    consumer = Consumer(conf)

    # Subscribe to the topic(s)
    topics = ['swatiTest']  # Replace with your topic name

    consumer.subscribe(topics)

    try:
      while True:
        # Poll for messages
        msg = consumer.poll(1.0)

        if msg is None:
            continue
        elif msg.error():
            if msg.error().code() == KafkaError._PARTITION_EOF:
                print('Reached end of partition')
            else:
                print('Error: {}'.format(msg.error()))
        else:
            # Process the message
            print('Received message: {}'.format(msg.value().decode('utf-8')))

    except KeyboardInterrupt:
        pass
    finally:
        # Close the consumer gracefully
        consumer.close()

if __name__ == '__main__':

    print('testing consumer')
    publish()
