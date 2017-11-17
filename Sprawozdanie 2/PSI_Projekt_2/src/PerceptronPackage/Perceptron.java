package PerceptronPackage;

import java.util.Random;

// Klasa implementująca perceptron
public class Perceptron {
    public double[] getWeights() {
        return weights;
    }

    // Pola używane w klasie
    private double[] weights;
    private int numerOfInput;
    Random random = new Random();


    // Konstruktor klasy nadający początkowe wagi
    public Perceptron(int numberOfInput) {
        this.numerOfInput = numberOfInput;
        weights = new double[numberOfInput];
        for (int i = 0; i < weights.length; i++) {
            //weights[i] = 3;
            weights[i] = random.nextDouble();
//            System.out.println("Start weight:" + i + " " + weights[i]);
//            System.out.println();
        }
    }


    //Funkcja aktywacji oparta na unipolarnej funkcji progowej
    public int activationFunction(double output) {
        if (output < 0) return 0;
        else return 1;
    }


    //Funkcja sumująca
    public int calculateOutput(int[] input) {
        double output = 0;
        for (int i = 0; i < this.numerOfInput; i++) {
            output += (input[i] * weights[i]);
        }
        return activationFunction(output);
    }


    // Funkcja ucząca, która modyfikuje wagi przy każdym kroku uczenia
    public void learnFunction(int[] input, double y, double learn_rate) {
        double output = calculateOutput(input);
        for (int i = 0; i < weights.length; i++) {
            weights[i] += (y - output) * learn_rate * input[i];
        }
    }
}