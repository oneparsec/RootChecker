package com.oneparsec.rootchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {


    private static boolean checkRootMethod1() {
        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
                "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (String path : paths) {
            if (new File(path).exists()) return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView status = (TextView) findViewById(R.id.statusT);
        Button checkButton = (Button) findViewById(R.id.checkB);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkRootMethod1() == true){
                    status.setText("Root Access: Yes");
                    checkButton.setText("Re-check root access");
                }
                else{
                    status.setText("Root Access: No");
                    checkButton.setText("Re-check root access");
                }
            }
        });
    }

}