public class BatailleReal {


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
            //Pep8.charo(colonne);
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
     * message indiquant au joueur qu'il peut tirer
     */
    public static void msgFeuAVolonte() {

        Pep8.stro("Feu à volonté!\n" +
                "(entrer les coups à tirer: colonne [A-R] rangée [1-9])\n" +
                "ex: A3 I5 M3");
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
/**
 if(!estValide){
 //msgPLacerBateau();
 Pep8.stro("grandeur  est incorrecte");
 }
 **/

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
/**
 if (!estValide) {
 //msgPLacerBateau();
 Pep8.stro("orientation est incorrecte");
 Pep8.charo('\n');
 }
 **/
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
/**
 if (!estValide) {
 //msgPLacerBateau();
 Pep8.stro("colonne est incorrecte");
 Pep8.charo('\n');
 }
 **/


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
/**
 if (!estValide) {
 Pep8.stro("nombre de rangees est incorrecte");
 Pep8.charo('\n');
 }
 **/
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

     **/


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

    /**

     public static void main(String[] args) {
     int rangeeInitiale=9;
     int colonneInitiale=18;
     int rangeePositionBateau;
     int colonnePositionBateau;
     char charSituationInitiale ='~';
     imprimerTableauInitial(9,18, charSituationInitiale);


     /* *
     * methode affichant msg erreur lors les coups entré sont invalides
     *
     */
    public static void msgErreurCoupsTire(){
        Pep8.stro("les coups tiré sont à l'exterieur de l'éspace de jeu");
    }



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
        int n=0;
        int k=0;

        int rangeeInitiale=9;
        int rangeeInitialeTemp;
        int colonneInitiale=18;
        int colonneInitialeTemp;

        char [][] situationInitiale = new char [rangeeInitiale][colonneInitiale];

        char [][] positionDesBateau = new char [rangeeInitiale][colonneInitiale];


        //

        msgBienvenue();
        afficherLetters();
        Pep8.charo('\n');
        imprimerTableauInitial(9, 18, '~');



        char []tailleTab=new char[1000];
        char []orientationTab=new char[1000];
        char []colonneTab=new char[1000];
        int  []colonneTabConvertis = new int [1000];
        char []rangeeTab=new char[1000];
        int [] rangeeTabConvertis = new int [1000];






        do { /** boucle pour arreter le programme quand on pese sur la touche entrer
         */
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

                    tailleTab[n] = Pep8.chari();

                    if (!checkTaille(tailleTab[n])) {


                        estValide = false;


                    }

                    /**
                     * * le deuxiem char est l'orientation du bateau
                     * */


                    orientationTab[n] = Pep8.chari();

                    if (!checkOriontation(orientationTab[n])) {


                        estValide = false;


                    }

                    /**
                     * le 3eme char est la colonne
                     */

                    colonneTab[n] = Pep8.chari();

                    if (!checkLetterColonne(colonneTab[n])) {


                        estValide = false;



                    }

                    /**
                     * le 4eme char est la rangee
                     */

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
                     */
                    lignInput1 = Pep8.chari();


                } while (lignInput1 == ' ');

                /**
                 * Conversion des chars à des entiers
                 */


                for (int j = 0; j < n; j++) {
                    colonneTabConvertis[j] = (int) colonneTab[j] - 65;
                    rangeeTabConvertis[j] = (int) rangeeTab[j] - 48;

                    /**
                     * Affichage de l'espace de jeu mis à jour
                     */


                    for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {

                        for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {

                            /**
                             * quand la cordonnees du bateau initiale egale la coordonnees du position entré
                             * une coordonnee du bateau initiale est definit par numero de range et numero du colonne
                             * une coordonnee du position du bateau  est definit par numero de range et numero du colonne
                             */


                            if (tailleTab[j] == 'g') {

                                if (orientationTab[j] == 'h') {
                                    /**
                                     * Si le bateau est grand, orienter horizontalement
                                     * et que la colonne commence à O, le bateau va pas etre affiché.
                                     */

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
                                     */


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
                                     */

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
                                     */


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
            }while(!estValide);

            /**
             * Affichage de l'espace de jeu mis à jour

             // if(temporary) {
             */

            afficherLetters();
            Pep8.charo('\n');
            char c;
            for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {
                Pep8.deco(rangeeInitiale + 1);
                Pep8.charo('|');
                for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {
                    c = positionDesBateau[rangeeInitiale][colonneInitiale];
                    if(c == 'v' || c == '>') {
                        Pep8.charo(c);
                    }
                    else {
                        tild();
                    }
                    Pep8.charo(' ');
                }
                Pep8.charo('|');
                Pep8.charo('\n');
            }




            /**
             * le bout de code suivant va afficher un msg demandanu au joueur d'entrer des coups
             */



            char  espaceEntreCoup;
            //int k;
            char []colonneFeu = new char[1000];
            int [] colonneFeuConvertis = new int [1000];
            char []rangeeFeu = new char [1000];
            int [] rangeeFeuConvertis = new int [1000];



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

                //if(!estValide) {
                    //msgErreurCoupsTire();
               // }

                    if(!estValide){
                         k=0;
                    }else{
                        k++;}

                    espaceEntreCoup = Pep8.chari();

                }while(espaceEntreCoup==' ');






            for (int j = 0; j < k; j++) {



                colonneFeuConvertis[j] = (int) colonneFeu[j] - 65;
                Pep8.charo('\n');
                Pep8.stro("colonne de feu tiré est : "+colonneFeuConvertis[j]);

                rangeeFeuConvertis[j] = (int) rangeeFeu[j] - 48;
                Pep8.charo('\n');
                Pep8.stro("rangee de feu tiré est : "+rangeeFeuConvertis[j]);
                Pep8.charo('\n');


                /**
                 * le code suivant est sensé affiché le jeu mise a jour
                 * la position des bateaux
                 * les coups tiré
                 */



                for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {

                    for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {

                        /**
                         * quand la cordonnees du bateau initiale egale la coordonnees du position entré
                         * une coordonnee du bateau initiale est definit par numero de range et numero du colonne
                         * une coordonnee du position du bateau  est definit par numero de range et numero du colonne
                         */
                        if(rangeeInitiale==(rangeeTabConvertis[j]-1) && colonneInitiale == colonneTabConvertis[j]) {
// -1
                            if ((rangeeFeuConvertis[j] == rangeeTabConvertis[j]) && (colonneFeuConvertis[j] == colonneTabConvertis[j])) {
                                positionDesBateau[rangeeFeuConvertis[j]][colonneFeuConvertis[j]] = '*';
                            } else {
                                positionDesBateau[rangeeFeuConvertis[j]][colonneFeuConvertis[j]] = 'o';
                            }
                        }


                        if (tailleTab[j] == 'g') {


                            if (orientationTab[j] == 'h') {

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
                                        positionDesBateau[rangeeTabConvertis[j] - 1][colonneTabConvertis[j] + i] = '>';

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



                    }

                }
            }

            }while(!estValide ); // || nb v ou > !=0



            afficherLetters();
            Pep8.charo('\n');
            int nbCoup=0;
            //char c;
            char toucheOuNon ;  //Si touché on imprime '*' sinon 'o'

            for (rangeeInitiale = 0; rangeeInitiale < positionDesBateau.length; rangeeInitiale++) {
                Pep8.deco(rangeeInitiale + 1);
                Pep8.charo('|');
                for (colonneInitiale = 0; colonneInitiale < positionDesBateau[rangeeInitiale].length; colonneInitiale++) {
                    c = positionDesBateau[rangeeInitiale][colonneInitiale];
                   toucheOuNon = positionDesBateau[(rangeeFeuConvertis[nbCoup])-1][colonneFeuConvertis[nbCoup]];
                    //toucheOuNon = positionDesBateau[rangeeFeuConvertis[j]][colonneFeuConvertis[j]];




                    //Pep8.charo(positionDesBateau[rangeeFeuConvertis[k]][colonneFeuConvertis[k]] ='o');
                    //if(eau !='v' || eau != '>')
                      //  Pep8.charo('o');

                    if(c == 'v' || c == '>' || c == toucheOuNon) {
                        Pep8.charo(c);

                    }else{
                        tild();

                    }

                     /**
                     *code imprimant 'o' ou '*'


                    if(o == 'v' || o == '>') {
                        Pep8.charo('*');
                    }
                    else{
                        Pep8.charo(positionDesBateau[rangeeFeuConvertis[k]][colonneFeuConvertis[k]]='o');

                    }
                     */






                    Pep8.charo(' ');

                }
                Pep8.charo('|');
                Pep8.charo('\n');


            }





















            /**
             * Pour quitter le jeu entrer un char diffrent de <Enter> puis appuyez sur <Enter>.
             */
            Pep8.charo('\n');
            msgQuitter();
            charQuitter = Pep8.chari();
            //if(charQuitter=='\n') {
            //   n = 0;
            //  }
        } while (charQuitter == '\n');

    }
}



