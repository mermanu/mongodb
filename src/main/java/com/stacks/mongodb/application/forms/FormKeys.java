/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application.forms;

import com.stacks.mongodb.application.FieldTypes;
import com.stacks.mongodb.application.data.DFFData;
import java.util.HashMap;

/**
 *
 * @author manuelmerida
 */
public class FormKeys extends DFFData{

    public FormKeys() {
        docName="keys";
        data=new HashMap<>();
        data.put("id", FieldTypes.NUMBER.getField());
        data.put("idCenter", FieldTypes.NUMBER.getField());
        data.put("idProfile", FieldTypes.NUMBER.getField());
        data.put("idUser", FieldTypes.NUMBER.getField());
        data.put("idConfig", FieldTypes.NUMBER.getField());
        data.put("packey", FieldTypes.STRING.getField());
    }   
}
