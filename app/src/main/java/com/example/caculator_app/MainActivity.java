package com.example.caculator_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtInput, txtOutput;
    private String input, output, newOutput;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnclear, btnpower,
            btnpercent, btndivision, btnMultiply, btnSubstraction, btnAddition, btnPoint, btnEqual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);
        txtOutput = findViewById(R.id.txtOutput);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAddition = findViewById(R.id.btnAddition);
        btnclear = findViewById(R.id.btnclear);
        btndivision = findViewById(R.id.btndivision);
        btnEqual = findViewById(R.id.btnEqual);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnpercent = findViewById(R.id.btnpercent);
        btnPoint = findViewById(R.id.btnPoint);
        btnpower = findViewById(R.id.btnpower);
        btnSubstraction = findViewById(R.id.btnSubstraction);
    }

    public void onButtonClicked(View view) {
        Button button = (Button) view;
        String data =button.getText().toString();
        switch (data){
            case "C":
                input = null;
                output = null;
                newOutput = null;
                txtOutput.setText("");
                break;

            case "^":
                solve();
                input+="^";
                break;
            case "*":
                solve();
                input+="*";
                break;
            case "=":
                solve();
                break;
            case "%":
                input+="%";
                double d = Double.parseDouble(txtInput.getText().toString())/100;
                txtOutput.setText(String.valueOf(d));
                break;
            default:
                if (input == null){
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")){
                    solve();
                }
                input +=data;
        }
        txtInput.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2){
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                txtOutput.setText(newOutput);
                input = d + "";
            }
            catch (Exception e){
                txtOutput.setError(e.getMessage().toString());
            }
        }

        if (input.split("\\*").length == 2){
            String numbers[] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                txtOutput.setText(newOutput);
                input = d + "";
            }
            catch (Exception e){
                txtOutput.setError(e.getMessage().toString());
            }
        }

        if (input.split("\\/").length == 2){
            String numbers[] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                txtOutput.setText(newOutput);
                input = d + "";
            }
            catch (Exception e){
                txtOutput.setError(e.getMessage().toString());
            }
        }

        if (input.split("\\^").length == 2){
            String numbers[] = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                txtOutput.setText(newOutput);
                input = d + "";
            }
            catch (Exception e){
                txtOutput.setError(e.getMessage().toString());
            }
        }

        if (input.split("\\-").length == 2){
            String numbers[] = input.split("\\-");
            try {
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    txtOutput.setText("-" + newOutput);
                    input = d + "";
                }
                else {
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newOutput = cutDecimal(output);
                    txtOutput.setText(newOutput);
                    input = d + "";
                }
            }
            catch (Exception e){
                txtOutput.setError(e.getMessage().toString());
            }
        }
    }
    private String cutDecimal (String number) {
        String n [] = number.split("\\.");
        if (n.length >1){
            if (n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }
}