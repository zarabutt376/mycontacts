package com.example.back;

import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Context;

import androidx.annotation.NonNull;
import android.content.Intent;
import android.content.Context;
public class ContactList extends ListActivity {

    ListView listView;
    String menuitems[] = {
            "Menu Item 1",
            "Menu Item 2",
            "Menu Item 3",
            "Menu Item ",
            "Menu Item ",
            "Menu Item ",

    };


    int imageid[] = {
            R.drawable.lady,
            R.drawable.girl,
            R.drawable.biggirl1,
            R.drawable.man2,
            R.drawable.biggirl,
            R.drawable.girl4,  };

String name[]={"Amna Ismail","Rabia Nadeem","Hamza Ehsan","Sara Waseem","Samra Hijab","Laiba Zahid"};

String number[]={"(650)555-1234","(345)777-9876","(002)998-9654","(998)222-0987","(765)3443-5656","(543)111-9832"};
    String email[]={"amna_ismail@gmail.com","rabia_nadeem@yahoo.com","hamza_ehsan@yahoo.com","sara_waseem@gmail.com","samra_hijab@hotmail.com","laiba_zahid@yahoo.com"};








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);



        listView = findViewById(android.R.id.list);
        MyAdapter adapter = new MyAdapter(this, menuitems, imageid);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), Contact1.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", imageid[0]);

                    intent.putExtra("position", "" + 0);
                    startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), Contact2.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", imageid[1]);

                    intent.putExtra("position", "" + 1);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), Contact3.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", imageid[2]);

                    intent.putExtra("position", "" + 2);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), Contact4.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", imageid[3]);

                    intent.putExtra("position", "" + 3);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), Contact5.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", imageid[4]);

                    intent.putExtra("position", "" + 4);
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), Contact6.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", imageid[5]);

                    intent.putExtra("position", "" + 5);
                    startActivity(intent);
                }
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String menuitems[];
        int imageid[];
        String name[];
        String number[];
        String email[];

        MyAdapter(Context c, String menuitem[], int imageid[]) {
            super(c, R.layout.rox_item,R.id.textView1, menuitem);
            this.context = c;
            this.menuitems = menuitem;
            this.imageid = imageid;

        }
@NonNull
@Override
        public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           View row=layoutInflater.inflate(R.layout.rox_item,parent,false);
            ImageView image=row.findViewById(R.id.imageViewFlag);
            TextView textView=row.findViewById(R.id.textView1);
            image.setImageResource(imageid[position]);
            textView.setText(menuitems[position]);

            return row;
        }
    }
}