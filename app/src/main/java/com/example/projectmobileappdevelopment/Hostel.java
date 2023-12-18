package com.example.projectmobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hostel extends AppCompatActivity {

    Button OwnDtl, AddBtn, UpdtBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostel);
        OwnDtl = findViewById(R.id.ownDtlBtn);
        AddBtn = findViewById(R.id.AddLisBtn);
        UpdtBtn = findViewById(R.id.UptDtlBtn);

        OwnDtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(),HostelOwnerForm.class);
                startActivity(intent);
                finish();
            }
        });
        UpdtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(),HostelOwnerForm.class);
                startActivity(intent);
                finish();
            }
        });
        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(),HostelOwnerForm.class);
                startActivity(intent);
                finish();
            }
        });
    }
}