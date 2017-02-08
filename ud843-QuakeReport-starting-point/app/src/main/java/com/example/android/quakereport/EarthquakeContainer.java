package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by flexi on 20-10-2016.
 */

public class EarthquakeContainer {

    private double mMag;

    private String mCity;

    private Date mDate;

    private String murl;

    public EarthquakeContainer(double mag,String city,Date date,String url){

        mMag=mag;

        mCity=city;

        mDate=date;

        murl=url;
    }

    public Date getmDate() {

        return mDate;
    }



    public String getmCity() {
        return mCity;
    }

    public Double getmMag() {
        return mMag;
    }

    public String getMurl() {
        return murl;
    }
}
