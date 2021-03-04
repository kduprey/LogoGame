package com.example.logogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class Mode1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private final String[] imgName = {"a", "b", "c", "f", "h", "l", "mc", "me", "mi", "n", "p", "s", "te", "to", "v"};
    private final String[] modelNames = {"Audi", "BMW", "Cadillac", "Ford", "Honda", "Lexus", "McLaren", "Mercedes", "Mini Cooper", "Nissan", "Porsche", "Subaru", "Tesla", "Toyota", "Volkswagen"};

    private String userSelection = "";
    private boolean winStatus = false;
    private String displayedImg = "";
    private String displayedModel = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode1);

        setRandomImage();

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

    public void setRandomImage() {
        ImageView img = findViewById(R.id.random_img);

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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        userSelection = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void submitAnswer(View view) {


//        On submit check if spinner selection is correct
        for (int i = 0; i < imgName.length; i++) {

            if (userSelection.toLowerCase().charAt(0) == displayedImg.charAt(0) && userSelection.toLowerCase().charAt(1) == displayedImg.charAt(1)) {
//              If correct, display green text "CORRECT!"
                winStatus = true;
                setStatus(winStatus);
                System.out.println("Correct");
            } else if (userSelection.toLowerCase().charAt(0) == displayedImg.charAt(0)) {
//              If correct, display green text "CORRECT!"
                winStatus = true;
                setStatus(winStatus);
                System.out.println("Correct");
            } else {
//            If incorrect, display red text "Incorrect"
                winStatus = false;
                setStatus(winStatus);

//            Display correct car make in yellow

                TextView x = findViewById(R.id.car_model_textview);
                x.setText(displayedModel);
                System.out.println("Incorrect");

            }

        }

//            Change button text to next
    }

    public void setStatus(boolean winStatus) {
       TextView x = findViewById(R.id.win_status_textview);
       Button y = findViewById(R.id.identify_btn);

       //       If winStatus change color to green and display winning text
        if (winStatus) {
            x.setText(R.string.win_txt);
            x.setTextColor(getResources().getColor(R.color.winning_green));


            y.setText(R.string.next);
            y.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetLevel();
                }
            });
        }
//       If lose change color to red and display losing text
        if (!winStatus) {

//            Display losing text and change text color to red
            x.setText(R.string.lose_txt);
            x.setTextColor(getResources().getColor(R.color.losing_red));

//            Change Submit button text and method
            y.setText(R.string.next);
            y.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetLevel();
                }
            });
        }
    }
    public void resetLevel() {
        TextView x = findViewById(R.id.car_model_textview);
        x.setText("");
        TextView y = findViewById(R.id.win_status_textview);
        y.setText("");

        Button z = findViewById(R.id.identify_btn);
        z.setText(R.string.identify_btn_text);
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAnswer(v);
            }
        });

        setRandomImage();
    }


}