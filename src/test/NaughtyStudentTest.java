package test;

import com.linocks.NaughtyStudent;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NaughtyStudentTest {

    @Test
    void getAverageGrade() {
        NaughtyStudent naughtyStudent = new NaughtyStudent(Arrays.asList(4.5,5.5,6.5,7.5)); //6.6

//        assertTrue(naughtyStudent instanceof Student);
        assertNotEquals(6, naughtyStudent.getAverageGrade());
    }
}