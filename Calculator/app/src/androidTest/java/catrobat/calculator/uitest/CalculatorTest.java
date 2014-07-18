package catrobat.calculator.uitest;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

import catrobat.calculator.Calculator;
import catrobat.calculator.R;

public class CalculatorTest extends ActivityInstrumentationTestCase2<Calculator> {

    private Solo mySolo;

    public CalculatorTest(){
        super(Calculator.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        mySolo = new Solo(getInstrumentation(), getActivity());

    }

    public void tearDown() throws Exception {

    }

    public void testButtons(){
        for(int i = 0; i <= 9; i++){
            mySolo.clickOnButton(Integer.toString(i));
        }

        mySolo.clickOnButton("+");
        mySolo.clickOnButton("-");
        mySolo.clickOnButton("/");
        mySolo.clickOnButton("*");

        mySolo.clickOnButton("=");
        mySolo.clickOnButton("C");
    }

    public void testInputField(){
        mySolo.clickOnButton("4");
        mySolo.clickOnButton("2");

        mySolo.getText("42");
    }

    public void testAddition(){
        mySolo.clickOnButton("8");
        mySolo.clickOnButton("+");
        mySolo.clickOnButton("9");
        mySolo.clickOnButton("=");

        waitAndAssertEquals("17");
    }

    public void testSubtraction(){
        mySolo.clickOnButton("8");
        mySolo.clickOnButton("-");
        mySolo.clickOnButton("3");
        mySolo.clickOnButton("=");

        waitAndAssertEquals("5");
    }

    public void testMultiplication(){
        mySolo.clickOnButton("2");
        mySolo.clickOnButton("*");
        mySolo.clickOnButton("1");
        mySolo.clickOnButton("3");
        mySolo.clickOnButton("=");

        waitAndAssertEquals("26");
    }

    public void testDivision(){
        mySolo.clickOnButton("8");
        mySolo.clickOnButton("/");
        mySolo.clickOnButton("4");
        mySolo.clickOnButton("=");

        waitAndAssertEquals("2");
    }

    public void testDivision1(){
        mySolo.clickOnButton("3");
        mySolo.clickOnButton("/");
        mySolo.clickOnButton("0");
        mySolo.clickOnButton("=");

        waitAndAssertEquals("0");
    }

    public void testMultipleButtons(){
        mySolo.clickOnButton("3");
        mySolo.clickOnButton("+");
        mySolo.clickOnButton("8");
        mySolo.clickOnButton("=");
        mySolo.clickOnButton("5");

        waitAndAssertEquals("5");
    }

    public void testClearButton(){
        mySolo.clickOnButton("3");
        mySolo.clickOnButton("C");

        waitAndAssertEquals("0");
    }


    private void waitAndAssertEquals(String assertion){
        TextView textView = (TextView) mySolo.getCurrentActivity().findViewById(R.id.textView);
        mySolo.sleep(300);
        assertEquals(assertion, textView.getText());
    }
}