package test;

import com.linocks.Bag;
import com.linocks.Lecture;
import com.linocks.NaughtyStudent;
import com.linocks.Student;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void add() {
        Bag<Lecture> bagOfLectures = new Bag<>();

        Lecture science = new Lecture();
        Lecture math = new Lecture();


        //students enter into the science class
        science.enter(new NaughtyStudent(Arrays.asList(2.5,3.5,4.5,1.5))); //average grade is 3
        science.enter(new NaughtyStudent(Arrays.asList(5.5,2.5,3.5,4.5))); // average grade is 4

        //students enter into the math class
        math.enter(new Student(Arrays.asList(5.5,6.5,4.5,1.5))); //average grade is 3
        math.enter(new Student(Arrays.asList(2.5,4.5,4.5,7.5))); // average grade is 4

        bagOfLectures.add(science);
        bagOfLectures.add(math);

        assertEquals(2, bagOfLectures.bagList.size()); //there are currently 2 lectures (math and science) in the bag of lectures
    }
}