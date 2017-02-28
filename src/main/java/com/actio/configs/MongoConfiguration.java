package com.actio.configs;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.actio.repositories.mongo")
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value(value = "${spring.data.mongodb.name}")
    private String mongoName;

    @Value(value = "${spring.data.mongodb.net.bindIp}")
    private String mongoHost;

    @Value(value = "${spring.data.mongodb.net.port}")
    private int mongoPort;

    @Override
    protected String getDatabaseName() {
        return mongoName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoHost, mongoPort);
    }

}