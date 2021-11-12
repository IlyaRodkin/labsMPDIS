package com.example.lab6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText fSurname, fGroup, fFaculty;
    Button write, readSurname, readGroup, readFaculty;
    TextView filecon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fSurname = (EditText) findViewById(R.id.f_surname);
        fGroup = (EditText) findViewById(R.id.f_group);
        fFaculty = (EditText) findViewById(R.id.f_faculty);
        write = (Button) findViewById(R.id.btnwrite);
        readSurname = (Button) findViewById(R.id.b_surname);
        readGroup = (Button) findViewById(R.id.b_group);
        readFaculty = (Button) findViewById(R.id.b_faculty);
        filecon = (TextView) findViewById(R.id.filecon);

        write.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String surname = fSurname.getText().toString();
                String group = fGroup.getText().toString();
                String faculty = fFaculty.getText().toString();


                FileOperations fop = new FileOperations();

                if (fop.write(surname, group, faculty)) {
                    Toast.makeText(getApplicationContext(), "successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "I/O error", Toast.LENGTH_SHORT).show();

                }
            }
        });

        readSurname.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                FileOperations fop = new FileOperations();
                String text = fop.read("surname");
                if (text != null) {
                    filecon.setText(text);
                } else {
                    Toast.makeText(getApplicationContext(), "File not Found", Toast.LENGTH_SHORT).show();
                    filecon.setText(null);
                }

            }
        });

        readGroup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                FileOperations fop = new FileOperations();
                String text = fop.read("group");
                if (text != null) {
                    filecon.setText(text);
                } else {
                    Toast.makeText(getApplicationContext(), "File not Found", Toast.LENGTH_SHORT).show();
                    filecon.setText(null);
                }

            }
        });

        readFaculty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                FileOperations fop = new FileOperations();
                String text = fop.read("faculty");
                if (text != null) {
                    filecon.setText(text);
                } else {
                    Toast.makeText(getApplicationContext(), "File not Found", Toast.LENGTH_SHORT).show();
                    filecon.setText(null);
                }

            }
        });
    }
}