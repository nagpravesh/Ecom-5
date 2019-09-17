package com.catalog;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogServiceApplication implements CommandLineRunner {
	
	@Value("${kafka.bootstrap.servers}")
	private String kafkaBootstrapServers;
	
	@Value("${kafka.topic.products}")
	private String products;
	
    @Value("${zookeeper.groupId}")
    private String zookeeperGroupId;
    
    @Value("${zookeeper.host}")
    String zookeeperHost;

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
        Properties consumerProperties = loadConsumerConfigurations();

        /*
         * Creating a thread to listen to the kafka topic
         */
        Thread kafkaConsumerThread = new Thread(() -> {
        	System.out.println("Starting Kafka consumer thread.");

            ProductKafkaConsumer simpleKafkaConsumer = new ProductKafkaConsumer(
            		products,
                    consumerProperties
            );

            simpleKafkaConsumer.runSingleWorker();
        });
        
        kafkaConsumerThread.start();
		
	}

	private Properties loadConsumerConfigurations() {
		/*
         * Defining Kafka consumer properties.
         */
        Properties consumerProperties = new Properties();
        consumerProperties.put("bootstrap.servers", kafkaBootstrapServers);
        consumerProperties.put("group.id", zookeeperGroupId);
        consumerProperties.put("zookeeper.session.timeout.ms", "6000");
        consumerProperties.put("zookeeper.sync.time.ms","2000");
        consumerProperties.put("auto.commit.enable", "false");
        consumerProperties.put("auto.commit.interval.ms", "1000");
        consumerProperties.put("consumer.timeout.ms", "-1");
        consumerProperties.put("max.poll.records", "1");
        consumerProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		return consumerProperties;
	}

}
