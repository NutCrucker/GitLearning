package com.example.tomer.gitlearn;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Kalay extends AppCompatActivity {
    TextView A;
    Courts C = new Courts();
    String M;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalay);
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
    }
}
