package com.android.vanshika.parking.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.vanshika.parking.R;

public class FourWheelFragment extends Fragment {
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
}
