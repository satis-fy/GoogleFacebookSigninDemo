package com.example.googlesingindemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class Facebook_Account extends AppCompatActivity {
    private CircleImageView circleImageView;
    private TextView txtName, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook__account);

        txtName = findViewById(R.id.Aprofile_name);
        txtEmail = findViewById(R.id.Aprofile_email);
        circleImageView = findViewById(R.id.Aprofile_pic);

        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        if (sharedpreferences != null) {
            try {
                txtName.setText(sharedpreferences.getString("Name", null));
                txtEmail.setText(sharedpreferences.getString("Email", null));
                String img=sharedpreferences.getString("ProfilePicture", null);
                //circleImageView.setImageResource(BitmapFactory.decodeFile(img));
                Glide.with(Facebook_Account.this).load(img).into(circleImageView);

            } catch (Exception e) {
            }
        }


    }

    public void AFacebookLogout(View view) {
        LoginManager.getInstance().logOut();
        finish();
        startActivity(new Intent(Facebook_Account.this, MainActivity.class));
    }

}
