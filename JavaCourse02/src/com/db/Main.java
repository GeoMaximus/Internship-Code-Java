package com.db;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
//	System.out.println("Hello world");
    int Sum = 0;
    for (int i = 0;i<10;i++){
        Sum+=i;
    }

//    System.out.println(Sum);

    Car car = new Car();

    Car car1 = new Car(1234589, "Toyota", 220);
//    System.out.println(car1.getBrand());
//    System.out.println((car1.getSerialNo()));
//    System.out.println(car1.getMaxSpeed());
//
//    System.out.println(car1);


        int[] array0 = new int[5];
        int[] array = new int[]{1,2,3,4,5};

        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }

        System.out.println(array[0]);

        int sum = 0;
        for(int i =0;i<array.length;i++){
            sum += array[i];
        }
        System.out.println(sum);

        int matrix[][] = new int[3][4];

        int matrix1[][] = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
        System.out.println(matrix);

        for (int[] ints : matrix1) {
            for(int elem : ints){
                System.out.print(elem+" ");
            }
            System.out.println();
        }

        System.out.println("-------------------------");
        
        for (int i = 0; i < matrix1.length; i++) {
            for(int y = 0; y< 3;y++){
                System.out.print(matrix1[i][y] + " ");
        }
            System.out.println();

            }

        long itr = 0;
        for (int u = 100; u <= 200; u--) {
            itr++;
        }

        System.out.println(itr);

        }



    }
