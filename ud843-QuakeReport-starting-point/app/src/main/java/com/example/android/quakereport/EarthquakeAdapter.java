package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.android.quakereport.R.id.cityname;
import static com.example.android.quakereport.R.id.magnitude;


public class EarthquakeAdapter extends ArrayAdapter<EarthquakeContainer> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context c, ArrayList<EarthquakeContainer> r) {

        super(c, 0, r);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;
        if (currentView == null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list, parent, false);
        }

        EarthquakeContainer currentEarthquake = getItem(position);
        Date d = currentEarthquake.getmDate();

        TextView dateView = (TextView) currentView.findViewById(R.id.date);
        dateView.setText(formatDate(d));

        TextView timeView = (TextView) currentView.findViewById(R.id.time);
        timeView.setText(formatTime(d));

        String city = currentEarthquake.getmCity();

        String primaryLocation;

        String locationOffset;

        if (city.contains(LOCATION_SEPARATOR)) {
            String[] parts = city.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = city;
        }

        TextView offsetName = (TextView) currentView.findViewById(R.id.offset);
        offsetName.setText(locationOffset);

        TextView cityName = (TextView) currentView.findViewById(R.id.cityname);
        cityName.setText(primaryLocation);

        double mag=currentEarthquake.getmMag();

        TextView magnitude = (TextView) currentView.findViewById(R.id.magnitude);
        magnitude.setText(formatMagnitude(mag));


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(mag);

        // Set the color on the magnitude circle
             magnitudeCircle.setColor(magnitudeColor);



        return currentView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd LLL, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }


    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        System.err.println(magnitudeFloor);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
