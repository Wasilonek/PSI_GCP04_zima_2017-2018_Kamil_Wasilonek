package PerceptronPackage;

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
    public static int[] getLetter(int size, int letter) {
        int[] signal = new int[7];
        for (int i = 0; i < 6; i++) {
            signal[i] = 0;
        }
        signal[0] = 1;

        int sizeLetter[][][];
        if (size == 0) {
            sizeLetter = bigLetters;
        } else {
            sizeLetter = smallLetters;
        }


        //sektor 1
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 2; j++)
                if (sizeLetter[letter][i][j] == 1)
                    signal[1] = 1;

        //sektor 2
        for (int i = 0; i < 3; i++)
            for (int j = 2; j < 3; j++)
                if (sizeLetter[letter][i][j] == 1)
                    signal[2] = 1;

        //sektor 3
        for (int i = 0; i < 3; i++)
            for (int j = 3; j < 5; j++)
                if (sizeLetter[letter][i][j] == 1)
                    signal[3] = 1;

        //sektor 4
        for (int i = 3; i < 7; i++)
            for (int j = 0; j < 2; j++)
                if (sizeLetter[letter][i][j] == 1)
                    signal[4] = 1;

        //sektor 5
        for (int i = 3; i < 7; i++)
            for (int j = 2; j < 3; j++)
                if (sizeLetter[letter][i][j] == 1)
                    signal[5] = 1;

        //sektor 6
        for (int i = 3; i < 7; i++)
            for (int j = 3; j < 5; j++)
                if (sizeLetter[letter][i][j] == 1)
                    signal[6] = 1;

        return signal;
    }

//    public static int[] getLetterVector(int isBig, int letter) {
//        int inputLetter[] = new int[7];
//        for(int i = 0 ; i < 7 ; i++){
//            inputLetter[i] = 0;
//        }
//        inputLetter[0] = 1;
//
//        int sizeLetter[][][];
//
//        if(isBig == 0){
//            sizeLetter = bigLetters;
//        }else{
//            sizeLetter = smallLetters;
//        }
//
//        //sektor 1
//        for ( int i = 0; i < 3; i++ )
//            for ( int j = 0; j < 2; j++ )
//                if ( sizeLetter[letter][i][j] == 1 )
//                    inputLetter[1] = 1;
//
//        //sektor 2
//        for ( int i = 0; i < 3; i++ )
//            for ( int j = 0; j < 2; j++ )
//                if ( sizeLetter[letter][i][j] == 1 )
//                    inputLetter[2] = 1;
//
//        //sektor 3
//        for ( int i = 0; i < 3; i++ )
//            for ( int j = 0; j < 2; j++ )
//                if ( sizeLetter[letter][i][j] == 1 )
//                    inputLetter[3] = 1;
//
//        //sektor 4
//        for ( int i = 0; i < 3; i++ )
//            for ( int j = 0; j < 2; j++ )
//                if ( sizeLetter[letter][i][j] == 1 )
//                    inputLetter[4] = 1;
//
//        //sektor 5
//        for ( int i = 0; i < 3; i++ )
//            for ( int j = 0; j < 2; j++ )
//                if ( sizeLetter[letter][i][j] == 1 )
//                    inputLetter[5] = 1;
//
//        //sektor 6
//        for ( int i = 0; i < 3; i++ )
//            for ( int j = 0; j < 2; j++ )
//                if ( sizeLetter[letter][i][j] == 1 )
//                    inputLetter[6] = 1;
//
//        return inputLetter;
//
//    }


}
