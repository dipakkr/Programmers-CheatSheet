package com.dipakkr.github.codinginterview;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by deepak on 21-12-2016.
 */
public class SimpleFragmentAdapter extends FragmentPagerAdapter {
    private Context mContext;
    public SimpleFragmentAdapter(Context context, FragmentManager fragmentManager){
        super(fragmentManager);
        mContext = context;
    }
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ArrayFragment();
        }
        else if (position == 1) {
            return new StackFragment();
        } else if (position == 2) {
            return new QueueFragment();
        } else if (position == 3) {
            return new SingleLinkedListFragment();
        } else if (position == 4) {
            return new DoubleLLFragment();
        } else if (position == 5) {
            return new BtreeFragment();
        } else if (position == 6) {
            return new BSTFragment();
        } else if (position == 7) {
            return new HashTableFragment();
        }
        else
            return new AVLTreeFragment();
    }
    @Override
    public int getCount() {
        return 8;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.tab_title_one);
        } else if (position == 1) {
            return mContext.getString(R.string.tab_title_two);
        } else if (position == 2) {
            return mContext.getString(R.string.tab_title_three);
        } else if (position == 3) {
            return mContext.getString(R.string.tab_title_four);
        }else if(position ==4){
            return mContext.getString(R.string.tab_title_five);
        }else if(position ==5){
            return mContext.getString(R.string.tab_title_six);
        }else if(position == 6){
            return mContext.getString(R.string.tab_title_seven);
        }
        else
            return mContext.getString(R.string.tab_title_seven);
    }
}
