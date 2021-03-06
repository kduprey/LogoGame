package com.example.logogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Mode4 extends AppCompatActivity {

    private final String[] imgName = {"a", "b", "c", "f", "h", "l", "mc", "me", "mi", "n", "p", "s", "te", "to", "v"};
    private final String[] modelNames = {"Audi", "BMW", "Cadillac", "Ford", "Honda", "Lexus", "McLaren", "Mercedes", "Mini Cooper", "Nissan", "Porsche", "Subaru", "Tesla", "Toyota", "Volkswagen"};

    private String displayedImg1 = "";
    private String displayedModel1 = "";
    private String displayedImg2 = "";
    private String displayedModel2 = "";
    private String displayedImg3 = "";
    private String displayedModel3 = "";
    private int score = 0;
    private int attempts = 0;
    private int numCorrect = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode4);

        TextView scoreTxt = findViewById(R.id.score_text);

        scoreTxt.setText("Score: " + score);


        setRandomImage1();
        setRandomImage2();
        setRandomImage3();

    }

//    Methods to set the three random images
    public void setRandomImage1() {
        ImageView img = findViewById(R.id.ran_img_1);

        int x = new Random().nextInt(5) + 1;
        int y = new Random().nextInt(imgName.length);
        String newImg = imgName[y] + x;
        String newModel = modelNames[y];

        if (newModel.equals(displayedModel1) || newModel.equals(displayedModel2) || newModel.equals(displayedModel3))
            setRandomImage1();
        else {
            displayedImg1 = newImg;
            displayedModel1 = newModel;
            int id = getResources().getIdentifier(newImg, "drawable", getPackageName());
            img.setImageResource(id);
        }
    }

    public void setRandomImage2() {
        ImageView img = findViewById(R.id.ran_img_2);

        int x = new Random().nextInt(5) + 1;
        int y = new Random().nextInt(imgName.length);
        String newImg = imgName[y] + x;
        String newModel = modelNames[y];

        if (newModel.equals(displayedModel1) || newModel.equals(displayedModel2) || newModel.equals(displayedModel3)
                || newImg.charAt(0) == displayedImg1.charAt(0))
            setRandomImage2();
        else {
            displayedImg2 = newImg;
            displayedModel2 = newModel;
            int id = getResources().getIdentifier(newImg, "drawable", getPackageName());
            img.setImageResource(id);
        }
    }

    public void setRandomImage3() {
        ImageView img = findViewById(R.id.ran_img_3);

        int x = new Random().nextInt(5) + 1;
        int y = new Random().nextInt(imgName.length);
        String newImg = imgName[y] + x;
        String newModel = modelNames[y];

        if (newModel.equals(displayedModel1) || newModel.equals(displayedModel2) || newModel.equals(displayedModel3)
                || newImg.charAt(0) == displayedImg1.charAt(0) || newImg.charAt(0) == displayedImg2.charAt(0))
            setRandomImage3();
        else {
            displayedImg3 = newImg;
            displayedModel3 = newModel;
            int id = getResources().getIdentifier(newImg, "drawable", getPackageName());
            img.setImageResource(id);
        }
    }

