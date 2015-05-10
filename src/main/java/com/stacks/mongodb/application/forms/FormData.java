/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application.forms;

import com.stacks.mongodb.application.data.DFFData;
import com.stacks.mongodb.application.FieldTypes;
import java.util.HashMap;

/**
 *
 * @author manuelmerida
 */
public class FormData extends DFFData{

    public FormData() {
        docName="data";
        data=new HashMap<>();
        data.put("dat1", FieldTypes.STRING.getField());
        data.put("dat2", FieldTypes.STRING.getField());
        data.put("dat3", FieldTypes.TIMESTAMP.getField());
        data.put("dat4", FieldTypes.DATA.getField());
        data.put("dat5", FieldTypes.NUMBER.getField());
        data.put("dat6", FieldTypes.DATE.getField());
    }    
}
