package com.example.tomer.gitlearn;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Head;
    Context context;
    Actions Act = new Actions();
    Spinner City;
    ArrayAdapter<CharSequence> Cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = getWindow().getDecorView().findViewById(android.R.id.content);
        context = view.getContext();
        SetUIView();

    }
    public void SetUIView(){
        Head=(TextView) findViewById(R.id.Head);
        Head.setX(Act.getWidth(context)/2 - 350);
        Head.setY(500);
        City=(Spinner) findViewById(R.id.City);
        Cities = ArrayAdapter.createFromResource(this,R.array.cities,android.R.layout.simple_spinner_item);
        Cities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        City.setAdapter(Cities);
        City.setX(Act.getWidth(context)/2 - 350);
        City.setY(Head.getY()+250);
    }



}
