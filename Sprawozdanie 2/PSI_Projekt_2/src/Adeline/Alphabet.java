package Adeline;

import java.util.Arrays;

/**
 * Created by Kamil on 2017-11-15.
 */
public class Alphabet {

    // Wielkie litery
    static int[][][] bigLetters =
            {
                    {{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}}, // A 0
                    {{1, 1, 1, 1, 0}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 0}}, // B 1
                    {{0, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 1, 1, 1}}, // C 2
                    {{1, 1, 1, 1, 0}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 0}}, // D 3
                    {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 1, 1}}, // E 4
                    {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}}, // F 5
                    {{0, 1, 1, 1, 1}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {0, 1, 1, 1, 1}}, // G 6
                    {{1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}}, // H 7
                    {{0, 0, 1, 0, 1}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}}, // I 8
                    {{0, 1, 1, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 1, 1}, {0, 0, 1, 1, 0}, {0, 1, 0, 1, 0}, {0, 0, 1, 0, 0}}, // J 9

            };

    // Małe litery
    static int[][][] smallLetters = {
            {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 0}, {0, 1, 1, 1, 1}}, // a 0
            {{1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 0, 0}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 0}, {1, 1, 1, 0, 0}}, // b 1
            {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 1, 1, 0}}, // c 2
            {{0, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 1, 1, 1, 0}, {1, 0, 0, 1, 0}, {1, 0, 0, 1, 0}, {0, 1, 1, 1, 0}}, // d 3
            {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 1, 0, 0, 0}, {0, 1, 1, 1, 0}}, // e 4
            {{0, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}}, // f 5
            {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 0}, {0, 1, 1, 0, 0}}, // g 6
            {{1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 0, 1, 0, 0}, {1, 0, 1, 0, 0}}, // h 7
            {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}}, // i 8
            {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 1, 1, 0, 0}}, // j 9
    };


    //zwraca wektor sygnałów wejściowych zależny od danej litery
    public static int[] getLetter ( int size, int letter ) {
        int[] ret = new int[7];
        Arrays.fill( ret, 1, 6, 0 );
        ret[0] = 1;

        int sizeLetter[][][];
        if (size == 0) {
            sizeLetter = bigLetters;
        } else {
            sizeLetter = smallLetters;
        }


        //sektor 1
        for ( int i = 0; i < 3; i++ )
            for ( int j = 0; j < 2; j++ )
                if ( sizeLetter[letter][i][j] == 1 )
                    ret[1] = 1;

        //sektor 2
        for ( int i = 0; i < 3; i++ )
            for ( int j = 2; j < 3; j++ )
                if ( sizeLetter[letter][i][j] == 1 )
                    ret[2] = 1;

        //sektor 3
        for ( int i = 0; i < 3; i++ )
            for ( int j = 3; j < 5; j++ )
                if ( sizeLetter[letter][i][j] == 1 )
                    ret[3] = 1;

        //sektor 4
        for ( int i = 3; i < 7; i++ )
            for ( int j = 0; j < 2; j++ )
                if ( sizeLetter[letter][i][j] == 1 )
                    ret[4] = 1;

        //sektor 5
        for ( int i = 3; i < 7; i++ )
            for ( int j = 2; j < 3; j++ )
                if ( sizeLetter[letter][i][j] == 1 )
                    ret[5] = 1;

        //sektor 6
        for ( int i = 3; i < 7; i++ )
            for ( int j = 3; j < 5; j++ )
                if ( sizeLetter[letter][i][j] == 1 )
                    ret[6] = 1;

        return ret;
    }

}