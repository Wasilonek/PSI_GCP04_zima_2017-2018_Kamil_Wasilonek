import java.util.Random;

/**
 * Created by Kamil on 2018-01-10.
 */
public class KohonenWTM {
    private int numberOfInputs;		//ilość wejść
    private double[] wage;		//wagi

    // losowanie wag od 0 do 1
    public KohonenWTM ( int numbers_of_inputs ) {
        numberOfInputs = numbers_of_inputs;
        wage = new double[numberOfInputs];
        for (int i = 0; i < numberOfInputs; i++ )
            wage[i] = new Random().nextDouble();
    }

    //uczenie poprzez zmniejszenie odległości między wektorem wag a zadanym wektorem
    public void learn ( double[] x, double learnRate ) {
        for (int i = 0; i < numberOfInputs; i++ )
            wage[i] += learnRate * ( x[i] - wage[i] );
    }

    public double[] getWage() {
        return wage;
    }

}
