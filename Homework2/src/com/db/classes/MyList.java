package com.db.classes;

import java.util.ArrayList;

public class MyList<T> {

    private ArrayList<T> list = new ArrayList<>();

    public MyList(int dimension){
        //constructor

    }

    public void add(T element){
        //add an element to the list
        list.add(element);
    }

    public void print(){
        //print the list
        for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public boolean lookup(T element){
        //search for an element, return true if found, return false if not found
        boolean flag = false;
        for(int i=0;i<list.size();i++){
            if(list.get(i) == element)
                flag = true;
        }
        return flag;
    }

}
