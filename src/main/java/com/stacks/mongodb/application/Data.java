/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stacks.mongodb.application;

/**
 *
 * @author manuelmerida
 */
public class Data {
    private String code;
    private String data;

    public Data(String code, String data) {
        this.code = code;
        this.data = data;
    }    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
