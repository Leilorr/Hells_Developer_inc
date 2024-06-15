package javaHashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;
}

@Data
class Key {
    private String faculty;
    private int year;
}

@Data
@AllArgsConstructor
class Main {
    private static List<Student> students = new ArrayList<>();
    private static Map<Key, List<Student>> groupedStudents = new HashMap<>();

    public static void main(String[] args) {
        students.add(new Student("John", "Computer Science", 2));
        students.add(new Student("Emily", "Mathematics", 1));
        students.add(new Student("Michael", "Physics", 1));
        students.add(new Student("Sophia", "Computer Science", 2));
        students.add(new Student("William", "Physics", 2));
        students.add(new Student("Olivia", "Computer Science", 1));
        students.add(new Student("James", "Mathematics", 2));
        students.add(new Student("Ava", "Physics", 1));
        students.add(new Student("Benjamin", "Physics", 1));
        students.add(new Student("Mia", "Mathematics", 2));

        System.out.println(groupingStudentsByFacultyAndYear(students));
        System.out.println(addNewStudent("Noah", "Mathematics", 2));
        System.out.println(removeStudent("Emily", "Mathematics", 1));
        System.out.println(searchAllStudentsByFacultyAndYear("Mathematics", 2));

    }

    public static Map<Key, List<Student>> groupingStudentsByFacultyAndYear(List<Student> students) {
        for (Student student : students) {
            Key key = getKey(student.getFaculty(), student.getYear());
            if (!groupedStudents.containsKey(key)) {
                groupedStudents.put(key, new ArrayList<>());
            }
            groupedStudents.get(key).add(student);
        }
        return groupedStudents;
    }


    public static Map<Key, List<Student>> addNewStudent(String name, String faculty, int year) {
        Key key = getKey(faculty, year);
        if (!groupedStudents.containsKey(key)) {
            groupedStudents.put(key, new ArrayList<>());
        }
        groupedStudents.get(key).add(new Student(name, faculty, year));
        return groupedStudents;
    }

    public static Map<Key, List<Student>> removeStudent(String name, String faculty, int year) {
        Key key = getKey(faculty, year);
        if (!groupedStudents.containsKey(key)) {
            groupedStudents.put(key, new ArrayList<>());
        }
        groupedStudents.get(key).remove(new Student(name, faculty, year));
        return groupedStudents;
    }

    public static List<Student> searchAllStudentsByFacultyAndYear(String faculty, int year) {
        Key key = getKey(faculty, year);
        return groupedStudents.get(key);
    }

    private static Key getKey(String faculty, int year) {
        Key key = new Key();
        key.setFaculty(faculty);
        key.setYear(year);
        return key;
    }
}