/**
 * Le code suivant represente un jeu de BatNav2 navale
 * l'espace du jeu est constitué de 9 rangées et 18 colonnes
 * Au debut le code affiche un msg de bienvenu suivis d'un tableau remplit avec des '~'
 * Ensuite, un msg demandant à l'utilisateur d'entrer des bateaux selon un format
 * si le format n'est pas resptée, un msg d'erreur va etre affiché en demandant a l'utilisateur de rentrer encoree une fois des bateaux
 *  Ensuite, un msg s'affiche demandant a l'utilisateur d'entrer des coups
 *  si les coups tiré ne sont pas valide, l'utilisateur serait invité à rentrer des coups
 *  Le programme est fonctionnel sauf qu'il affiche 'o' au lieu de l'*' pour les parties de bateaux touchées.
 *  Le programme s'execute en boucle jusqu'à ce qu'on clique sur la touche entrer.
 *
 */


public class Batnav {


    /**
     * Msg demandant de placer les tableaux
     */

    public static void msgPLacerBateau() {
        Pep8.stro("Entrer la description et la position des bateaux\n" +
                "selon le format suivant, separes par des espaces:\n" + " taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9]\n" + " ex: ghC4 mvM2 phK9");

    }




    public static void msgBienvenue() {
        Pep8.stro("Bienvenue au jeu de BatNav2 navale!");
        Pep8.charo('\n');
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
        if(orientation != 'h' && orientation != 'v') {

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
     * @param rangee   rangee du tableau
     * @param colonne colonne du tableau
     * @param tild  le char '~'
     * @return  imprime le tableau du jeu
     */

    public static char [][] imprimerTableauInitial(int rangee, int colonne, char tild){


        char [][]situationInitiale = new char [rangee][colonne];


        situationInitiale[rangee-1][colonne-1] =tild;

        for (rangee = 0; rangee < situationInitiale.length; rangee++) {
            Pep8.deco(rangee + 1);
            Pep8.charo('|');

            for (colonne = 0; colonne < (situationInitiale[rangee].length); colonne++) {

                Pep8.charo(situationInitiale[rangee][colonne] =tild);
                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        };
        return situationInitiale;
    }



     /* *
     * methode affichant msg erreur lors les coups entré sont invalides
     * n'a pas été utilisée
     */
    public static void msgErreurCoupsTire(){
        Pep8.stro("les coups tiré sont à l'exterieur de l'éspace de jeu");
    }


    /**
     *
     * @param positionDesBateau tableau de l'espace de jeu
     * @return  boolean, s'il reste des parties des bateau non detruits ou non
     */

    public static boolean stilHasBoat(char [][]positionDesBateau){

        boolean resultat = false;
        for(int rangee=0; rangee<positionDesBateau.length; rangee++){
            for(int colonne=0; colonne<positionDesBateau[rangee].length; colonne++){
                if(positionDesBateau[rangee][colonne]=='v' ||positionDesBateau[rangee][colonne]=='>' ){
                    resultat=true;
                }
            }
        }

        return resultat;
    }


     /**
     * @param positionDesBateau tableau de l'espace de jeu
     * @param rangFeu  le coup est definit par la rangee
     * @param colFeu  le coup est definit par la colonne
     * @param j  j est utilisé pour parcourire le tableau stockant les de coups tirés.
     * @return boolean, determinant si les coups touches les parties de bateau ou non.
     */


    /**
     *
     * @param tailleTab taille du bateau
     * @param orint  orientation
     * @param rangee nb de rangee
     * @param col nb de colonne
     * @return  le boolean est utilisé pour repeter la demande de rentrer les bateaux s'ils depassent l'espace de jeu.
     */

    public static boolean checkBateau( char []tailleTab, char []orint, int []rangee, int []col){
        int j=0;
        boolean res=false;

        if(tailleTab[j]=='g'){

            if(orint[j]=='v'){
                if(rangee[j]>=6 ){
                    res=true;
                    Pep8.stro("le bateaux avec ces grandeur est à l'exterieur de l'espace de jeu");
                }
            }
        }
        if( tailleTab[j] =='m'){
            if(orint[j]=='v'){
                if(rangee[j]>7){
                    res=true;
                }
            }
        }


        if(tailleTab[j]=='g' ){
            if(orint[j]=='h'){
                if(col[j]>13){
                    res=true;
                }
            }
        }


        if( tailleTab[j] =='m'){
            if(orint[j]=='h'){
                if(col[j]>15){
                    res=true;
                }
            }
        }
        return res;

    }


    public static boolean detruireBateauRecursivement(char [][] positionDesBateau, int []rangFeu, int []colFeu, int j) {

    boolean effect = false;
    int[] tempRangeeFeu = new int[5000];
    int[] tempColonneFeu = new int[5000];


    for (int rangee = 0; rangee < positionDesBateau.length; rangee++) {
        for (int colonne = 0; colonne < positionDesBateau[rangee].length; colonne++) {

            if ((rangFeu[j] >0 || rangFeu[j]<=9) && (colFeu[j]>0 || colFeu[j]<=18) ) {


                if (positionDesBateau[rangee][colonne] == 'v' || positionDesBateau[rangee][colonne] == '>') {
                  //  positionDesBateau[rangFeu[j] - 1][colFeu[j]] = '*';

                    if (positionDesBateau[rangFeu[j] - 1][colFeu[j]] == 'v' || positionDesBateau[rangFeu[j] - 1][colFeu[j]] == '>') {

                        positionDesBateau[rangFeu[j] - 1][colFeu[j]] = '*';

                        if (rangFeu[j] > 1 && rangFeu[j] < 9) {


                            if (positionDesBateau[(rangFeu[j] - 1) - 1][colFeu[j]] == '>' || positionDesBateau[(rangFeu[j] - 1) - 1][colFeu[j]] == 'v') {
                                positionDesBateau[(rangFeu[j] - 1) - 1][colFeu[j]] = '*';
                            } else {
                                positionDesBateau[(rangFeu[j] - 1) - 1][colFeu[j]] = 'o';
                            }
                            if (positionDesBateau[(rangFeu[j] - 1)][colFeu[j] - 1] == '>' || positionDesBateau[(rangFeu[j] - 1)][colFeu[j] - 1] == 'v') {
                                positionDesBateau[(rangFeu[j] - 1)][colFeu[j] - 1] = '*';
                            } else {
                                positionDesBateau[(rangFeu[j] - 1)][colFeu[j] - 1] = 'o';
                            }
                            if (positionDesBateau[(rangFeu[j] - 1) + 1][colFeu[j]] == 'v' || positionDesBateau[(rangFeu[j] - 1) + 1][colFeu[j]] == '>') {
                                positionDesBateau[(rangFeu[j] - 1) + 1][colFeu[j]] = '*';
                            } else {
                                positionDesBateau[(rangFeu[j] - 1) + 1][colFeu[j]] = 'o';
                            }

                        } else if (rangFeu[j] == 9) {
                            tempRangeeFeu[j] = rangFeu[j] - 1;
                            positionDesBateau[(tempRangeeFeu[j])][colFeu[j]] = '*';

                            positionDesBateau[tempRangeeFeu[j] - 1][colFeu[j]] = 'o';
                            positionDesBateau[tempRangeeFeu[j]][colFeu[j] - 1] = 'o';

                        } else if (rangFeu[j] == 1) {
                            tempRangeeFeu[j] = rangFeu[j] + 1;

                            positionDesBateau[(tempRangeeFeu[j] - 1) - 1][colFeu[j]] = 'o';
                            positionDesBateau[(tempRangeeFeu[j] - 1)][colFeu[j]] = 'o';


                        }
                        positionDesBateau[rangFeu[j] - 1][(colFeu[j]) + 1] = 'o';

                        if (colFeu[j] == 1) {
                            tempColonneFeu[j] = colFeu[j] + 1;

                            positionDesBateau[rangFeu[j]][tempColonneFeu[j] - 1] = 'o';
                        }
                        effect = true;


                    }
                }
            }
    }
}
    return effect;
}



    public static void main(String[] args) {





        boolean estValide;
        char lignInput1;
        char charQuitter;
        int n=0;
        int k=0;
        int j;

        int rangeeInitiale;

        int colonneInitiale;



        msgBienvenue();
        afficherLetters();
        Pep8.charo('\n');

        char [][] positionDesBateau = imprimerTableauInitial(9, 18, '~');


        char []tailleTab=new char[1000];
        char []orientationTab=new char[1000];
        char []colonneTab=new char[1000];
        int  []colonneTabConvertis = new int [1000];
        char []rangeeTab=new char[1000];
        int  []rangeeTabConvertis = new int [1000];






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


                for ( j = 0; j < n; j++) {
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
           //}while(!estValide);
        }while(!estValide || checkBateau(tailleTab, orientationTab, rangeeTabConvertis, colonneTabConvertis));

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

                        Pep8.charo(c);

                    Pep8.charo(' ');
                }
                Pep8.charo('|');
                Pep8.charo('\n');
            }




            /**
             * le bout de code suivant va afficher un msg demandanu au joueur d'entrer des coups
             */



            char  espaceEntreCoup;
            char []colonneFeu = new char[1000];
            int [] colonneFeuConvertis = new int [1000];
            char []rangeeFeu = new char [1000];
            int [] rangeeFeuConvertis = new int [1000];

            /**
             * Verification des coups entrés.
             */



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
                     */

                    colonneFeuConvertis[j] = (int) colonneFeu[j] - 65;
                    Pep8.charo('\n');

                    rangeeFeuConvertis[j] = (int) rangeeFeu[j] - 48;
                    Pep8.charo('\n');



                    /**
                     * le code suivant est sensé affiché le jeu mise a jour
                     * la position des bateaux
                     * les coups tiré
                     */


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
                             */



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

                            /**
                             * Condition Vérifiant si les coordonnées des coups tirés sont à la même place que les positions des bateaux.

                             **/


                               if(detruireBateauRecursivement(positionDesBateau, rangeeFeuConvertis, colonneFeuConvertis, j)){

                              } else {
                                 positionDesBateau[rangeeFeuConvertis[j] - 1][colonneFeuConvertis[j]] = 'o';

                                }




                            /**
                             * le char c est '~'
                             */
                            c = positionDesBateau[rangeeInitiale][colonneInitiale];

                           Pep8.charo(c);

                            Pep8.charo(' ');

                        }
                        Pep8.charo('|');
                        Pep8.charo('\n');

                            }



                        }
                /**
                 * on refait l'execution du programme si les coups entrés sont invalide ou s'il reste encore des bateaux non detruit
                 */

            }while(!estValide || stilHasBoat(positionDesBateau));


            /**
             * Pour quitter le jeu entrer un char diffrent de <Enter> puis appuyez sur <Enter>.
             */
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



