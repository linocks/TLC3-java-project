package com.linocks;

import java.util.List;

public class NaughtyStudent extends Student {

    public NaughtyStudent(List<Double> studentGrades) {
        super(studentGrades);
    }

    public double getAverageGrade() {
        double newAverage = super.getAverageGrade() * 0.1 + super.getAverageGrade();
        return newAverage;
    }
}
