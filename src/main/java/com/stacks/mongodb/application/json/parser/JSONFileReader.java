/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application.json.parser;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author manuelmerida
 */
public class JSONFileReader {

    public String getJsonFromFile(String name) {
        String contents = null;
        try {
            File file = new File("/Users/manuelmerida/NetBeansProjects/mongodb/src/main/resources/" + name + ".json");
            contents = FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException ex) {
            Logger.getLogger(JSONFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contents;
    }

}
