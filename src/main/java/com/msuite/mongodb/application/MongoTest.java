/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msuite.mongodb.application;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.msuite.mongodb.application.builder.Constants;
import com.msuite.mongodb.application.builder.MDBClient;
import com.msuite.mongodb.application.definition.CollectionDefinition;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author manuelmerida
 */
public class MongoTest {

    private final MongoDatabase database;
    private final MongoClient mongoClient;   

    public MongoTest() {
        mongoClient = MDBClient.DEFAULT.getMongoClient();
        database = mongoClient.getDatabase(Constants.DATAFLOW_DB);
    }   
    
    public void testInsertDefinition(Scanner scanInput){
        CollectionDefinition definition=new CollectionDefinition("flow_data","forms");
        MongoCollection<Document> collection = database.getCollection(definition.getCollection());          
        
        definition.traverse(definition.getDocument(), scanInput);       
        System.out.println("Do you want to insert the form?");
        String field = scanInput.nextLine(); 
        
        if(field.equals("yes")){
            collection.insertOne(definition.getDocument());
        }else{
            System.out.println("Ok thanks...");
        }
    }

    public int queryCollection(String field) {
        MongoCollection<Document> collection = database.getCollection("flow_data");
        /*MongoCursor<Document> cursor = collection.find().iterator();
         try {
         while (cursor.hasNext()) {
         System.out.println(cursor.next().get("custom6"));
         }
         } finally {
         cursor.close();
         }*/
        Block<Document> printBlock = new Block<Document>() {
            @Override
            public void apply(final Document document) {
                System.out.println(document.toJson());

            }
        };
        MongoCursor<Document> cursor = collection.find(Filters.and(Filters.exists(field, true))).iterator();//.forEach(printBlock);
        int i = 0;
        try {
            while (cursor.hasNext()) {
                cursor.next();
                i++;
            }
        } finally {
            cursor.close();
        }
        return i;

    }

}
