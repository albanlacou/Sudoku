package com.company;

import java.sql.ResultSet;
import java.util.SortedMap;

public class Main {
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";
    static int[][] boardEasy = {
            {4, 0, 0, 1, 0, 2, 6, 8, 0},
            {1, 0, 0, 0, 9, 0, 0, 0, 4},
            {0,  3, 8, 0, 6, 4, 0, 1, 0},
            {0, 0, 5, 0, 7, 1, 9, 2, 0},
            {0, 2, 6, 0, 0, 9, 8, 0, 0},
            {8, 0, 0, 2, 5, 0, 0, 0, 0},
            {9, 0, 3, 0, 0, 0, 0, 0, 8},
            {2, 5, 0, 6, 0, 0, 1, 0, 7},
            {6, 0, 7, 9, 0, 5, 3, 0, 0}
    };


    public static void afficheGrille(int[][] tableau){

        for(int colonne = 0; colonne < 9 ;colonne++){
            if(colonne%3 == 0){
                System.out.print(RED +"______________________________________"+ RESET);
                System.out.println();
            }else{
                System.out.print("______________________________________");
                System.out.println();
            }

            for(int ligne =0;ligne<9;ligne++){

                if(ligne%3 == 0){
                    System.out.print(RED+" | "+RESET);
                }else{
                    System.out.print(" | ");
                }
                System.out.print(tableau[colonne][ligne]);

            }System.out.print(RED+" | "+RESET);
            System.out.println("");

        }System.out.print(RED +"______________________________________"+ RESET);




    }


    public static void main(String[] args) {
    afficheGrille(boardEasy);







    }
}
