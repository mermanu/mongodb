/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author manuelmerida
 */
public class HDataModel {
    
    private Map<String,Data> dataPackage;

    public HDataModel(int number) {
        dataPackage=new HashMap<>();
        for(int i=0; i<number; i++){
            dataPackage.put("custom"+i, new Data("custom"+i, "test custom"+i));
        }
    }     

    public Map<String, Data> getDataPackage() {
        return dataPackage;
    }

    public void setDataPackage(Map<String, Data> dataPackage) {
        this.dataPackage = dataPackage;
    }
    
    
    
}
