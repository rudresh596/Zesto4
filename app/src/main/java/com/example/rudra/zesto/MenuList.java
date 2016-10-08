package com.example.rudra.zesto;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by Rudra on 26-05-2016.
 */
public class MenuList extends BaseAdapter implements ListAdapter {

    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<Integer> image = new ArrayList<Integer>();
    private Context context;


    public MenuList(ArrayList<String> list, ArrayList<Integer> image, Context context) {
        this.list = list;
        this.context = context;
        this.image = image;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);

    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.single_menu, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView) view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position));

        ImageView menuPic = (ImageView) view.findViewById(R.id.img);
        menuPic.setImageResource(image.get(position));

        //Handle buttons and add onClickListeners
        final ImageButton addBtn = (ImageButton) view.findViewById(R.id.addbtn);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                addBtn.setVisibility(v.GONE); //or some other task
                Toast.makeText(context, "Added, Swipe to check Orders", Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
            }
        });

        return view;
    }

}