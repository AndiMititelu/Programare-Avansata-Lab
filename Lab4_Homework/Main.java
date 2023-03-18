package org.example;

import com.github.javafaker.Faker;

import java.awt.*;
import java.util.stream.IntStream;
//import org.jgrapht.*;

public class Main {
    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i))
                .toArray(Student[] :: new);
        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i))
                .toArray(Project[] :: new);

        students[0].setAdmissibleProjects(projects[0], projects[1], projects[2]);
        students[1].setAdmissibleProjects(projects[0], projects[1]);
        students[2].setAdmissibleProjects(projects[0]);


        Problem problem = new Problem();
        problem.setAllStudents(students);
        problem.setAllProjects(projects);
        System.out.println(problem.getAllStudents());
        System.out.println(problem.getAllProjects());

        //Write a query that display all the students that have a number of preferences lower than the avg nr of preferences
        int totalPreferences = 0;
        for(Student stud : students) {
            totalPreferences += stud.getAdmissibleProjects().size();
        }

        //Calculate avg number of preferences
        double averagePreferences = problem.getAllStudents().stream()
                        .mapToInt(student -> student.getAdmissibleProjects().size())
                        .average()
                        .orElse(0.0);

        //Displaying students with fewer than average preferences
        System.out.println("Students with fewer than average number of preferences:");
        problem.getAllStudents().stream()
                .filter(student -> student.getAdmissibleProjects().size() < averagePreferences)
                .map(Student::getName)
                .forEach(System.out::println);

        //Generating random fake names for students and projects
        Faker faker = new Faker();
        for(int i = 0; i < students.length; i++) {
            students[i].setName(faker.name().fullName());
        }
        for(int i = 0; i < projects.length; i++) {
            projects[i].setName(faker.food().dish());
        }
        System.out.println(problem.findBestMatching());



    }
}