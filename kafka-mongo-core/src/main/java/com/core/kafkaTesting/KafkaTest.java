package com.core.kafkaTesting;

import com.core.bean.KafkaBean;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Sidharth Das
 * created on  04/10/22
 */
@Component
@AllArgsConstructor
public class KafkaTest {

    private final KafkaBean kafkaBean;

    @PostConstruct
    public void init(){
        kafkaBean.publishRecords("test1", 0, "test", "hello world", null);
        ConsumerRecords consumerRecords = kafkaBean.getRecords();
        ConsumerRecord c1 = (ConsumerRecord) consumerRecords.records("test1").iterator().next();
        System.out.println("Value : "+ c1.value());
        System.out.println("Key : " +  c1.key());
    }
}
