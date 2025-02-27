package org.example.javaHashMap.DoubleCacheCache;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase();

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");

        db.addStudentWithSubjects(alice, Map.of(math, 90, physics, 85));
        db.addStudentWithSubjects(bob, Map.of(math, 85));

        db.addSubjectForStudent(bob, physics, 75);

        db.printAllStudentsWithGrades();

        db.printAllSubjectsWithStudents();
    }
}
