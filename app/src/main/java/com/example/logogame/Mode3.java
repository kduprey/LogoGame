package com.example.logogame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Mode3 extends AppCompatActivity {

    private final String[] imgName = {"a", "b", "c", "f", "h", "l", "mc", "me", "mi", "n", "p", "s", "te", "to", "v"};
    private final String[] modelNames = {"Audi", "BMW", "Cadillac", "Ford", "Honda", "Lexus", "McLaren", "Mercedes", "Mini Cooper", "Nissan", "Porsche", "Subaru", "Tesla", "Toyota", "Volkswagen"};

    private String displayedImg1 = "";
    private String displayedModel1 = "";
    private String displayedImg2 = "";
    private String displayedModel2 = "";
    private String displayedImg3 = "";
    private String displayedModel3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode3);

        setRandomImage1();
        setRandomImage2();
        setRandomImage3();

        chooseRandModel();

    }

    public void chooseRandModel() {
        TextView x = findViewById(R.id.find_model_txt);

        int y = new Random().nextInt(3);

        switch (y) {
            case 0:
                x.setText(displayedModel1);
                break;
            case 1:
                x.setText(displayedModel2);
                break;
            case 2:
                x.setText(displayedModel3);
                break;
        }
    }

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


    public void setWinDisplay(boolean win) {
        TextView x = findViewById(R.id.win_status_text_m3);

        clearOnClick();

        if (win) {
            x.setText(R.string.win_txt);
            x.setTextColor(getResources().getColor(R.color.winning_green));

        }
        if (!win) {
            x.setText(R.string.lose_txt);
            x.setTextColor(getResources().getColor(R.color.losing_red));

        }
    }

    public void confirmSelection1(View view) {
        TextView x = findViewById(R.id.find_model_txt);


        if (displayedModel1.equals(x.getText().toString()))
            setWinDisplay(true);
         else
            setWinDisplay(false);


    }

    public void confirmSelection2(View view) {
        TextView x = findViewById(R.id.find_model_txt);

        if (displayedModel2.equals(x.getText().toString()))
            setWinDisplay(true);
        else
            setWinDisplay(false);
    }

    public void confirmSelection3(View view) {
        TextView x = findViewById(R.id.find_model_txt);

        if (displayedModel3.equals(x.getText().toString()))
            setWinDisplay(true);
        else
            setWinDisplay(false);
    }

    public void clearOnClick() {
        ImageView img1 = findViewById(R.id.ran_img_1);
        ImageView img2 = findViewById(R.id.ran_img_2);
        ImageView img3 = findViewById(R.id.ran_img_3);

        img1.setOnClickListener(null);
        img2.setOnClickListener(null);
        img3.setOnClickListener(null);
    }

    public void resetMode(View view) {
        TextView x = findViewById(R.id.win_status_text_m3);
        ImageView img1 = findViewById(R.id.ran_img_1);
        ImageView img2 = findViewById(R.id.ran_img_2);
        ImageView img3 = findViewById(R.id.ran_img_3);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmSelection1(v);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmSelection2(v);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmSelection3(v);
            }
        });

        x.setText("");

        setRandomImage1();
        setRandomImage2();
        setRandomImage3();

        chooseRandModel();
    }

}