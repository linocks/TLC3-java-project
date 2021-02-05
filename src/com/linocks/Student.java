package com.linocks;

import java.util.List;
import java.util.stream.DoubleStream;

public class Student implements Nameable, HasLevel{
    List<Double> studentGrades;
    private String studentName;
    private Level level;

    public Student(List<Double> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public Student(List<Double> studentGrades, String studentName) {
        this.studentGrades = studentGrades;
        this.studentName = studentName;
    }

    public Student(List<Double> studentGrades, String studentName, Level level) {
        this.studentGrades = studentGrades;
        this.studentName = studentName;
        this.level = level;
    }

    public double getAverageGrade(){
        double total = 0.0;
        for(double d : studentGrades){
            total += d;
        }

        return total / studentGrades.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentGrades=" + studentGrades +
                ", studentName='" + studentName + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public String getName() {
        return this.studentName;
    }

    @Override
    public Level getLevel() {
        return this.level;
    }

    public DoubleStream getGradesAsDoubleStream(){
        return studentGrades.stream().mapToDouble(s->s.doubleValue());
    }


}
