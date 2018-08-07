package com.android.vanshika.parking.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.vanshika.parking.R;
import com.android.vanshika.parking.Vehicle;
import com.android.vanshika.parking.adapter.BikeAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FourWheelFragment extends android.support.v4.app.Fragment {
  BikeAdapter adapter;
  RecyclerView recyclerView;
  List<Vehicle> carsParked;
  public static int itemCount;
  public FourWheelFragment() {
    //requiredEmtyConstructor
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
  }


  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_four, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    recyclerView=getActivity().findViewById(R.id.recyclerView2);
    carsParked=new ArrayList<>();
    addData();
    adapter=new BikeAdapter(carsParked);
    RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setAdapter(adapter);
    itemCount=carsParked.size();
    super.onViewCreated(view, savedInstanceState);
  }

  private void addData() {
    long mil = System.currentTimeMillis();
    Date date = new Date(mil);
    @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("hh:mm a");
    String hms = formatter.format(date);
    carsParked.add(new Vehicle("4567",hms,60));
    carsParked.add(new Vehicle("4547",hms,40));
    carsParked.add(new Vehicle("bvkev",hms,60));
    carsParked.add(new Vehicle("456fiwe7",hms,40));
  }
}
