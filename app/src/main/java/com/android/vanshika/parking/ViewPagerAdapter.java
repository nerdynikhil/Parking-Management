package com.android.vanshika.parking;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.android.vanshika.parking.fragment.TwoWheelFragment;
import java.util.ArrayList;
import java.util.List;

class ViewPagerAdapter extends FragmentPagerAdapter {

  private final List<Fragment> mFragmentList = new ArrayList<>();
  private final List<String> mFragmentTitleList = new ArrayList<>();

  public ViewPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {
    return mFragmentList.get(position);
  }

  @Override public int getCount() {
    return mFragmentList.size();
  }


  @Override public int getItemPosition(@NonNull Object object) {
    return super.getItemPosition(object);
  }

  @Nullable @Override public CharSequence getPageTitle(int position) {
    return mFragmentTitleList.get(position);
  }

  public void addFragment(Fragment fragment, String title) {
    mFragmentList.add(fragment);
    mFragmentTitleList.add(title);
  }
}