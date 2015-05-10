/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application;

import com.stacks.mongodb.application.builder.DataField;
import com.stacks.mongodb.application.builder.DateField;
import com.stacks.mongodb.application.builder.Field;
import com.stacks.mongodb.application.builder.NumberField;
import com.stacks.mongodb.application.builder.StringField;

/**
 *
 * @author manuelmerida
 */
public enum FieldTypes {
    STRING {

        @Override
        public Field getField() {
            return new StringField();
        }
    },NUMBER {

        @Override
        public Field getField() {
            return new NumberField();
        }
    },DATA {

        @Override
        public Field getField() {
            return new DataField();
        }
    },DATE {

        @Override
        public Field getField() {
            return new DateField();
        }
    },TIMESTAMP {

        @Override
        public Field getField() {
            return new DateField();
        }
    };
    
    
    public abstract Field getField();
}
