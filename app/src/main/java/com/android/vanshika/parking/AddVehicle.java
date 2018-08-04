package com.android.vanshika.parking;

import android.app.ActionBar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.Objects;

public class AddVehicle extends AppCompatActivity {

  @RequiresApi(api = Build.VERSION_CODES.KITKAT) @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_vehicle);
    //android.support.v7.widget.Toolbar toolbar =
    //    (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
    ////toolbar.setTitle("Customer Info");
    //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    //getSupportActionBar().setDisplayShowHomeEnabled(true);
    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.vehicle_type, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
  }
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      // Respond to the action bar's Up/Home button
      case android.R.id.home:
        NavUtils.navigateUpFromSameTask(this);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
