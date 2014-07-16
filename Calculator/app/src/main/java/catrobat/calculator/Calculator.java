package catrobat.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Calculator extends Activity implements View.OnClickListener {

    public enum NumberStrings {
        Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine
    };

    public enum OperationFlag {
        ADD, SUB, MUL, DIV, INIT, NOP
    };

    private ArrayList<Button> numberButtons = new ArrayList<Button>();
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;

    private Button buttonEqual;
    private Button buttonClear;

    private TextView numberView;

    private String recentNumber = "";

    private OperationFlag flag = OperationFlag.INIT;
    private int firstNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        generateNumberButtons();

        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);

        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonClear = (Button) findViewById(R.id.buttonClear);

        numberView = (TextView) findViewById(R.id.textView);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);

        buttonEqual.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void generateNumberButtons() {
        for (int i = 0; i <= 9; i++) {
            String buttonName = "button" + NumberStrings.values()[i].toString();

            int id = getResources().getIdentifier(buttonName, "id", R.class.getPackage().getName());

            Button button = ((Button) findViewById(id));
            button.setOnClickListener(this);
            numberButtons.add(button);
        }
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;

        switch (clickedButton.getId()) {
            case R.id.buttonPlus:
                clearNumberView();
                flag = OperationFlag.ADD;
                break;
            case R.id.buttonMinus:
                clearNumberView();
                flag = OperationFlag.SUB;
                break;
            case R.id.buttonMultiply:
                clearNumberView();
                flag = OperationFlag.MUL;
                break;
            case R.id.buttonDivide:
                clearNumberView();
                flag = OperationFlag.DIV;
                break;
            case R.id.buttonEqual:
                doEqual();
                break;
            case R.id.buttonClear:
                makeClear();
                break;
            default:
                recentNumber = numberView.getText().toString();
                if (flag == OperationFlag.INIT) {
                    recentNumber = "";
                    flag = OperationFlag.NOP;
                }
                recentNumber += clickedButton.getText().toString();
                numberView.setText(recentNumber);
        }
    }

    private void clearNumberView() {
        String tempString = numberView.getText().toString();
        if(!tempString.equals("")){
            firstNumber = Integer.valueOf(tempString);
        }
        numberView.setText("");
    }

    private void doEqual() {
        int secondNumber = 0;

        String tempString = numberView.getText().toString();
        if(!tempString.equals("")){
            secondNumber = Integer.valueOf(tempString);
        }

        int result = 0;
        switch(flag){
            case ADD:
                result = Calculations.doAddition(firstNumber, secondNumber);
                break;
            case SUB:
                result = Calculations.doSubtraction(firstNumber, secondNumber);
                break;
            case MUL:
                result = Calculations.doMultiplication(firstNumber, secondNumber);
                break;
            case DIV:
                result = Calculations.doDivision(firstNumber, secondNumber);
                break;
            default:
                result = secondNumber;
        }
        flag = OperationFlag.INIT;
        numberView.setText(Integer.toString(result));
    }

    private void makeClear() {
        numberView.setText("0");
        firstNumber = 0;
        flag = OperationFlag.INIT;
    }
}
