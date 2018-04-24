package com.example.android.quizwte;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView t;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView) findViewById(R.id.quiz);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/JOKERMAN.TTF");
        t.setTypeface(myCustomFont);
    }

    /**
     * This method saves the user's name and checks the answers
     */

    public void showMyResult(View view) {

        RadioButton question1 = findViewById(R.id.answer_1_a);
        CheckBox question2a = findViewById(R.id.answer_2_a);
        CheckBox question2c = findViewById(R.id.answer_2_c);
        CheckBox question2e = findViewById(R.id.answer_2_e);
        CheckBox question2f = findViewById(R.id.answer_2_f);
        EditText answer3 = findViewById(R.id.answer_3_edit);
        String question3 = answer3.getText().toString();
        RadioButton question4 = findViewById(R.id.answer_4_b);
        RadioButton question5 = findViewById(R.id.answer_5_b);
        RadioButton question6 = findViewById(R.id.answer_6_c);
        RadioButton question7 = findViewById(R.id.answer_7_d);
        RadioButton question8 = findViewById(R.id.answer_8_c);
        RadioButton question9 = findViewById(R.id.answer_9_a);
        RadioButton question10 = findViewById(R.id.answer_10_c);


        if (question1.isChecked()) {
            score = score + 1;
        }

        if (question2a.isChecked() && question2c.isChecked() && question2e.isChecked() && question2f.isChecked()) {
            score = score + 1;
        }

        if (question3.equalsIgnoreCase("MUL KALIFA")) {
            score = score + 1;
        }

        if (question4.isChecked()) {
            score = score + 1;
        }

        if (question5.isChecked()) {
            score = score + 1;
        }

        if (question6.isChecked()) {
            score = score + 1;
        }

        if (question7.isChecked()) {
            score = score + 1;
        }

        if (question8.isChecked()) {
            score = score + 1;
        }

        if (question9.isChecked()) {
            score = score + 1;
        }

        if (question10.isChecked()) {
            score = score + 1;
        }

        setContentView(R.layout.result);

        t = (TextView) findViewById(R.id.your_score);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/JOKERMAN.TTF");
        t.setTypeface(myCustomFont);

        t = (TextView) findViewById(R.id.score);
        myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/JOKERMAN.TTF");
        t.setTypeface(myCustomFont);

        displayScore(score);
        displayMessage(score);
    }

    /**
     * Displays the given score.
     */

    public void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays different score message depending on the score range.
     */

    public void displayMessage(int score) {

        TextView scoreMessageTextView = (TextView) findViewById(R.id.text_result);


        if (score <= 2) {
            scoreMessageTextView.setText(R.string.message_1);

        } else if ((score > 2) && (score <= 6)) {
            scoreMessageTextView.setText(R.string.message_2);


        } else if ((score > 6) && (score <= 8)) {
            scoreMessageTextView.setText(R.string.message_3);

        } else {
            scoreMessageTextView.setText(R.string.message_4);
        }

    }

    /**
     * This method resets the quiz and comes back to questions
     */

    public void tryAgain(View view) {

        score = 0;

        setContentView(R.layout.activity_main);

        t = (TextView) findViewById(R.id.quiz);
        Typeface myCustomFont = Typeface.createFromAsset(getAssets(), "fonts/JOKERMAN.TTF");
        t.setTypeface(myCustomFont);

    }

    /**
     * This method is called when the order button is clicked.
     */

    public void shareYourResult(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        {
            intent.setData(Uri.parse("mailto: paczuch.mail@gmail.com")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "paczuch.mail@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.wte_quiz_result));
            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.my_result) + score);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }

    }

}


