package com.example.lab6;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {

    public FileOperations() {

    }

    public Boolean write(String surname, String group, String faculty) {
        try {

            String fPathSurname = "/sdcard/" + "surname" + ".txt";
            String fPathGroup = "/sdcard/" + "group" + ".txt";
            String fPathFaculty = "/sdcard/" + "faculty" + ".txt";

            File fileSurname = new File(fPathSurname);
            File fileGroup = new File(fPathGroup);
            File fileFaculty = new File(fPathFaculty);

            // If file does not exists, then create it
            if (!fileSurname.exists()) {
                fileSurname.createNewFile();
            }
            if (!fileGroup.exists()) {
                fileGroup.createNewFile();
            }
            if (!fileFaculty.exists()) {
                fileFaculty.createNewFile();
            }

            FileWriter fwSurname = new FileWriter(fileSurname.getAbsoluteFile());
            FileWriter fwGroup = new FileWriter(fileGroup.getAbsoluteFile());
            FileWriter fwFaculty = new FileWriter(fileFaculty.getAbsoluteFile());

            BufferedWriter bwSurname = new BufferedWriter(fwSurname);
            BufferedWriter bwGroup = new BufferedWriter(fwGroup);
            BufferedWriter bwFaculty = new BufferedWriter(fwFaculty);

            bwSurname.write(surname);
            bwGroup.write(group);
            bwFaculty.write(faculty);

            bwSurname.close();
            bwGroup.close();
            bwFaculty.close();

            Log.d("Suceess", "Sucess");
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public String read(String fname) {

        BufferedReader br = null;
        String response = null;

        try {

            StringBuffer output = new StringBuffer();
            String fpath = "/sdcard/" + fname + ".txt";

            br = new BufferedReader(new FileReader(fpath));
            String line = "";
            while ((line = br.readLine()) != null) {
                output.append(line + "/n");
            }
            response = output.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
        return response;

    }
}
