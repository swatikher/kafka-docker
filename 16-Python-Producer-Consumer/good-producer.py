from confluent_kafka import Producer
import json

def delivery_report(err, msg):
    if err is not None:
        print(f'Message delivery failed: {err}')
    else:
        print(f'Message delivered to {msg.topic()} [{msg.partition()}]')

def main():
    conf = {
        'bootstrap.servers': 'localhost:9092',  # Replace with your Kafka broker address
        'client.id': 'my-producer'
    }

    producer = Producer(conf)

    topic = 'perf'
    data = {'message': 'Hello, Kafka!'}

    producer.produce(topic, json.dumps(data).encode('utf-8'), callback=delivery_report)

    # Ensure all messages are delivered
    producer.flush()

if __name__ == '__main__':
    main()
