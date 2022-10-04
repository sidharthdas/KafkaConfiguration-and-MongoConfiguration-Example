package com.core.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author Sidharth Das
 * created on  04/10/22
 */
@Lazy
@Configuration
public class MongoConfiguration {

    @Value("${mongodb.uri}")
    private String mongoURI;

    @Value("${mongodb.database}")
    private String mongoDatabase;

    @Bean
    @Lazy
    public MongoDatabase mongoDatabase(){
        MongoClient mongoClient = MongoClients.create(mongoURI);
        return mongoClient.getDatabase(mongoDatabase);
    }
}
