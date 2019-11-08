public class Bateau2 {


    public static void msgBienvenue() {
        Pep8.stro("Bienvenue au jeu de BatNav2 navale!");
        Pep8.charo('\n');
    }


    /**
     * Msg demandant de placer les tableaux
     */

    public static void msgPLacerBateau() {
        Pep8.stro("Entrer la description et la position des bateaux\n" +
                "selon le format suivant, separes par des espaces:\n" + " taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9]\n" + " ex: ghC4 mvM2 phK9");

    }


    /**
     * methode affichant les lettres de A jusqu'à R
     */
    public static void afficherLetters() {
        char colonne = 'A';
        Pep8.charo(' ');
        while (colonne <= 'R') {

            Pep8.stro(" " + colonne);

            colonne = (char) (colonne + 1);
        }

    }


    /**
     * Verifier la grandeur du bateau
     *
     * @param grandeurBateau est la grandeur du bateau, peut etre p, m ou g
     */

    public static boolean checkTaille(char grandeurBateau) {
        boolean estValide;

        estValide = true;

        if (grandeurBateau != 'p' && grandeurBateau != 'm' && grandeurBateau != 'g') {

            Pep8.charo('\n');
            estValide = false;
        }

        return estValide;
    }


    /**
     * @param orientation, l'oriontation du bateau h pour horizontale.
     *                     v pour vertical.
     * @return caractere > quand la position est horizontal sinon V.
     */

    public static boolean checkOriontation(char orientation) {
        boolean estValide;
        //do{
        estValide = true;
        if (orientation != 'h' && orientation != 'v') {

            estValide = false;
        }

        return estValide;
    }

    /**
     * @param alpha la lettre qui designe la colonne doit etre entre A et R
     * @return alpha
     */
    public static boolean checkLetterColonne(char alpha) {
        boolean estValide;

        // do {
        estValide = true;
        if (alpha < 'A' || alpha > 'R') {

            estValide = false;

        }

        return estValide;

    }

    /**
     * @param rangee, nombre des rangées, ne peut pas etre plus que 9
     * @return nomre de rangées
     */

    public static boolean checkNombreRanger(char rangee) {
        boolean estValide;
        estValide = true;
        if ((int) rangee < 49 || (int) rangee > 57) {
            estValide = false;
        }

        return estValide;
    }

    /**
     *
     *


     public static char[][] printPartBoatH(int rang, int col, char []size, char[]direction, int []rowBoat, int []colBoat ) {
     int j = 0;
     // char[][] situationInitiale = new char[9][18];
     char[][] boatHorizontal = new char[rowBoat[j]][colBoat[j]];
     //char[] boatHorizontal = new char[rowBoat[j]];


     if (size[j] == 'g') {
     if (direction[j] == 'h') {

     for (int i = 0; i < 5; i++) {

     [rowBoat[j]][colBoat[j] + i] = '>';
     }
     }
     }
     }
     }

     return boatHorizontal;
     }

     */
    /**
     *
     * @param taille de bateau
     * @return nb de case que le bateau va occuper
     */

    public static int nbcases(char []taille){
        int j=0;

        int nbCase=0;
        if(taille[j]=='g'){
            nbCase=5;
        }else if(taille[j]=='m'){
            nbCase=3;
        }else if(taille[j] =='p'){
            nbCase=1;
        }

        return nbCase;
    }


    public static void printCharOfBoat(char [] direction, char [] sizeOfBoat){

    }


    /**
     * @param rang nb rangee de l'espace de jeu
     * @param col nb de colonne de l'espace de jeu
     * @param rowBoat  indice de rangee de bateau
     * @param colBoat indice de colonne de bateau
     * @return print un tableau contenant la description des bateaux.
     */

    public static char[][] espaceDeJeu(int rang, int col, int []rowBoat, int []colBoat, char [] taille, char [] direction) {

        int j=0;
        int nbCase = nbcases(taille);

        char[][] situationInitiale = new char[9][18];


        afficherLetters();
         Pep8.charo('\n');
        for (rang = 0; rang < situationInitiale.length; rang++) {
            Pep8.deco(rang + 1);
            Pep8.charo('|');

            for (col = 0; col < (situationInitiale[rang].length); col++) {

                situationInitiale[rang][col] = '~';


                //if(taille[j] =='g' || taille[j]=='m' || taille[j]=='p') {
                    if (direction[j] == 'h') {

                        for (int i = 0; i < nbCase; i++) {
                            situationInitiale[rowBoat[j]-1][colBoat[j]+i] = '>';
                        }
                    }else if (direction[j]=='v'){

                        for (int i = 0; i < nbCase; i++) {
                            situationInitiale[(rowBoat[j]-1)+i][colBoat[j]] = 'v';
                        }

                    }
              //  }

                Pep8.charo(situationInitiale[rang][col]);
                //situationInitiale[rang][col];

                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        }

        return situationInitiale;
    }

    public static void main(String[] args) {
        int rang =9;
        int col =18;
        char [][] positionDesBateau = new char[rang][col];


        boolean estValide;
        int n =0;
        int j;
        char lignInput1;

        char[] sizeBoat = new char[1000];
        char[] dirBoat = new char[1000];
        char[] colBoat = new char[1000];
        int[] colBoatInt = new int[1000];
        char[] rowBoat = new char[1000];
        int[] rowBoatInt = new int[1000];




        //msgPLacerBateau();
        Pep8.charo('\n');



        // afficherLetters();
        //Pep8.charo('\n');

        do {

            msgPLacerBateau();

            estValide = true;


        do {

            /**
             boucle arret de lecture de la ligne entree. l'espace entre les char est pris comme condition de continuite de lecture.
             */

            /**
             * le premier char est la taille
             */

            sizeBoat[n] = Pep8.chari();

            if (!checkTaille(sizeBoat[n])) {

                estValide = false;

            }

            /**
             * * le deuxiem char est l'orientation du bateau
             * */


            dirBoat[n] = Pep8.chari();

            if (!checkOriontation(dirBoat[n])) {

                estValide = false;

            }

            /**
             * le 3eme char est la colonne
             */

            colBoat[n] = Pep8.chari();

            if (!checkLetterColonne(colBoat[n])) {

                estValide = false;

            }


            /**
             * le 4eme char est la rangee
             */

            rowBoat[n] = Pep8.chari();

            if (!checkNombreRanger(rowBoat[n])) {

                estValide = false;

            }

            if (!estValide) {
                n = 0;

            } else {
                n++;
            }



            /**
             * le 5eme char est l'espace separant les specifications d'un bateau à l'autre.
             */
            lignInput1 = Pep8.chari();


        }while(lignInput1 == ' ');



/**

 **/

        for(j=0; j<n; j++) {

            colBoatInt[j] = (int) colBoat[j] - 65;
            rowBoatInt[j] = (int) rowBoat[j] - 48;


           // afficherLetters();
          //  Pep8.charo('\n');



             for (rang = 0; rang < positionDesBateau.length; rang++) {
            // Pep8.deco(rang + 1);
             //Pep8.charo('|');

             for (col = 0; col < positionDesBateau[rang].length; col++) {

             //espaceDeJeu(rangeeInitiale, colonneInitiale, rowBoatInt, colBoatInt, sizeBoat, dirBoat);

                 //situationInitiale[rang][col] = '~';
                 positionDesBateau[rang][col] = '~';



                 if(sizeBoat[j] =='g'){// || taille[j]=='m' || taille[j]=='p') {
                 if (dirBoat[j] == 'h') {

                     for (int i = 0; i < nbcases(sizeBoat); i++) {
                         positionDesBateau[rowBoatInt[j]-1][colBoatInt[j]+i] = '>';
                     }
                 }else if (dirBoat[j]=='v'){

                     for (int i = 0; i < nbcases(sizeBoat); i++) {
                         positionDesBateau[(rowBoatInt[j]-1)+i][colBoatInt[j]] = 'v';
                     }

                 }else if(dirBoat[j]=='m') {
                     if (dirBoat[j] == 'h') {

                         for (int i = 0; i < nbcases(sizeBoat); i++) {
                             positionDesBateau[rowBoatInt[j] - 1][colBoatInt[j] + i] = '>';
                         }
                     } else if (dirBoat[j] == 'v') {

                         for (int i = 0; i < nbcases(sizeBoat); i++) {
                             positionDesBateau[(rowBoatInt[j] - 1) + i][colBoatInt[j]] = 'v';
                         }
                     }
                 }else if(dirBoat[j]=='p'){

                     if (dirBoat[j] == 'h') {

                         for (int i = 0; i < nbcases(sizeBoat); i++) {
                             positionDesBateau[rowBoatInt[j] - 1][colBoatInt[j] + i] = '>';
                         }
                     } else if (dirBoat[j] == 'v') {

                         for (int i = 0; i < nbcases(sizeBoat); i++) {
                             positionDesBateau[(rowBoatInt[j] - 1) + i][colBoatInt[j]] = 'v';
                         }
                     }
                 }

                 }


                 //Pep8.charo(positionDesBateau[rang][col]);

            // Pep8.charo(' ');

             }
            // Pep8.charo('|');
            // Pep8.charo('\n');
             }



             }


       // espaceDeJeu(9, 18, rowBoatInt, colBoatInt, sizeBoat, dirBoat);


    }while(!estValide );//|| checkBateau(tailleTab, orientationTab, rangeeTabConvertis, colonneTabConvertis));


            // }
            //positionDesBateau =  espaceDeJeu(9, 18, rowBoatInt, colBoatInt, sizeBoat, dirBoat);
        afficherLetters();
        Pep8.charo('\n');
        char c;
        for (rang = 0; rang< positionDesBateau.length; rang++) {
            Pep8.deco(rang + 1);
            Pep8.charo('|');
            for (col = 0; col < positionDesBateau[rang].length; col++) {
                c = positionDesBateau[rang][col];

                Pep8.charo(c);

                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        }
        }
    }


