/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msuite.mongodb.application.definition;

import java.io.IOException;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author manuelmerida
 */
public class JSONDefinition {

    public String getJsonFromFile(String fileName) {

        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName + ".json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public String getJsonFromCollection(){
        
        return null;        
    }

}
