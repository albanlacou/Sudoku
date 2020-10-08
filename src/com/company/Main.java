package com.company;

import java.util.SortedMap;

public class Main {
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";
    public static final String BLUE = "\033[0;34m";
    static boolean nbSup10 = false;

    static int[][] boardEasy2 = {
            {4, 1, 1, 1, 1, 2, 6, 8, 1},
            {4, 1, 1, 1, 1, 2, 6, 8, 1},
            {4, 1, 1, 1, 1, 2, 6, 8, 1},
            {4, 1, 1, 1, 1, 2, 6, 8, 1},
            {4, 1, 1, 1, 1, 2, 6, 8, 1},
            {4, 1, 1, 1, 1, 2, 6, 8, 1},
            {4, 1, 1, 1, 1, 2, 6, 8, 1},
            {4, 1, 1, 1, 1, 2, 6, 8, 1},
            {4, 1, 1, 1, 1, 2, 6, 8, 1},
    };
    static int[][] boardEasy = {
            {4, 0, 0, 1, 0, 2, 6, 8, 0},
            {1, 0, 0, 0, 9, 0, 0, 0, 4},
            {0, 3, 8, 0, 6, 4, 0, 1, 0},
            {0, 0, 5, 0, 7, 1, 9, 2, 0},
            {0, 2, 6, 0, 0, 9, 8, 0, 0},
            {8, 0, 0, 2, 5, 0, 0, 0, 0},
            {9, 0, 3, 0, 0, 0, 0, 0, 8},
            {2, 5, 0, 6, 0, 0, 1, 0, 7},
            {6, 0, 7, 9, 0, 5, 3, 0, 0}
    };

    public static int[] grilleSimple(int[][] boardComplexe,int nbSection){
        int[] boardSimple = {0,0,0,0,0,0,0,0,0};
        int ligne=0;
        int colonne =0;
        int add =0;
        if(nbSection == 1){
            ligne = 0;
            colonne = 0;
        }
        if(nbSection ==2){
            ligne = 0;
            colonne = 3;
            add = 3;
        }
        if(nbSection ==3){
            ligne = 0;
            colonne =6;
            add = 6;
        }
        if(nbSection == 4){
            ligne = 3;
            colonne = 0;
        }
        if(nbSection == 5){
            ligne = 3;
            colonne = 3;
            add = 3;
        }
        if(nbSection == 6){
            ligne =3;
            colonne = 6;
            add = 6;
        }
        if(nbSection == 7){
            ligne = 6;
            colonne = 0;
        }
        if(nbSection == 8){
            ligne = 6;
            colonne = 3;
            add = 3;
        }
        if (nbSection == 9){
            ligne = 6;
            colonne = 6;
            add = 6;
        }
        for(int i = 0;i<9;i++){

            boardSimple[i] = boardComplexe[ligne][colonne];
            colonne++;
            if(colonne>2+add){
                colonne = 0+add;
                ligne++;
            }
        }
        return boardSimple;
    }
    public static boolean verifGrilleSimple(int[][]board){
        for(int i = 0;i<10;i++){ //boucle qui verifie toute les sections
            int[] tableau = grilleSimple(board,i);
            for(int n =0;n<9;n++){  //boucle qui verifie 1 section complete
                int nb = tableau[n];
                for(int s = 1;s<9;s++){
                    if(n==s){
                        s++;
                        } else{
                        int nb2 = tableau[s];
                        if(nb == nb2 && nb !=0 && nb2 !=0){
                            return false;
                        }
                    }

                }

            }
        }return true;
    }

    public static boolean verif0(int[][] board) {
        for (int ligne = 0 ; ligne < 9 ; ligne++){
                for (int colonne = 0; colonne < board.length; colonne++) {
                    if (0 == board[ligne][colonne]) {
                        return false;
                    }

                    }
            }

            return true;
        }



