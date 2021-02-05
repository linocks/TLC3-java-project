package com.linocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lecture {
    List<Student> studentList = new ArrayList<>();
    List<Double> averageGrades = new ArrayList<>();

    public void enter(Student student) {
        studentList.add(student);
        averageGrades.add(student.getAverageGrade());
    }

    public double getHighestAverageGrade() {
//        Collections.sort(averageGrades, Collections.reverseOrder());
//        return averageGrades.get(0);
        return averageGrades
                .stream()
                .sorted()
                .collect(Collectors.toList())
                .get(0);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public double getAverageGradeOfNaughty() {
        return studentList.get(0).getAverageGrade();
    }
}
