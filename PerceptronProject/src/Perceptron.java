import java.util.Random;

public class Perceptron {

    public double[] getWeights() {
        return weights;
    }

    private double[] weights;
    private int numerOfInput;
    Random random = new Random();

    public Perceptron(int numberOfInput) {
        this.numerOfInput = numberOfInput;
        weights = new double[numberOfInput];
        for (int i = 0; i < weights.length; i++) {
            weights[i] = 0.5;
        }
    }

    public void randWeight(double[] weight) {
        for (int i = 0; i < weight.length; i++) {
            weight[i] = random.nextDouble();
            System.out.println("Weight " + i + " " + weight[i]);
        }
    }

    public int activationFunction(double output) {
        if (output < 0) return 0;
        else return 1;
    }

    public int calculateOutput(int[] input) {
        double output = 0;
        for (int i = 0; i < this.numerOfInput; i++) {
            output += (input[i] * weights[i]);
        }
        return activationFunction(output);
    }

    public void learnFunction(int[] input, double y, double learn_rate) {
        double output = calculateOutput(input);
        for (int i = 0; i < weights.length; i++) {
            weights[i] += (y - output) * learn_rate * input[i];
        }
    }
}