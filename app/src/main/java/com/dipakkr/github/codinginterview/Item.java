package com.dipakkr.github.codinginterview;

/**
 * Created by deepak on 24-12-2016.
 */

public class Item {
    private String mAvgAcess;
    private String mAvgSearch;
    private String mAvgInsert;
    private String mAvgDelete;

    private String mWorstAcess;
    private String mWorstSearch;
    private String mWorstInsert;
    private String mWorstDelete;

    public Item(String  AvgAcess,String AvgSearch,String AvgInsert,String AvgDelete,
                       String WorstAccess,String WorstSearch, String WorstInsert,String worstDelete){
        mAvgAcess=AvgAcess;
        mAvgDelete = AvgDelete;
        mAvgInsert = AvgInsert;
        mAvgSearch = AvgSearch;

        mWorstAcess = WorstAccess;
        mWorstDelete = worstDelete;
        mWorstInsert = WorstInsert;
        mWorstSearch = WorstSearch;
    }
    public String getmAvgAcess(){
        return mAvgAcess;
    }
    public String getmAvgSearch(){
        return mAvgSearch;
    }
    public String getmAvgInsert(){
        return mAvgInsert;
    }
    public String getmAvgDelete(){
        return mAvgDelete;
    }
    public String getmWorstAcess(){
        return mWorstAcess;
    }
    public String getmWorstSearch(){
        return mWorstSearch;
    }
    public String getmWorstInsert(){
        return mWorstInsert;
    }
    public String getmWorstDelete(){
        return mWorstDelete;
    }

}
