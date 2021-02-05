package test;

import com.linocks.Lecture;
import com.linocks.NaughtyStudent;
import com.linocks.Student;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LectureTest {

    @Test
    void getHighestAverageGrade() {
        Lecture lecture = new Lecture();

        List<Double> grade1 = Arrays.asList(2.5,3.5,4.5,1.5);
        List<Double> grade2 = Arrays.asList(1.5,2.5,3.5,4.5);
        List<Double> grade3 = Arrays.asList(3.5,3.5,4.5,1.5);
        List<Double> grade4 = Arrays.asList(2.5,3.5,4.5,6.5);


        lecture.enter(new Student(grade1));
        lecture.enter(new Student(grade2));
        lecture.enter(new Student(grade3));
        lecture.enter(new Student(grade4));



        assertEquals(4.25,lecture.getHighestAverageGrade());



    }

    @Test
    void getAverageGradeOfNaughty() {
        Lecture lecture = new Lecture();

        lecture.enter(new NaughtyStudent(Arrays.asList(2.5,3.5,4.5,1.5))); //average grade is 3
        lecture.enter(new NaughtyStudent(Arrays.asList(5.5,2.5,3.5,4.5))); // average grade is 4

        assertEquals(4.0,lecture.getStudentList().get(1).getAverageGrade());
    }
}