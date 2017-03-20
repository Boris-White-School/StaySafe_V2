package com.example.pc.staysafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pc.staysafe.Common.PositionMemory;

public class InternetActivity extends AppCompatActivity {
    private TextView tips;
    private final PositionMemory position = new PositionMemory(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        tips = (TextView) findViewById(R.id.tip);
        tips.setText("Danger " + Integer.toString(position.getPosition()));
    }

    public void next(View view) {
        if (position.incrementPosition()) {
            tips.setText("Danger" + Integer.toString(position.getPosition()));
        } else {
            startActivity(new Intent(this, TestActivity.class));
        }
    }

    public void back (View view){
        if (position.decrementPosition()) {
            tips.setText("Danger " + Integer.toString(position.getPosition()));
        }
    }
}
