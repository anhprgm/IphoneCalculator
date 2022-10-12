package com.theanhdev.iphonecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView number0, number1, number2, number3, number4, number5, number6, number7, number8, number9,
            negativeNumber, add, multiply, mod, equal, sub, ac, div, dot, onChangeNumber, previousNumber;
    private String numberText = "", prefix, previousPrefix;

    private double firstNumber = 0, secondNumber = 0, equalNumber = 0;

    private boolean firstNumberWasSet = false, isNegativeNumber = false, secondNumberWasSet = false;

//   public final Vibrator vibrator = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding();
        // on tap number
        number0.setOnClickListener(v -> {
            numberText += '0';
            setOnChangeNumber(numberText);
        });
        number1.setOnClickListener(v -> {
            numberText += '1';
            setOnChangeNumber(numberText);
        });
        number2.setOnClickListener(v -> {
            numberText += '2';
            setOnChangeNumber(numberText);
        });
        number3.setOnClickListener(v -> {
            numberText += '3';
            setOnChangeNumber(numberText);
        });
        number4.setOnClickListener(v -> {
            numberText += '4';
            setOnChangeNumber(numberText);
        });
        number5.setOnClickListener(v -> {
            numberText += '5';
            setOnChangeNumber(numberText);
        });
        number6.setOnClickListener(v -> {
            numberText += '6';
            setOnChangeNumber(numberText);
        });
        number7.setOnClickListener(v -> {
            numberText += '7';
            setOnChangeNumber(numberText);
        });
        number8.setOnClickListener(v -> {
            numberText += '8';
            setOnChangeNumber(numberText);
        });
        number9.setOnClickListener(v -> {
            numberText += '9';
            setOnChangeNumber(numberText);
        });
        dot.setOnClickListener(v -> {
            numberText += '.';
            setOnChangeNumber(numberText);
        });
        ac.setOnClickListener(v -> {
            if(!numberText.isEmpty()) {
                numberText = numberText.substring(0, numberText.length() - 1);
            }
            firstNumberWasSet = false;
            secondNumberWasSet = false;
            firstNumber = 0;
            secondNumber = 0;
            equalNumber = 0;
            setOnChangeNumber(numberText);
        });

        ac.setOnLongClickListener(v -> {
            numberText = "";
            equalNumber = 0;
            previousNumber.setText("");
            prefix = "";
            setOnChangeNumber(numberText);
            return true;
        });
        //set prefix
        add.setOnClickListener(v -> {
            if (firstNumberWasSet && secondNumberWasSet) {
                setOnChangeNumber(NumberEqual(firstNumber, secondNumber) + "");
                prefix = "";
            }
            getNumber();
            prefix = "add";
        });
        sub.setOnClickListener(v -> {
            if (firstNumberWasSet && secondNumberWasSet) {
                setOnChangeNumber(NumberEqual(firstNumber, secondNumber) + "");
                prefix = "";
            }
            getNumber();
            prefix = "sub";
        });
        mod.setOnClickListener(v -> {
            if (firstNumberWasSet && secondNumberWasSet) {
                setOnChangeNumber(NumberEqual(firstNumber, secondNumber) + "");
                prefix = "";
            }
            getNumber();
            prefix = "mod";
        });
        multiply.setOnClickListener(v -> {
            if (firstNumberWasSet && secondNumberWasSet) {
                setOnChangeNumber(NumberEqual(firstNumber, secondNumber) + "");
                prefix = "";
            }
            getNumber();
            prefix = "mul";
        });
        div.setOnClickListener(v -> {
            if (firstNumberWasSet && secondNumberWasSet) {
                setOnChangeNumber(NumberEqual(firstNumber, secondNumber) + "");
                prefix = "";
            }
            getNumber();
            prefix = "div";
        });

        negativeNumber.setOnClickListener(v -> {
            if (!isNegativeNumber) {
                numberText = "-" + numberText;
                setOnChangeNumber(numberText);
                isNegativeNumber = true;
            } else {
                numberText = numberText.substring(1);
                setOnChangeNumber(numberText);
                isNegativeNumber = false;
            }
        });

        equal.setOnClickListener(v -> {
            if (firstNumberWasSet && secondNumberWasSet) {
                setOnChangeNumber(NumberEqual(firstNumber, secondNumber) + "");
                prefix = "";
            }
        });
    }

    private void binding() {
        //number btn
        number0 = findViewById(R.id.number0);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);
        // option btn
        negativeNumber = findViewById(R.id.negativeNumber);
        add = findViewById(R.id.add);
        multiply = findViewById(R.id.multiply);
        mod = findViewById(R.id.mod);
        equal = findViewById(R.id.equal);
        sub = findViewById(R.id.sub);
        ac = findViewById(R.id.ac);
        div = findViewById(R.id.division);
        dot = findViewById(R.id.dot);
        //change number
        onChangeNumber = findViewById(R.id.onChangeNumber);
        previousNumber = findViewById(R.id.previousNumber);
    }

    private void setOnChangeNumber(String numberText) {
        if (numberText.length() > 5) {
            onChangeNumber.setTextSize(50);
        } else onChangeNumber.setTextSize(80);
         onChangeNumber.setText(numberText);
    }

    private void setPreviousNumber(String s) {
        if (!s.isEmpty()) {
            previousNumber.setText(s);
        }
    }

    private void getNumber() {
        if (!numberText.isEmpty()) {
            if (!firstNumberWasSet) {
                firstNumber = Double.parseDouble(numberText);
                numberText = "";
                setPreviousNumber(firstNumber + " " + prefix);
                setOnChangeNumber(numberText);
                firstNumberWasSet = true;
            } else {
                secondNumber = Double.parseDouble(numberText);
                secondNumberWasSet = true;
            }
        }
    }

    private void add() {
        add.setBackgroundResource(R.drawable.background_color_change);
    }

    private void sub(){

    }

    private void div() {

    }

    private void mul() {

    }
    private void mod() {

    }

    private void setFalse() {
        firstNumberWasSet = false;
        secondNumberWasSet = false;
    }

    private double NumberEqual(double firstNumber, double secondNumber) {
        double sum;
        setFalse();
        switch (prefix) {
            case "add":
                sum = firstNumber + secondNumber;
                return sum;
            case "sub":
                sum = firstNumber - secondNumber;
                return sum;
            case "mod":
                sum = firstNumber % secondNumber;
                return sum;
            case "mul":
                sum = firstNumber * secondNumber;
                return sum;
            case "div":
                sum = firstNumber / secondNumber;
                return sum;
            default:
                return -999999999;
        }
    }
}