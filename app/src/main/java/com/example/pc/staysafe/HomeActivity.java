package com.example.pc.staysafe;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * The method will take care of all button belonging to HomeActivity activity
     *
     * Specifying this method in android:onclick in .xml file is needed, id of the buttons required
     * <b>WARNING</b>: if button that use this method doesn`t have an id, app will crash clicked
     * Recommendation: use this method only to start activities & very simple stuff; max 10 lines
     * each case statement maybe?
     *
     * @param view the button which id used
     */
    public void onHomeButtonClick(View view) {
        switch (view.getId()) {
            case R.id.Home_btn_dangers:
                Log.w(getLocalClassName(), "Home_btn_dangers");
                chooseTopicDialog();
                break;

            case R.id.Home_btn_avoid:
                Log.w(getLocalClassName(), "Home_btn_avoid");

                // No activity yet
                Toast.makeText(this, "No activity yet", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Home_btn_tips:
                Log.w(getLocalClassName(), "Home_btn_tips");

                // No activity yet
                Toast.makeText(this, "No activity yet", Toast.LENGTH_SHORT).show();
                break;

            case R.id.dialog_home_btn_internet:
                Log.w(getLocalClassName(), "danger_btn_internet");
                startActivity(new Intent(getBaseContext(), InternetActivity.class));
                break;

            case R.id.dialog_home_btn_realLife:
                Log.w(getLocalClassName(), "danger_btn_realLife");

                // No activity yet
                Toast.makeText(this, "No activity yet", Toast.LENGTH_SHORT).show();
                break;

            case R.id.logout:
                Log.w(getLocalClassName(), "logout");
                startActivity(new Intent(getBaseContext(), Login.class));
                break;
        }
    }

    /**
     * Show the DialogAlert
     */
    private void chooseTopicDialog() {
        View view = View.inflate(this, R.layout.dialog_home_choose, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(view);
        dialog = builder.create();
        dialog.show();

        Button internet = (Button) view.findViewById(R.id.dialog_home_btn_internet);
        Button realLife = (Button) view.findViewById(R.id.dialog_home_btn_realLife);
        internet.setOnClickListener(new CustomOnClickListener());
        realLife.setOnClickListener(new CustomOnClickListener());
    }

    /**
     * Custom class
     *
     * Buttons in view need OnClickListener to act, this class act like onClickListener, but
     * onClick method start the {@link #onHomeButtonClick(View)}, which take care of the buttons
     */
    private class CustomOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            dialog.cancel();
            onHomeButtonClick(view);
        }
    }
}