    public static void afficheTableauSimple(int[] tableau){
        for(int i = 0;i<tableau.length;i++){
            System.out.print(tableau[i]);
        }
    } //a enlever si plus besoin
    public static void afficheGrille(int[][] tableau) {

        for (int colonne = 0; colonne < 9; colonne++) {
            if (colonne % 3 == 0) {
                System.out.print(RED + "______________________________________" + RESET);
                System.out.println();
            } else {
                System.out.print(BLUE+"______________________________________"+RESET);
                System.out.println();
            }

            for (int ligne = 0; ligne < 9; ligne++) {

                if (ligne % 3 == 0) {
                    System.out.print(RED + " | " + RESET);
                } else {
                    System.out.print(BLUE+" | "+RESET);
                }
                System.out.print(tableau[colonne][ligne]);

            }
            System.out.print(RED + " | " + RESET);
            System.out.println("");

        }
        System.out.print(RED + "______________________________________" + RESET);


    }
    public static boolean ligneplus(int[][] board) {
        int ligne = 0;
        while (ligne < 1) { //remettre 9
            for (int i = 1; i < 10; i++) {
                int value = 0;
                for (int colonne = 0; colonne < board.length; colonne++) {
                    if (i == board[ligne][colonne]) {
                        value++;
                    }
                    if (value > 1) {
                        return false;
                    }
                }
            }
            ligne = ligne + 1;
        }
            return true;

    }
    public static boolean colonneplus(int[][] board) {
        int colonne = 0;
        while (colonne < 9) {
            for (int i = 1; i < 10; i++) {
                int value = 0;
                for (int ligne = 0; ligne < board.length; ligne++) {
                    if (i == board[ligne][colonne]) {
                        value++;
                    }
                    if (value > 1) {
                        return false;
                    }
                }
            }
            colonne = colonne + 1;
        }
        return true;

    }
    public static boolean tableauverif(int[][] board){
        if (ligneplus(board)==true && colonneplus(board)==true &&  verifGrilleSimple(board)==true ){
            return true;
        }
        else {
            return false;
        }
    }
    public static int[][] backtracking(int[][]board,int ligne,int colonne,int nb2){

        boolean isValid = false;
        if(verif0(board) == true){
            return board;
        }
        if(colonne>8){
                colonne = 0;
                ligne = ligne+1;

            }
        int nb = board[ligne][colonne];
            if (nb != 0){
                backtracking(board,ligne,colonne+1,nb2);
                //peut etre placer un retour en arriere ici mais probleme avec ligne


            }else{
                System.out.print(isValid);
                while(isValid == false){
                    board[ligne][colonne] = nb2+1;
                    nb2++;
                    isValid = tableauverif(board);
                    afficheGrille(board);
                    if(nb2>9){
                        nbSup10 = true;
                        return board;
                    }
                }





                    }
            backtracking(board,ligne,colonne+1,0);



                if(nbSup10 ==true){

                    isValid = false;
                    while(isValid == false && nb2<10){
                        nb2++;
                        isValid = tableauverif(board);
                    }nbSup10 = false;
                    return backtracking(board,ligne,colonne+1,1);







            }return board;



        }




    public static boolean ligne(int[][] board){
        int ligne=0;
        int colonne=0;
        int colonneplus=colonne+1;
        while (ligne<9){
            if (board[ligne][colonne] == board[ligne][colonneplus]   &&   board[ligne][colonne] != 0){
                return false;
            }
            else{
                colonneplus=colonneplus+1;
            }
            if (colonneplus==8){
                colonne=colonne+1;
                colonneplus=colonne+1;
            }
            if(colonne==7){
                colonne=0;
                ligne=ligne+1;
                colonneplus=colonne+1;
            }
        }
        return true;
    }
    public static boolean colonne(int[][] board){
        int ligne=0;
        int colonne=0;
        int ligneplus=ligne+1;
        while (colonne<9){
            if (board[ligne][colonne] == board[ligneplus][colonne]   &&   board[ligne][colonne] != 0){
                return false;
            }
            else{
                ligneplus=ligneplus+1;
            }
            if (ligneplus==8){
                ligne=ligne+1;
                ligneplus=ligne+1;
            }
            if(ligne==7){
                ligne=0;
                colonne=colonne+1;
                ligneplus=ligne+1;
            }
        }
        return true;
    }




    public static void main(String[] args) {
        //afficheGrille(boardEasy);
        int [][] board=boardEasy;
        boolean ligneverifier=ligneplus(board);
        boolean colonneverifier=colonneplus(board);
        boolean sectionVerifier = verifGrilleSimple(board);
        boolean tableauverifier=tableauverif(board);

        int[][]b = backtracking(boardEasy,0,0,0);
        /*
        System.out.println(" ");
        System.out.println(ligneverifier);
        System.out.println(colonneverifier);
        System.out.println(sectionVerifier);*/
        //System.out.println(tableauverifier);
        //boolean zero = verif0(boardEasy2);
        //System.out.print(zero);
    }
}
