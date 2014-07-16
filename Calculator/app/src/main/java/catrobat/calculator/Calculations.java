package catrobat.calculator;

/**
 * Created by stephan on 16.07.14.
 */
public class Calculations {


    private Calculations(){}


    public static int doAddition(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public static int doSubtraction(int firstNumber, int secondNumber){
        return firstNumber - secondNumber;
    }

    public static int doMultiplication(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }

    public static int doDivision(int firstNumber, int secondNumber){

        if(secondNumber == 0){
            return 0;
        }
        return firstNumber / secondNumber;
    }
}
