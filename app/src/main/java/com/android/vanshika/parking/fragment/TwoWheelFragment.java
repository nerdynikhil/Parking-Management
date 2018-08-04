package com.android.vanshika.parking.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.vanshika.parking.R;
import com.android.vanshika.parking.Vehicle;
import com.android.vanshika.parking.adapter.BikeAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class TwoWheelFragment extends Fragment{
BikeAdapter adapter;
RecyclerView recyclerView;
List<Vehicle> bikesParked;
    public TwoWheelFragment() {
      //required empty public constructor
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        Bundle savedInstanceState) {
      recyclerView=getActivity().findViewById(R.id.recyclerView1);
      bikesParked=new ArrayList<>();
      addData();
        adapter=new BikeAdapter(bikesParked);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
      return inflater.inflate(R.layout.fragment_two, container, false);
    }

  private void addData() {
      bikesParked.add(new Vehicle("4567",Calendar.getInstance().getTime().toString(),20));
    bikesParked.add(new Vehicle("4547",Calendar.getInstance().getTime().toString(),40));
    bikesParked.add(new Vehicle("bvkev",Calendar.getInstance().getTime().toString(),20));
    bikesParked.add(new Vehicle("456fiwe7",Calendar.getInstance().getTime().toString(),40));
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setHasOptionsMenu(true);
    }
  }


