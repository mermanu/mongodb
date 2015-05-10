/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application.forms;

import com.stacks.mongodb.application.data.DFFData;
import java.util.Map;

/**
 *
 * @author manuelmerida
 */
public class DFDocument {
    protected Map<String,DFFData> document;
    
    protected DFFData keys;
    
    protected String collection;

    public Map<String, DFFData> getDocument() {
        return document;
    }

    public void setDocument(Map<String, DFFData> document) {
        this.document = document;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public DFFData getKeys() {
        return keys;
    }

    public void setKeys(DFFData keys) {
        this.keys = keys;
    }
      
}
