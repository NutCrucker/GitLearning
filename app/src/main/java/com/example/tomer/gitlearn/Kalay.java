package com.example.tomer.gitlearn;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class Kalay extends AppCompatActivity {
    TextView A;
    Courts C = new Courts();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalay);
        A = (TextView)findViewById(R.id.Av);
        A.setText((CharSequence) C.execute("kalay"));
        }
}
