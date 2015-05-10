/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application.builder;

import com.stacks.mongodb.application.json.parser.JSONFileReader;
import java.util.Map;
import java.util.Scanner;
import org.bson.Document;

/**
 *
 * @author manuelmerida
 */
public class CollectionDefinition {
    
    private static final String KEY_INSERT="Insert ";
    
    private Document document;
    
    private String collection;
    
    private String jsonDefinition;

    public CollectionDefinition(String collection, String jsonDefinition) {
        this.collection = collection;
        this.jsonDefinition = jsonDefinition;
        initDefinition();
    }  
    
    private void initDefinition(){
        JSONFileReader fReader=new JSONFileReader();
        String json=fReader.getJsonFromFile(jsonDefinition);     
        this.document=Document.parse(json);
    }

    public void traverse(Document doc, Scanner scanInput) {
        
        for (Map.Entry<String, Object> entry : doc.entrySet()) {
            if (entry.getValue() instanceof String) {
                System.out.println(KEY_INSERT+" "+entry.getKey()+":");
                String field = scanInput.nextLine();
                entry.setValue(field);
            }
            if (entry.getValue() instanceof Document) {
                traverse((Document) entry.getValue(), scanInput);
            }
        }
    }  

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getJsonDefinition() {
        return jsonDefinition;
    }

    public void setJsonDefinition(String jsonDefinition) {
        this.jsonDefinition = jsonDefinition;
    }

}
