public class UnTableau {



    public static void msgPLacerBateau() {
        Pep8.stro("Entrer la description et la position des bateaux\n" +
                "selon le format suivant, separes par des espaces:\n" + " taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9]\n" + " ex: ghC4 mvM2 phK9");

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


        msgPLacerBateau();

        char lignInput = 'x';

        char taille;
        char orientation='n';
        char colonne;
        char rangee;
        char lignInput1 = 'x';

        Pep8.charo('\n');

        //lignInput = Pep8.chari();


       do{

              //reading first char


            do {

                taille = Pep8.chari();

                Pep8.stro("taille des bateaux est :" + taille);  // il prend le premier caractere
                Pep8.charo('\n');

                orientation = Pep8.chari();
                Pep8.stro("l'orientation des bateaus est   :" + orientation); // il prend le 2eme char
                Pep8.charo('\n');

                colonne = Pep8.chari();
                Pep8.stro("colonne est :" + colonne);
                Pep8.charo('\n');

                rangee = Pep8.chari();
                Pep8.stro("rangee du bateau est  :" + rangee);
                Pep8.charo('\n');


                lignInput1 = Pep8.chari();
                //Pep8.stro("//what are you doing?  :" + lignInput);
                //Pep8.charo('\n');

                Pep8.stro("the second line of code is supposed to print l'orientation  :" + orientation);
                Pep8.charo('\n');


            }while (lignInput1 == ' ');  //&& lignInput1 != '\n'
                //A l'interieur de cette boucle, on obtient les specification de chaque bateau.


            //Pep8.stro("the first line of code is supposed to print la taille :"+lignInput);
            // Pep8.charo('\n');




           lignInput = Pep8.chari();

        } while (lignInput != '\n');


    }
}

