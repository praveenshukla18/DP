package com.company;

import com.company.beans.Item;
import com.company.beans.LookUp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int knapsack(List<Item> items, int capacity, int itemIndex, LookUp lookUp){
        if(itemIndex < 0 || capacity == 0){
            return 0;
        }
        Integer lookUpMapData = lookUp.getFromLookUp(itemIndex,capacity);
        if(lookUpMapData != null && lookUpMapData > 0){
            return lookUpMapData;
        }
        int value;
        if(capacity - items.get(itemIndex).getWeight() < 0){
            value = knapsack(items,capacity,itemIndex-1,lookUp);
        }else{
            value = Math.max(
                    knapsack(items,capacity,itemIndex-1,lookUp),
                    items.get(itemIndex).getValue() + knapsack(items,capacity - items.get(itemIndex).getWeight(),itemIndex - 1,lookUp)
            );
        }
        lookUp.updateInLookUpMap(itemIndex,capacity,value);
        return value;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(12,190));
        items.add(new Item(56,50));
        items.add(new Item(80,10));
        items.add(new Item(5,30));
        items.add(new Item(23,90));

        int capacity = 240;

        int value = knapsack(items,capacity,items.size()-1,new LookUp());
        System.out.println(value);
    }
}
