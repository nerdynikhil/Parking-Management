package com.android.vanshika.parking.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.vanshika.parking.R;
import com.android.vanshika.parking.Room.AppDatabase;
import com.android.vanshika.parking.Room.User;
import com.android.vanshika.parking.Vehicle;
import com.android.vanshika.parking.adapter.BikeAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class TwoWheelFragment extends android.support.v4.app.Fragment {
BikeAdapter adapter;
RecyclerView recyclerView;
List<Vehicle> bikesParked;
  List<User> items;
  AppDatabase db;
  RecyclerView.LayoutManager mLayoutManager;
public static int itemCount;
    public TwoWheelFragment() {
      //required empty public constructor
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        Bundle savedInstanceState) {

      return inflater.inflate(R.layout.fragment_two, container, false);
    }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    recyclerView=getActivity().findViewById(R.id.recyclerView1);
    //bikesParked=new ArrayList<>();
    //addData();
    //adapter=new BikeAdapter(getActivity().getApplicationContext(),bikesParked);
    //RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
    //recyclerView.setLayoutManager(mLayoutManager);
    //recyclerView.setAdapter(adapter);

    db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "users")
        .build();
    new task().execute("");
    super.onViewCreated(view, savedInstanceState);
  }

  private void addData() {
    long mil = System.currentTimeMillis();
    Date date = new Date(mil);
    @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("hh:mm a");
    String hms = formatter.format(date);
      bikesParked.add(new Vehicle("4567",hms,20));
    bikesParked.add(new Vehicle("4547",hms,40));
    bikesParked.add(new Vehicle("bvkev",hms,20));
    bikesParked.add(new Vehicle("456fiwe7",hms,40));
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setHasOptionsMenu(true);
    }

  private class task extends AsyncTask<String,String,String> {


    @Override protected String doInBackground(String... strings) {
      items = db.userDao().getAllItems();
      itemCount=items.size();
      return null;
    }
    @Override protected void onPostExecute(String s) {
      super.onPostExecute(s);
      RecyclerView recyclerView = getActivity().findViewById(R.id.recyclerView1);
      mLayoutManager=new LinearLayoutManager(getActivity().getApplication(),LinearLayoutManager.VERTICAL,false);
      recyclerView.setItemAnimator(new DefaultItemAnimator());
      adapter=new BikeAdapter(getActivity().getApplicationContext(),items);
      recyclerView.setAdapter(adapter);
      recyclerView.setLayoutManager(mLayoutManager);

    }
  }
}


