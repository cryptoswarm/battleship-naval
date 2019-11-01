public class Grandeur {


    public static void msgPLacerBateau() {
        Pep8.stro("Entrer la description et la position des bateaux\n" +
                "selon le format suivant, separes par des espaces:\n" + " taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9]\n" + " ex: ghC4 mvM2 phK9");

    }


    /**
     * Verifier la grandeur du bateau
     * @param grandeurBateau est la grandeur du bateau, peut etre p, m ou g
     */

    public static char checkTaille(char grandeurBateau) {
        boolean estValide;

        //do{
            estValide = true;

            if (grandeurBateau != 'p' && grandeurBateau != 'm' && grandeurBateau != 'g') {


                Pep8.charo('\n');
                estValide = false;
            }

            if(!estValide){
                msgPLacerBateau();
            }

        //}while(!estValide);

        return grandeurBateau;
    }




    /**
     * methode verifiant les caracteristiques d'un bateau
     * @
    */

     public static char[] checkSpecificationBateau(char []grandeurBateau){
         boolean estValide;
         int i=0;
         estValide = true;

         if (((grandeurBateau[i] != 'p' && grandeurBateau[i] != 'm' && grandeurBateau[i] != 'g')) &&

            (grandeurBateau[i] != 'h' && grandeurBateau[i]!= 'v') &&
                 (grandeurBateau[i] < 'A' || grandeurBateau[i] > 'R') &&
                 ((int) (grandeurBateau[i]) < 1 || (int) (grandeurBateau[i]) > 9)){
             estValide = false;
         }

         if (!estValide) {
             Pep8.stro("les specification du bateau sont incorrectes");
         }

         return grandeurBateau;
     }



    /**
     * main
     * @param args
     */

    public static void main(String[] args) {


        char taille='x';
        char orientation='n';
        char colonne='V';
        char rangee=4;
        char lignInput1;

        boolean estValide;

        msgPLacerBateau();
        Pep8.charo('\n');



            do {

                estValide=true;

                /**
                 boucle arret de lecture de la ligne entree. l'espace entre les char est pris comme condition de continuite de lecture.
                 */

                /**
                 * le premier char est la taille
                 */

                //taille = Pep8.chari();

                //taille = Pep8.chari();
                //taille = checkTaille(Pep8.chari());
                //estValide = false;
                //char taille;

                char []lign = {taille, orientation, colonne, rangee};
                int i=0;
                for (i = 0; i < 3; i++) {

                    lign[i] = Pep8.chari();
                    //lign[i] = checkSpecificationBateau([]lign);

                    //Pep8.stro("the first line of code is supposed to print la taille :" + lign[0]);
                    Pep8.charo('\n');
                }


                taille = checkTaille(lign[i]);
                orientation = lign[i];
                colonne = lign[i];
                rangee = lign[i];




                /**
                 * le 5eme char est l'espace separant les specifications d'un bateau à l'autre.
                 */
                lignInput1 = Pep8.chari();

            } while (lignInput1 == ' ' );  //&& lignInput1 != '\n"

        Pep8.stro("the first line of code is supposed to print la taille :" + taille);
        Pep8.charo('\n');
        Pep8.stro("the first line of code is supposed to print la orientation: " + orientation);
        Pep8.charo('\n');
        Pep8.stro("the first line of code is supposed to print la colonne :" + colonne);
        Pep8.charo('\n');
        Pep8.stro("the first line of code is supposed to print la rangee :" + rangee );
        Pep8.charo('\n');
    }
}
