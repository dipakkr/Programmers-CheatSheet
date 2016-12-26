package com.dipakkr.github.codinginterview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by deepak on 27-12-2016.
 */

public class FirstFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_time_complexity,container,false);
        ViewPager viewPager = (ViewPager)rootview.findViewById(R.id.viewpager);

        SimpleFragmentAdapter adapter = new SimpleFragmentAdapter(getContext(), getActivity().getSupportFragmentManager());
        TabLayout tabLayout = (TabLayout)rootview.findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabTextColors(ContextCompat.getColor(getActivity(),R.color.color_unselected_tab),
                ContextCompat.getColor(getActivity(),R.color.color_text_primary));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return rootview;
    }

}
