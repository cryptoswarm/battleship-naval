public class JeuBatailleNavale {

    //<T> [][] tableauNavale;
    //String[][] tableauNavale = new String[9][18];

    public static void msgBienvenue(){
        Pep8.stro("Bienvenue au jeu de bataille navale!");
        Pep8.charo('\n');
    }

    /**
     * methode affichant les lettres de A jusqu'à R
     */
    public static void  afficherLetters(){
        char colonne='A';
        while(colonne<='R'){

            Pep8.stro(" "+colonne);
            colonne =(char)(colonne+1);
        }

    }

    public static void msgPLacerBateau(){
        Pep8.stro("Entrer la description et la position des bateaux\n" +
                "selon le format suivant, separes par des espaces:\n" + " taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9]\n" + " ex: ghC4 mvM2 phK9");

    }

    /**
     * imprimer le caractere tild
     */

    public static void tild() {
        Pep8.charo('~');
    }


    /**
     * Verifier la grandeur du bateau
     * @param grandeurBateau est la grandeur du bateau, peut etre p, m ou g
     */

    public static char checkTaille(char grandeurBateau) {
        boolean estValide;
        estValide =true;

        if (grandeurBateau != 'p' && grandeurBateau != 'm' && grandeurBateau != 'g') {
            estValide =false;
        }

        if(!estValide){
            Pep8.stro("la grandeur entree est incorrecte");
            Pep8.charo('\n');
        }
        return grandeurBateau;
    }


    /**
     *
     * @param orientation, l'oriontation du bateau h pour horizontale.
     *                     v pour vertical.
     * @return caractere > quand la position est horizontal sinon V.
     */

    public static char checkOriontation(char orientation) {
        boolean estValide;

        estValide =true;
        if (orientation != 'h' && orientation != 'v') {

            estValide=false;
        } else {
            if (orientation == 'h') {
                Pep8.charo('>');
            }else{
                Pep8.charo('v');
                Pep8.stro("vvvvvvv");
                Pep8.charo('\n');

            }
        }

        if(!estValide){
            Pep8.stro("l'orientation du bateau est incorrecte");
            Pep8.charo('\n');
        }
        return orientation;
    }


    /**
     *
     * @param alpha la lettre qui designe la colonne doit etre entre A et R
     * @return alpha
     */
    public static char checkLetterColonne(char alpha){
        boolean estValide;

        estValide =true;
        //char alpha ='Q';
        if(alpha<'A'|| alpha>'R'){
            estValide =false;

        }

        if(!estValide){
            Pep8.stro("lettre designant la colonne est incorrecte");
            Pep8.charo('\n');
        }

        return alpha;

    }

    /**
     *
     * @param rangee, nombre des rangées, ne peut pas etre plus que 9
     * @return nomre de rangées
     */

    public static char checkNombreRanger(char rangee){
        boolean estValide;
        estValide =true;
        if((int)rangee<1 || (int)rangee>9){
            estValide =false;
        }

        if(!estValide){
            Pep8.stro("nombre de rangees est incorrecte");
            Pep8.charo('\n');
        }
        return rangee;
    }


    public static void main(String[] args) {

        char [][]grandeur;
        //char orientation;


        boolean estValide =true;
        boolean estValide1;

        int [] tabLettresEntrees = {1,2,3,4};
        char taille='d';
        char orientation='b';
        char  colonne ='A';
        char rangee =1;



/**
 int[][] tableauNavale = new int[9][18];
 //int[][] tableauNavale;


 for (int i = 1; i < tableauNavale.length; i++) {


 for (int j = 1; j < tableauNavale[i].length; j++) {
 tableauNavale[i][j] = '~';
 System.out.println(tableauNavale[i][j]+"|"+"|");
 System.out.println();


 }
 }
 **/

/**
        while (colonne() <= 'R') {
            char alpha = colonne();
            //colonne()='A'
            Pep8.stro(" " + alpha);
            //Pep8.charo((char) (colonne() + 1));
            alpha = (char) (colonne() + 1);
            //Pep8.charo(alpha);
        }


 **/
        msgBienvenue();
        Pep8.charo(' ');
        afficherLetters();



            Pep8.charo('\n');


            for (rangee = 1; rangee <= 9; rangee++) {


                Pep8.deco(rangee);
                Pep8.charo('|');
                for (colonne = 0; colonne < 18; colonne++) {
                    tild();
                    Pep8.charo(' ');
                }
                Pep8.charo('|');
                Pep8.charo('\n');
                //System.out.println(i + "|" + "|");
            }

            Pep8.charo('\n');

            //msg demandant a l'utilisateur d'entrer son choix


            msgPLacerBateau();

            Pep8.charo('\n');



        //char []ligne = {'a','b','c','d'};
        //char []bateau = {taille,orientation,colonne,rangee};
        char []bateau = {taille,orientation,colonne,rangee};
        //char[]bateaux =
        //char []ligne;
        //char []ligne = {checkTaille('a'),checkOriontation('a'),checkLetterColonne('A'),checkNombreRanger('x')};
        //char bidon = Pep8.chari();

        int j=0;
do{

     //estValide1=true;

    //for (int i = 0; i <= 3 && bateau[i] != ' '; i++) {
        for (int i = 0; i <= 3 ; i++) {

        //[]ligne = {taille,orientation,colonne,rangee};

        bateau[i] = Pep8.chari();
        System.out.print(bateau[i]);
        //Pep8.charo('\n');
        //taille = checkTaille(ligne[0]);
        //orientation = checkOriontation(ligne[i]);
        //colonne = checkLetterColonne(ligne[i]);
        //rangee = checkNombreRanger(ligne[i]);

        //estValide1=true;
        //j++;
    }
    j++;



    //estValide1=false;

}while(bateau[j]!=' ' && bateau[j]!='\n');
  //  }while(bateau[j]==' ' && bateau[j]!='\n');



        //[]ligne = {taille,orientation,colonne,rangee};

         taille = checkTaille(bateau[0]);
        System.out.println("taille du bateau est "+taille);

        orientation = checkOriontation(bateau[1]);

        System.out.println("l'orientation  du bateau est "+orientation);

         colonne = checkLetterColonne(bateau[2]);

        System.out.println("la colonne  du bateau est "+colonne);

         rangee = checkNombreRanger(bateau[3]);

        System.out.println("la rangee du bateau est "+rangee);



        }
    }




