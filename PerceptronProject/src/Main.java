import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        //Tworzenie perceptronu z nadaniem żądanej ilości wejść
        Perceptron perceptron = new Perceptron(3);

        //Podanie ilości epok i kroku uczenia
        int howManyStepsToLearn = 0;
        double learn_rate = 0.1;

        //Podanie danych uczących
        int bias = 1;
        int[] input1 = {0, 1, 0, 1};
        int[] input2 = {0, 1, 1, 0};

        //Podanie oczekiwanych wartości dla poszczególnych zestawów uczących
        int[] expectedData = {0, 1, 0, 0}; //AND
        int[] outputData = new int[4];


//        Pętla realizująca uczenie perceptronu założoną ilość epok
//        for (int i = 0; i < howManyStepsToLearn; i++) {
//            for (int j = 0; j < input1.length; j++) {
//                int[] inputData = {bias,input1[j],input2[j]};
//                perceptron.learnFunction( inputData , expectedData[j], learn_rate);
//            }
//        }


        // pętla sprawdzająca zgodnosc wartości wyliczonych z oczekiwanymi
        while (!Arrays.equals(expectedData, outputData)) {

            for (int i = 0; i < 4; i++) {
                int[] inputData = {bias, input1[i], input2[i]};
                perceptron.learnFunction(inputData, expectedData[i], learn_rate);
            }

            for (int i = 0; i < 4; i++) {
                outputData[i] = perceptron.calculateOutput(new int[]{bias, input1[i], input2[i]});
            }

            howManyStepsToLearn++;

            if (howManyStepsToLearn > 1000) break;
        }

        // wypisanie końcowych wag
        double weight[] = perceptron.getWeights();
        for (int i = 0; i < weight.length; i++) {
            System.out.println("\nEnd weight: " + weight[i]);
        }

        // wypisanie końcowego wyliczonego wyniku
        for (int i = 0; i < outputData.length; i++) {
            System.out.println(outputData[i]);
        }

        System.out.println("\nIle kroków potrzebnych do nauki: " + howManyStepsToLearn);

    }
}