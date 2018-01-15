/**
 * Created by Kamil on 2018-01-10.
 */
public class Main {
    private static double learningRate = 0.5;	//współczynnik uczenia się
    private static int numberOfInputs = 70;		//ilość wejść
    private static int numberOfNeurons = 50000;	//liczba neuronów
    private static int numberOfLearn = 20;	//liczba danych uczących
    private static int numberOfTest = 20;	//liczba danych testujących
    private static int learnLimit = 50;		//próg epok uczenia
    private static double radius = 4.2;	//początkowa wartość promienia

    public static void main ( String[] args ) {

        KohonenWTM[] kohonens = new KohonenWTM[numberOfNeurons];
        for ( int i = 0; i < numberOfNeurons; i++ )
            kohonens[i] = new KohonenWTM( numberOfInputs );

        int ages = learn( kohonens );

        int[] winnerLearn = new int[numberOfLearn], winnerTest = new int[numberOfTest];
        int percent = 0;

//wyniki uczenia
        for (int i = 0; i < numberOfLearn; i++ )
            winnerLearn[i] = getWinner( kohonens, DataToLearnAndTest.lettersLearn[i] );

//wyniki testowania
        for (int i = 0; i < numberOfLearn; i++ )
            winnerTest[i] = getWinner( kohonens, DataToLearnAndTest.lettersTest[i] );

        for (int i = 0; i < numberOfTest; i++ )
            if ( winnerLearn[i] == winnerTest[i] )
                percent++;
    }

    //uczenie sieci
    private static int learn ( KohonenWTM[] kohonens ) {

        int counter = 0;
        int winner;
        int[] winners = new int[numberOfLearn];
        for (int i = 0; i < numberOfLearn; i++ )
            winners[i] = - 1;

        //dopóki sieć się nauczy
        while ( ! isUnique( winners ) ) {
            for (int i = 0; i < numberOfLearn; i++ ) {
                winner = getWinner( kohonens, DataToLearnAndTest.lettersLearn[i] );
                kohonens[winner].learn( DataToLearnAndTest.lettersLearn[i], learningRate );

                //uczenie sąsiednich neuronów
                for ( int j = 0; j < numberOfNeurons; j++ )
                    if ( j != winner )
                        if ( distanceBetweenVectors( kohonens[winner].getWage(), kohonens[j].getWage() ) <= radius)
                            kohonens[j].learn( DataToLearnAndTest.lettersLearn[i], learningRate );
            }

            // pobieramy zwycięzców
            for (int i = 0; i < numberOfLearn; i++ )
                winners[i] = getWinner( kohonens, DataToLearnAndTest.lettersLearn[i] );

            if ( ++ counter == learnLimit )
                break;
        }
        return counter;
    }

    //sprawdza czy sieć jest już nauczona
    private static boolean isUnique ( int[] winners ) {

        //czy zwycięzca sie zgadzają
        for (int i = 0; i < numberOfLearn; i++ )
            for (int j = i; j < numberOfLearn; j++ )
                if ( i != j )
                    if ( winners[i] == winners[j] )
                        return false;

        return true;
    }

    //zwraca zwycięzcę
    private static int getWinner ( KohonenWTM[] kohonens, double[] vector ) {

        int winner = 0;
        double minDistance = distanceBetweenVectors( kohonens[0].getWage(), vector );

        //sprawdza który neuron jest zwycięzcą
        for ( int i = 0; i < numberOfNeurons; i++ ) {
            if ( distanceBetweenVectors( kohonens[i].getWage(), vector ) < minDistance ) {
                winner = i;
                minDistance = distanceBetweenVectors( kohonens[i].getWage(), vector );
            }
        }
        return winner;
    }

    //zwraca odległość między zadanymi wektorami
    private static double distanceBetweenVectors ( double[] vector1, double[] vector2 ) {

        double suma = 0.0;

        for ( int i = 0; i < vector1.length; i++ )
            suma += Math.abs( vector1[i] - vector2[i] );

        return Math.sqrt( suma );
    }

}
