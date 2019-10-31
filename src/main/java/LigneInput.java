public class LigneInput {


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

    public static void msgPLacerBateau() {
        Pep8.stro("Entrer la description et la position des bateaux\n" +
                "selon le format suivant, separes par des espaces:\n" + " taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9]\n" + " ex: ghC4 mvM2 phK9");

    }

    /**
     * methode verifiant les caracteristiques d'un bateau
     * @


     public static void checkSpecificationBateau(char grandeurBateau[], int i){
     boolean estValide;
     estValide = true;

     if ((grandeurBateau[i] == 'p' || grandeurBateau[i] == 'm' || grandeurBateau[i] == 'g'){
     ||
     }
     (orientation != 'h' && orientation != 'v')                               ||
     (alpha < 'A' || alpha > 'R')                                             ||
     ((int) rangee < 1 || (int) rangee > 9) ){
     estValide = false;
     }

     if(!estValide){
     Pep8.stro("les specification du bateau sont incorrectes");
     }

     }
     */


    /**
     * Methode imprimant un beateau a deux dimensions de 9 rangees et 18 colonnes
     */


    public static char[][]  imprimerTableau(int rangee, int colonne){

        //char resDeRangeeColonne;
        char situationInitiale[][] = new char [rangee][colonne];


        //resDeRangeeColonne = situationInitiale[rangee][colonne];

        for (rangee = 0; rangee < situationInitiale.length; rangee++) {
            Pep8.deco(rangee + 1);
            Pep8.charo('|');

            for (colonne = 0; colonne < (situationInitiale[rangee].length); colonne++) {
                Pep8.charo(situationInitiale[rangee][colonne]);
                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        }
        return situationInitiale;
    }


    /**
     * Verifier la grandeur du bateau
     *
     * @param grandeurBateau est la grandeur du bateau, peut etre p, m ou g
     */
    public static char checkTaille(char grandeurBateau) {
        boolean estValide;
        estValide = true;

        if (grandeurBateau != 'p' && grandeurBateau != 'm' && grandeurBateau != 'g') {
            estValide = false;
        }

        if (!estValide) {
            Pep8.stro("la grandeur entree est incorrecte");
            Pep8.charo('\n');
        }
        return grandeurBateau;
    }

    /**
     * @param orientation, l'oriontation du bateau h pour horizontale.
     *                     v pour vertical.
     * @return caractere > quand la position est horizontal sinon V.
     */

    public static char checkOriontation(char orientation) {
        boolean estValide;

        estValide = true;
        if (orientation != 'h' && orientation != 'v') {

            estValide = false;
        }

        if (!estValide) {
            Pep8.stro("l'orientation du bateau est incorrecte");
            Pep8.charo('\n');
        }
        return orientation;
    }

    /**
     * @param alpha la lettre qui designe la colonne doit etre entre A et R
     * @return alpha
     */
    public static char checkLetterColonne(char alpha) {
        boolean estValide;

        estValide = true;
        //char alpha ='Q';
        if (alpha < 'A' || alpha > 'R') {
            estValide = false;

        }

        if (!estValide) {
            Pep8.stro("lettre designant la colonne est incorrecte");
            Pep8.charo('\n');
        }

        return alpha;

    }

    /**
     * @param rangee, nombre des rangées, ne peut pas etre plus que 9
     * @return nomre de rangées
     */

    public static char checkNombreRanger(char rangee) {
        boolean estValide;
        estValide = true;
        if ((int) rangee < 48 || (int) rangee > 57) {
            estValide = false;
        }

        if (!estValide) {
            Pep8.stro("nombre de rangees est incorrecte");
            Pep8.charo('\n');
        }
        return rangee;
    }







    public static void main(String[] args) {
        char lignInput='k';
        char lignInput1='k';
        int i=0;
        int j=0;
        char taille = 'x';
        char orientation = 'x';
        char colonne = 'x';
        char rangee = 'x';
        int rangeeInitial =9;
        int colonneInitial =18;

        //char bateau[] = {taille, orientation, colonne, rangee };

        msgBienvenue();
        Pep8.charo('\n');

        afficherLetters();
        Pep8.charo('\n');

        imprimerTableau(rangeeInitial, colonneInitial);

        Pep8.charo('\n');

        msgPLacerBateau();

        while (lignInput != '\n'){

            lignInput = Pep8.chari();  //reading first char


                while(lignInput!=' ' && lignInput != '\n'){




                    Pep8.stro("taille des bateaux est :"+lignInput);  // il prend le premier caractere
                    Pep8.charo('\n');

                    orientation = Pep8.chari();
                   Pep8.stro("l'orientation des bateaus est   :"+orientation); // il prend le 2eme char
                    Pep8.charo('\n');

                    colonne =Pep8.chari();
                    Pep8.stro("colonne est :"+colonne);
                    Pep8.charo('\n');

                    rangee =Pep8.chari();
                    Pep8.stro("rangee du bateau est  :"+rangee);
                    Pep8.charo('\n');



                    lignInput =Pep8.chari(); //what are you doing?
                    Pep8.charo('\n');


                   }//A l'interieur de cette boucle, on obtient les specification de chaque bateau.



            //Pep8.stro("the first line of code is supposed to print la taille :"+lignInput);
           // Pep8.charo('\n');
            Pep8.stro("the second line of code is supposed to print l'orientation  :"+orientation);
            Pep8.charo('\n');


            }


        }
    }

