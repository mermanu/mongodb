/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msuite.mongodb.application.builder;

import com.msuite.mongodb.application.components.types.DataField;
import com.msuite.mongodb.application.components.types.DateField;
import com.msuite.mongodb.application.components.Field;
import com.msuite.mongodb.application.components.types.NumberField;
import com.msuite.mongodb.application.components.types.StringField;

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
