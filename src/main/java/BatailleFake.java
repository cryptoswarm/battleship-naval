public class BatailleFake {

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


    public static char imprimerTableau(int rangee, int colonne){

        char resDeRangeeColonne;
        char situationInitiale[][] = new char [rangee][colonne];
        resDeRangeeColonne = situationInitiale[rangee][colonne];

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
        return resDeRangeeColonne;
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


    public static void main(String[] params) {


        int rangeeInitiale = 0;
        int colonneInitiale = 0;
        char[][] situationInitiale = {{'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'}};

        char positionBateau[][] = {{'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'},
                {'~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~', '~'}};

        boolean fini_jeu;

        Pep8.stro("numbers of lines = " + situationInitiale.length);
        Pep8.charo('\n');
        Pep8.stro("numbers of colones = " + situationInitiale[rangeeInitiale].length);
        Pep8.charo('\n');

        msgBienvenue();
        afficherLetters();
        Pep8.charo('\n');


        for (rangeeInitiale = 0; rangeeInitiale < situationInitiale.length; rangeeInitiale++) {
            Pep8.deco(rangeeInitiale + 1);
            Pep8.charo('|');

            for (colonneInitiale = 0; colonneInitiale < (situationInitiale[rangeeInitiale].length); colonneInitiale++) {
                Pep8.charo(situationInitiale[rangeeInitiale][colonneInitiale]);
                Pep8.charo(' ');
            }
            Pep8.charo('|');
            Pep8.charo('\n');
        }

        msgPLacerBateau();


        char grandeurDuBateau = 'd';
        char orientationDuBateau = 'b';
        char rangeePositionBateau = 's';
        char colonnePositionBateau = 'A';
        char colonnePositionBateauInitiale = 'A';
        int colonnePositionBateauFinal = 0;
        int indiceDeRangeeFinal;


        char[] caracteristicDuBateau = {grandeurDuBateau, orientationDuBateau, colonnePositionBateau, rangeePositionBateau};
        int listDesBateau[];

        int j = 0;

        do {

            //estValide1=true;

            //for ( caracteristicDuBateau[i] != ' '; i++) {

            for (int i = 0; i <= 3 ; i++) {

            }
                while (caracteristicDuBateau[j]!=' '){

                //[]ligne = {taille,orientation,colonne,rangee};

                caracteristicDuBateau[j] = Pep8.chari();
                System.out.print(caracteristicDuBateau[j]);

                //Pep8.charo('\n');
                //taille = checkTaille(ligne[0]);
                //orientation = checkOriontation(ligne[i]);
                //colonne = checkLetterColonne(ligne[i]);
                //rangee = checkNombreRanger(ligne[i]);

                //estValide1=true;
                j++;
            }
            //j++;


            Pep8.charo('\n');

            grandeurDuBateau = checkTaille(caracteristicDuBateau[0]);
            System.out.println("taille du bateau est " + grandeurDuBateau);

            orientationDuBateau = checkOriontation(caracteristicDuBateau[1]);

            System.out.println("l'orientation  du bateau est " + orientationDuBateau);

            colonnePositionBateau = checkLetterColonne(caracteristicDuBateau[2]);

            System.out.println("la colonne  de position bateau est " + colonnePositionBateau);

            /**
             * Conversion du colonne position bateau qui est un char en int
             */

            colonnePositionBateauFinal = (int) colonnePositionBateau - 65;

            System.out.println("la colonne  de position bateau est " + colonnePositionBateauFinal);

            rangeePositionBateau = checkNombreRanger(caracteristicDuBateau[3]);


            System.out.println("l'indice de  rangee du position bateau est " + rangeePositionBateau);
            indiceDeRangeeFinal = (int) (rangeePositionBateau) - 48;
            Pep8.stro("indice apres convertion =" + indiceDeRangeeFinal);
            Pep8.charo('\n');

            //estValide1=false;

            //} while (listDesBateau[j] != ' ' && listDesBateau[j] != '\n');
            //  }while(bateau[j]==' ' && bateau[j]!='\n');


            /**
             * Affichage de l'espace de jeu mis à jour
             */

            afficherLetters();
            Pep8.charo('\n');

            //for (rangeePositionBateau = 0; rangeePositionBateau < positionBateau.length; rangeePositionBateau++) {
            //for (colonnePositionBateauFinal = 0; colonnePositionBateauFinal < positionBateau[rangeePositionBateau].length; colonnePositionBateauFinal++) {

            for (rangeeInitiale = 0; rangeeInitiale < situationInitiale.length; rangeeInitiale++) {
                Pep8.deco(rangeeInitiale + 1);
                Pep8.charo('|');

                for (colonneInitiale = 0; colonneInitiale < situationInitiale[rangeeInitiale].length; colonneInitiale++) {
                    //Pep8.charo(situationInitiale[rangeeInitiale][colonneInitiale]);

                    //Pep8.stro("resultat de impression 1 est : "+situationInitiale[rangeePositionBateau][colonnePositionBateauFinal]);
                    // Pep8.stro("resultat de impression 2 est : "+situationInitiale[rangeeInitiale][colonneInitiale-1]);
                    //if (situationInitiale[rangeeInitiale][colonneInitiale] == situationInitiale[rangeePositionBateau][colonnePositionBateauFinal]) {

                    //(rangeePositionBateau-1)
                    //indiceDeRangeeFinal
                    //colonnePositionBateauFinal
                    //if (rangeeInitiale == 8 && colonneInitiale ==10 ) {

                    /**
                     * quand la cordonnees du bateau initiale egale la coordonnees du position entré
                     * une coordonnee du bateau initiale est definit par numero de range et numero du colonne
                     * une coordonnee du position du bateau  est definit par numero de range et numero du colonne
                     */

                    if (rangeeInitiale == (indiceDeRangeeFinal - 1) && (colonneInitiale == colonnePositionBateauFinal)) {


                        switch (checkTaille(grandeurDuBateau)) {

                            case 'g':

                                if (checkOriontation(orientationDuBateau) == 'h') {
                                    //if ((situationInitiale[rangeeInitiale][colonneInitiale]) == (positionBateau[indiceDeRangeeFinal - 1][colonnePositionBateauFinal])) {

                                    for (int i = 0; i < 5; i++) {
                                        //Pep8.charo(situationInitiale[indiceDeRangeeFinal - 1][colonnePositionBateauFinal + i] = '>');
                                        Pep8.charo(situationInitiale[indiceDeRangeeFinal - 1][colonnePositionBateauFinal + 1] = '>');

                                        //Pep8.charo(positionBateau[indiceDeRangeeFinal - 1][colonnePositionBateauFinal + i] = '>');

                                        Pep8.charo(' ');
                                    }
                                    //}
                                } else if (checkOriontation(orientationDuBateau) == 'v') {

                                    // if ((situationInitiale[rangeeInitiale][colonneInitiale]) == (positionBateau[indiceDeRangeeFinal - 1][colonnePositionBateauFinal])) {

                                    for (int i = 0; i < 5; i++) {

                                        // Pep8.charo(situationInitiale[(indiceDeRangeeFinal - i) ][colonnePositionBateauFinal] = 'v');

                                        Pep8.charo(positionBateau[(indiceDeRangeeFinal - 1) + i][colonnePositionBateauFinal] = 'v');


                                    }
                                    //}
                                }

                                break;

                            case 'm':

                                if (checkOriontation(orientationDuBateau) == 'h') {
                                    if ((situationInitiale[rangeeInitiale][colonneInitiale]) == (positionBateau[indiceDeRangeeFinal - 1][colonnePositionBateauFinal])) {

                                        for (int i = 0; i < 3; i++) {
                                            Pep8.charo(situationInitiale[indiceDeRangeeFinal - 1][colonnePositionBateauFinal + i] = '>');
                                            Pep8.charo(' ');
                                        }
                                    }
                                } else if (checkOriontation(orientationDuBateau) == 'v') {

                                    if ((situationInitiale[rangeeInitiale][colonneInitiale]) == (positionBateau[indiceDeRangeeFinal - 1][colonnePositionBateauFinal])) {

                                        for (int i = 0; i < 3; i++) {
                                            Pep8.charo(situationInitiale[(indiceDeRangeeFinal - 1) + i][colonnePositionBateauFinal] = 'v');
                                            //Pep8.charo(positionBateau[(indiceDeRangeeFinal - 1) + i][colonnePositionBateauFinal] = 'v');

                                        }
                                    }
                                }
                                break;

                            case 'p':

                                if (checkOriontation(orientationDuBateau) == 'h') {

                                    //Pep8.charo(situationInitiale[rangeePositionBateau][colonnePositionBateauFinal] = '>');

                                    if ((situationInitiale[rangeeInitiale][colonneInitiale]) == (positionBateau[indiceDeRangeeFinal - 1][colonnePositionBateauFinal])) {

                                        Pep8.charo(situationInitiale[indiceDeRangeeFinal - 1][colonnePositionBateauFinal] = '>');
                                        Pep8.charo(' ');
                                    }


                                } else if (checkOriontation(orientationDuBateau) == 'v') {
                                    if ((situationInitiale[rangeeInitiale][colonneInitiale]) == (positionBateau[indiceDeRangeeFinal - 1][colonnePositionBateauFinal])) {

                                        Pep8.charo(situationInitiale[indiceDeRangeeFinal - 1][colonnePositionBateauFinal] = 'v');
                                        Pep8.charo(' ');
                                    }
                                }
                                break;

                        }

                    } else {
                        Pep8.charo(situationInitiale[rangeeInitiale][colonneInitiale]);
                        //Pep8.charo(positionBateau[rangeeInitiale][colonneInitiale]);
                        Pep8.charo(' ');
                    }
                }
                Pep8.charo('|');
                Pep8.charo('\n');
            }


        }while (caracteristicDuBateau[j]!='\n');
    }
}
