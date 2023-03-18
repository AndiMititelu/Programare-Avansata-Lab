package org.example;
import java.util.*;

public class Student implements Comparable<Student>{
    private String name;
    private List<Project> admissibleProjects;
    private Project assignedProject;
    public Student(String name) {
        this.name = name;
        admissibleProjects = new ArrayList<>();
        assignedProject = null;
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

    public Project getAssignedProject() {
        return assignedProject;
    }

    public void setAssignedProject(Project assignedProject) {
        this.assignedProject = assignedProject;
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return this.name + " - admissible proj: " + getAdmissibleProjects();
    }

}
