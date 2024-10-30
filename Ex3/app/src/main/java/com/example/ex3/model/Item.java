package com.example.ex3.model;

public class Item {
    private String name;

    public Item(String name){
        this.name = name;
    }

    public Item(){

    }

    public void setItemName(String newName){
        this.name = newName;
    }

    public String getItemName(){
        return this.name;
    }
}
