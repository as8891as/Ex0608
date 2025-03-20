package com.example.ex0608;

import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tV_level1_high;
    TextView tV_level1_low;
    TextView tV_level2_high;
    TextView tV_level2_low;
    TextView tV_level3_high;
    TextView tV_level3_low;
    EditText eT_number_level1;
    EditText eT_number_level2;
    EditText eT_number_level3;
    ImageView iV_level1;
    ImageView iV_level2;
    ImageView iV_level3;
    Button btn_level1;
    Button btn_level2;
    Button btn_level3;
    Button btn_restart;
    Random rnd;
    int num1;
    int num2;
    int user_answer;
    int currentLevel;
    int numCorrectAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tV_level1_high = findViewById(R.id.tV_level1_high);
        tV_level1_low = findViewById(R.id.tV_level1_low);
        tV_level2_high = findViewById(R.id.tV_level2_high);
        tV_level2_low = findViewById(R.id.tV_level2_low);
        tV_level3_high = findViewById(R.id.tV_level3_high);
        tV_level3_low = findViewById(R.id.tV_level3_low);
        eT_number_level1 = findViewById(R.id.eT_number_level1);
        eT_number_level2 = findViewById(R.id.eT_number_level2);
        eT_number_level3 = findViewById(R.id.eT_number_level3);
        iV_level1 = findViewById(R.id.iV_level1);
        iV_level2 = findViewById(R.id.iV_level2);
        iV_level3 = findViewById(R.id.iV_level3);
        btn_level1 = findViewById(R.id.btn_level1);
        btn_level2 = findViewById(R.id.btn_level2);
        btn_level3 = findViewById(R.id.btn_level3);
        btn_restart = findViewById(R.id.btn_restart);
        rnd = new Random();
        currentLevel = 1;
        numCorrectAnswers = 0;
        num1 = rnd.nextInt(90)+10;
        num2 = rnd.nextInt(90)+10;
        tV_level1_high.setText(num1+"");
        tV_level1_low.setText(num2+"");
        tV_level1_high.setVisibility(VISIBLE);
        tV_level1_low.setVisibility(VISIBLE);
    }

    public void level1_submitted(View view) {
        if (!eT_number_level1.getText().toString().isEmpty() && currentLevel==1)
        {
            user_answer = Integer.parseInt(eT_number_level1.getText().toString());
            if (user_answer==num1+num2)
            {
                iV_level1.setImageResource(R.drawable.correct);
                numCorrectAnswers++;
            }
            else
            {
                iV_level1.setImageResource(R.drawable.incorrect);
            }
            iV_level1.setVisibility(VISIBLE);
            num1 += num2;
            num2 = rnd.nextInt(90)+10;
            tV_level2_high.setText(num1+"");
            tV_level2_low.setText(num2+"");
            tV_level2_high.setVisibility(VISIBLE);
            tV_level2_low.setVisibility(VISIBLE);
            eT_number_level2.setVisibility(VISIBLE);
            btn_level2.setVisibility(VISIBLE);
            currentLevel++;
        }
    }
}