public class bataille_naval_0804 {

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


    public static void imprimerHoriOuVerti(char taille, char orientation, int colonne, int rangee) {

        char[][] tab = new char[9][18];

        for (rangee = 0; rangee < tab.length; rangee++) {
            for (colonne = 0; colonne < tab[rangee].length; colonne++) {

        if (taille == 'g') {
            if (orientation == 'h') {
                for (int k = 0; k < 5; k++) {
                    Pep8.charo(tab[rangee][colonne + k] = '>');
                    Pep8.charo(' ');
                }

            } else if (orientation == 'v') {

                        Pep8.charo(tab[rangee][colonne] = 'v');
                        Pep8.charo(tab[rangee + 1][colonne] = 'v');
                        Pep8.charo(tab[rangee + 2][colonne] = 'v');
                        Pep8.charo(tab[rangee + 3][colonne] = 'v');
                        Pep8.charo(tab[rangee + 4][colonne] = 'v');
                    }
                }
            }

        }
    }


    public static void imprimerTableauInitial(int rangee, int colonne, char tild){

        char resDeRangeeColonne;

        char [][]situationInitiale = new char [9][18];

        //        resDeRangeeColonne =
        situationInitiale[rangee-1][colonne-1] =tild;

        afficherLetters();
        Pep8.charo('\n');

        for (int i = 0; i < situationInitiale.length; i++) {
            Pep8.deco(i + 1);
            Pep8.charo('|');

            for (int j = 0; j < situationInitiale[i].length; j++) {


                if(i == rangee-1 && j== colonne-1){
                    if(colonne<14) {
                        for (int n = 0; n < 5; n++) {
                            Pep8.charo(situationInitiale[rangee][colonne] = '>');
                            Pep8.charo(' ');
                        }
                    }else {
                        for (int n = 0; n <(situationInitiale[i].length-colonne) ; n++) {
                            Pep8.charo(situationInitiale[rangee][colonne] = '>');
                            Pep8.charo(' ');
                        }
                    }

                    j=j+4;

                }else{
                    Pep8.charo(situationInitiale[rangee-1][colonne-1] =tild);
                    Pep8.charo(' ');
                }

            }
            Pep8.charo('|');
            Pep8.charo('\n');
        };
        //return resDeRangeeColonne;
    }


    public static void main(String[] args) {

      //  imprimerHoriOuVerti('g', 'v', 5, 4);

        imprimerTableauInitial(9,12,'~');

    }
}

