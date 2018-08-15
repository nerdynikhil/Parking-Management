package com.android.vanshika.parking.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.vanshika.parking.R;

public class RecivedFragment extends android.support.v4.app.Fragment {
  TextView totalSum,queBike,queCar;
  public RecivedFragment() {
    //required empty constructor
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }


  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    View v=inflater.inflate(R.layout.fragment_recieved, container, false);
    totalSum=v.findViewById(R.id.totalSum);
    queBike=v.findViewById(R.id.numOfBikes);
    queCar=v.findViewById(R.id.numOfCars);
    int carTotal=0;
    carTotal = PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("CarPay",0);
    int bikeTotal=0;
    bikeTotal = PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("BikePay",0);
    totalSum.setText(String.valueOf(bikeTotal+carTotal));
    int numBikes= PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("BikeNumber",0);
    int numCars= PreferenceManager.getDefaultSharedPreferences(getContext()).getInt("CarNumber",0);
    queBike.setText(String.valueOf(numBikes));
    queCar.setText(String.valueOf(numCars));
    return v;
  }
}
