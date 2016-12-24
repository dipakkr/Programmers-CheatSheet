package com.dipakkr.github.codinginterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by deepak on 24-12-2016.
 */

public class BSTFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.frag_bst,container,false);
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("O(log(n)","O(log(n)","O(log(n)","O(log(n)","O(n)","O(n)","O(n)","O(n)"));
        ItemAdapter adapter = new ItemAdapter(getActivity(),items);
        ListView arraystack = (ListView)rootview.findViewById(R.id.list_bst);
        arraystack.setAdapter(adapter);
        return rootview;
    }

}
