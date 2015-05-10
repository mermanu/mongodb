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
public class FormCustom extends DFFData {

    public FormCustom() {
        docName="custom";
        data = new HashMap<>();
        data.put("cus1", FieldTypes.STRING.getField());
        data.put("cus2", FieldTypes.STRING.getField());
        data.put("cus3", FieldTypes.STRING.getField());
        data.put("cus4", FieldTypes.STRING.getField());
        data.put("cus5", FieldTypes.STRING.getField());
        data.put("cus6", FieldTypes.STRING.getField());
        data.put("cus7", FieldTypes.TIMESTAMP.getField());
        data.put("cus8", FieldTypes.DATA.getField());
        data.put("cus9", FieldTypes.NUMBER.getField());
        data.put("cus10", FieldTypes.DATE.getField());
    }
}
