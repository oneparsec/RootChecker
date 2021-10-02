package com.oneparsec.rootchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.File;



public class MainActivity extends AppCompatActivity {

    String version = "1.1.1";

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
        Button closeButton = (Button) findViewById(R.id.closeB);
        TextView footer = (TextView) findViewById(R.id.footerT);
        FloatingActionButton githubF = (FloatingActionButton) findViewById(R.id.githubF);

        footer.setText("Root Checker by OneParsec. Version: " + version + ".");

        githubF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("http://github.com/OneParsec/RootChecker"); Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl); startActivity(launchBrowser);
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkRootMethod1() == true){
                    status.setText("Yes");
                    checkButton.setEnabled(false);
                }
                else{
                    status.setText("No");
                    checkButton.setEnabled(false);
                }
            }
        });
    }

}