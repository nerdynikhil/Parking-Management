package com.android.vanshika.parking;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.android.vanshika.parking.fragment.FourWheelFragment;
import com.android.vanshika.parking.fragment.RecivedFragment;
import com.android.vanshika.parking.fragment.TwoWheelFragment;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
TabLayout tabLayout;
Fragment twoWheelFragment;
  Fragment fourWheelFragment;
  Fragment recievedFragment;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    viewPager = (ViewPager) findViewById(R.id.viewpager);
    viewPager.setOffscreenPageLimit(3);
    setupViewPager(viewPager);
    tabLayout = (TabLayout) findViewById(R.id.tablayout);
    tabLayout.setupWithViewPager(viewPager);
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,AddVehicle.class);
        startActivity(intent);
      }
    });
  }
  private void setupViewPager(ViewPager viewPager)
  {
    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
    twoWheelFragment=new Fragment();
    fourWheelFragment=new Fragment();
    recievedFragment=new Fragment();
    adapter.addFragment(twoWheelFragment,"2-Wheelers");
    adapter.addFragment(fourWheelFragment,"4-Wheelers");
    adapter.addFragment(recievedFragment,"Recieved");
    viewPager.setAdapter(adapter);
  }
}
