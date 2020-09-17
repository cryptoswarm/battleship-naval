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
                    break;
                }
            }
        }
        return resultat;
    }

    /**
     *
     * @param boatPosition
     * @param rowBoatInt
     * @return  nb de parties de bateau par rangee.
     */

    public static int ShipCount(int[][]boatPosition, int rowBoatInt){
        int count =0;
        int numberOfCellsPerRow = 18;

        return count;
    }


    public static char [][] placeBoat(char [][] boatPosition, char taille, char ori, int nbCol, int nbRow){

            switch (taille){
                    case 'g':
                        if(ori =='h'){ //Si le bateau est grand, orienter horizontalement
                            if ( nbCol < 13) { //et que la colonne commence à O, le bateau ne va pas etre affiché.

                                for (int i = 0; i < 5; i++) {

                                    boatPosition[nbRow - 1][nbCol + i] = '>';

                                }
                            }

                        }else if(ori =='v'){ //Si le bateau est grand, orienter verticalement
                            if (nbRow < 6) { //et que la rangee commence à 6, le bateau va pas etre affiché.
                                for (int i = 0; i < 5; i++) {
                                    boatPosition[(nbRow - 1) + i][nbCol] = 'v';
                                }
                            }
                        }
                        break;
                    case 'm':
                        if(ori =='h'){ //Si le bateau est moyen, orienter horizontalement
                            if ( nbCol < 15 ) {//et que la colonne commence à Q, le bateau va pas etre affiché.
                                for (int i = 0; i < 3; i++) {
                                    boatPosition[nbRow - 1][nbCol + i] = '>';
                                }
                            }

                        }else if(ori =='v'){ //Si le bateau est moyen, orienter verticalement
                            if (nbRow < 5) { //et que la rangee commence à 8, le bateau va pas etre affiché.
                                for (int i = 0; i < 3; i++) {
                                    boatPosition[(nbRow - 1) + i][nbCol] = 'v';
                                }
                            }
                        }
                        break;
                    case 'p':
                        if(ori =='h'){
                            for (int i = 0; i < 1; i++) {

                                boatPosition[nbRow - 1][nbCol + i] = '>';
                            }
                        }else if(ori =='v'){
                            for (int i = 0; i < 1; i++) {

                                boatPosition[nbRow - 1 + i][nbCol] = 'v';
                            }
                        }
                        break;
                }
        return boatPosition;
    }

    public static void printBoat(char [][]boatPosition){
        afficherLetters();
        Pep8.charo('\n');
        char c;
        for (int rowPlaySpace = 0; rowPlaySpace < boatPosition.length; rowPlaySpace++) {
            Pep8.deco(rowPlaySpace + 1);
            Pep8.charo('|');
            for (int colPlaySpace = 0; colPlaySpace < boatPosition[rowPlaySpace].length; colPlaySpace++) {
                c = boatPosition[rowPlaySpace][colPlaySpace];

                Pep8.charo(c);

                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        }
    }

     /**
     * @param boatPosition tableau de l'espace de jeu
     * @param rowFeuInt  le coup est definit par la rangee
     * @param colFeuInt  le coup est definit par la colonne
    // * @param j  j est utilisé pour parcourire le tableau stockant les de coups tirés.
     * @return boolean, determinant si les coups touches les parties de bateau ou non.
     **/
     public static void destroyBoat(char [][] boatPosition, int rowFeuInt, int colFeuInt) { //row = 4 = 3  et col = c

         if (rowFeuInt >= 0 && rowFeuInt< 9 && colFeuInt >= 0 && colFeuInt < 18) {

             if (boatPosition[rowFeuInt][colFeuInt] == '~') {
                 boatPosition[rowFeuInt][colFeuInt] = 'o';

             } else if (boatPosition[rowFeuInt][colFeuInt] == '>' || boatPosition[rowFeuInt][colFeuInt] == 'v') {

                 boatPosition[rowFeuInt][colFeuInt] = '*';

                 destroyBoat(boatPosition, rowFeuInt, colFeuInt + 1);
                 destroyBoat(boatPosition, rowFeuInt, colFeuInt - 1);
                 destroyBoat(boatPosition, rowFeuInt - 1, colFeuInt);
                 destroyBoat(boatPosition, rowFeuInt + 1, colFeuInt);

             }
         }

     }

    public static void main(String[] args) {

        boolean estValide;
        boolean first = true;
        char lignInput1;
        char charQuitter;

        int rowPlaySpace;

        int colPlaySpace;



        msgBienvenue();
        afficherLetters();
        Pep8.charo('\n');

        char [][] boatPosition = imprimerTableauInitial(9, 18, '~');


        char sizeBoat;
        char dirBoat;
        char colBoat;
        int  colBoatInt =0;
        char rangeeTab;
        int  rowBoat =0;

        do { /** boucle pour arreter le programme quand on pese sur la touche entrer*/

            do {
                estValide = true;

                do {
                    if(first) {
                        msgPLacerBateau();
                        first = false;
                    }
                    sizeBoat = Pep8.chari();   // la taille du bateau

                    if (!checkTaille(sizeBoat)) {
                        estValide = false;
                    }

                    dirBoat = Pep8.chari();  //orientation de bateau

                    if (!checkOriontation(dirBoat)) {
                        estValide = false;
                    }
                    colBoat = Pep8.chari();  //la colonne

                    if (checkLetterColonne(colBoat)) {
                        colBoatInt = (int) colBoat - 65;
                    }else{
                        estValide = false;
                    }

                    rangeeTab = Pep8.chari(); //la rangee

                    if (checkNombreRanger(rangeeTab)) {
                        rowBoat = (int) rangeeTab - 48;
                    }else{
                        estValide = false;
                    }
                    if(!estValide){
                        first = true;
                    }
                } while (!estValide );

                placeBoat(boatPosition, sizeBoat, dirBoat, colBoatInt, rowBoat);
                lignInput1 = Pep8.chari(); //read ' '

            }while(lignInput1 == ' ');

            printBoat(boatPosition); //Affichage de l'espace de jeu mis à jour


            /**
             * le bout de code suivant va afficher un msg demandant au joueur d'entrer des coups
             */

            char  espaceEntreCoup;
            char colonneFeu;
            int colFeuInt = 0 ;
            char rangeeFeu ;
            int rowFeuInt = 0;

            /**
             * Verification des coups entrés.
             */

            do{
                Pep8.charo('\n');
                msgFeuAVolonte();
                estValide=true;

                do{
                    colonneFeu = Pep8.chari();
                    if (checkLetterColonne(colonneFeu)){
                        colFeuInt = (int) colonneFeu - 65;
                    }else{
                        estValide = false;
                    }
                    rangeeFeu = Pep8.chari() ;
                    if (checkNombreRanger(rangeeFeu)) {
                        rowFeuInt = (int) rangeeFeu - 48;
                    }else{
                        estValide = false;
                    }
                    destroyBoat(boatPosition, rowFeuInt-1, colFeuInt);   //detruit les bateaux
                    espaceEntreCoup = Pep8.chari();

                }while(espaceEntreCoup==' ');

                    printBoat(boatPosition); //afficher espace de jeu mit à jour

            }while(!estValide || stilHasBoat(boatPosition)); //refait l'execution  si les coups entrés sont invalide
                                                                // ou s'il reste encore des bateaux non detruit

            for(rowPlaySpace=0; rowPlaySpace<boatPosition.length; rowPlaySpace++){
                for(colPlaySpace=0; colPlaySpace<boatPosition[rowPlaySpace].length; colPlaySpace++){
                    boatPosition[rowPlaySpace][colPlaySpace]='~';
                }
            }
            msgQuitter();
            charQuitter = Pep8.chari();

        } while (charQuitter == '\n');

    }
}



