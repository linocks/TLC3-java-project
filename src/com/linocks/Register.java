package com.linocks;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Register<T extends Student> {
    List<T> list;

    public Register(List<T> list) { //(List<Student> studentList)
        this.list = list;
    }


    public List<String> getRegister() {
        //loop through list of students and call the
        //getName() function
//        List<String> namesList = new ArrayList<>();
//
//        for(Student s : list)
//            namesList.add(s.getName());
//        }

        //another way of retrieving the items
//        for (int i = 0; i < list.size() ; i++) {
//            namesList.add(list.get(i).getName());
//
//        }
//
//        return namesList;

        return list
                .stream()
                .map(s -> s.getName())
                .collect(Collectors.toList());
    }

//    public List<String> getRegisterByLevel(Level level){
//
    /*
        List<String> namesList = new ArrayList<>();

        for(Student s: list){
            if(s.getLevel() == level){
                namesList.add(s.getName());
            }
        }
        return namesList;
     */
//
//        return list
//                .stream()
//                .filter(s->s.getLevel() == level)
//                .map(s-> s.getName())
//                .collect(Collectors.toList());
//    }


    //Method refactored to return a map
    public Map<Level, List<Student>> getRegisterByLevel(Level level) {

        Map<Level, List<Student>> studentMap = new HashMap<>();

//        List<Student> listOfStudents = new ArrayList<Student>();

//        for(Student s: list){
//            if(s.getLevel() == level){
//                listOfStudents.add(s);
//            }
//        }


//        List<Student> studentList = list
//                .stream()
//                .filter(s -> s.getLevel() == level)
//                .collect(Collectors.toList());


        studentMap.put(level, list
                .stream()
                .filter(s -> s.getLevel() == level)
                .collect(Collectors.toList()));

//        studentMap.put(level,studentList);

        return studentMap;

    }

    public void printReport() {
        System.out.println("Printing Student List");
        System.out.println("======================\n");

         list
                .stream()
                .sorted(Comparator.comparing(Student::getLevel))//sorted list based on student level
                .forEach(s -> System.out.printf("%-30s%-15s%n", s.getName(), s.getLevel().name()));

    }


    public List<Student> sort(Comparator<Student> student) {

        return list.stream()
                .sorted(student)
                .collect(Collectors.toList());
    }

    public String getStudent(String studentName) throws Exception {

        /*
            for(Student s: list){
                if(s.getName().equals(studentName)){
                    return s.getName();
                }

            }

            throw new StudentNotFoundException("Student Not found");

         */


        T student = (T) list
                .stream()
                .filter(s -> s.getName().equals(studentName))
                .findAny()
                .orElseThrow(StudentNotFoundException::new);

        return student.getName();
    }

    public Optional<T> getOptionalStudent(String studentName) {
        return list
                .stream()
                .filter(s -> s.getName().equals(studentName))
                .findAny();
    }

    public List<T> getStudentByName(List<String> studentNames) {
        return list
                .stream()
                .map(s -> {

                    List<T> newList = new ArrayList<T>();
                    studentNames.stream().forEach(sn -> {

                        if (s.getName().equals(sn)) {
                            newList.add(s);
                        }

                    });
                    return newList;
                }).flatMap(Collection::stream).collect(Collectors.toList());
    }

    public double getOverAllHighestGrade() {
        return list
                .stream()
                .map(s -> s.studentGrades)
                .flatMap(s -> s.stream())
                .mapToDouble(s -> s.doubleValue())
                .max().getAsDouble();

    }

    public double getOverAllAverageGrade() {
        return list
                .stream()
                .map(s -> s.studentGrades)
                .flatMap(s -> s.stream())
                .mapToDouble(s -> s.doubleValue())
                .average().getAsDouble();
    }

    public List<Double> getGradesAboveSixty() {
        return list
                .stream()
                .map(s -> s.studentGrades)
                .flatMap(s -> s.stream())
//                .mapToDouble(s->s.doubleValue())
                .filter(s -> s > 60)
                .map(s -> s)
                .collect(Collectors.toList());

    }


}
