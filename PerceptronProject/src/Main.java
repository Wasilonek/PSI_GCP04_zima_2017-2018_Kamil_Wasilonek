
public class Main {

    public static void main(String[] args) {

        Perceptron perceptron = new Perceptron(3);

        int howManyStepsToLearn = 10;
        double learn_rate = 0.1;

        int bias = 1;
        int[] input1 = { 0, 1, 0, 1 };
        int[] input2 = { 0, 1, 1, 0 };

        int[] expectedData = {0, 1, 0, 0}; //AND

        for (int i = 0; i < howManyStepsToLearn; i++) {
            for (int j = 0; j < input1.length; j++) {
                int[] inputData = {bias,input1[j],input2[j]};
                perceptron.learnFunction( inputData , expectedData[j], learn_rate);
            }
        }


//        perceptron.learnFunction( new int[]{1,0,0} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,0,0} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,0,0} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,0,0} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,0,0} , 0, learn_rate);
//
//        perceptron.learnFunction( new int[]{1,1,1} , 1, learn_rate);
//        perceptron.learnFunction( new int[]{1,1,1} , 1, learn_rate);
//
//        perceptron.learnFunction( new int[]{1,0,1} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,0,1} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,0,1} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,0,1} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,0,1} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,0,1} , 0, learn_rate);
//
//        perceptron.learnFunction( new int[]{1,1,0} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,1,0} , 0, learn_rate);
//        perceptron.learnFunction( new int[]{1,1,0} , 0, learn_rate);








        double weight[] = perceptron.getWeights();
        for(int i = 0 ; i < weight.length ; i++ ){
            System.out.println("weight: " + weight[i]);
        }

        System.out.println();

        System.out.println("Expected output:" + expectedData[0]);
        System.out.println("\tCalculated output:" + perceptron.calculateOutput(new int[] {bias, 0, 0}));
        System.out.println("Expected output:" + expectedData[1]);
        System.out.println("\tCalculated output:" + perceptron.calculateOutput(new int[] {bias, 1, 1}));
        System.out.println("Expected output:" + expectedData[2]);
        System.out.println("\tCalculated output:" + perceptron.calculateOutput(new int[] {bias, 0, 1}));
        System.out.println("Expected output:" + expectedData[3]);
        System.out.println("\tCalculated output:" + perceptron.calculateOutput(new int[] {bias, 1, 0}));
    }
}