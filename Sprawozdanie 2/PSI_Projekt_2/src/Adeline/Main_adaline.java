package Adeline;

import java.util.Arrays;

public class Main_adaline {

    public static void main ( String[] args ) {

        int numberOfInputs = 7;        //ilość wejść
        int numberOfLetters = 5;       //ilość liter MAX 26
        int counter = 0;    //licznik ilości epok uczenia się
        double leranRate = 0.1;    //krok uczenia się

        Adaline[] adaline = new Adaline[numberOfInputs];
        for ( int i = 0; i < numberOfInputs; i++ )
            adaline[i] = new Adaline( numberOfInputs );

        int[] lettersArray = new int[numberOfLetters * 2];     //-1 - duża litera, 1 - mała litera
        for (int i = 0; i < numberOfLetters; i++) {
            lettersArray[i] = -1;
        }

        for (int i = numberOfLetters; i < numberOfLetters * 2; i++) {
            lettersArray[i] = 1;
        }

        int[] outputArray = new int[numberOfLetters * 2];   //tablica przechowująca wyniki testowania adaline

        while ( ! Arrays.equals( lettersArray, outputArray ) ) {
            int licznik = 0;
            for ( int i = 0; i < 2; i++ ) {     //-1 - wielkie litery, 1 - małe litery
                for ( int j = 0; j < numberOfLetters; j++ )
                    learn( adaline, numberOfInputs, leranRate, i, j );
            }

            outputArray = test( adaline, numberOfLetters, numberOfInputs );

            for (int i = 0; i < numberOfLetters * 2; i++) {
                if (outputArray[i] != lettersArray[i]) {
                    licznik++;
                }
            }

            System.out.println((licznik * 100) / (2 * numberOfLetters)+",00%");
            counter++;
        }

        System.out.println( "Ilość kroków do nauczenia się = " + counter );
    }


    private static void learn ( Adaline[] adaline, int numberOfLetters, double learnRate, int i, int j ) {
        int[] inVector;                   //tablica przechowująca wektor sygnałów wejściowych do uczenia pierwszej warstwy sieci
        inVector = Alphabet.getLetter( i, j );
        format( inVector );

        int[] outVector = new int[numberOfLetters];  //tablica przechowująca wektor sygnałów wyjściowych pierwszej warstwy sieci
        outVector[0] = 1; //bias

        int letter_size;
        if ( i == 0 ) letter_size = - 1;
            else letter_size = 1;

        for ( int k = 0; k < numberOfLetters - 1; k++ ) {               //uczenie pierwszej warstwy
            adaline[k].learnFunction( inVector, letter_size, learnRate );
            outVector[k + 1] = adaline[k].checkActivationFunction( inVector );        //pobranie sygnału wyjściowego
        }
        adaline[numberOfLetters - 1].learnFunction( outVector, letter_size, learnRate );    //uczenie perceptronu wynikowego na podstawie sygnałów wyjściowych pierwszej warstwy
    }

    private static int[] test ( Adaline[] adaline, int numberOfLetters, int numberOfInpiut ) {
        int[] wyj = new int[numberOfLetters * 2];
        int[] inVector;                   //tablica przechowująca wektor sygnałów wejściowych do testowania pierwszej warstwy sieci
        int[] outVector = new int[numberOfInpiut];  //tablica przechowująca wektor sygnałów wyjściowych pierwszej warstwy sieci
        outVector[0] = 1;                //bias

        for ( int i = 0; i < 2; i++ ) { //testowanie, celem upewnienia się, czy sieć już nauczona
            for ( int j = 0; j < numberOfLetters; j++ ) {
                inVector = Alphabet.getLetter( i, j );
                format( inVector );

                for ( int k = 0; k < numberOfInpiut - 1; k++ )
                    outVector[k + 1] = adaline[k].checkActivationFunction( inVector );

                wyj[i * numberOfLetters + j] = adaline[numberOfInpiut - 1].checkActivationFunction( outVector );
            }
        }
        return wyj;
    }

    //Zmiana sygnału wejściowego 0 na sygnały -1
    private static void format( int[] vector ){
        for ( int k = 0; k < vector.length; k++ )
            if ( vector[k] == 0 ) vector[k] = -1;
    }
}