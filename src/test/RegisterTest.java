package test;

import com.linocks.Level;
import com.linocks.NaughtyStudent;
import com.linocks.Register;
import com.linocks.Student;
import org.junit.jupiter.api.Test;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {

    @Test
    void getRegister() {
        List<Student> studentList = new ArrayList<Student>();

        //creates individual students
        Student student1 = new Student(Arrays.asList(3.6,4.0),"Enock Boadi-Ansah");
        Student student2 = new Student(Arrays.asList(1.6,2.0),"Emmanuel Coffie Debrah");
        Student student3 = new Student(Arrays.asList(2.6,3.0),"Joshuah Chartey Marbell");
        Student student4 = new Student(Arrays.asList(2.6,3.0),"Michael Likem Dorgbefu");

        //adds students to studentList
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        List<NaughtyStudent> naughtyList = new ArrayList<>();
        Register register = new Register(studentList);

//        assertEquals(4,register.list.size());

//        register.getRegister().forEach(System.out::println); //print out the names of all the registered students

        assertEquals(4, register.getRegister().size()); //check whether we have four names in our register

    }

    @Test
    void getRegisterByLevel() {
        List<Student> studentList = new ArrayList<Student>();

        Student student = new Student(Arrays.asList(3.6,4.0),"Sam Moorehouse", Level.FOUR_HUNDRED);
        Student student1 = new Student(Arrays.asList(3.6,4.0),"Enock Boadi-Ansah", Level.FOUR_HUNDRED);
        Student student2 = new Student(Arrays.asList(1.6,2.0),"John Erbynn", Level.THREE_HUNDRED);
        Student student3 = new Student(Arrays.asList(1.6,2.0),"Emmanuel Coffie Debrah", Level.THREE_HUNDRED);
        Student student4 = new Student(Arrays.asList(2.6,3.0),"Joshuah Chartey Marbell", Level.TWO_HUNDRED);
        Student student5 = new Student(Arrays.asList(2.6,3.0),"Michael Likem Dorgbefu", Level.HUNDRED);

        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        Register register = new Register(studentList);

        //get users at a level
//        List<String> studentNames = register.getRegisterByLevel(Level.HUNDRED);// this method has been changed to return a map
        Map<Level,List<Student>> studentNames = register.getRegisterByLevel(Level.FOUR_HUNDRED);// this method has been changed to return a map

        for(Map.Entry<Level,List<Student>> entry : studentNames.entrySet()){
            System.out.println("LEVEL: "+entry.getKey());
            entry.getValue().stream().forEach(System.out::println);
        }
        System.out.println("\n\n");

        register.printReport();

        assertEquals(1, studentNames.size());

    }

    @Test
    void getStudent() throws Exception {
        List<Student> studentList = new ArrayList<Student>();

        Student student = new Student(Arrays.asList(3.6,4.0),"Sam Moorehouse", Level.FOUR_HUNDRED);
        Student student1 = new Student(Arrays.asList(3.6,4.0),"Enock Boadi-Ansah", Level.FOUR_HUNDRED);
        studentList.add(student);
        studentList.add(student1);


        Register register = new Register(studentList);
        register.printReport();

        assertEquals("Enock Boadi-Ansah",register.getStudent("Enock Boadi-Ansah"));
    }

    @Test
    void getOverAllHighestGrade() {
        List<Student> studentList = new ArrayList<Student>();

        Student student = new Student(Arrays.asList(3.6,4.0),"Sam Moorehouse", Level.FOUR_HUNDRED);
        Student student1 = new Student(Arrays.asList(3.6,7.0),"Enock Boadi-Ansah", Level.FOUR_HUNDRED);
        studentList.add(student);
        studentList.add(student1);


        Register register = new Register(studentList);

        assertEquals(7, register.getOverAllHighestGrade());
    }

    @Test
    void getOverAllAverageGrade() {

        List<Student> studentList = new ArrayList<Student>();

        Student student = new Student(Arrays.asList(3.6,4.0),"Sam Moorehouse", Level.FOUR_HUNDRED);
        Student student1 = new Student(Arrays.asList(3.6,7.0),"Enock Boadi-Ansah", Level.FOUR_HUNDRED);
        studentList.add(student);
        studentList.add(student1);


        Register register = new Register(studentList);

        assertEquals(4.55, register.getOverAllAverageGrade());
    }

    @Test
    void getGradesAboveSixty() {
        List<Student> studentList = new ArrayList<Student>();

        Student student = new Student(Arrays.asList(3.6,88.1),"Sam Moorehouse", Level.FOUR_HUNDRED);
        Student student1 = new Student(Arrays.asList(3.6,7.0),"Enock Boadi-Ansah", Level.FOUR_HUNDRED);
        studentList.add(student);
        studentList.add(student1);


        Register register = new Register(studentList);

        System.out.println("Grades Above Sixty");
        register.getGradesAboveSixty().stream().forEach(System.out::println);

        assertEquals(88.1, register.getGradesAboveSixty().get(0));
    }

    @Test
    void getStudentByName() {
        List<Student> studentList = new ArrayList<Student>();

        Student student = new Student(Arrays.asList(3.6,4.0),"Sam Moorehouse", Level.FOUR_HUNDRED);
        Student student1 = new Student(Arrays.asList(3.6,4.0),"Enock Boadi-Ansah", Level.FOUR_HUNDRED);
        Student student2 = new Student(Arrays.asList(1.6,2.0),"John Erbynn", Level.THREE_HUNDRED);
        Student student3 = new Student(Arrays.asList(1.6,2.0),"Emmanuel Coffie Debrah", Level.THREE_HUNDRED);
        Student student4 = new Student(Arrays.asList(2.6,3.0),"Joshuah Chartey Marbell", Level.TWO_HUNDRED);
        Student student5 = new Student(Arrays.asList(2.6,3.0),"Michael Likem Dorgbefu", Level.HUNDRED);

        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);


        Register register = new Register(studentList);

        List<Student> students = register.getStudentByName(Arrays.asList("Enock Boadi-Ansah","John Erbynn"));

        students.forEach(System.out::println);

        assertEquals(2, students.size());
    }
}