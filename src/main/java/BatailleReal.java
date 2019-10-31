public class BatailleReal {

    public static void msgPLacerBateau(){
        Pep8.stro("Entrer la description et la position des bateaux\n" +
                "selon le format suivant, separes par des espaces:\n" + " taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9]\n" + " ex: ghC4 mvM2 phK9");

    }


    /**
     *
     * @param rangee, nombre des rangées, ne peut pas etre plus que 9
     * @return nomre de rangées
     */

    public static boolean checkNombreRanger(char rangee){
        boolean estValide;
        estValide =true;
        if((int)rangee<1 || (int)rangee>9){
            estValide =false;
        }

        if(!estValide){
            Pep8.stro("nombre de rangees est incorrecte");
            Pep8.charo('\n');
        }
        return estValide;
    }

/**
    public static void main(String[] args) {
        int colonne;
        int lign;
        char charactereInitiale ='A';
        String coordonnees=" ";

        colonne = coordonnees.charAt(0)-charactereInitiale;
        String ligne = coordonnees.substring(1,2);
        lign=Integer.parseInt(ligne);
    }

**/

public static void main(String[] args) {

    char ligneEntree[] = new char [10000000];

    char  grandeurBateau[] = new char [10000000];
    char orientationBateau[]= new char [10000000];
    char colonneBateau[] = new char [10000000];
    char rangeeBateau[] = new char [10000000];
    int i=0;
    int j=0;
    int k=0;
    int l=0;
    int m=0;

    msgPLacerBateau();

    ligneEntree[i] = Pep8.chari();

    /**

    do{ //(ligneEntree[i] != '\n' )

        //for(int j=0; j<=3 && ligneEntree[i]!= ' '; j++){

        if (ligneEntree[i] == 'g' || ligneEntree[i] == 'p') {
            grandeurBateau[j] = ligneEntree[i];
            j++;
        } else {
            msgPLacerBateau();
        }
        i++;

        if (ligneEntree[i] == 'h' || ligneEntree[i] == 'v') {
            orientationBateau[j] = ligneEntree[i];
            k++;
        } else {
            msgPLacerBateau();
        }
        i++;

        if(ligneEntree[i]<'A' || ligneEntree[i]>'R'){
            colonneBateau[j] = ligneEntree[i];
            l++;
        }else{
            msgPLacerBateau();
        }
        i++;

        if(checkNombreRanger(ligneEntree[i])){
            rangeeBateau[j]=ligneEntree[i];
            m++;
        }else{
            msgPLacerBateau();
        }

        i++;
       // }
        Pep8.charo(grandeurBateau[i]);

    }while (ligneEntree[i] != '\n');



}

**/

    //for (int i = 0; i <= 3 ; i++) {

        //[]ligne = {taille,orientation,colonne,rangee};

      //
    // ligneEntree[i] = Pep8.chari();
    char ligneInput = Pep8.chari();
    char grandeur;

//do{

    if (ligneInput == 'g' || ligneInput == 'p') {
        grandeur = ligneInput;
        Pep8.stro("grandeur du bateau est : " + grandeur);
        //i++;
    } else {
        msgPLacerBateau();
    }

//}while (ligneInput != '\n');
    //Pep8.stro("grandeur bateau "+grandeurBateau[0]);

        //System.out.print(bateau[i]);
        //Pep8.charo('\n');
        //taille[] = checkTaille(ligne[0]);
        //orientation[] = checkOriontation(ligne[i]);
        //colonne[] = checkLetterColonne(ligne[i]);
        //rangee[] = checkNombreRanger(ligne[i]);

        //estValide1=true;
        //j++;
    }



}

