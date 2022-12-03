package com.example.egay_learningtask42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etSideA, etSideB, etSideC;
    String resultAcute, resultObtuse, resultRight, strSideA, strSideB, strSideC;
    double exp = 2, doubSideA, doubSideB, doubSideC, Expo, result;
    int triangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Computing....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        etSideA = (EditText) findViewById(R.id.etSideA);
        etSideB = (EditText) findViewById(R.id.etSideB);
        etSideC = (EditText) findViewById(R.id.etSideC);

        strSideA = etSideA.getText().toString();
        strSideB = etSideB.getText().toString();
        strSideC = etSideC.getText().toString();
        doubSideA = Double.parseDouble (strSideA);
        doubSideB = Double.parseDouble (strSideB);
        doubSideC = Double.parseDouble (strSideC);

        result = Math.pow(doubSideA, exp) + Math.pow(doubSideB, exp);
        Expo = Math.pow(doubSideC, exp);

        if(result > Expo){
            triangle = 1;

        }else if(result == Expo){
            triangle = 2;

        }else if(result < Expo){
            triangle = 3;

        }

        switch (triangle) {
            case 1:
                AcuteIntent();
                break;

            case 2:
                RightIntent();
                break;

            case 3:
                ObtuseIntent();
                break;
        }

    }
    public void clearEditText(){
        etSideA.getText().clear();
        etSideB.getText().clear();
        etSideC.getText().clear();
    }

    public void AcuteIntent() {
        resultAcute = "side a = " + strSideA + ", side b = " + strSideB + ", side c = " + strSideC + "\n\n" +
                strSideA + "^2 + " + strSideB + "^2 = " + (int) result + "\n" +
                strSideC + "^2 = " + (int) Expo + "\n" +
                (int) result + " > " + (int) Expo + "\n\n" +
                "Therefore, it is an Acute Triangle.";
        Bundle args = new Bundle();
        args.putString("result", resultAcute);

        Intent intent = new Intent(MainActivity.this, AcuteActivity.class);
        intent.putExtras(args);
        startActivity(intent);

        clearEditText();
    }

    public void RightIntent() {
        resultRight = "side a = " + strSideA + ", side b = " + strSideB + ", side c = " + strSideC + "\n\n" +
                strSideA + "^2 + " + strSideB + "^2 = " + (int) result + "\n" +
                strSideC + "^2 = " + (int) Expo + "\n" +
                (int) result + " = " + (int) Expo + "\n\n" +
                "Therefore, it is a Right Triangle.";

        Bundle args = new Bundle();
        args.putString("result", resultRight);

        Intent intent = new Intent(MainActivity.this, RightActivity.class);
        intent.putExtras(args);
        startActivity(intent);

        clearEditText();
    }

    public void ObtuseIntent() {
        resultObtuse = "side a = " + strSideA + ", side b = " + strSideB + ", side c = " + strSideC + "\n\n" +
                strSideA + "^2 + " + strSideB + "^2 = " + (int) result + "\n" +
                strSideC + "^2 = " + (int) Expo + "\n" +
                (int) result + " < " + (int) Expo + "\n\n" +
                "Therefore, it is an Obtuse Triangle.";

        Bundle args = new Bundle();
        args.putString("result", resultObtuse);

        Intent intent = new Intent(MainActivity.this, ObtuseActivity.class);
        intent.putExtras(args);
        startActivity(intent);

        clearEditText();
    }
}