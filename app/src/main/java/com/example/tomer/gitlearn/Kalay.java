package com.example.tomer.gitlearn;
import android.content.Context;
import android.content.Intent;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Kalay extends AppCompatActivity {
    TextView A,T;
    Button B,Main;
    Courts C = new Courts();
    CourtNum CC = new CourtNum();
    Changes D = new Changes();
    String M,Name;
    Actions Yo= new Actions();
    ImageView Button;
    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalay);
        View view = getWindow().getDecorView().findViewById(android.R.id.content);
        context = view.getContext();
        SetUIView();
    }
    public void SetUIView(){
        Bundle bundle = getIntent().getExtras();
        String Get = bundle.getString("name");
        String Title = bundle.getString("title");
        T = (TextView) findViewById(R.id.title);
        T.setText(Title);
        this.Name = Get;
        int Width = Yo.getWidth(context);
        A = (TextView)findViewById(R.id.Av);
        A.setX(Width/2 - 250);
        A.setY(250);
        T.setX(Width/2 - 350);
        T.setY(1000);
        try {
            String M = C.execute(Get).get();
            this.M = M;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        A.setText(M);
        String Bulbul = A.getText().toString();
        Button = (ImageView)findViewById(R.id.button);
        Button.setX(A.getX()-125);
        Button.setY(250);
        if(Bulbul.equals("Free")){
            Button.setImageResource(R.mipmap.freebt);
        }
        Main = (Button)findViewById(R.id.main);
        Main.setY(500);
        Main.setX(100);
        B = (Button)findViewById(R.id.cange);
        B.setX(Main.getX()+740);
        B.setY(500);
    }

    public void Change(View V) throws ExecutionException, InterruptedException {
        D.execute(Name);
        String M = CC.execute(Name).get();
        A.setText(M);
        String Bulbul = A.getText().toString();
        if(Bulbul.equals("Free")){
            Button.setImageResource(R.mipmap.freebt);
        }
        else{
            Button.setImageResource(R.mipmap.caughtbt);
        }
        B.setX(9000);
        B.setY(9000);
    }

    public void toMain(View V){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        Kalay.this.finish();
    }
}
