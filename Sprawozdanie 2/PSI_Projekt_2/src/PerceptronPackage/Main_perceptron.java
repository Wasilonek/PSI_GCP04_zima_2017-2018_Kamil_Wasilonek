package PerceptronPackage;


import java.util.Arrays;

public class Main_perceptron {

    public static void main(String[] args) {

        int numberOfInputs = 7;        //ilość wejść
        int numberOfLetters = 5;       //ilość liter do uczenia
        int counter = 0;                //licznik  epok uczenia się
        double leranRate = 0.1;                //krok uczenia się

        Perceptron[] perceptron = new Perceptron[numberOfInputs];
        for (int i = 0; i < numberOfInputs; i++)
            perceptron[i] = new Perceptron(numberOfInputs);

        int[] lettersArray = new int[numberOfLetters * 2];     //0 - duża litera, 1 - mała litera

        for (int i = 0; i < numberOfLetters; i++) {
            lettersArray[i] = 0;
        }

        for (int i = numberOfLetters; i < numberOfLetters * 2; i++) {
            lettersArray[i] = 1;
        }


        int[] outputArray = new int[numberOfLetters * 2];   //tablica wynikowa testowania


        while (!Arrays.equals(lettersArray, outputArray)) {
            int licznik = 0;
            for (int i = 0; i < 2; i++)       //0 - wielkie litery, 1 - małe litery
                for (int j = 0; j < numberOfLetters; j++)
                    mainLearn(perceptron, numberOfInputs, leranRate, i, j);

            outputArray = test(perceptron, numberOfLetters, numberOfInputs);

            for (int i = 0; i < numberOfLetters * 2; i++) {
                if (outputArray[i] != lettersArray[i]) {
                    licznik++;
                }
            }

            System.out.println((int)(licznik * 100) / (2 * numberOfLetters)+",00%");
            counter++;

        }

        System.out.println("Ilość kroków do nauczenia się = " + counter);


        //Testowanie czy rozpoznaje pozostały przedział liter
        int licznik = 0;

        for (int i = 0; i < 2; i++) {       //0 - wielkie litery, 1 - małe litery
            for (int j = numberOfInputs; j < numberOfLetters * 2; j++){
                outputArray = test(perceptron, numberOfLetters, numberOfInputs);
            }

        }

        for (int i = 0; i < numberOfLetters * 2; i++) {
            if (outputArray[i] != lettersArray[i]) {
                licznik++;
            }
        }

        System.out.println("Procent błedów testowania " + (licznik * 100.0) / (2.0 * numberOfLetters));
    }


    public static void mainLearn(Perceptron[] perceptron, int numberOfInputs, double lr, int i, int j) {
        int[] InputVector;                   //tablica sygnałów wejściowych pierwszej warstwy
        InputVector = Alphabet.getLetter(i, j);

        int[] vector_p = new int[numberOfInputs];  //tablica sygnałów wyjściowych pierwszej warstwy
        vector_p[0] = 1; //bias

        for (int k = 0; k < numberOfInputs - 1; k++) {               //uczenie pierwszej warstwy
            perceptron[k].learnFunction(InputVector, i, lr);
            vector_p[k + 1] = perceptron[k].calculateOutput(InputVector);    //pobranie sygnału wyjściowego
        }
        perceptron[numberOfInputs - 1].learnFunction(vector_p, i, lr);             //uczenie perceptronu wynikowego na podstawie sygnałów wyjściowych pierwszej warstwy
    }

    public static int[] test(Perceptron[] perc, int numberOfLetters, int noi) {
        int[] wyj = new int[numberOfLetters * 2];
        int[] vector;                   //tablica przechowująca wektor sygnałów wejściowych do testowania pierwszej warstwy sieci
        int[] vector_p = new int[noi];  //tablica przechowująca wektor sygnałów wyjściowych pierwszej warstwy sieci
        vector_p[0] = 1;                //bias

        for (int i = 0; i < 2; i++) { //testowanie, celem upewnienia się, czy sieć już nauczona
            for (int j = 0; j < numberOfLetters; j++) {
                vector = Alphabet.getLetter(i, j);
                for (int k = 0; k < noi - 1; k++)
                    vector_p[k + 1] = perc[k].calculateOutput(vector);

                wyj[i * numberOfLetters + j] = perc[noi - 1].calculateOutput(vector_p);
            }
        }
        return wyj;
    }
}