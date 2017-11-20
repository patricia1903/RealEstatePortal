package com.realestateportalandroid.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.realestateportalandroid.R;
import com.realestateportalandroid.model.Property;
import com.realestateportalandroid.model.PropertyList;

import java.util.List;


public class PropertyListActivity extends AppCompatActivity {

    PropertyList propertyList;
    List<Property> properties;

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertylist);

        propertyList = new PropertyList();
        properties = PropertyList.getProperties();

        listView = findViewById(R.id.listView);

        final ArrayAdapter<Property> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, properties);

        listView.setAdapter(arrayAdapter);


    }


}
