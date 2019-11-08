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


public class Batnav3 {


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
     * @param sizeBoat taille du bateau
     * @param orint  orientation
     * @param rangee nb de rangee
     * @param col nb de colonne
     * @return  le boolean est utilisé pour repeter la demande de rentrer les bateaux s'ils depassent l'espace de jeu.
     */

    public static boolean checkBateau( char []sizeBoat, char []orint, int []rangee, int []col){
        int j=0;
        boolean res=false;

        if(sizeBoat[j]=='g'){

            if(orint[j]=='v'){
                if(rangee[j]>=6 ){
                    res=true;

                }
            }
        }
        if( sizeBoat[j] =='m'){
            if(orint[j]=='v'){
                if(rangee[j]>7){
                    res=true;
                }
            }
        }


        if(sizeBoat[j]=='g' ){
            if(orint[j]=='h'){
                if(col[j]>13){
                    res=true;
                }
            }
        }


        if( sizeBoat[j] =='m'){
            if(orint[j]=='h'){
                if(col[j]>15){
                    res=true;
                }
            }
        }
        if(res){
            Pep8.charo('\n');
            Pep8.stro("La description ou la position de bateau n'est pas conforme au format.  Il'est à l'exterieur de l'espace de jeu");
            Pep8.charo('\n');
        }
        return res;

    }



    /**
     *
     * @param boatPosition tableau de l'espace de jeu
     * @return  boolean, s'il reste des parties des bateau non detruits ou non
     */

    public static boolean stilHasBoat(char [][]boatPosition){

        boolean resultat = false;
        for(int rangee=0; rangee<boatPosition.length; rangee++){
            for(int colonne=0; colonne<boatPosition[rangee].length; colonne++){
                if(boatPosition[rangee][colonne]=='v' || boatPosition[rangee][colonne]=='>' ){
                    resultat=true;
                }
            }
        }

        return resultat;
    }


     /**
     * @param boatPosition tableau de l'espace de jeu
     * @param rowFeuInt  le coup est definit par la rangee
     * @param colFeuInt  le coup est definit par la colonne
     * @param j  j est utilisé pour parcourire le tableau stockant les de coups tirés.
     * @return boolean, determinant si les coups touches les parties de bateau ou non.


public static boolean destroyBoat(char [][] boatPosition, int []rowFeuInt, int []colFeuInt, int j) {

    boolean effect = false;

    for (int rangee = 0; rangee < boatPosition.length; rangee++) {
        for (int colonne = 0; colonne < boatPosition[rangee].length; colonne++) {

            if ((rangFeu[j] >0 || rangFeu[j]<=9) && (colFeu[j]>0 || colFeu[j]<18) ) {

                if (boatPosition[rangFeu[j] - 1][colFeu[j]] == 'v' || boatPosition[rangFeu[j] - 1][colFeu[j]] == '>') {
                    boatPosition[rangFeu[j] - 1][colFeu[j]] = '*';
                    effect=true;
                   // destroyBoat(boatPosition, rangFeu, colFeu, j);


                }
                else if(boatPosition[rangFeu[j] - 1][colFeu[j]] == '~' ) {
                    boatPosition[rangFeu[j] - 1][(colFeu[j])] = 'o';
                    effect = false;
                }

                if (rangFeu[j] > 1 && rangFeu[j] < 9 && colFeu[j]>1 && colFeu[j]<=18) {
                    if (boatPosition[rangFeu[j] - 2][colFeu[j]] == 'v' || boatPosition[rangFeu[j] - 2][colFeu[j]] == '>') {
                        boatPosition[rangFeu[j] - 2][colFeu[j]] = '*';
                        effect=true;
                    }
                    if (boatPosition[rangFeu[j]][colFeu[j]] == 'v' || boatPosition[rangFeu[j]][colFeu[j]] == '>') {
                        boatPosition[rangFeu[j]][colFeu[j]] = '*';
                        effect=true;
                    }
                    if (boatPosition[rangFeu[j] - 1][colFeu[j] - 1] == 'v' || boatPosition[rangFeu[j] - 1][colFeu[j] - 1] == '>') {
                        boatPosition[rangFeu[j] - 1][colFeu[j] - 1] = '*';
                        effect=true;
                    }
                    if (boatPosition[rangFeu[j] - 1][colFeu[j] ] == 'v' || boatPosition[rangFeu[j] - 1][colFeu[j] ] == '>') {
                        boatPosition[rangFeu[j] - 1][colFeu[j] ] = '*';
                        effect=true;
                    }
                }
            }
    }
}
    return effect;
}
*/

