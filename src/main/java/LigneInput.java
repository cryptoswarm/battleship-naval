public class LigneInput {
    public static void main(String[] args) {
        char lignInput='k';
        int j=0;
        int i=0;
        char taille = 'x';
        char orientation = 'x';
        char colonne = 'x';
        char rangee = 'x';

        char bateau[] = {taille, orientation, colonne, rangee };

        Pep8.stro("Entrez votre ligne comme l'exemple suivant : ghC4 mvM2 phK9 :");
        Pep8.charo('\n');
        while (lignInput != '\n'){

                lignInput = Pep8.chari();

                while(lignInput!=' ' && lignInput != '\n'){

//la boucle se repete 3 fois parcequ'il ya trois bateaux
                    
                    taille = Pep8.chari();
                    Pep8.stro("taille des bateaux est :"+lignInput);  // il prend le premier caractere
                    Pep8.charo('\n');
                    Pep8.stro("l'orientation des bateaus est   :"+taille); // il prend le 2eme char
                    Pep8.charo('\n');
                    Pep8.stro("colonne est :"+lignInput);  //retourne
                    //Pep8.stro("taille est :"+orientation);
                    Pep8.charo('\n');
                    Pep8.stro("taille est :"+lignInput);
                    Pep8.charo('\n');
                    orientation =Pep8.chari();
                    Pep8.charo('\n');
                    colonne =Pep8.chari();
                    Pep8.charo('\n');
                    lignInput =Pep8.chari();
                    Pep8.charo('\n');


                    //lignInput = Pep8.chari();
                    //bateau[i] = lignInput;

                    //if(lignInput == 'p' || lignInput == 'm' || lignInput=='g'){
                        //taille[i] = lignInput;
                    //}else{
                      //  Pep8.stro("taille invalide");
                   // }

                    //for(i=0; i<4; i++){
/**
                        if(lignInput == 'p' || lignInput == 'm' || lignInput=='g'){
                            taille = lignInput;
                            }else{
                             Pep8.stro("taille invalide");
                             }
**/
                         //bateau[i] = lignInput;
                        Pep8.charo('\n');
                        //Pep8.charo(bateau[i]);
                   // Pep8.charo(lignInput);
                     //   Pep8.charo('\n');

                   }




                Pep8.charo(lignInput);
            j++;
            }

        }
    }
//}
