package com.example.logogame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Random;

public class Mode1 extends AppCompatActivity {

    String[] models = {"a", "b", "c", "f", "h", "l", "mc", "me", "mi", "n", "p", "s", "te", "to", "v"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode1);
        ImageView img = (ImageView) findViewById(R.id.random_img);
        int id = getRandomImage();
        img.setImageResource(id);

    }

    public int getRandomImage() {
        int x = new Random().nextInt(5) + 1;
        int y = new Random().nextInt(models.length);
        String randImg = models[y] + x;

        int id = getResources().getIdentifier(randImg, "drawable", getPackageName());

        return id;

    }
}