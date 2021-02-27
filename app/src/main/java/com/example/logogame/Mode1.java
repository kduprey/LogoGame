package com.example.logogame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Random;

public class Mode1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] models = {"a", "b", "c", "f", "h", "l", "mc", "me", "mi", "n", "p", "s", "te", "to", "v"};

    private String userSelection = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode1);
        ImageView img = (ImageView) findViewById(R.id.random_img);
        int id = getRandomImage();
        img.setImageResource(id);

        Spinner carSpinner = findViewById(R.id.model_list_spinner);
        if (carSpinner != null) {
            carSpinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.models_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (carSpinner != null) {
            carSpinner.setAdapter(adapter);
        }

    }

    public int getRandomImage() {
        int x = new Random().nextInt(5) + 1;
        int y = new Random().nextInt(models.length);
        String randImg = models[y] + x;

        int id = getResources().getIdentifier(randImg, "drawable", getPackageName());

        return id;

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        userSelection = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}