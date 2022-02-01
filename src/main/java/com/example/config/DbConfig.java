package com.example.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bson.Document;

@Factory
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class DbConfig {

    private final @NonNull ApplicationProperties properties;

    @Singleton
    @Bean
    @Named("mongodbClient")
    public MongoClient mongodbClient() {
        ServerAddress server = new ServerAddress(properties.getHost(), properties.getPort());
        MongoCredential credential = MongoCredential.createCredential(properties.getUsername(),
                properties.getDatabase(),
                properties.getPassword().toCharArray());
        MongoClientOptions param = new MongoClientOptions.Builder()
                .connectTimeout(properties.getTimeout())
                .build();
        return new MongoClient(server, credential, param);
    }

    @Singleton
    @Bean
    @Named("mongopocDb")
    public MongoDatabase mongopocDb(@NonNull @Named("mongodbClient") final MongoClient mongoClient) {
        return mongoClient.getDatabase(properties.getDatabase());
    }

    @Singleton
    @Bean
    @Named("invoiceCollection")
    public MongoCollection<Document> invoiceCollection(@NonNull @Named("mongopocDb") final MongoDatabase database) {
        return database.getCollection("invoice");
    }
}
