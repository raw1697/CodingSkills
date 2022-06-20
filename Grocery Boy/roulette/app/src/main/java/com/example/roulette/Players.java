package com.example.roulette;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



/**
 * Created by apple on 14/03/2019.
 */

public class Players {


    public static void main (String[] args) {

        int length;
        Scanner input = new Scanner(System.in);

        System.out.println("What is the name of the friends that will be partaking in card roulette?");
        length = input.nextInt();


        String[] names = new String [length];

        for(int counter = 0; counter < length; counter++){
            System.out.println("Enter the name of friend"+(counter+1));
            names[counter] =  input.next();
        }

        input.close();

        System.out.println("The name of the participants are");
        for(int counter = 0; counter < length; counter++){
            System.out.println(names[counter]);
        }



    }






}
