package com.android.vanshika.parking.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.vanshika.parking.R;

public class TwoWheelFragment extends Fragment{


    public TwoWheelFragment() {
      //required empty public constructor
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        Bundle savedInstanceState) {

      return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override public void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setHasOptionsMenu(true);
    }
  }


