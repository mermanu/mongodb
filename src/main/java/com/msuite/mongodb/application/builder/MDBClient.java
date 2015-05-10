/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msuite.mongodb.application.builder;

import com.mongodb.MongoClient;

/**
 *
 * @author nherman
 */
public enum MDBClient {
    DEFAULT(new MongoClient(Constants.MONGO_HOST, Constants.MONGO_PORT));
    
    private MongoClient mongoClient;

    private MDBClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }
    
    
} 
