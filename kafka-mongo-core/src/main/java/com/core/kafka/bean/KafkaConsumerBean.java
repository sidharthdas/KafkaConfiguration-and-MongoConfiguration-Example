package com.core.kafka.bean;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author Sidharth Das
 * created on  04/10/22
 */
@Lazy
@Component
@AllArgsConstructor
public class KafkaConsumerBean {

    private final KafkaConsumer kafkaConsumer;

    public ConsumerRecords<String, String> getRecords() {
        return kafkaConsumer.poll(Duration.ofMillis(Long.MAX_VALUE));
    }

    public void commitRecords(){
        kafkaConsumer.commitSync();
    }
}
