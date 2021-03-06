package com.realestateportalandroid.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.realestateportalandroid.R;
import com.realestateportalandroid.model.Property;
import com.realestateportalandroid.model.PropertyList;

import java.util.List;


public class PropertyListActivity extends AppCompatActivity {

    PropertyList propertyList;
    List<Property> properties;

    ListView listView;
    PropertyListAdapter arrayAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertylist);

        propertyList = new PropertyList();
        properties = PropertyList.getProperties();

        listView = findViewById(R.id.listView);

        arrayAdapter = new PropertyListAdapter(this, properties);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Property property = arrayAdapter.getItem(i);
                Intent intent = new Intent(view.getContext(), PropertyDetailsActivity.class);
                intent.putExtra("property", property);
                startActivityForResult(intent,1);
            }
        });


        findViewById(R.id.contactUs).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(),MailActivity.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        arrayAdapter.notifyDataSetChanged();
    }



    private class PropertyListAdapter extends ArrayAdapter<Property> {
        private List<Property> properties;
        private Context context;

        public PropertyListAdapter(Context context, List<Property> properties) {
            super(context, -1, properties);
            this.properties = properties;
            this.context = context;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.row_propertylist, parent, false);

            Property property = getItem(position);

            TextView textView = rowView.findViewById(R.id.firstLine);
            textView.setText(property.getTitle());

            TextView textView2 = rowView.findViewById(R.id.secondLine);
            textView2.setText(property.getPrice());


            ImageView imageView = rowView.findViewById(R.id.icon);
            imageView.setImageResource(R.drawable.re);

            return rowView;
        }
    }


}
