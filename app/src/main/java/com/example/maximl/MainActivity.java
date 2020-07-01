package com.example.maximl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent serviceIntent = new Intent(this, ExampleService.class);
        startService(serviceIntent);

    }

    public  void startService(View v){

        startActivity(new Intent(MainActivity.this, WebViewActivity.class));
    }
    public  void stopService(View v){
        Intent serviceIntent = new Intent(this, ExampleService.class);
        stopService(serviceIntent);

    }
}