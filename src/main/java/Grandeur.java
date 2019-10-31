public class Grandeur {


    public static void msgPLacerBateau() {
        Pep8.stro("Entrer la description et la position des bateaux\n" +
                "selon le format suivant, separes par des espaces:\n" + " taille[p/m/g] orientation[h/v] colonne[A-R] rangée[1-9]\n" + " ex: ghC4 mvM2 phK9");

    }

    public static void main(String[] args) {

        char grandeur ='h';
        char orientation = 'o';


        msgPLacerBateau();

        char ligneInput = Pep8.chari();




    //while (ligneInput != '\n') {

        if (ligneInput == 'g' || ligneInput == 'p') {

            grandeur = ligneInput;


        } else {
            msgPLacerBateau();
        }

        if(ligneInput =='v' || ligneInput == 'h' ){
            orientation = ligneInput;

        }else {
            msgPLacerBateau();
        }
   // }
//mvM2

        Pep8.stro("grandeur du bateau est : " + grandeur);
        Pep8.stro("orientation du bateau est : " + orientation);

    }
}
