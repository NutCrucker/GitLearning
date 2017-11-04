package com.example.tomer.gitlearn;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView Head;
    Context context;
    Actions Act = new Actions();
    Spinner City,Court;
    ArrayAdapter<CharSequence> Cities,Courts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = getWindow().getDecorView().findViewById(android.R.id.content);
        context = view.getContext();
        SetUIView();
        City.setOnItemSelectedListener(this);
        Court.setOnItemSelectedListener(this);
    }



    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String Choice = parent.getItemAtPosition(pos).toString();
        switch(Choice){
            case "גבעתיים":
                Courts = ArrayAdapter.createFromResource(this,R.array.givataim,android.R.layout.simple_spinner_item);
                Courts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Court.setAdapter(Courts);
                break;
            case "תל-אביב":
                Courts = ArrayAdapter.createFromResource(this,R.array.telaviv,android.R.layout.simple_spinner_item);
                Courts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Court.setAdapter(Courts);
                break;
            case "בחר עיר":
                Courts = ArrayAdapter.createFromResource(this,R.array.empty,android.R.layout.simple_spinner_item);
                Courts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Court.setAdapter(Courts);
                break;
            case "קלעי":
                startActivity(new Intent(getApplicationContext(),Kalay.class));
                MainActivity.this.finish();
                break;
        }
    }
    public void onNothingSelected(AdapterView<?> parent) {

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
        Court=(Spinner) findViewById(R.id.Court);
        Court.setX(Act.getWidth(context)/2 - 350);
        Court.setY(City.getY()+200);
    }



}
