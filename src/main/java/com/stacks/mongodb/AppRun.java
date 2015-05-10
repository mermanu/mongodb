/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb;

import com.stacks.mongodb.application.MongoTest;
import java.util.Scanner;

/**
 *
 * @author manuelmerida
 */
public class AppRun {
    
    private static final String fNEW_LINE = System.getProperty("line.separator");
    private static final String FIELD_TO_SEARCH = "Please insert field top search:";
    private static final String EXIT = "exit";
    private static final String SEARCHING = "searching...";
    private static final String RESULTS = "rows: ";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MongoTest mongo = new MongoTest();
        
        try (Scanner scanInput = new Scanner(System.in)) {
            System.out.println(FIELD_TO_SEARCH);
            String field = scanInput.nextLine();
            
            while (!field.equals(EXIT)) {
                int i = mongo.queryCollection(field);
                System.out.println(RESULTS + String.valueOf(i));
                System.out.println(FIELD_TO_SEARCH);
                field = scanInput.nextLine();
                if (field.equals("more")) {
                    mongo.dinamicDataTest();
                }
                if (field.equals("form")) {
                    mongo.testInsertDefinition(scanInput);
                }
            }
            
        }
    }
    
}
