package com.admin.service.impl;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.admin.dto.ProductRequest;
import com.admin.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Value("${kafka.bootstrap.servers}")
	private String kafkaBootstrapServers;
	
	@Value("${kafka.topic.products}")
	private String products;
	
    @Value("${zookeeper.groupId}")
    private String zookeeperGroupId;
    
    @Value("${zookeeper.host}")
    String zookeeperHost;

	@Override
	public void createProduct(ProductRequest productRequest) {

		Properties producerProperties = loadProducerConfigurations();
		
		/*
		Creating a Kafka Producer object with the configuration above.
		 */
		KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties);

		sendMessagesToKafka(producer,productRequest);		
			
	}
	
	private Properties loadProducerConfigurations() {
		Properties producerProperties = new Properties();
		producerProperties.put("bootstrap.servers", kafkaBootstrapServers);
		producerProperties.put("acks", "all");
		producerProperties.put("retries", 0);
		producerProperties.put("batch.size", 16384);
		producerProperties.put("linger.ms", 1);
		producerProperties.put("buffer.memory", 33554432);
		producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		return producerProperties;
	}

    private void sendMessagesToKafka(KafkaProducer<String, String> producer,ProductRequest productRequest) {

            JSONObject jsonObject = new JSONObject();
            JSONObject nestedJsonObject = new JSONObject();

            try {

                jsonObject.put("productCode", productRequest.getProductCode());
                jsonObject.put("productName", productRequest.getProductName());

                /*
                We're adding a field in the nested JSON object.
                 */
                nestedJsonObject.put("nestedObjectMessage", "This is a nested JSON object with index: " +  productRequest.getProductCode());

                /*
                Adding the nexted JSON object to the main JSON object.
                 */
                jsonObject.put("nestedJsonObject", nestedJsonObject);

            } catch (JSONException e) {
            	System.out.println(e.getMessage());
            }

            System.out.println("Sending Kafka message: " + jsonObject.toString());
    	    producer.send(new ProducerRecord<>(products, jsonObject.toString()));
    }



}
