/**
ublic class RestOfBatailleFake {


    char []tailleTab=new char[1000];
    char []orientationTab=new char[1000];
    char []colonneTab=new char[1000];
    int  []colonneTabConvertis = new int [1000];
    char []rangeeTab=new char[1000];
    int  []rangeeTabConvertis = new int [1000];






        do { /** boucle pour arreter le programme quand on pese sur la touche entrer
     *
        do {

            msgPLacerBateau();
            Pep8.charo('\n');

            estValide = true;

            do {

                /**
                 boucle arret de lecture de la ligne entree. l'espace entre les char est pris comme condition de continuite de lecture.
                 */

                /**
                 * le premier char est la taille


                tailleTab[n] = Pep8.chari();

                if (!checkTaille(tailleTab[n])) {


                    estValide = false;


                }


                 * * le deuxiem char est l'orientation du bateau
                 *


                orientationTab[n] = Pep8.chari();

                if (!checkOriontation(orientationTab[n])) {


                    estValide = false;


                }

                /**
                 * le 3eme char est la colonne


                colonneTab[n] = Pep8.chari();

                if (!checkLetterColonne(colonneTab[n])) {


                    estValide = false;



                }

                /**
                 * le 4eme char est la rangee


                rangeeTab[n] = Pep8.chari();

                if (!checkNombreRanger(rangeeTab[n])) {


                    estValide = false;


                }

                if(!estValide){
                    n=0;

                }else{
                    n++;
                }



                /**
                 * le 5eme char est l'espace separant les specifications d'un bateau à l'autre.

                lignInput1 = Pep8.chari();


            } while (lignInput1 == ' ');

            /**
             * Conversion des chars à des entiers



            for ( j = 0; j < n; j++) {
                colonneTabConvertis[j] = (int) colonneTab[j] - 65;
                rangeeTabConvertis[j] = (int) rangeeTab[j] - 48;

                /**
                 * Affichage de l'espace de jeu mis à jour



                for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {

                    for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {

                        /**
                         * quand la cordonnees du bateau initiale egale la coordonnees du position entré
                         * une coordonnee du bateau initiale est definit par numero de range et numero du colonne
                         * une coordonnee du position du bateau  est definit par numero de range et numero du colonne



                        if (tailleTab[j] == 'g') {

                            if (orientationTab[j] == 'h') {
                                /**
                                 * Si le bateau est grand, orienter horizontalement
                                 * et que la colonne commence à O, le bateau va pas etre affiché.


                                if (positionDesBateau[rangeeInitiale].length - (colonneTabConvertis[j] - 1) > 5) {

                                    for (int i = 0; i < 5; i++) {

                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                            positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';

                                        } else if ((rangeeTabConvertis[j] == rangeeTabConvertis[j + 1]) && (colonneTabConvertis[j + 1] > colonneTabConvertis[j])) {
                                            // }
                                            positionDesBateau[rangeeTabConvertis[j + 1]][colonneTabConvertis[j + 1] + i] = ' ';
                                        }
                                    }
                                }


                                /**
                                 * Si le bateau est grand, orienter verticalement
                                 * et que la rangee commence à 6, le bateau va pas etre affiché.



                            } else if (orientationTab[j] == 'v') {
                                if (positionDesBateau.length - (rangeeTabConvertis[j] -1) >= 5) {
                                    for (int i = 0; i < 5; i++) {
                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                            positionDesBateau[(rangeeTabConvertis[j] - 1) + i][colonneTabConvertis[j]] = 'v';

                                        }

                                    }
                                }

                            }


                        }else if (tailleTab[j] == 'm') {


                            if (orientationTab[j] == 'h') {

                                /**
                                 * Si le bateau est moyen, orienter horizontalement
                                 * et que la colonne commence à Q, le bateau va pas etre affiché.


                                if (positionDesBateau[rangeeInitiale].length - (colonneTabConvertis[j] - 1) > 3) {
                                    for (int i = 0; i < 3; i++) {
                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                            positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';

                                        }
                                    }
                                }

                            } else if (orientationTab[j] == 'v') {

                                /**
                                 * Si le bateau est moyen, orienter verticalement
                                 * et que la rangee commence à 8, le bateau va pas etre affiché.



                                if (positionDesBateau.length - (rangeeTabConvertis[j] -1) >= 3) {
                                    for (int i = 0; i < 3; i++) {
                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                            positionDesBateau[(rangeeTabConvertis[j] - 1) + i][colonneTabConvertis[j]] = 'v';

                                        }
                                    }
                                }

                            }


                        } else if (tailleTab[j] == 'p') {

                            if (orientationTab[j] == 'h') {


                                for (int i = 0; i < 1; i++) {
                                    if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                        positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';

                                    }
                                }
                            }


                        } else if (orientationTab[j] == 'v') {

                            for (int i = 0; i < 1; i++) {
                                if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                    positionDesBateau[rangeeTabConvertis[j] - 1 + i][colonneTabConvertis[j]] = 'v';

                                }
                            }

                        }

                    }

                }
            }
            // }while(!estValide);
        }while(!estValide || checkBateau(tailleTab, orientationTab, rangeeTabConvertis, colonneTabConvertis));

        /**
         * Affichage de l'espace de jeu mis à jour

         // if(temporary) {


        afficherLetters();
        Pep8.charo('\n');
        char c;
        for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {
            Pep8.deco(rangeeInitiale + 1);
            Pep8.charo('|');
            for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {
                c = positionDesBateau[rangeeInitiale][colonneInitiale];

                Pep8.charo(c);

                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        }




        /**
         * le bout de code suivant va afficher un msg demandanu au joueur d'entrer des coups




        char  espaceEntreCoup;
        char []colonneFeu = new char[1000];
        int [] colonneFeuConvertis = new int [1000];
        char []rangeeFeu = new char [1000];
        int [] rangeeFeuConvertis = new int [1000];

        /**
         * Verification des coups entrés.




        do{
            Pep8.charo('\n');
            msgFeuAVolonte();
            estValide=true;



            do{
                colonneFeu[k] = Pep8.chari();
                if (!checkLetterColonne(colonneFeu[k])){
                    estValide = false;
                }
                rangeeFeu[k] = Pep8.chari() ;
                if (!checkNombreRanger(rangeeFeu[k])) {
                    estValide = false;
                }

                if(!estValide){
                    k=0;
                }else{
                    k++;}

                espaceEntreCoup = Pep8.chari();

            }while(espaceEntreCoup==' ');


            for (j = 0; j < k; j++) {


                /**
                 * conversion des chars en entiers


                colonneFeuConvertis[j] = (int) colonneFeu[j] - 65;
                Pep8.charo('\n');

                rangeeFeuConvertis[j] = (int) rangeeFeu[j] - 48;
                Pep8.charo('\n');



                /**
                 * le code suivant est sensé affiché le jeu mise a jour
                 * la position des bateaux
                 * les coups tiré



                afficherLetters();
                Pep8.charo('\n');

                for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {
                    Pep8.deco(rangeeInitiale + 1);
                    Pep8.charo('|');

                    for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {

                        /**
                         * quand la cordonnees du bateau initiale egale la coordonnees du position entré
                         * une coordonnee du bateau initiale est definit par numero de range et numero du colonne
                         * une coordonnee du position du bateau  est definit par numero de range et numero du colonne




                        if (tailleTab[j] == 'g') {


                            if (orientationTab[j] == 'h') {

                                if (positionDesBateau[rangeeInitiale].length - (colonneTabConvertis[j] - 1) > 5) {

                                    for (int i = 0; i < 5; i++) {

                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                            positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';

                                        } else if ((rangeeTabConvertis[j] == rangeeTabConvertis[j + 1]) && (colonneTabConvertis[j + 1] > colonneTabConvertis[j])) {

                                            positionDesBateau[rangeeTabConvertis[j + 1]][colonneTabConvertis[j + 1] + i] = ' ';
                                        }
                                    }
                                }


                            } else if (orientationTab[j] == 'v') {

                                if (positionDesBateau.length - (rangeeTabConvertis[j] -1) >= 5) {
                                    for (int i = 0; i < 5; i++) {
                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                            positionDesBateau[(rangeeTabConvertis[j] - 1) + i][colonneTabConvertis[j]] = 'v';

                                        }

                                    }
                                }
                            }



                        }else if (tailleTab[j] == 'm') {


                            if (orientationTab[j] == 'h') {
                                if (positionDesBateau[rangeeInitiale].length - (colonneTabConvertis[j] - 1) > 3) {

                                    for (int i = 0; i < 3; i++) {
                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                            // if(rangeeFeu[j]-1== rangeeTabConvertis[j]-1  && colonneFeu ) {

                                            // }else {
                                            positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';
                                            //  }

                                        }
                                    }
                                }

                            } else if (orientationTab[j] == 'v') {
                                if (positionDesBateau.length - (rangeeTabConvertis[j] -1) >= 3) {
                                    for (int i = 0; i < 3; i++) {
                                        if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                            positionDesBateau[(rangeeTabConvertis[j] - 1) + i][colonneTabConvertis[j]] = 'v';

                                        }
                                    }
                                }

                            }


                        } else if (tailleTab[j] == 'p') {


                            if (orientationTab[j] == 'h') {


                                for (int i = 0; i < 1; i++) {
                                    if (rangeeInitiale == (rangeeTabConvertis[j] - 1) && (colonneInitiale == colonneTabConvertis[j])) {
                                        positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';

                                    }
                                }
                            }

                        } else if (orientationTab[j] == 'v') {

                            for (int i = 0; i < 1; i++) {
                                if (rangeeInitiale == (rangeeTabConvertis[j] - 1 + i) && (colonneInitiale == colonneTabConvertis[j])) {
                                    positionDesBateau[rangeeTabConvertis[j] - 1 + i][colonneTabConvertis[j]] = 'v';

                                }
                            }

                        }

                        /**
                         * Condition Vérifiant si les coordonnées des coups tirés sont à la même place que les positions des bateaux.




                        if(detruireBateauRecursivement(positionDesBateau, rangeeFeuConvertis, colonneFeuConvertis, j)){
                            positionDesBateau[rangeeFeuConvertis[j]-1][colonneFeuConvertis[j]] = '$';

                        }
                        // positionDesBateau[rangeeFeuConvertis[j]-1][colonneFeuConvertis[j]] = '#';

                        if(positionDesBateau[rangeeFeuConvertis[j]-1][colonneFeuConvertis[j]] !='>' || positionDesBateau[rangeeFeuConvertis[j]-1][colonneFeuConvertis[j]] !='v'){
                            positionDesBateau[rangeeFeuConvertis[j]-1][colonneFeuConvertis[j]] = '@';
                        }




                        /**
                         * le char c est '~'

                        c= positionDesBateau[rangeeInitiale][colonneInitiale];

                        Pep8.charo(c);

                        Pep8.charo(' ');

                    }
                    Pep8.charo('|');
                    Pep8.charo('\n');

                }



            }
            /**
             * on refait l'execution du programme si les coups entrés sont invalide ou s'il reste encore des bateaux non detruit


        }while(!estValide || stilHasBoat(positionDesBateau));


        /**
         * Pour quitter le jeu entrer un char diffrent de <Enter> puis appuyez sur <Enter>.

        for(rangeeInitiale=0; rangeeInitiale<positionDesBateau.length; rangeeInitiale++){
            for(colonneInitiale=0; colonneInitiale<positionDesBateau[rangeeInitiale].length; colonneInitiale++){
                positionDesBateau[rangeeInitiale][colonneInitiale]='~';
            }
        }


        Pep8.charo('\n');
        msgQuitter();
        charQuitter = Pep8.chari();
        if(charQuitter=='\n') {
            n = 0;
            k=0;
        }
    } while (charQuitter == '\n');

}
}




        }
                 **/
