package com.android.vanshika.parking.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.vanshika.parking.R;
import com.android.vanshika.parking.Room.AppDatabase;
import com.android.vanshika.parking.Room.myuser;
import com.android.vanshika.parking.Vehicle;
import com.android.vanshika.parking.adapter.BikeAdapter;
import com.android.vanshika.parking.adapter.CarAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FourWheelFragment extends android.support.v4.app.Fragment {
  CarAdapter adapter;
  RecyclerView recyclerView;
  List<myuser> carsParked;
  public static int itemCount;
  AppDatabase db;
  RecyclerView.LayoutManager mLayoutManager;
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
    //carsParked=new ArrayList<>();
    //addData();
    //adapter=new BikeAdapter(carsParked);
    //RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
    //recyclerView.setLayoutManager(mLayoutManager);
    //recyclerView.setAdapter(adapter);
    db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "cars")
        .build();
    new task().execute("");
    //itemCount=carsParked.size();
    super.onViewCreated(view, savedInstanceState);
  }

  //private void addData() {
  //  long mil = System.currentTimeMillis();
  //  Date date = new Date(mil);
  //  @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("hh:mm a");
  //  String hms = formatter.format(date);
  //  carsParked.add(new Vehicle("4567",hms,60));
  //  carsParked.add(new Vehicle("4547",hms,40));
  //  carsParked.add(new Vehicle("bvkev",hms,60));
  //  carsParked.add(new Vehicle("456fiwe7",hms,40));
  //}

  private class task  extends AsyncTask<String,String,String>
  {
    @Override protected String doInBackground(String... strings) {
      carsParked=db.userDao().getAllCars();
      itemCount=carsParked.size();
      return null;
    }

    @Override protected void onPostExecute(String s) {
      super.onPostExecute(s);
      RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerView2);
      mLayoutManager=new LinearLayoutManager(getActivity().getApplication(),LinearLayoutManager.VERTICAL,false);
      recyclerView.setItemAnimator(new DefaultItemAnimator());
      adapter=new CarAdapter(getActivity().getApplicationContext(),carsParked);
      recyclerView.setAdapter(adapter);
      recyclerView.setLayoutManager(mLayoutManager);
    }
  }
}
