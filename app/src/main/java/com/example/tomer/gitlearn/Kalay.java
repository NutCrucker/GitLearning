package com.example.tomer.gitlearn;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Kalay extends AppCompatActivity {
    TextView A;
    Button B;
    Courts C = new Courts();
    CourtNum CC = new CourtNum();
    Changes D = new Changes();
    String M;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalay);
        SetUIView();
    }
    public void SetUIView(){
        A = (TextView)findViewById(R.id.Av);
        try {
            String M = C.execute("kalay").get();
            this.M = M;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        A.setText(M);
        B = (Button)findViewById(R.id.button);
        B.setX(500);
        B.setY(500);
    }

    public void Change(View V) throws ExecutionException, InterruptedException {
        D.execute("kalay");
        String M = CC.execute("kalay").get();
        A.setText(M);
        B.setX(9000);
        B.setY(9000);
    }
}
