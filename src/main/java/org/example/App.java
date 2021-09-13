package org.example;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 John Slauter
 */

import java.util.Scanner;

public class App 
{

    private static final double tax_rate = .055;

    public static void main( String[] args )
    {

        Scanner s = new Scanner(System.in);

        String state, temp, output = new String();

        double amount, tax;

        System.out.print("What is the order amount? ");

        temp = s.nextLine();

        amount = String_to_double(temp);

        System.out.print("What is the state? ");

        state = s.nextLine();

        if(state.equals("WI")){

            tax = ceiling(tax_rate*amount);

            output = output.concat(String.format("The subtotal is $%.2f.\nThe tax is $%.2f.\n", amount, tax));

            amount += tax;

        }

        output = output.concat(String.format("The total is $%.2f.", amount));

        System.out.print(output);

    }

    private static double ceiling(double num){

        int temp = (int)(num*100);

        if((num*1000)%(temp*10) > 0){

            return ((double)(temp+1))/100;

        }

        return ((double)temp)/100;

    }

    private static int String_to_int(String s){

        int res = 0;

        for(int i = 0; i < s.length(); i++){

            res += (s.charAt(i)-'0')*pow(10, s.length()-1-i);

        }

        return res;

    }

    private static double String_to_double(String s){

        int flag = 0, decimal_index = -1;

        double res = 0.0;

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '.'){

                decimal_index = i;

            }

        }

        if(decimal_index == -1){

            return(String_to_int(s));

        }

        for(int i = 0; i < s.length(); i++){

            if(i == decimal_index){

                continue;

            }

            else if(i < decimal_index || decimal_index == -1) {

                res += (s.charAt(i) - '0') * pow(10, decimal_index-1-i);

            }

            else{

                res += (s.charAt(i) - '0') * pow(10, -1*(i-decimal_index));

            }


        }

        return res;

    }

    private static double pow(int base, int exponent){

        if(exponent < 0){

            return pow_negative_exponent(base, -1*exponent);

        }

        double res = 1;

        for(int i = 0; i < exponent; i++){

            res *= base;

        }

        return res;

    }

    private static double pow_negative_exponent(int base, int exponent){

        double res = 1;

        for(int i = 0; i < exponent; i++){

            res /= base;

        }

        return res;

    }

}
