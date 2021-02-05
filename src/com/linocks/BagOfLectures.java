package com.linocks;

import java.util.ArrayList;
import java.util.List;

public class BagOfLectures {
    List<Lecture> lectureList = new ArrayList<>();

    public void add(Lecture lecture){
        lectureList.add(lecture);
    }

    public void remove(Lecture lecture){
        lectureList.remove(lecture);
    }

    public void clear(){
        lectureList.clear();
    }

}