     public static void destroyBoat(char [][] boatPosition, int []rowFeuInt, int []colFeuInt, int j) {

         //boolean effect = false;
         char c;

         for (int rowPlaySpace = 0; rowPlaySpace < boatPosition.length; rowPlaySpace++) {
             for (int colPlaySpace = 0; colPlaySpace< boatPosition[rowPlaySpace].length; colPlaySpace++) {

                 if (rowPlaySpace == rowFeuInt[j] - 1 && colPlaySpace == colFeuInt[j]) {

                     if (boatPosition[rowFeuInt[j] - 1][colFeuInt[j]] == '>') {
                         boatPosition[rowFeuInt[j] - 1][colFeuInt[j]] = '*';
                         boatPosition[rowFeuInt[j]-2][colFeuInt[j]] = 'o';
                         if(rowFeuInt[j] != 9) {
                             boatPosition[rowFeuInt[j]][colFeuInt[j]] = 'o';
                         }
                         if(boatPosition[rowFeuInt[j]-1][colFeuInt[j]-1] != '*'){
                             boatPosition[rowFeuInt[j] - 1][colFeuInt[j]-1] = 'o';
                         }

                     }

                     if(boatPosition[rowFeuInt[j] - 1][colFeuInt[j]] == 'v'){


                         boatPosition[rowFeuInt[j] - 1][colFeuInt[j]] = '*';

                         boatPosition[rowFeuInt[j]-1 ][colFeuInt[j]+1] = 'o';
                         boatPosition[rowFeuInt[j]-1 ][colFeuInt[j]-1] = 'o';

                         if(boatPosition[rowFeuInt[j]][colFeuInt[j]] == 'v') {
                             boatPosition[rowFeuInt[j]][colFeuInt[j]] = '*';
                             boatPosition[rowFeuInt[j]][colFeuInt[j]+1] = 'o';
                             boatPosition[rowFeuInt[j]][colFeuInt[j]-1] = 'o';

                             if(boatPosition[rowFeuInt[j]+1][colFeuInt[j]] == 'v'){

                                 boatPosition[rowFeuInt[j]+1][colFeuInt[j]] = '*';
                                 boatPosition[rowFeuInt[j]+1][colFeuInt[j]+1] = 'o';
                                 boatPosition[rowFeuInt[j]+1][colFeuInt[j]-1] = 'o';

                                 if(boatPosition[rowFeuInt[j]+2][colFeuInt[j]] == 'v'){

                                     boatPosition[rowFeuInt[j]+2][colFeuInt[j]] = '*';
                                     boatPosition[rowFeuInt[j]+2][colFeuInt[j]+1] = 'o';
                                     boatPosition[rowFeuInt[j]+2][colFeuInt[j]-1] = 'o';

                                     if(boatPosition[rowFeuInt[j]+3][colFeuInt[j]] == 'v') {

                                         boatPosition[rowFeuInt[j] + 3][colFeuInt[j]] = '*';
                                         boatPosition[rowFeuInt[j] + 3][colFeuInt[j] + 1] = 'o';
                                         boatPosition[rowFeuInt[j] + 3][colFeuInt[j] - 1] = 'o';
                                     }

                                 }

                             }
                         }

                     }

                 } else if (boatPosition[rowFeuInt[j] - 1][colFeuInt[j]] == '~') {

                     boatPosition[rowFeuInt[j] - 1][colFeuInt[j]] = 'o';
                 }
             }
         }
     }


