package org.d3ifcool.com.listdata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends ArrayAdapter<Data> {

    DataAdapter(Context context, ArrayList<Data> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Data currentData = getItem(position);

        TextView name = convertView.findViewById(R.id.name_TextView);
        TextView version = convertView.findViewById(R.id.version_TextView);
        TextView desc = convertView.findViewById(R.id.desc_TextView);

        ImageView image = convertView.findViewById(R.id.image_Data);

        image.setImageResource(currentData.getImage());
        name.setText(currentData.getName());
        version.setText(currentData.getVersion());
        desc.setText(currentData.getDescription());

        return convertView;
    }
}
