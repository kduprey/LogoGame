package com.example.logogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class Mode2 extends AppCompatActivity {

    private final String[] imgName = {"a", "b", "c", "f", "h", "l", "mc", "me", "mi", "n", "p", "s", "te", "to", "v"};
    private final String[] modelNames = {"Audi", "BMW", "Cadillac", "Ford", "Honda", "Lexus", "McLaren", "Mercedes", "Mini Cooper", "Nissan", "Porsche", "Subaru", "Tesla", "Toyota", "Volkswagen"};

    private String displayedImg = "";
    private String displayedModel = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode2);

        setRandomImage();

    }

    public void setRandomImage() {
        ImageView img = findViewById(R.id.random_img_mode2);

        int x = new Random().nextInt(5) + 1;
        int y = new Random().nextInt(imgName.length);
        String newImg = imgName[y] + x;
        String newModel = modelNames[y];

        if (newModel.equals(displayedModel))
            setRandomImage();
        else {
            displayedImg = newImg;
            displayedModel = newModel;
            int id = getResources().getIdentifier(newImg, "drawable", getPackageName());
            img.setImageResource(id);
        }
    }


}