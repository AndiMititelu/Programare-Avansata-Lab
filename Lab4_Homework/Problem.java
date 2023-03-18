package org.example;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class Problem {
    List<Student> allStudents;
    Set<Project> allProjects;

    public Problem() {
        allStudents = new LinkedList<>();
        allProjects = new TreeSet<>();
    }
    public void setAllStudents(Student... students) {
        for(Student stud : students) {
            allStudents.add(stud);
        }
    }

    public void setAllProjects(Project... projects) {
        for(Project proj : projects) {
            allProjects.add(proj);
        }
    }
    public List<Student> getAllStudents() {
        return allStudents;
    }
    public Set<Project> getAllProjects() {
        return allProjects;
    }
    public Map<Student, Project> findBestMatching() {
        Map<Student, Project> matching = new HashMap<>();
        for(Student student : allStudents) {
            for(Project project : student.getAdmissibleProjects()) {
                if(student.getAssignedProject() == null && project.getAssignedStudent() == null) {
                    project.setAssignedStudent(student);
                    student.setAssignedProject(project);
                    matching.put(student, project);
                }
            }
        }
        return matching;
    }

}
