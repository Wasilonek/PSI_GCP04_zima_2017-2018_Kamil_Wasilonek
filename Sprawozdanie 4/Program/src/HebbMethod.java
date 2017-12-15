import java.util.Random;

/**
 * Created by Kamil on 2017-12-14.
 */
public class HebbMethod {
    private int numberOfInputs;    //ilość wejść
    private double[] wages; //wagi
    public static boolean HebbWithForget = true;
    public static boolean HebbWithoutForget = false;

    public HebbMethod(int numbers_of_inputs ) {
        numberOfInputs = numbers_of_inputs;
        wages = new double[numberOfInputs];

        for (int i = 0; i < numberOfInputs; i++ )
            wages[i] = new Random().nextDouble(); //wagi początkowe sa losowane

        normalizeWeights();
    }

    //funkcja aktywacji
    private double activationFunction(double y_p ) {
        return ( 1.0 / ( 1 + Math.pow( Math.E, - y_p ) ) );		//unipolarna sigmoidalna
    }

    //zwraca sumę iloczynu wag i sygnałów wejściowych
    private double sumMethod(double[] x ) {
        double y_p = 0.0;
        for (int i = 0; i < numberOfInputs; i++ )
            y_p += x[i] * wages[i];

        return y_p;
    }

    //uczenie
    public double learnMethod(double[] x, double lr, double fr, boolean isTeacher ) {
        double y_p = activationFunction( sumMethod( x ) );

        //wages zależności od podanej wersji, nauka będzie z lub bez współczynnika zapominania
        for (int i = 0; i < numberOfInputs; i++ )
            if ( isTeacher ) wages[i] = ( 1 - fr ) * wages[i] + lr * x[i] * y_p;		//ze współczynnikiem zapominania
            else wages[i] += lr * x[i] * y_p;									//bez współczynnika zapominania

        normalizeWeights();

        return activationFunction( sumMethod( x ) );
    }

    //zwraca output neuronu
    public double test ( double[] x ) {
        return activationFunction( sumMethod( x ) );
    }

    //normalizuje wagi
    private void normalizeWeights () {
        double dl = 0.0;
        for (int i = 0; i < wages.length; i++ )
            dl += Math.pow( wages[i], 2 );

        dl = Math.sqrt( dl );

        for (int i = 0; i < wages.length; i++ )
            if ( wages[i] > 0 && dl != 0 )
                wages[i] = wages[i] / dl;
    }
}
