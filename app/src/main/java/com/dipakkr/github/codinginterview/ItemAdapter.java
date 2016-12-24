package com.dipakkr.github.codinginterview;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by deepak on 24-12-2016.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

  public ItemAdapter(Activity context,ArrayList<Item> items){
      super(context,0,items);
  }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Item item = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ui_list_items,parent,false);
        }
        TextView avgAccess = (TextView)convertView.findViewById(R.id.avg_acess);
        TextView avgSearch = (TextView)convertView.findViewById(R.id.avg_search);
        TextView avgInsert = (TextView)convertView.findViewById(R.id.avg_insert);
        TextView avgDelete = (TextView)convertView.findViewById(R.id.avg_delete);

        TextView worstAccess = (TextView)convertView.findViewById(R.id.worst_access);
        TextView worstSearch = (TextView)convertView.findViewById(R.id.worst_search);
        TextView worstInsert = (TextView)convertView.findViewById(R.id.worst_insert);
        TextView worstDelete = (TextView)convertView.findViewById(R.id.worst_delete);

        avgAccess.setText(item.getmAvgAcess());
        avgSearch.setText(item.getmAvgSearch());
        avgInsert.setText(item.getmAvgInsert());
        avgDelete.setText(item.getmAvgDelete());

        worstAccess.setText(item.getmWorstAcess());
        worstSearch.setText(item.getmWorstSearch());
        worstInsert.setText(item.getmWorstInsert());
        worstDelete.setText(item.getmWorstDelete());
      return convertView;
    }
}
