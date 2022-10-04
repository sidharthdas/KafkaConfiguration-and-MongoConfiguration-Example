package com.core.kafka.bean;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Headers;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Sidharth Das
 * created on  04/10/22
 */

@Lazy
@Component
@AllArgsConstructor
public class KafkaProducerBean {

    private final KafkaTemplate kafkaProducerTemplate;

    public void publishRecords(final String targetTopic,
                               final Integer partition,
                               final String key,
                               final String body,
                               final Headers headers){

        ProducerRecord<String, String>  producerRecord =
                new ProducerRecord<>(targetTopic,
                        partition,
                        key,
                        body,
                        headers);
        this.kafkaProducerTemplate.send(producerRecord);
    }
}
