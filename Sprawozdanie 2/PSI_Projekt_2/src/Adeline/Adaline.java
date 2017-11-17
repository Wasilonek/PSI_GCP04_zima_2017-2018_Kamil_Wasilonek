package Adeline;

import java.util.Random;

// Klasa implementująca perceptron
public class Adaline {
    public double[] getWeights() {
        return weights;
    }

    // Pola używane w klasie
    private double[] weights;
    private int numerOfInput;
    Random random = new Random();


    // Konstruktor klasy nadający początkowe wagi
    public Adaline(int numberOfInput) {
        this.numerOfInput = numberOfInput;
        weights = new double[numberOfInput];
        for (int i = 0; i < weights.length; i++) {
            //weights[i] = 3;
            weights[i] = random.nextDouble();
//            System.out.println("Start weight:" + i + " " + weights[i]);
//            System.out.println();
        }
    }


    //Funkcja aktywacji
    public int activationFunction(double output) {
        if(output > 0) {
            return 1;
        }else {
            return -1;
        }
    }


    //Funkcja sumująca
    public double calculateOutput(int[] input) {
        double output = 0;
        for (int i = 0; i < this.numerOfInput; i++) {
            output += (input[i] * weights[i]);
        }
        return output;
    }

    //Funkcja zwracająca wartość w zależności od funkcji aktywacji
    public int checkActivationFunction(int [] input){
        double output = 0;
        for (int i = 0; i < this.numerOfInput; i++) {
            output += (input[i] * weights[i]);
        }
        return activationFunction(output);
    }


    // Funkcja ucząca, która modyfikuje wagi przy każdym kroku uczenia
    public void learnFunction(int[] input, double y, double learn_rate) {
        double outputSum = calculateOutput(input);
        for (int i = 0; i < weights.length; i++) {
            weights[i] += (y - outputSum) * learn_rate * input[i];
        }
    }
}