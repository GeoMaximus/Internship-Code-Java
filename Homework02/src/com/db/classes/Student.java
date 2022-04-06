package com.db.classes;


public class Student implements Comparable<Student>{

    private String name;
    private double grade;


    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public double getGrade() {
        return this.grade;
    }

    @Override
    public int compareTo(Student o) {
        if(this.getGrade() > o.getGrade()){
            return -1;
        }
        else if(this.getGrade() == o.getGrade()) {
            return 0;
        }
        else return 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
