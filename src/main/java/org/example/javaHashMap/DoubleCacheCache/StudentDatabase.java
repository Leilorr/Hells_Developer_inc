package org.example.javaHashMap.DoubleCacheCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase {
    private final Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();
    private final Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public void addStudentWithSubjects(Student student, Map<Subject, Integer> subjects) {
        if (studentSubjects.containsKey(student)){
            throw new IllegalArgumentException("Student already exists.");
        }
        studentSubjects.put(student, new HashMap<>(subjects));
        for (Subject subject : subjects.keySet()){
            subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
        }
    }

    public void addSubjectForStudent(Student student, Subject subject, int grade){
        if (!studentSubjects.containsKey(student)){
            throw new IllegalArgumentException("Student does not exist.");
        }
        studentSubjects.get(student).put(subject, grade);
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(student);
    }

    public void removeStudent(Student student){
        if (!studentSubjects.containsKey(student)){
            throw new IllegalArgumentException("Student does not exist.");
        }
        for (Subject subject : studentSubjects.get(student).keySet()){
            subjectStudents.get(subject).remove(student);
        }
        studentSubjects.remove(student);
    }

    public void printAllStudentsWithGrades(){
        for (Map.Entry<Student, Map<Subject, Integer>> entry : studentSubjects.entrySet()){
            System.out.println("Student: " + entry.getKey().getName());
            for (Map.Entry<Subject, Integer> subjectEntry : entry.getValue().entrySet()){
                System.out.println("  Subject: " + subjectEntry.getKey().getName() + ", Grade: " + subjectEntry.getValue());
            }
        }
    }

    public void addSubjectwithStudent(Subject subject, List<Student> students){
        if (subjectStudents.containsKey(subject)){
            throw new IllegalArgumentException("Subject already exists.");
        }
        subjectStudents.put(subject, new ArrayList<>(students));
        for (Student student : students){
            studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, 0);
        }
    }

    public void addStudentToSubject(Student student, Subject subject, int grade){
        if (!subjectStudents.containsKey(subject)){
            throw new IllegalArgumentException("Subject does not exist.");
        }
        subjectStudents.get(subject).add(student);
        studentSubjects.computeIfAbsent(student, k -> new HashMap<>()).put(subject, grade);
    }

    public void removeStudentFromSubject(Student student, Subject subject){
        if (!subjectStudents.containsKey(subject)){
            throw new IllegalArgumentException("Subject does not exist.");
        }
        subjectStudents.get(subject).remove(student);
        if (studentSubjects.containsKey(student)){
            studentSubjects.get(student).remove(subject);
        }
    }

    public void printAllSubjectsWithStudents(){
        for (Map.Entry<Subject, List<Student>> entry : subjectStudents.entrySet()){
            System.out.println("Subject: " + entry.getKey().getName());
            for (Student student : entry.getValue()){
                System.out.println("  Student: " + student.getName());
            }
        }
    }
}
