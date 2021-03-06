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

public class Mode2 extends AppCompatActivity {

    private final String[] imgName = {"a", "b", "c", "f", "h", "l", "mc", "me", "mi", "n", "p", "s", "te", "to", "v"};
    private final String[] modelNames = {"Audi", "BMW", "Cadillac", "Ford", "Honda", "Lexus", "McLaren", "Mercedes", "Mini Cooper", "Nissan", "Porsche", "Subaru", "Tesla", "Toyota", "Volkswagen"};

    private String displayedImg = "";
    private String displayedModel = "";
    private String blankString = "";
    private int tries = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode2);

        setRandomImage();
        setBlanks();

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

    public void setBlanks() {
        TextView x = findViewById(R.id.blank_car_name);
        blankString = "";

        for (int i = 0; i < displayedModel.length(); i++)
            blankString = blankString.concat("-");
        x.setText(blankString);
    }

    public void checkUserEntry(View view) {
        EditText x = findViewById(R.id.user_entry);
        TextView y = findViewById(R.id.blank_car_name);
        TextView z = findViewById(R.id.win_status);
        Button btn = findViewById(R.id.submit_button);
        boolean correct = false;

        if (x.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Enter a character", Toast.LENGTH_SHORT).show();
        } else {
            char userInput = x.getText().toString().toLowerCase().charAt(0);

            x.getText().clear();

            for (int i = 0; i < displayedModel.length(); i++) {
                if (userInput == displayedModel.toLowerCase().charAt(i)) {
//                Display the corresponding letter in the space
                    blankString = blankString.substring(0, i) + displayedModel.charAt(i) + blankString.substring(i + 1);
                    correct = true;
                }
            }

            if (!correct)
                tries++;

            System.out.println("Tries: " + tries);
            System.out.println("Blank string: " + blankString);
            if (tries < 3 && !blankString.toLowerCase().equals(displayedModel.toLowerCase()))
                y.setText(blankString);
            else {
                System.out.println("Here 1");
                if (blankString.toLowerCase().equals(displayedModel.toLowerCase())) {
                    System.out.println("Here 2");
                    y.setText(displayedModel);
                    z.setText(R.string.win_txt);
                    z.setTextColor(getResources().getColor(R.color.winning_green));
                } else {
                    System.out.println("Here 3");
                    z.setText(R.string.lose_txt);
                    z.setTextColor(getResources().getColor(R.color.losing_red));
                    y.setTextColor(getResources().getColor(R.color.car_model_yellow));
                    y.setText(displayedModel);
                }
                btn.setText(R.string.next);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        y.setTextColor(getResources().getColor(R.color.black));
                        z.setText("");

                        resetMode();
                        tries = 0;
                    }
                });
            }
        }
    }

    public void resetMode() {
        Button x = findViewById(R.id.submit_button);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserEntry(v);
            }
        });
        setRandomImage();
        setBlanks();
    }

}