/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application.data;

import com.stacks.mongodb.application.builder.Field;
import java.util.Map;

/**
 *
 * @author manuelmerida
 */
public class DFFData {

    protected String docName;   
    
    protected Map<String, Field> data;

    public DFFData() {
    }

    public Map<String, Field> getData() {
        return data;
    }

    public void setData(Map<String, Field> data) {
        this.data = data;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }      
    
}
