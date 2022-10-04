package com.core.kafka.config;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.List;
/**
 * @author Sidharth Das
 * created on  04/10/22
 */
@Lazy
@Configuration
public class KafkaConfiguration {

    @Lazy
    @Bean
    public KafkaConsumer kafkaConsumer(@Autowired final  KafkaProperties kafkaProperties,
                                       @Value("#{'${kafka.consumer.topics}'.split(',')}") final List<String> consumptionTopics){
        KafkaConsumer kafkaConsumer = new KafkaConsumer(kafkaProperties.buildConsumerProperties());
        kafkaConsumer.subscribe(consumptionTopics);
        return kafkaConsumer;

    }
}
