package com.realestateportalandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.realestateportalandroid.R;
import com.realestateportalandroid.model.Property;
import com.realestateportalandroid.model.PropertyList;

public class PropertyDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertydetails);

        final Property property = (Property) getIntent().getExtras().getSerializable("property");

        final TextView id = findViewById(R.id.idTextView);
        final EditText titleEditText = findViewById(R.id.titleEditText);
        final EditText descriptionEditText = findViewById(R.id.descriptionEditText);
        final EditText priceEditText = findViewById(R.id.priceEditText);
        final EditText addressEditText = findViewById(R.id.addressEditText);
        final EditText phoneEditText = findViewById(R.id.phoneEditText);
        final EditText emailEditText = findViewById(R.id.emailEditText);


        id.setText(property.getId());
        titleEditText.setText(property.getTitle());
        descriptionEditText.setText(property.getDescription());
        priceEditText.setText(property.getPrice());
        addressEditText.setText(property.getAddress());
        emailEditText.setText(property.getEmail());
        phoneEditText.setText(property.getPhone());


        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Property p = new Property();
                p.setTitle(titleEditText.getText().toString());
                p.setDescription(descriptionEditText.getText().toString());
                p.setId(id.getText().toString());
                p.setPrice(priceEditText.getText().toString());
                p.setAddress(addressEditText.getText().toString());
                p.setEmail(emailEditText.getText().toString());
                p.setPhone(phoneEditText.getText().toString());

                PropertyList.updateProperties(p);

                finish();
            }
        });
    }

}
