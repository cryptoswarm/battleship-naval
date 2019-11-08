public class Tableau {


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
     */

    public static void printPartBoatH(char []size, char[] direction ){
        int j=0;
        if(size[j] =='g') {
            if (direction[j] == 'h') {

                for (int i = 0; i < 5; i++) {

                    situationInitiale[rowBoath][colBoath+i] = '>';
                }
            }
        }
    }


    public static void printCharOfBoat(char [] direction, char [] sizeOfBoat){

    }


    /**
     * @param rang
     * @param col
     * @param rowBoath
     * @param colBoath
     * @return
     */

    public static char[][] espaceDeJeu(int rang, int col, int rowBoath, int colBoath, char [] taille, char [] direction) {

        int j=0;

        char[][] situationInitiale = new char[9][18];









        afficherLetters();
        Pep8.charo('\n');
        for (rang = 0; rang < situationInitiale.length; rang++) {
            Pep8.deco(rang + 1);
            Pep8.charo('|');

            for (col = 0; col < (situationInitiale[rang].length); col++) {

                situationInitiale[rang][col] = '~';

                if(taille[j] =='g') {
                    if (direction[j] == 'h') {

                        for (int i = 0; i < 5; i++) {

                            situationInitiale[rowBoath][colBoath+i] = '>';
                        }
                    }
                }

                Pep8.charo(situationInitiale[rang][col]);

                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        }

        return situationInitiale;
    }

    public static void main(String[] args) {


        boolean estValide;
        int n =0;
        int j=0;
        char lignInput1;

        char[] sizeBoat = new char[1000];
        char[] dirBoat = new char[1000];
        char[] colonneTab = new char[1000];
        int[] colonneTabConvertis = new int[1000];
        char[] rangeeTab = new char[1000];
        int[] rangeeTabConvertis = new int[1000];


        //   do { /** boucle pour arreter le programme quand on pese sur la touche entrer
        //   */
        //do {

        msgPLacerBateau();
        Pep8.charo('\n');

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

            if (!estValide) {
                n = 0;

            } else {
                n++;
            }


            /**
             * le 5eme char est l'espace separant les specifications d'un bateau à l'autre.
             */
            lignInput1 = Pep8.chari();


        } while (lignInput1 == ' ');


        // }
        for(j=0; j<n; j++) {

            espaceDeJeu(9, 18, 3, 5, sizeBoat, dirBoat);
        }


    }
}
