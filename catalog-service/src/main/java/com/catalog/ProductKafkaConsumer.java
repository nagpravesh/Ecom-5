package com.catalog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ProductKafkaConsumer {
	
	private KafkaConsumer<String, String> kafkaConsumer;
	
	public ProductKafkaConsumer(String productsTopic, Properties consumerProperties) {

	    kafkaConsumer = new KafkaConsumer<>(consumerProperties);
	    kafkaConsumer.subscribe(Arrays.asList(productsTopic));
	}


	public void runSingleWorker() {

	    /*
	     * We will start an infinite while loop, inside which we'll be listening to
	     * new messages in each topic that we've subscribed to.
	     */
	    while(true) {

	        ConsumerRecords<String, String> records = kafkaConsumer.poll(100);

	        for (ConsumerRecord<String, String> record : records) {

	            String message = record.value();


	            System.out.println("Received message: " + message);

	            try {
	                JSONObject receivedJsonObject = new JSONObject(message);

	                System.out.println("Product code of deserialized JSON object: " + receivedJsonObject.getString("productCode"));
	            } catch (JSONException e) {
	            	System.out.println(e.getMessage());
	            }

	            /*
	            Once we finish processing a Kafka message, we have to commit the offset so that we don't end up consuming the same message endlessly. By default, the consumer object takes care of this. But to demonstrate how it can be done, we have turned this default behaviour off, instead, we're going to manually commit the offsets.
	            The code for this is below. It's pretty much self explanatory.
	             */
	            {
	                Map<TopicPartition, OffsetAndMetadata> commitMessage = new HashMap<>();

	                commitMessage.put(new TopicPartition(record.topic(), record.partition()),
	                        new OffsetAndMetadata(record.offset() + 1));

	                kafkaConsumer.commitSync(commitMessage);

	                System.out.println("Offset committed to Kafka.");
	            }
	        }
	    }
	}

}
