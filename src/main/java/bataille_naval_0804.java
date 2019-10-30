public class bataille_naval_0804 {

        static int[][] situation = new int[11][11];
        static boolean fini_jeu;

        public static int[][] initialisation() {
            int i;
            int j;
            int x;
            int y;
            for (i = 0; i < 11; i = i + 1) {
                for (j = 0; j < 11; j = j + 1) {
                    situation[i][j] = 0;
                }
            }
            x = (int) (Math.random() * 10);
            y = (int) (Math.random() * 10);
            situation[x][y] = 1 - situation[x][y];
            situation[x][y - 1] = 1 - situation[x][y - 1];
            fini_jeu = false;
            return situation;
        }
        // Déclaration de la grille
        public static void affiche_jeu(int[][] situation) {
            int i;
            int j;
            System.out.println("   A B C D E F G H I J");
            for (i = 0; i < 10; i = i + 1) {
                System.out.print(i + "  ");
                for (j = 1; j < 11; j = j + 1) {
                    if (situation[i][j] == 0) {
                        System.out.print("~ ");
                    }
                    if (situation[i][j] == 2) {
                        System.out.print("* ");
                    }
                    if (situation[i][j] == 1) {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
        }
        public static void main(String[] args) {
            situation = initialisation();
            affiche_jeu(situation);
        }
    }

