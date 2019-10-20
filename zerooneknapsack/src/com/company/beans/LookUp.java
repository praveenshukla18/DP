package com.company.beans;

import java.util.HashMap;

public class LookUp {

    private HashMap<Item,Integer> lookUpMap = new HashMap<>();

    public void updateInLookUpMap(int itemIndex, int capacity, int value){
        Item item = new Item(itemIndex,capacity);
        lookUpMap.put(item,value);
    }

    public Integer getFromLookUp(int itemIndex, int capacity){
        Item item = new Item(itemIndex,capacity);
        return lookUpMap.get(item);
    }
}
