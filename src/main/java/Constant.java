public class Constant {

    public static String WELCOME_MSG =
            """
            "Bienvenue au jeu de BatNav2 navale!"
            """;

    public static String BOAT_SIZE_POSITION_MSG =
                                    """
                                    Enter the description and position of the boats
                                    according to the following format, separated by spaces:
                                    size[s/m/l] orientation[h/v] column[A-R] row[1-9]
                                    e.g., shC4 mvM2 lhK9
                                    """;

    public static String FIRE_AT_WILL_MSG =
                            """
                            Fire at will!
                            (enter shots to fire: column [A-R] row [1-9])
                            e.g., A3 I5 M3        
                            """;

    public static String EXIT_MSG =
                        """
                        You have annihilated the fleet!
                        Press <Enter> to play again or
                        any other input to quit.
                        
                        """;

    public static String BOAT_SIZE_INVALID_MSG = "The boat size is outside the game space!";
}
