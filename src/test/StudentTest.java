package test;

import com.linocks.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getAverageGrade() {
        //        List<Double> grades = Arrays.asList(2.5,6.6,6.8,7.8,5.8);
        List<Double> grades = new ArrayList<>();
        grades.add(5.5);
        grades.add(6.5);
        grades.add(7.5);

        Student st = new Student(grades);

        assertEquals(6.53, st.getAverageGrade(),.05);
    }
}