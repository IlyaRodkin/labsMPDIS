package com.example.lab3;


import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {


    private Button switchToGreen;
    private Button switchToRed;
    private Button switchToBlue;
    private Button switchToYellow;
    private Button switchToImage;
    private Button dialog;
    private Dialog dialogTmp;
    private LinearLayout screenLayout;
    private Toast informationToast;


    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init buttons
        switchToBlue = (Button) findViewById(R.id.switchBlue);
        switchToGreen = (Button) findViewById(R.id.switchGreen);
        switchToRed = (Button) findViewById(R.id.switchRed);
        switchToYellow = (Button) findViewById(R.id.switchBlack);
        switchToImage = (Button) findViewById(R.id.image);
        dialog = (Button) findViewById(R.id.dialog);


        screenLayout = (LinearLayout) switchToBlue.getParent();

        // setup listeners
        switchToBlue.setOnClickListener(this);
        switchToRed.setOnClickListener(this);
        switchToGreen.setOnClickListener(this);
        switchToYellow.setOnClickListener(this);
        switchToImage.setOnClickListener(this);
        dialog.setOnClickListener(this);

        informationToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);

    }


    public void onClick(View view) {

        if (switchToBlue.equals(view)) {
            screenLayout.setBackgroundColor(Color.BLUE);
            showToast("Hello blue");
        } else if (switchToRed.equals(view)) {
            screenLayout.setBackgroundColor(Color.RED);
            showToast("Hello red");
        } else if (switchToGreen.equals(view)) {
            screenLayout.setBackgroundColor(Color.GREEN);
            showToast("Hello green");
        }else if (switchToYellow.equals(view)) {
            screenLayout.setBackgroundColor(Color.YELLOW);
            showToast("Hello yellow");
        }else if (switchToImage.equals(view)) {
            screenLayout.setBackground(getResources().getDrawable(R.drawable.ic_launcher_background,null));
        }else if (dialog.equals(view)) {

            dialogTmp = new Dialog(MainActivity.this);

            dialogTmp.setContentView(R.layout.dialog_view);
            dialogTmp.show();
        }


    }


    private void showToast(String text) {
        informationToast.cancel();
        informationToast.setText(text);
        informationToast.show();
    }
}