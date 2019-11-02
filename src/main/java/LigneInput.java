public class LigneInput {



    public static void msgPLacerBateau() {
        Pep8.stro("Entrer la description et la position des bateaux\n" +
                "selon le format suivant, separes par des espaces:\n" + " taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9]\n" + " ex: ghC4 mvM2 phK9");

    }


    public static void msgBienvenue() {
        Pep8.stro("Bienvenue au jeu de bataille navale!");
        Pep8.charo('\n');
    }

    /**
     * methode affichant les lettres de A jusqu'à R
     */
    public static void afficherLetters() {
        char colonne = 'A';
        Pep8.charo(' ');
        while (colonne <= 'R') {
            //Pep8.charo('');
            Pep8.stro(" " + colonne);
            colonne = (char) (colonne + 1);
        }

    }

    /**
     * imprimer le caractere tild
     */

    public static void tild() {
        Pep8.charo('~');
    }

    /**
     * msg de fin de jeu ou de recommencer  le jeu
     */

    public static void msgQuitter(){
        Pep8.stro("Vous avez anéanti la flotte! \n"+
                "Appuyer sur <Enter> pour jouer à nouveau ou \n"+
                "n'importe quelle autre saisie pour quitter.");
    }


    /**
     * Verifier la grandeur du bateau
     * @param grandeurBateau est la grandeur du bateau, peut etre p, m ou g
     */

    public static boolean checkTaille(char grandeurBateau) {
        boolean estValide;

        //do{
        estValide = true;

        if (grandeurBateau != 'p' && grandeurBateau != 'm' && grandeurBateau != 'g') {

            Pep8.charo('\n');
            estValide = false;
        }

        if(!estValide){
            //msgPLacerBateau();
            Pep8.stro("grandeur  est incorrecte");
        }

        //}while(!estValide);

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
        if(orientation != 'h' && orientation != 'v') {

            estValide = false;
        }

        if (!estValide) {
            //msgPLacerBateau();
            Pep8.stro("orientation est incorrecte");
            Pep8.charo('\n');
        }
        //}while (!estValide);

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

        if (!estValide) {
            //msgPLacerBateau();
            Pep8.stro("colonne est incorrecte");
            Pep8.charo('\n');
        }


        //  }while (!estValide);

        return estValide;

    }

    /**
     * @param rangee, nombre des rangées, ne peut pas etre plus que 9
     * @return nomre de rangées
     */

    public static boolean checkNombreRanger(char rangee) {
        boolean estValide;
        estValide = true;
        if ((int) rangee < 48 || (int) rangee > 57) {
            estValide = false;
        }

        if (!estValide) {
            Pep8.stro("nombre de rangees est incorrecte");
            Pep8.charo('\n');
        }
        return estValide;
    }


    /**
     * Methode imprimant un beateau a deux dimensions de 9 rangees et 18 colonnes
     */


    /**
     * imprimer le caractere tild


     public static void tild() {
     Pep8.charo('~');
     }


     public static void imprimerTableauInitial(int rangee, int colonne, char tild){

     char resDeRangeeColonne;
     char situationInitiale[][] = new char [rangee][colonne];
     //        resDeRangeeColonne =
     situationInitiale[rangee-1][colonne-1] =tild;

     for (rangee = 0; rangee < situationInitiale.length; rangee++) {
     Pep8.deco(rangee + 1);
     Pep8.charo('|');

     for (colonne = 0; colonne < (situationInitiale[rangee].length); colonne++) {
     //Pep8.charo(situationInitiale[rangee][colonne]);
     //tild();
     Pep8.charo(situationInitiale[rangee][colonne] =tild);
     Pep8.charo(' ');
     }
     Pep8.charo('|');
     Pep8.charo('\n');
     };
     //return resDeRangeeColonne;
     }

     public static void main(String[] args) {
     int rangeeInitiale=9;
     int colonneInitiale=18;
     int rangeePositionBateau;
     int colonnePositionBateau;
     char charSituationInitiale ='~';
     imprimerTableauInitial(9,18, charSituationInitiale);


     }
     }
     */

    public static void main(String[] args) {




        char lignInput = 'x';
        boolean estValide;
        boolean temporary=true;
        char taille='x';
        char orientation='n';
        char colonne='v';
        int colonneConvertis;
        char rangee='x';
        int rangeeConvertis;
        char lignInput1 = 'x';
        char charQuitter='y';

        int rangeeInitiale=9;
        int rangeeInitialeTemp;
        int colonneInitiale=18;
        int colonneInitialeTemp;

        char [][] situationInitiale = new char [rangeeInitiale][colonneInitiale];

        char [][] positionDesBateau = new char [rangeeInitiale][colonneInitiale];




        msgBienvenue();
        afficherLetters();
        Pep8.charo('\n');


        for (rangeeInitiale = 0; rangeeInitiale < situationInitiale.length; rangeeInitiale++) {

            Pep8.deco(rangeeInitiale + 1);
            Pep8.charo('|');

            for (colonneInitiale = 0; colonneInitiale < (situationInitiale[rangeeInitiale].length); colonneInitiale++) {
                tild();
                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        }






        do{ /** boucle pour arreter le programme quand on pese sur la touche entrer
         */
            do{
                Pep8.charo('\n');
                msgPLacerBateau();

                Pep8.charo('\n');

                estValide = true;
                //temporary=true;

                do {

                    /**
                     boucle arret de lecture de la ligne entree. l'espace entre les char est pris comme condition de continuite de lecture.
                     */

                    /**
                     * le premier char est la taille
                     */


                        //if(estValide) {
                         taille = Pep8.chari();
                         if (!checkTaille(taille)) {
                         estValide = false;
                         // temporary=false;

                         }

                         Pep8.charo('\n');


                        /**
                         * * le deuxiem char est l'orientation du bateau
                         * */

                        orientation = Pep8.chari();
                        if (!checkOriontation(orientation)) {
                            estValide = false;
                            //temporary=false;

                        }

                        Pep8.charo('\n');

                        /**
                         * le 3eme char est la colonne
                         */

                        colonne = Pep8.chari();
                        if (!checkLetterColonne(colonne)) {
                            estValide = false;
                            // temporary=false;

                        }

                        Pep8.charo('\n');

                        /**
                         * le 4eme char est la rangee
                         */

                        rangee = Pep8.chari();

                        if (!checkNombreRanger(rangee)) {
                            estValide = false;
                            //temporary=false;

                        }


                        Pep8.charo('\n');
                        //}else{
                         //msgPLacerBateau();
                        // }


                    /**
                     * Le corps du jeu, englobant l'affichat du tableau mise a jour et l'affichage des bateaux aneantis
                     */

                    Pep8.stro("the first line of code is supposed to print la taille :" + taille);
                    Pep8.charo('\n');
                    Pep8.stro("the second line of code is supposed to print l'orientation  :" + orientation);
                    Pep8.charo('\n');
                    Pep8.stro("the second line of code is supposed to print la colonne  :" + colonne);
                    Pep8.charo('\n');

                    colonneConvertis = (int) colonne - 65;

                    Pep8.stro("la colonne  de position bateau est " + colonneConvertis);
                    Pep8.charo('\n');
                    Pep8.stro("the second line of code is supposed to print la rangee  :" + rangee);
                    Pep8.charo('\n');
                    rangeeConvertis = (int) (rangee) - 48;
                    Pep8.stro("indice de rangee apres convertion =" + rangeeConvertis);

                    Pep8.charo('\n');


                    /**
                     * Affichage de l'espace de jeu mis à jour
                     */
                 // if(temporary) {

                      afficherLetters();
                      Pep8.charo('\n');

                      for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {
                          Pep8.deco(rangeeInitiale + 1);
                          Pep8.charo('|');
                          for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {


                              //for (rangeeInitiale = 0; rangeeInitiale < situationInitiale.length; rangeeInitiale++) {
                              //Pep8.deco(rangeeInitiale + 1);
                              //Pep8.charo('|');

                              // for (colonneInitiale = 0; colonneInitiale < situationInitiale[rangeeInitiale].length; colonneInitiale++) {
                              //Pep8.charo(situationInitiale[rangeeInitiale][colonneInitiale]);

                              //Pep8.stro("resultat de impression 1 est : "+situationInitiale[rangeePositionBateau][colonnePositionBateauFinal]);
                              // Pep8.stro("resultat de impression 2 est : "+situationInitiale[rangeeInitiale][colonneInitiale-1]);
                              //if (situationInitiale[rangeeInitiale][colonneInitiale] == situationInitiale[rangeePositionBateau][colonnePositionBateauFinal]) {

                              //(rangeePositionBateau-1)
                              //indiceDeRangeeFinal
                              //colonnePositionBateauFinal
                              //if (rangeeInitiale == 8 && colonneInitiale ==10 ) {

                              /**
                               * quand la cordonnees du bateau initiale egale la coordonnees du position entré
                               * une coordonnee du bateau initiale est definit par numero de range et numero du colonne
                               * une coordonnee du position du bateau  est definit par numero de range et numero du colonne
                               */

                              // if (rangeeInitiale == (rangeeConvertis - 1) && (colonneInitiale == colonneConvertis)) {
                              //if (rangeeInitiale == (rangeeConvertis) && (colonneInitiale == colonneConvertis)) {
                              // if ((situationInitiale[rangeeInitiale][colonneInitiale]) == (positionDesBateau[rangeeConvertis - 1][colonneConvertis])) {

                              if (taille == 'g') {


                                  if (orientation == 'h') {


                                      for (int i = 0; i < 5; i++) {
                                          if (rangeeInitiale == (rangeeConvertis - 1) && (colonneInitiale == colonneConvertis)) {


                                              Pep8.charo(positionDesBateau[rangeeConvertis - 1][colonneConvertis + i] = '>');

                                              Pep8.charo(' ');
                                              temporary = false;
                                          }
                                      }
                                  } else if (orientation == 'v') {

                                      for (int i = 0; i < 5; i++) {

                                          if (rangeeInitiale == (rangeeConvertis - 1 + i) && (colonneInitiale == colonneConvertis)) {

                                              Pep8.charo(situationInitiale[(rangeeConvertis - 1) + i][colonneConvertis] = 'v');

                                              Pep8.charo(' ');
                                              temporary = false;
                                          }

                                      }
                                  }


                              } else if (taille == 'm') {

                                  if (orientation == 'h') {

                                      for (int i = 0; i < 3; i++) {

                                          if (rangeeInitiale == (rangeeConvertis - 1) && (colonneInitiale == colonneConvertis)) {
                                              Pep8.charo(positionDesBateau[rangeeConvertis - 1][colonneConvertis + i] = '>');


                                              Pep8.charo(' ');
                                              temporary = false;
                                          }
                                      }


                                  } else if (orientation == 'v') {


                                      for (int i = 0; i < 3; i++) {

                                          if (rangeeInitiale == (rangeeConvertis - 1 + i) && (colonneInitiale == colonneConvertis)) {

                                              Pep8.charo(situationInitiale[(rangeeConvertis - 1) + i][colonneConvertis] = 'v');

                                              Pep8.charo(' ');
                                              temporary = false;
                                          }
                                      }

                                  }


                              } else if (taille == 'p') {

                                  if (orientation == 'h') {


                                      for (int i = 0; i < 1; i++) {
                                          if (rangeeInitiale == (rangeeConvertis - 1) && (colonneInitiale == colonneConvertis)) {
                                              Pep8.charo(positionDesBateau[rangeeConvertis - 1][colonneConvertis + i] = '>');
                                              Pep8.charo(' ');
                                              temporary = false;
                                          }
                                      }
                                  }


                              } else if (orientation == 'v') {

                                  for (int i = 0; i < 1; i++) {
                                      if (rangeeInitiale == (rangeeConvertis - 1 + i) && (colonneInitiale == colonneConvertis)) {
                                          Pep8.charo(positionDesBateau[rangeeConvertis - 1 + i][colonneConvertis] = 'v');
                                          Pep8.charo(' ');
                                          temporary = false;
                                      }
                                  }

                              }

                                          tild();
                                          Pep8.charo(' ');



                          }




                          Pep8.charo('|');
                          Pep8.charo('\n');
                      }


                 // }














                    /**
                     * le 5eme char est l'espace separant les specifications d'un bateau à l'autre.
                     */
                    lignInput1 = Pep8.chari();

                } while (lignInput1 == ' ');










            }while(!estValide);
            /**
             * Pour quitter le jeu entrer un char diffrent de <Enter> puis appuyez sur <Enter>.
             */
            msgQuitter();
            charQuitter = Pep8.chari();
        } while (charQuitter == '\n');

    }


}