    public static void main(String[] args) {





        boolean estValide;
        char lignInput1;
        char charQuitter;
        int n=0;
        int k=0;
        int j;

        int rowPlaySpace;

        int colPlaySpace;



        msgBienvenue();
        afficherLetters();
        Pep8.charo('\n');

        char [][] boatPosition = imprimerTableauInitial(9, 18, '~');


        char []sizeBoat=new char[1000];
        char []dirBoat=new char[1000];
        char []colBoat=new char[1000];
        int  []colBoatInt = new int [1000];
        char []rangeeTab=new char[1000];
        int  []rowBoat = new int [1000];






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
                    colBoatInt[j] = (int) colBoat[j] - 65;
                    rowBoat[j] = (int) rangeeTab[j] - 48;

                    /**
                     * Affichage de l'espace de jeu mis à jour
                     */


                    for (rowPlaySpace = 0; rowPlaySpace < boatPosition.length; rowPlaySpace++) {

                        for (colPlaySpace = 0; colPlaySpace < boatPosition[rowPlaySpace].length; colPlaySpace++) {

                            /**
                             * quand la cordonnees du bateau initiale egale la coordonnees du position entré
                             * une coordonnee du bateau initiale est definit par numero de range et numero du colonne
                             * une coordonnee du position du bateau  est definit par numero de range et numero du colonne
                             */


                            if (sizeBoat[j] == 'g') {

                                if (dirBoat[j] == 'h') {
                                    /**
                                     * Si le bateau est grand, orienter horizontalement
                                     * et que la colonne commence à O, le bateau va pas etre affiché.
                                     */

                                    if (boatPosition[rowPlaySpace].length - (colBoatInt[j] - 1) > 5) {

                                        for (int i = 0; i < 5; i++) {

                                                boatPosition[rowBoat[j] - 1][colBoatInt[j] + i] = '>';

                                        }
                                    }


                                    /**
                                     * Si le bateau est grand, orienter verticalement
                                     * et que la rangee commence à 6, le bateau va pas etre affiché.
                                     */


                                } else if (dirBoat[j] == 'v') {
                                    if (boatPosition.length - (rowBoat[j] -1) >= 5) {
                                        for (int i = 0; i < 5; i++) {
                                                boatPosition[(rowBoat[j] - 1) + i][colBoatInt[j]] = 'v';


                                        }
                                    }

                                }


                            }else if (sizeBoat[j] == 'm') {


                                if (dirBoat[j] == 'h') {

                                    /**
                                     * Si le bateau est moyen, orienter horizontalement
                                     * et que la colonne commence à Q, le bateau va pas etre affiché.
                                     */

                                    if (boatPosition[rowPlaySpace].length - (colBoatInt[j] - 1) > 3) {
                                        for (int i = 0; i < 3; i++) {
                                                boatPosition[rowBoat[j] - 1][colBoatInt[j] + i] = '>';


                                        }
                                    }

                                } else if (dirBoat[j] == 'v') {

                                    /**
                                     * Si le bateau est moyen, orienter verticalement
                                     * et que la rangee commence à 8, le bateau va pas etre affiché.
                                     */


                                    if (boatPosition.length - (rowBoat[j] -1) >= 3) {
                                        for (int i = 0; i < 3; i++) {
                                                boatPosition[(rowBoat[j] - 1) + i][colBoatInt[j]] = 'v';


                                        }
                                    }

                                }


                            } else if (sizeBoat[j] == 'p') {

                                if (dirBoat[j] == 'h') {


                                    for (int i = 0; i < 1; i++) {

                                            boatPosition[rowBoat[j] - 1][colBoatInt[j] + i] = '>';


                                    }
                                }


                            } else if (dirBoat[j] == 'v') {

                                for (int i = 0; i < 1; i++) {

                                        boatPosition[rowBoat[j] - 1 + i][colBoatInt[j]] = 'v';


                                }

                            }

                        }

                    }
                }

            }while(!estValide || checkBateau(sizeBoat, dirBoat, rowBoat, colBoatInt));

            /**
             * Affichage de l'espace de jeu mis à jour

             // if(temporary) {
             */

            afficherLetters();
            Pep8.charo('\n');
            char c;
            for (rowPlaySpace = 0; rowPlaySpace < boatPosition.length; rowPlaySpace++) {
                Pep8.deco(rowPlaySpace + 1);
                Pep8.charo('|');
                for (colPlaySpace = 0; colPlaySpace < boatPosition[rowPlaySpace].length; colPlaySpace++) {
                    c = boatPosition[rowPlaySpace][colPlaySpace];

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
            int [] colFeuInt = new int [1000];
            char []rangeeFeu = new char [1000];
            int [] rowFeuInt = new int [1000];

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

                    colFeuInt[j] = (int) colonneFeu[j] - 65;
                    Pep8.charo('\n');

                    rowFeuInt[j] = (int) rangeeFeu[j] - 48;
                    Pep8.charo('\n');



                    /**
                     * le code suivant est sensé affiché le jeu mise a jour
                     * la position des bateaux
                     * les coups tiré
                     */


                    afficherLetters();
                    Pep8.charo('\n');

                    for (rowPlaySpace = 0; rowPlaySpace < boatPosition.length; rowPlaySpace++) {
                        Pep8.deco(rowPlaySpace + 1);
                        Pep8.charo('|');

                        for (colPlaySpace = 0; colPlaySpace < boatPosition[rowPlaySpace].length; colPlaySpace++) {

                            /**
                             * quand la cordonnees du bateau initiale egale la coordonnees du position entré
                             * une coordonnee du bateau initiale est definit par numero de range et numero du colonne
                             * une coordonnee du position du bateau  est definit par numero de range et numero du colonne
                             */



                            if (sizeBoat[j] == 'g') {


                                if (dirBoat[j] == 'h') {

                                    if (boatPosition[rowPlaySpace].length - (colBoat[j] - 1) > 5) {

                                        for (int i = 0; i < 5; i++) {

                                                boatPosition[rowBoat[j] - 1][colBoat[j] + i] = '>';

                                        }
                                    }


                                } else if (dirBoat[j] == 'v') {

                                    if (boatPosition.length - (rowBoat[j] -1) >= 5) {
                                        for (int i = 0; i < 5; i++) {
                                                boatPosition[(rowBoat[j] - 1) + i][colBoatInt[j]] = 'v';


                                        }
                                    }
                                }



                            }else if (sizeBoat[j] == 'm') {


                                if (dirBoat[j] == 'h') {
                                    if (boatPosition[rowPlaySpace].length - (colBoat[j] - 1) > 3) {

                                        for (int i = 0; i < 3; i++) {

                                                boatPosition[rowBoat[j] - 1][colBoat[j] + i] = '>';


                                        }
                                    }

                                } else if (dirBoat[j] == 'v') {
                                    if (boatPosition.length - (rowBoat[j] -1) >= 3) {
                                        for (int i = 0; i < 3; i++) {
                                                boatPosition[(rowBoat[j] - 1) + i][colBoatInt[j]] = 'v';


                                        }
                                    }

                                }


                            } else if (sizeBoat[j] == 'p') {


                                if (dirBoat[j] == 'h') {


                                    for (int i = 0; i < 1; i++) {
                                            boatPosition[rowBoat[j] - 1][colBoatInt[j] + i] = '>';


                                    }
                                }

                            } else if (dirBoat[j] == 'v') {

                                for (int i = 0; i < 1; i++) {
                                        boatPosition[rowBoat[j] - 1 + i][colBoatInt[j]] = 'v';


                                }

                            }

                            /**
                             * Condition Vérifiant si les coordonnées des coups tirés sont à la même place que les positions des bateaux.




                               //if(destroyBoat(boatPosition, rowFeuInt, colFeuInt, j));
                            if(rowFeuInt[j]==rowBoat[j] && colFeuInt[j]== colBoatInt[j]){

                                if(boatPosition[rowFeuInt[j]-1][colBoatInt[j]] == '>') {

                                    boatPosition[rowFeuInt[j] - 1][colFeuInt[j]] = '#';
                                }

                            }else{
                                boatPosition[rowFeuInt[j] - 1][colFeuInt[j]] = '@';
                            }
                             **/
                            destroyBoat( boatPosition, rowFeuInt, colFeuInt, j);
                           /**
                            if(rowPlaySpace == rowFeuInt[j]-1 && colPlaySpace == colFeuInt[j] ) {
                                //Pep8.charo(boatPosition[rowBoat[j]][colBoat[j]]);
                                //boatPosition[rowBoat[j]][colBoatInt[j]] = '*';
                                //boatPosition[rowFeuInt[j]][colFeuInt[j]] = '*';
                                if (boatPosition[rowFeuInt[j]-1][colFeuInt[j]]=='>' || boatPosition[rowFeuInt[j]-1][colFeuInt[j]]=='v'){
                                    boatPosition[rowFeuInt[j]-1][colFeuInt[j]] = '*';
                                }
                                //Pep8.charo('*');
                            }else if(boatPosition[rowFeuInt[j]-1][colFeuInt[j]]=='~') {
                               // Pep8.charo('o');
                                //boatPosition[rowBoat[j]][colBoatInt[j]] = 'o';
                                boatPosition[rowFeuInt[j]-1][colFeuInt[j]] = 'o';
                            }


                            /**
                            if(boatPosition[rowFeuInt[j]-1][colBoatInt[j]] == '>'){
                                boatPosition[rowFeuInt[j] - 1][colFeuInt[j]] = '#';
                            }


                            /**
                             * le char c est '~'
                             */
                            c = boatPosition[rowPlaySpace][colPlaySpace];

                           Pep8.charo(c);

                            Pep8.charo(' ');

                        }
                        Pep8.charo('|');
                        Pep8.charo('\n');

                            }



                        }
                /**

                Pep8.charo('\n');
                Pep8.stro("Verification");
                Pep8.charo('\n');
                Pep8.stro("at the position of fire , there is : "+boatPosition[rowFeuInt[j]][colFeuInt[j]]);
                Pep8.charo('\n');
                Pep8.stro("at the position of boat , there is : "+boatPosition[rowBoat[j]][colBoat[j]]);

                Pep8.charo('\n');

                for(rowPlaySpace=0; rowPlaySpace<boatPosition.length; rowPlaySpace++){
                    for(colPlaySpace=0; colPlaySpace<boatPosition[rowPlaySpace].length; colPlaySpace++){

                        if(boatPosition[rowPlaySpace][colPlaySpace]=='v' || boatPosition[rowPlaySpace][colPlaySpace]=='>' ){

                            //Pep8.charo(boatPosition[rowPlaySpace][colPlaySpace]);
                            //Pep8.charo('\n');
                            //Pep8.charo(boatPosition[rowBoat[j]][colBoat[j]]);

                            if(rowPlaySpace == rowFeuInt[j] && colPlaySpace == colFeuInt[j] ) {
                                //Pep8.charo(boatPosition[rowBoat[j]][colBoat[j]]);
                                Pep8.charo('*');
                            }else {
                                Pep8.charo('o');
                            }
                        }
                    }
                }

                /**
                 * on refait l'execution du programme si les coups entrés sont invalide ou s'il reste encore des bateaux non detruit
                 */

            }while(!estValide || stilHasBoat(boatPosition));


            /**
             * Pour quitter le jeu entrer un char diffrent de <Enter> puis appuyez sur <Enter>.
             */
            for(rowPlaySpace=0; rowPlaySpace<boatPosition.length; rowPlaySpace++){
                for(colPlaySpace=0; colPlaySpace<boatPosition[rowPlaySpace].length; colPlaySpace++){
                    boatPosition[rowPlaySpace][colPlaySpace]='~';
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



