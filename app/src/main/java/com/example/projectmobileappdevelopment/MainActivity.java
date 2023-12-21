package com.example.projectmobileappdevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import user_dash_board.BottomNavigationBar;
import user_dash_board.UserDashboard;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button logoutbtn, HostelNavBtn, UserNav;
    TextView userDetails;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        logoutbtn = findViewById(R.id.LogoutBtn);
        userDetails = findViewById(R.id.user_details);
        HostelNavBtn = findViewById(R.id.HostleNav);
        UserNav = findViewById(R.id.Usernav);
        user = auth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            finish();

        }else{
            userDetails.setText(user.getEmail());
        }

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent =  new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();

            }
        });
        HostelNavBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(),Hostel.class);
                startActivity(intent);
                finish();
            }
        });
        UserNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getApplicationContext(), BottomNavigationBar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}