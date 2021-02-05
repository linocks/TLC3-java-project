package com.linocks;

import java.util.ArrayList;
import java.util.List;

public class BagOfStudents {
    List<Student> studentList = new ArrayList<>();

    public void add(Student student){
        studentList.add(student);
    }

    public void remove(Student student){
        studentList.remove(student);
    }

    public void clear(){
        studentList.clear();
    }
}


