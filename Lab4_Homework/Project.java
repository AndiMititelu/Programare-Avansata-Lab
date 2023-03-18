package org.example;

public class Project implements Comparable<Project>{
    private String name;
    private Student assignedStudent;
    public Project(String name) {
        this.name = name;
        assignedStudent = null;
    }

    public String getName() {
        return name;
    }

    public Student getAssignedStudent() {
        return assignedStudent;
    }

    public void setAssignedStudent(Student assignedStudent) {
        this.assignedStudent = assignedStudent;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Project other) {
        return name.compareTo(other.getName());
    }
    @Override
    public String toString() {
        return this.name;
    }

}
