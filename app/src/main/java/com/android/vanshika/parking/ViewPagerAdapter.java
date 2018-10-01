package com.android.vanshika.parking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.android.vanshika.parking.fragment.FourWheelFragment;
import com.android.vanshika.parking.fragment.RecivedFragment;
import com.android.vanshika.parking.fragment.TwoWheelFragment;
import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.Fragment;

class ViewPagerAdapter extends FragmentPagerAdapter {
  private Context mContext;

  public ViewPagerAdapter(Context context, FragmentManager fm) {
    super(fm);
    mContext = context;
  }

  // This determines the fragment for each tab
  @Override
  public Fragment getItem(int position) {
    if (position == 2){
      return new RecivedFragment();
    } else if (position == 1){
      return new FourWheelFragment();
    } else
     {
      return new TwoWheelFragment();
    }
  }

  // This determines the number of tabs
  @Override
  public int getCount() {
    return 3;
  }

  // This determines the title for each tab
  @Override
  public CharSequence getPageTitle(int position) {
    // Generate title based on item position
    switch (position) {
      case 0:
        return mContext.getString(R.string.bike);
      case 1:
        return mContext.getString(R.string.car);
      case 2:
        return mContext.getString(R.string.recieved);
      default:
        return null;
    }
  }

  //private final List<Fragment> mFragmentList = new ArrayList<>();
  //private final List<String> mFragmentTitleList = new ArrayList<>();
  //
  //public ViewPagerAdapter(FragmentManager fm) {
  //  super(fm);
  //}
  //
  //@Override public Fragment getItem(int position) {
  //  return mFragmentList.get(position);
  //}
  //
  //@Override public int getCount() {
  //  return mFragmentList.size();
  //}
  //
  //
  //@Override public int getItemPosition(@NonNull Object object) {
  //  return super.getItemPosition(object);
  //}
  //
  //@Nullable @Override public CharSequence getPageTitle(int position) {
  //  return mFragmentTitleList.get(position);
  //}
  //
  //public void addFragment(Fragment fragment, String title) {
  //  mFragmentList.add(fragment);
  //  mFragmentTitleList.add(title);
  //}

}