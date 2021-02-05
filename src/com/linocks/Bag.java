package com.linocks;

import java.util.ArrayList;
import java.util.List;

public class Bag<T> {
    public List<T> bagList = new ArrayList<>();

    public void add(T bag){
        bagList.add(bag);
    }

    public void remove(T bag){
        bagList.remove(bag);
    }

    public void clear(){
        bagList.clear();
    }
}
