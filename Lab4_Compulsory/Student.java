package org.example;
import java.util.*;
public class Student implements Comparable<Student>{
    String name;
    List<Project> admissibleProjects;
    public Student(String name) {
        this.name = name;
        admissibleProjects = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmissibleProjects(Project... admissibleProjects) {
        this.admissibleProjects = Arrays.asList(admissibleProjects);
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.getName());
    }
}
