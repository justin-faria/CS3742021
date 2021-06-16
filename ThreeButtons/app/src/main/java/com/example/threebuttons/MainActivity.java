package com.example.threebuttons;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.os.CountDownTimer;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Random rand = new Random();
    private TextView HorT;
    private TextView RPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HorT = findViewById(R.id.Coin_Screen);
        RPS = findViewById(R.id.Roshambo_Screen);
    }

    public void replyHello(View view) {
        Toast message = Toast.makeText(this, "Hey there!",
                Toast.LENGTH_SHORT);
        message.show();
    }

    public void Flip_a_Coin(View view) {
        int randomNum = rand.nextInt(2);
        HorT.setText(R.string.Flipping_text);
        HorT.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (HorT != null) {
                    if (randomNum == 1) {
                        HorT.setText(R.string.Heads_text);
                    } else {
                        HorT.setText(R.string.Tails_text);
                    }
                }
            }
        }, 1000);

    }

    public void Play_Roshambo(View view) {
        int randomNum = rand.nextInt(3);
        if (RPS != null) {
            new CountDownTimer(1500, 250) {
                int count = 4;
                int sub = 1;

                public void onTick(long millisUntilFinished) {
                    count = count - sub % 2;
                    RPS.setText(Integer.toString(count));
                    sub += 1;
                }

                public void onFinish() {
                    if (randomNum == 1) {
                        RPS.setText(R.string.Rock_text);
                    } else if (randomNum == 2) {
                        RPS.setText(R.string.Paper_text);
                    } else {
                        RPS.setText(R.string.Scissors_text);
                    }
                }
            }.start();
        }
        /*RPS.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(HorT != null){
                    if (randomNum == 1) {
                        HorT.setText(R.string.Rock_text);
                    }
                    else if (randomNum == 2) {
                        HorT.setText(R.string.Paper_text);
                    }
                    else{
                        HorT.setText(R.string.Scissors_text);
                    }
                }
            }
        }, 3000);*/

    }
}