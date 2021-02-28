
package com.example.logogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMode1(View view) {
        Intent intent = new Intent(MainActivity.this, Mode1.class);
        startActivity(intent);
    }

    public void startMode2(View view) {
        Intent intent = new Intent(MainActivity.this, Mode2.class);
        startActivity(intent);
    }

    public void startMode3(View view) {
        Intent intent = new Intent(MainActivity.this, Mode3.class);
        startActivity(intent);
    }

    public void startMode4(View view) {
        Intent intent = new Intent(MainActivity.this, Mode4.class);
        startActivity(intent);
    }
}