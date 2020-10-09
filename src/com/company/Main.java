package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.SortedMap;

public class Main {
    public static final String RED = "\033[0;31m";
    public static final String RESET = "\033[0m";
    public static final String BLUE = "\033[0;34m";
    public static int tour = 0;


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
    static int[][] boardMedium = {
            {0, 7, 0, 3, 4, 0, 2, 0, 6},
            {9, 0, 0, 7, 0, 6, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 7, 9, 8, 6, 0},
            {0, 0, 0, 0, 0, 2, 3, 0, 4},
            {4, 0, 7, 5, 0, 8, 0, 0, 0},
            {0, 0, 0, 9, 0, 0, 0, 0, 0},
            {0, 0, 6, 0, 0, 0, 0, 1, 7},
            {5, 1, 0, 0, 8, 0, 4, 0, 2}
    };

    static int[][] boardHard = {
            {0, 0, 0, 0, 0, 0, 9, 4, 0},
            {6, 0, 0, 0, 0, 0, 2, 7, 0},
            {8, 2, 0, 0, 4, 9, 6, 0, 0},
            {0, 7, 4, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 7, 6, 0, 0, 0, 0},
            {0, 6, 2, 0, 0, 5, 0, 8, 0},
            {0, 0, 0, 0, 5, 7, 0, 2, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {7, 5, 3, 2, 0, 4, 0, 0, 0}
    };

    static int[][] boardGodLike = {
            {0, 0, 0, 6, 0, 2, 8, 0, 4},
            {0, 0, 0, 0, 3, 0, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {4, 0, 6, 0, 5, 0, 3, 0, 0},
            {2, 0, 8, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 9, 1, 0},
            {1, 0, 0, 0, 0, 0, 2, 0, 0},
            {0, 7, 0, 9, 0, 0, 0, 5, 0},
            {0, 0, 2, 4, 0, 0, 0, 0, 8}
    };

    /**
     * decoupe les sous section pour en faire des lignes simples
     * @param boardComplexe a découper
     * @param nbSection la section a prendre
     * @return une ligne qui recupere une sous-section
     */
    public static int[] grilleSimple(int[][] boardComplexe, int nbSection) {
        int[] boardSimple = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int ligne = 0;
        int colonne = 0;
        int add = 0;
        if (nbSection == 1) {
            ligne = 0;
            colonne = 0;
        }
        if (nbSection == 2) {
            ligne = 0;
            colonne = 3;
            add = 3;
        }
        if (nbSection == 3) {
            ligne = 0;
            colonne = 6;
            add = 6;
        }
        if (nbSection == 4) {
            ligne = 3;
            colonne = 0;
        }
        if (nbSection == 5) {
            ligne = 3;
            colonne = 3;
            add = 3;
        }
        if (nbSection == 6) {
            ligne = 3;
            colonne = 6;
            add = 6;
        }
        if (nbSection == 7) {
            ligne = 6;
            colonne = 0;
        }
        if (nbSection == 8) {
            ligne = 6;
            colonne = 3;
            add = 3;
        }
        if (nbSection == 9) {
            ligne = 6;
            colonne = 6;
            add = 6;
        }
        for (int i = 0; i < 9; i++) {

            boardSimple[i] = boardComplexe[ligne][colonne];
            colonne++;
            if (colonne > 2 + add) {
                colonne = 0 + add;
                ligne++;
            }
        }
        return boardSimple;
    }

    /**
     * verifie si une ligne d'un tableau a 2nombres identiques
     * @param board simple a verifier
     * @return si la ligne du tableau possede 2 nombre identique
     */
    public static boolean verifGrilleSimple(int[][] board) {
        for (int i = 0; i < 10; i++) { //boucle qui verifie toute les sections
            int[] tableau = grilleSimple(board, i);
            for (int n = 0; n < 9; n++) {  //boucle qui verifie 1 section complete
                int nb = tableau[n];
                for (int s = 1; s < 9; s++) {
                    if (n == s) {
                        s++;
                    } else {
                        int nb2 = tableau[s];
                        if (nb == nb2 && nb != 0 && nb2 != 0) {
                            return false;
                        }
                    }

                }

            }
        }
        return true;
    }




    /**
     * recupere un tableau a partir d'un fichier
     * @return le tableau a partir d'un fichier
     */
    public static int[][] recupFichier() {
        int[][] board = new int[9][9];
        File f = new File("sud");
        int ligne = 0;
        int colonne = 0;
        int g = 0;
        try {
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";

            while ((readLine = b.readLine()) != null) {
                String[] array = readLine.split("\\ ");
                for (int i = 0; i < 9; i++) {
                    int result = Integer.parseInt(array[i]);
                    board[ligne][colonne] = result;
                    colonne++;
                    if (colonne > 8) {
                        colonne = 0;
                        ligne++;

                    }
                    if (ligne > 8) {
                        return board;
                    }
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return board;
    }





    /**
     * la fonction afficheGrille affiche la grille de sudoku du tableau rentrer dans la fonction
     *
     * @param tableau est un tableau utiliser dans la fonction afficheGrille
     */

    public static void afficheGrille(int[][] tableau) {

        for (int colonne = 0; colonne < 9; colonne++) {
            if (colonne % 3 == 0) {
                System.out.print(RED + "______________________________________" + RESET);
                System.out.println();
            } else {
                System.out.print(BLUE + "______________________________________" + RESET);
                System.out.println();
            }

            for (int ligne = 0; ligne < 9; ligne++) {

                if (ligne % 3 == 0) {
                    System.out.print(RED + " | " + RESET);
                } else {
                    System.out.print(BLUE + " | " + RESET);
                }
                System.out.print(tableau[colonne][ligne]);

            }
            System.out.print(RED + " | " + RESET);
            System.out.println("");

        }
        System.out.print(RED + "______________________________________" + RESET);


    }


    /**
     * la fonction ligneplus dit si les ligne du tableau on deux fois le meme chiffre ou pas
     *
     * @param board est un tableau utiliser dans la fonction ligneplus
     * @return true si les ligne n'ont pas deux fois le meme nombre et false si il y a deux chiffre dans la meme ligne
     */
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


    /**
     * la fonction colonneplus dit si les colonne du tableau on deux fois le meme chiffre ou pas
     *
     * @param board est un tableau utiliser dans la fonction colonneplus
     * @return true si les colonne n'ont pas deux fois le meme nombre et false si il y a deux chiffre dans la meme colonne
     */
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


    /**
     * la fonction tableauverif dit si le sudoku est valide ou pas
     *
     * @param board est un tableau utiliser dans la fonction tableauverif
     * @return false si il y a plus d'une fois un chiffre dans la meme colonne ou la meme ligne ou la meme section sinon true
     */
    public static boolean tableauverif(int[][] board) {
        if (ligneplus(board) == true && colonneplus(board) == true && verifGrilleSimple(board) == true) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * la fonction fini remplie le sodoku automatiquement et te previen si le sudoku ne peut pas etre resolu
     *
     * @param board est un tableau utiliser dans la fonction fini
     * @return true si le sudoku est remplie et valide sinon revoie false si le sudoku ne peut pas etre resolu
     */
    public static boolean fini(int[][] board) {
        for (int ligne = 0; ligne < 9; ligne++) {
            for (int colonne = 0; colonne < 9; colonne++) {
                if (board[ligne][colonne] == 0) {
                    for (int i = 1; i < 10; i++) {
                        board[ligne][colonne] = i;
                        tour++;
                        if (tableauverif(board) == true && fini(board) == true) {
                            return true;
                        }
                        board[ligne][colonne] = 0;

                    }
                    return false;
                }
            }
        }
        return true;
    }







        public static void main (String[]args){

        /*
        long TimerStart = System.currentTimeMillis();
        int [][] board=boardEasy;
        boolean fin=fini(board);
        System.out.println(" ");
        System.out.println(" ");
        afficheGrille(board);
        System.out.println(" ");
        System.out.println("Le sudoku est-il complet : "+fin);
        long TimerEnd = System.currentTimeMillis();
        long Timer = TimerEnd - TimerStart;
        System.out.println(" ");
        System.out.println("STATS PART :");
        System.out.println("Le sudoku s'est résolu en "+Timer+"ms");
        System.out.println("Le sudoku à effectué "+tour+" actions avant de finir");*/
            int[][] board = recupFichier();
            afficheGrille(board);

        }
    }

