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
import android.widget.TextView;
import com.android.vanshika.parking.fragment.FourWheelFragment;
import com.android.vanshika.parking.fragment.RecivedFragment;
import com.android.vanshika.parking.fragment.TwoWheelFragment;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
TabLayout tabLayout;
Fragment twoWheelFragment;
  Fragment fourWheelFragment;
  Fragment recievedFragment;
  String[] tabTitle={"Bike","Car","Recieved"};
  int[] unreadCount={0,5,0};
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    viewPager = (ViewPager) findViewById(R.id.viewpager);
    viewPager.setOffscreenPageLimit(3);
    ViewPagerAdapter adapter=new ViewPagerAdapter(this,getSupportFragmentManager());
    viewPager.setAdapter(adapter);
    //setupViewPager(viewPager);
    tabLayout = (TabLayout) findViewById(R.id.tablayout);
    tabLayout.setupWithViewPager(viewPager);

    //viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    //  @Override
    //  public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    //
    //  }
    //
    //  @Override public void onPageSelected(int position) {
    //    viewPager.setCurrentItem(position,false);
    //
    //  }
    //
    //  @Override public void onPageScrollStateChanged(int state) {
    //
    //  }
    //});
    //setupViewPager(viewPager);
    unreadCount[0]=TwoWheelFragment.itemCount;
    unreadCount[1]=FourWheelFragment.itemCount;

    try
    {
      setupTabIcons();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,AddVehicle.class);
        startActivity(intent);
      }
    });
  }

  private void setupTabIcons() {
    for(int i=0;i<tabTitle.length;i++)
    {
            /*TabLayout.Tab tabitem = tabLayout.newTab();
            tabitem.setCustomView(prepareTabView(i));
            tabLayout.addTab(tabitem);*/

      tabLayout.getTabAt(i).setCustomView(prepareTabView(i));
    }
  }

  private View prepareTabView(int pos) {
    View view = getLayoutInflater().inflate(R.layout.custom_tab,null);
    TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
    TextView tv_count = (TextView) view.findViewById(R.id.tv_count);
    tv_title.setText(tabTitle[pos]);
    if(unreadCount[pos]>0)
    {
      tv_count.setVisibility(View.VISIBLE);
      tv_count.setText(""+unreadCount[pos]);
    }
    else
      tv_count.setVisibility(View.GONE);


    return view;
  }

  //private void setupViewPager(ViewPager viewPager)
  //{
  //  ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
  //  twoWheelFragment=new Fragment();
  //  fourWheelFragment=new Fragment();
  //  recievedFragment=new Fragment();
  //  adapter.addFragment(twoWheelFragment,"Bike");
  //  adapter.addFragment(fourWheelFragment,"Car");
  //  adapter.addFragment(recievedFragment,"Recieved");
  //  viewPager.setAdapter(adapter);
  //}
}
