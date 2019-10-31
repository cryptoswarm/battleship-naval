public class UnTableau {

    /**
     * Methode imprimant un beateau a deux dimensions de 9 rangees et 18 colonnes
     */


    /**
     * imprimer le caractere tild
     */

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
