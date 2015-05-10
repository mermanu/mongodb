/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.stacks.mongodb.application.builder.CollectionDefinition;
import com.stacks.mongodb.application.builder.Field;
import com.stacks.mongodb.application.data.DFFData;
import com.stacks.mongodb.application.forms.DFDocument;
import com.stacks.mongodb.application.forms.DFFormDefinition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author manuelmerida
 */
public class MongoTest {

    private final MongoDatabase database;
    private final MongoClient mongoClient;
    private static final String KEY_INSERT="Insert ";
    private static final String DATA_INSERT="Insert data ";
    private static final String CUSTOM_INSERT="Insert custom ";

    public MongoTest() {
        mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDatabase("dataflow");
    }

    public void testDataInsert() {
        List<Document> documents = new ArrayList<Document>();
        MongoCollection<Document> collection = database.getCollection("flow_data");
        HisData hData = new HisData();
        for (int i = 0; i < 20000; i++) {
            hData.setFullName("Manuel Mérida " + i);
            hData.setAge(String.valueOf(10 + i));
            hData.setStatus("active");
            hData.setUserId("user" + i);
            CustomData cData = new CustomData();
            cData.setData("this is my data of Manuel Mérida " + i);
            hData.setCustomData(cData);

            Document doc = new Document("user", hData.getUserId())
                    .append("fullName", hData.getFullName())
                    .append("age", hData.getAge())
                    .append("status", hData.getStatus())
                    .append("customData", new Document("data", hData.getCustomData().getData()));

            documents.add(doc);

        }
        collection.insertMany(documents);
        mongoClient.close();

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
        
    public void testInsert(Scanner scanInput){
        DFDocument fDefinition=new DFFormDefinition();
        List<Document> documents = new ArrayList<Document>();
        MongoCollection<Document> collection = database.getCollection(fDefinition.getCollection());      
        
        setDataToForm(scanInput, fDefinition.getKeys().getDocName(), fDefinition.getKeys());                    
        for(Entry<String,DFFData> entry : fDefinition.getDocument().entrySet()){
            setDataToForm(scanInput, entry.getKey(), entry.getValue());                    
        }        
        
        System.out.println("Do you want to insert the form?");
        String field = scanInput.nextLine(); 
        if(field.equals("yes")){
            Document doc = new Document("idDoc","form");
            for(Entry<String,Field> entry : fDefinition.getKeys().getData().entrySet()){
                doc.append(entry.getKey(), entry.getValue().getValue());
            }           
            for(Entry<String,DFFData> entry : fDefinition.getDocument().entrySet()){
                Document data = new Document("idDoc",entry.getKey()); 
                for(Entry<String,Field> entry1 : entry.getValue().getData().entrySet()){
                    data.append(entry1.getKey(), entry1.getValue().getValue());
                }
                doc.append(entry.getKey(), data);
            }        
           collection.insertOne(doc);
            
        }else{
            System.out.println("Ok thanks...");
        }
        
    }
    
    private void setDataToForm(Scanner scanInput, String input, DFFData dfMap){
        for(Entry<String, Field> entry : dfMap.getData().entrySet()){
           System.out.println(input+" "+entry.getKey()+":");
           String field = scanInput.nextLine();
           entry.getValue().setValue(field);
        }
    }

    public void dinamicDataTest() {
        List<Document> documents = new ArrayList<Document>();
        MongoCollection<Document> collection = database.getCollection("flow_data");
        HisData hData = new HisData();
        for (int a = 0; a < 100; a++) {
            for (int i = 0; i < 10; i++) {
                HDataModel dModel = new HDataModel(i);
                Document doc = new Document("user", a);
                for (Entry<String, Data> entry : dModel.getDataPackage().entrySet()) {
                    doc.append(entry.getKey(), entry.getValue().getData() + i);
                }
                documents.add(doc);
            }
        }
        collection.insertMany(documents);
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

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

}
