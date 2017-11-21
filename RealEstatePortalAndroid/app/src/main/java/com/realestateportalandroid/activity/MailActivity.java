package com.realestateportalandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.realestateportalandroid.R;


public class MailActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        Button mailBtn = findViewById(R.id.sendEmailBtn);
        mailBtn.setOnClickListener(this);

        emailContent = findViewById(R.id.emailContentText);
    }

    @Override
    public void onClick(View view) {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ardelean.patricia@gmail.com"});
        intent.putExtra(Intent.EXTRA_TEXT, this.emailContent.getText());
        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "Open with"));
    }
}
