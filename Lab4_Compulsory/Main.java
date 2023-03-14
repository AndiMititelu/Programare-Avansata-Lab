package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[] :: new);
        var projects = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[] :: new);
        List<Student> studentList = new LinkedList<>();
        studentList.addAll(Arrays.asList(students));
        Collections.sort(studentList, (stud1, stud2) -> stud1.getName().compareTo(stud2.getName())); //daca vreau sa fie ordonate desc schimb ordinea stud
        for(Student s : studentList) {
            System.out.print(s.getName() + " ");
        }
        System.out.println();
        Set<Project> projectSet = new TreeSet<>();
        projectSet.addAll(Arrays.asList(projects));
        for(Project p : projectSet) {
            System.out.print(p.getName() + " ");
        }

    }
}