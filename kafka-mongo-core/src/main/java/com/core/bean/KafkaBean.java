package com.core.bean;

import com.core.kafka.bean.KafkaConsumerBean;
import com.core.kafka.bean.KafkaProducerBean;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.header.Headers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Sidharth Das
 * created on  04/10/22
 */
@Component
@Lazy
@AllArgsConstructor
public class KafkaBean {

    /*@Value("${topic.name}")
    private String topic;*/

    private final KafkaConsumerBean kafkaConsumerBean;
    private final KafkaProducerBean kafkaProducerBean;

    public ConsumerRecords getRecords(){
        return kafkaConsumerBean.getRecords();
    }

    public void commitRecords(){
        kafkaConsumerBean.commitRecords();
    }


    public void publishRecords(String topicName, Integer partition, String key, String body, Headers headers
    ){
        kafkaProducerBean.publishRecords(topicName,partition,key,body   ,headers);

    }


}
