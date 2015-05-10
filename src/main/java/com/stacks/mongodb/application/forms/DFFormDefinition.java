/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application.forms;

import com.stacks.mongodb.application.data.DFFData;
import java.util.HashMap;

/**
 *
 * @author manuelmerida
 */
public class DFFormDefinition extends DFDocument{

    
  
    public DFFormDefinition() {       
        this.collection = "flow_data";       
        this.keys = new FormKeys();
        DFFData data = new FormData();
        DFFData custom = new FormCustom();
        this.document=new HashMap<>();
        this.document.put(data.getDocName(), data);
        this.document.put(custom.getDocName(), custom);       
    }
    
    

}
