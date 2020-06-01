package com.codingwithjks.tictacgame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private static final String TAG = "main";
    private Button one,two,three,four,five,six,seven,eight,nine,clear;
 private int k=0;
 private AlertDialog.Builder builder;
 private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        clear=findViewById(R.id.clear);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        clear.setOnClickListener(this);


    }

    private void dialog(String text) {
        builder=new AlertDialog.Builder(this);
        View itemView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.dialog,null);
        dialog=builder.create();
        TextView textView=itemView.findViewById(R.id.win);
        Button ok=itemView.findViewById(R.id.ok);
        dialog.setView(itemView);
        textView.setText(text);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void checkResult() {

        //Horizontal line 1
        if(one.getText().toString().trim().equals("0") && two.getText().toString().trim().equals("0") && three.getText().toString().trim().equals("0"))
        {
            dialog("Player one wins");
            clear();
        }
        if(one.getText().toString().trim().equals("x") && two.getText().toString().trim().equals("x") && three.getText().toString().trim().equals("x"))
        {
            dialog("Player two wins");
            clear();
        }

        //Horizontal line2

        if(four.getText().toString().trim().equals("0") && five.getText().toString().trim().equals("0") && six.getText().toString().trim().equals("0"))
        {

            dialog("Player one wins");
            clear();
        }
        if(four.getText().toString().trim().equals("x") && five.getText().toString().trim().equals("x") && six.getText().toString().trim().equals("x"))
        {

            dialog("Player two wins");
            clear();
        }

        //Horizontal line3

        if(seven.getText().toString().trim().equals("0") && eight.getText().toString().trim().equals("0") && nine.getText().toString().trim().equals("0"))
        {

            dialog("Player one wins");
            clear();
        }
        if(seven.getText().toString().trim().equals("x") && eight.getText().toString().trim().equals("x") && nine.getText().toString().trim().equals("x"))
        {
            dialog("Player two wins");
            clear();
        }

        // cross 1
        if(one.getText().toString().trim().equals("0") && five.getText().toString().trim().equals("0") && nine.getText().toString().trim().equals("0"))
        {
            dialog("Player one wins");
            clear();
        }
        if(one.getText().toString().trim().equals("x") && five.getText().toString().trim().equals("x") && nine.getText().toString().trim().equals("x"))
        {
            dialog("Player two wins");
            clear();
        }

      //cross 2

        if(three.getText().toString().trim().equals("0") && five.getText().toString().trim().equals("0") && seven.getText().toString().trim().equals("0"))
        {
            dialog("Player one wins");
            clear();
        }

        if(three.getText().toString().trim().equals("x") && five.getText().toString().trim().equals("x") && seven.getText().toString().trim().equals("x"))
        {
            dialog("Player two wins");
            clear();
        }

        // vertical line 1

        if(one.getText().toString().trim().equals("0") && four.getText().toString().trim().equals("0") && seven.getText().toString().trim().equals("0"))
        {
            dialog("Player one wins");
            clear();
        }
        if(one.getText().toString().trim().equals("x") && four.getText().toString().trim().equals("x") && seven.getText().toString().trim().equals("x"))
        {
            dialog("Player two wins");
            clear();
        }

        //vertical line 2

        if(two.getText().toString().trim().equals("0") && five.getText().toString().trim().equals("0") && eight.getText().toString().trim().equals("0"))
        {
            dialog("Player one wins");
            clear();
        }
        if(two.getText().toString().trim().equals("x") && five.getText().toString().trim().equals("x") && eight.getText().toString().trim().equals("x"))
        {
            dialog("Player two wins");
            clear();
        }

        //vertical line 3

        if(three.getText().toString().trim().equals("0") && six.getText().toString().trim().equals("0") && nine.getText().toString().trim().equals("0"))
        {
            dialog("Player one wins");
            clear();
        }
        if(three.getText().toString().trim().equals("x") && six.getText().toString().trim().equals("x") && nine.getText().toString().trim().equals("x"))
        {
            dialog("Player two wins");
            clear();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.one:
                       logic_one(one);
                break;
            case R.id.two:
                logic_one(two);
                break;
            case R.id.three:
                logic_one(three);
                break;
            case R.id.four:
                logic_one(four);
                break;
            case R.id.five:
                logic_one(five);
                break;
            case R.id.six:
                logic_one(six);
                break;
            case R.id.seven:
                logic_one(seven);
                break;
            case R.id.eight:
                logic_one(eight);
                break;
            case R.id.nine:
                logic_one(nine);
                break;
            case R.id.clear:
                clear();
                break;
        }
    }

    private void clear() {
        one.setText("");
        three.setText("");
        two.setText("");
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");

        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        five.setEnabled(true);
        four.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(true);
        nine.setEnabled(true);

    }

    private void logic_one(Button btn) {
        if(k == 0)
        {
            btn.setText("0");
            btn.setEnabled(false);
            k=1;
            checkResult();
        }
        else{
            btn.setText("x");
            btn.setEnabled(false);
            k=0;
            checkResult();
        }
    }
}