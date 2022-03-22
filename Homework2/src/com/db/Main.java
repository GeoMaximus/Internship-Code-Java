//1. Students Map with TreeSets
//        Define a Student class containing a name and grade property. Requirements:
//        •Create a constructor that receives the name and the grade of a student
//        •Implement method public double getGrade()
//        •Define a Map that hold keys from 0 to 10, corresponding to a rounded grade
//        •Each value stored in a key of a map will hold a TreeSet of Students, allowing storing them in descending order by grade.
//        E.g.: for key 8 in the Map, values of the corresponding TreeSet could be [Ionel: 8.49, Vasile: 7.50]
//        •Test the class in a main method
//
//2. MyList of Generics
//        •Define a class named MyList, which holds a list of elements using an array of elements of type T
//        •Define the following methods:
//public MyList(dimension)
//public void add(T element)
//public void print()
//public boolean lookup(T element)
//        •Test the class in a main method


package com.db;

import com.db.classes.MyList;
import com.db.classes.Student;
import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //DISCLAIMER! I might have not understood very well the task for this homework

        Map<Integer, TreeSet<Student>> catalogue = new HashMap<>();

        //tree set for 10
        TreeSet<Student> class10 = new TreeSet<>();
        class10.add(new Student("S13", 9.80));
        class10.add(new Student("S14", 10.00));
        //tree set for 9
        TreeSet<Student> class9 = new TreeSet<>();
        class9.add(new Student("S13", 9.30));
        class9.add(new Student("S14", 8.79));
        //tree set for 8
        TreeSet<Student> class8 = new TreeSet<>();
        class8.add(new Student("S13", 8.30));
        class8.add(new Student("S14", 7.79));
        //tree set for 7
        TreeSet<Student> class7 = new TreeSet<>();
        class7.add(new Student("S13", 7.30));
        class7.add(new Student("S14", 6.85));
        //tree set for 6
        TreeSet<Student> class6 = new TreeSet<>();
        class6.add(new Student("S13", 6.20));
        class6.add(new Student("S14", 5.50));
        //tree set for 5
        TreeSet<Student> class5 = new TreeSet<>();
        class5.add(new Student("S13", 5.49));
        class5.add(new Student("S14", 4.78));
        //tree set for 4
        TreeSet<Student> class4 = new TreeSet<>();
        class4.add(new Student("S13", 4.15));
        class4.add(new Student("S14", 3.99));
        //tree set for 3
        TreeSet<Student> class3 = new TreeSet<>();
        class3.add(new Student("S1", 2.57));
        class3.add(new Student("S2", 3.00));
        class3.add(new Student("S3", 2.50));
        class3.add(new Student("S4", 3.12));
        class3.add(new Student("S5", 3.32));

        //tree set for 2
        TreeSet<Student> class2 = new TreeSet<>();
        class2.add(new Student("S6", 1.89));
        class2.add(new Student("S7", 1.89));
        class2.add(new Student("S8", 2.32));
        class2.add(new Student("S9", 2.22));
        class2.add(new Student("S10", 1.60));

        //tree set for 1
        TreeSet<Student> class1 = new TreeSet<>();
        class1.add(new Student("S11", 0.70));
        class1.add(new Student("S12", 1.20));

        //tree set for 0
        TreeSet<Student> class0 = new TreeSet<>();
        class0.add(new Student("S13", 0.30));
        class0.add(new Student("S14", 0.49));

        catalogue.put(0, class0);
        catalogue.put(1, class1);
        catalogue.put(2, class2);
        catalogue.put(3, class3);
        catalogue.put(4, class4);
        catalogue.put(5, class5);
        catalogue.put(6, class6);
        catalogue.put(7, class7);
        catalogue.put(8, class8);
        catalogue.put(9, class9);
        catalogue.put(10, class10);

        System.out.println("------------EXERCISE 1-------------");
        System.out.println(catalogue.get(0));
        System.out.println(catalogue.get(1));
        System.out.println(catalogue.get(2));
        System.out.println(catalogue.get(3));
        System.out.println(catalogue.get(4));
        System.out.println(catalogue.get(5));
        System.out.println(catalogue.get(6));
        System.out.println(catalogue.get(7));
        System.out.println(catalogue.get(8));
        System.out.println(catalogue.get(9));
        System.out.println(catalogue.get(10));

        System.out.println();
        System.out.println("------------EXERCISE 2-------------");

        MyList ml = new MyList(5);
        ml.add("A string");
        ml.add(45);
        ml.add('c');
        Student s1 = new Student("S14", 0.49);
        Student s2 = new Student("S15", 7.49);
        ml.add(s1);

        System.out.println("---PRINT METHOD---");
        ml.print();

        System.out.println("---LOOKUP METHOD---");
        System.out.println(ml.lookup(45));
        System.out.println(ml.lookup("A string"));
        System.out.println(ml.lookup(13));
        System.out.println(ml.lookup("SomeString"));
        System.out.println(ml.lookup(s1));
        System.out.println(ml.lookup(s2));





    }
}