//    Method to check the user submission on the click of the submit button
    public void checkSubmission(View view) {
        EditText input1 = findViewById(R.id.input_model_1);
        EditText input2 = findViewById(R.id.input_model_2);
        EditText input3 = findViewById(R.id.input_model_3);
        TextView m1 = findViewById(R.id.car_model_txt_1);
        TextView m2 = findViewById(R.id.car_model_txt_2);
        TextView m3 = findViewById(R.id.car_model_txt_3);
        TextView scoreTxt = findViewById(R.id.score_text);
        Button submitBtn = findViewById(R.id.submit_btn);


        if (input1.getText().toString().isEmpty() || input2.getText().toString().isEmpty() || input3.getText().toString().isEmpty())
            Toast.makeText(getApplicationContext(), "Fill all the blanks!", Toast.LENGTH_SHORT).show();
        else {
            String submission1 = input1.getText().toString().toLowerCase();
            String submission2 = input2.getText().toString().toLowerCase();
            String submission3 = input3.getText().toString().toLowerCase();

            System.out.println(submission1);
            System.out.println(submission2);
            System.out.println(submission3);

            if (submission1.equals(displayedModel1.toLowerCase())) {
                input1.setEnabled(false);
                input1.setTextColor(getResources().getColor(R.color.winning_green));
                numCorrect++;
                score++;
                scoreTxt.setText("Score: " + score);
                if (numCorrect == 3) {
                    numCorrect = 0;
                    submitBtn.setText("Next");
                    submitBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            resetGame(v);
                            m3.setText("");
                        }
                    });
                }
            } else if (attempts > 3) {
                input1.setTextColor(getResources().getColor(R.color.losing_red));
                input1.setEnabled(false);
                m1.setText(displayedModel1);
                submitBtn.setText("Next");
                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resetGame(v);
                        m1.setText("");
                    }
                });
            } else {
                attempts++;
                Toast.makeText(getApplicationContext(), "Attempts: " + attempts, Toast.LENGTH_SHORT).show();

            }

            if (submission2.equals(displayedModel2.toLowerCase())) {
                input2.setEnabled(false);
                input2.setTextColor(getResources().getColor(R.color.winning_green));
                numCorrect++;
                score++;
                scoreTxt.setText("Score: " + score);
                if (numCorrect == 3) {
                    numCorrect = 0;
                    submitBtn.setText("Next");
                    submitBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            resetGame(v);
                            m3.setText("");
                        }
                    });
                }
            } else if (attempts > 3) {
                input2.setTextColor(getResources().getColor(R.color.losing_red));
                input2.setEnabled(false);
                m2.setText(displayedModel2);
                submitBtn.setText("Next");
                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resetGame(v);
                        m2.setText("");
                    }
                });
            } else {
                attempts++;
                Toast.makeText(getApplicationContext(), "Attempts: " + attempts, Toast.LENGTH_SHORT).show();
            }

            if (submission3.equals(displayedModel3.toLowerCase())) {
                input3.setEnabled(false);
                input3.setTextColor(getResources().getColor(R.color.winning_green));
                numCorrect++;
                score++;
                scoreTxt.setText("Score: " + score);
                if (numCorrect == 3) {
                    numCorrect = 0;
                    submitBtn.setText("Next");
                    submitBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            resetGame(v);
                            m3.setText("");
                        }
                    });
                }
            } else if (attempts > 3) {
                input3.setTextColor(getResources().getColor(R.color.losing_red));
                input3.setEnabled(false);
                m3.setText(displayedModel3);
                submitBtn.setText("Next");
                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resetGame(v);
                        m3.setText("");
                    }
                });



            } else {
                attempts++;
                Toast.makeText(getApplicationContext(), "Attempts: " + attempts, Toast.LENGTH_SHORT).show();
            }

        }
    }

//    Method to reset the game view space for next round
    public void resetGame(View view) {
        Button submit = findViewById(R.id.submit_btn);
        TextView m1 = findViewById(R.id.car_model_txt_1);
        TextView m2 = findViewById(R.id.car_model_txt_2);
        TextView m3 = findViewById(R.id.car_model_txt_3);
        EditText input1 = findViewById(R.id.input_model_1);
        EditText input2 = findViewById(R.id.input_model_2);
        EditText input3 = findViewById(R.id.input_model_3);

        input1.setText("");
        input2.setText("");
        input3.setText("");
        input1.setTextColor(getResources().getColor(R.color.black));
        input2.setTextColor(getResources().getColor(R.color.black));
        input3.setTextColor(getResources().getColor(R.color.black));
        input1.setEnabled(true);
        input2.setEnabled(true);
        input3.setEnabled(true);

        m1.setText("");
        m2.setText("");
        m3.setText("");

        submit.setOnClickListener(this::checkSubmission);
        submit.setText(getResources().getText(R.string.submit_btn_text).toString());
        attempts = 0;

        setRandomImage1();
        setRandomImage2();
        setRandomImage3();

    }

}