package com.android.vanshika.parking;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.vanshika.parking.Room.AppDatabase;
import com.android.vanshika.parking.Room.User;
import com.android.vanshika.parking.Room.myuser;
import com.android.vanshika.parking.framework.APIService;
import com.android.vanshika.parking.framework.ApiUtils;
import com.android.vanshika.parking.framework.Post;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddVehicle extends AppCompatActivity {
  private APIService mAPIService;
  private Button saveButton;
  private String spinnerText;
  private EditText editTextNumber,editTextAmount;
  ArrayAdapter<CharSequence> adapter;
  @RequiresApi(api = Build.VERSION_CODES.KITKAT) @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_vehicle);

    editTextAmount=findViewById(R.id.enteredAmount);
    editTextNumber=findViewById(R.id.enterNumber);

    mAPIService = ApiUtils.getAPIService();

    final Spinner spinner = (Spinner) findViewById(R.id.spinner);
    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinnerText=adapterView.getSelectedItem().toString();
        if (spinnerText.equals("2Wheeler"))
          editTextAmount.setText("20");
        else if(spinnerText.equals("4Wheeler"))
          editTextAmount.setText("50");
      }


      @Override public void onNothingSelected(AdapterView<?> adapterView) {
            editTextAmount.setText("");
      }
    });

    saveButton=findViewById(R.id.saveButton);
    saveButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if (spinnerText.equals("2Wheeler")){
          addToRoomBike();
          updateAmountBikes();
        }

        else if(spinnerText.equals("4Wheeler")){
          addToRoomCar();
          updateAmountCars();
        }
        //sendPost(spinnerText,Integer.parseInt(editTextAmount.getText().toString()),editTextNumber.getText().toString());
      }
    });

    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    //Spinner spinner = (Spinner) findViewById(R.id.spinner);
    adapter = ArrayAdapter.createFromResource(this,
        R.array.vehicle_type, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
  }

  private void updateAmountCars() {
    int price= PreferenceManager.getDefaultSharedPreferences(AddVehicle.this).getInt("CarPay",0);
    PreferenceManager.getDefaultSharedPreferences(AddVehicle.this).edit().putInt("CarPay",Integer.parseInt(editTextAmount.getText().toString())+price).commit();
  }

  private void updateAmountBikes() {
    int price= PreferenceManager.getDefaultSharedPreferences(AddVehicle.this).getInt("BikePay",0);
    PreferenceManager.getDefaultSharedPreferences(AddVehicle.this).edit().putInt("BikePay",Integer.parseInt(editTextAmount.getText().toString())+price).commit();
  }

  private void sendPost(String spinner, int amount, String vehicleNumber) {
    long mil = System.currentTimeMillis();
    Date date = new Date(mil);
    @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("hh:mm a");
    String hms = formatter.format(date);
    mAPIService.savePost((String) spinner,vehicleNumber,amount,hms,"").enqueue(new Callback<Post>() {
      @Override public void onResponse(Call<Post> call, Response<Post> response) {
        Log.v("message1",response.body()+" errror body "+response.errorBody()+" "+response.code()+" "+response.raw()+" "+response.headers());
        if (response.isSuccessful()){
          Toast.makeText(AddVehicle.this, "Added Successfully", Toast.LENGTH_SHORT).show();
          Log.v("addvehicleactivity",response.message());
        }
      }

      @Override public void onFailure(Call<Post> call, Throwable t) {
        Toast.makeText(AddVehicle.this, "Can't add, please try again", Toast.LENGTH_SHORT).show();
        Log.v("addvehicleactivity",t.getMessage());
      }
    });

  }

  private void addToRoomCar() {
    final AppDatabase
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"cars")
        .build();
    long mil = System.currentTimeMillis();
    Date date = new Date(mil);
    @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("hh:mm a");
    String hms = formatter.format(date);
    final myuser ParkingList=new myuser(spinnerText,editTextNumber.getText().toString(),Integer.parseInt(editTextAmount.getText().toString()),hms);
    AsyncTask.execute(new Runnable() {
      @Override public void run() {
        db.userDao().InsertAllCars(ParkingList);
      }
    });
  }

  private void addToRoomBike() {
    final AppDatabase
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"users")
        .build();
    long mil = System.currentTimeMillis();
    Date date = new Date(mil);
    @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("hh:mm a");
    String hms = formatter.format(date);
    final User ParkingList=new User(spinnerText,editTextNumber.getText().toString(),Integer.parseInt(editTextAmount.getText().toString()),hms);
    AsyncTask.execute(new Runnable() {
      @Override public void run() {
          db.userDao().InsertAll(ParkingList);
      }
    });
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
  public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {


    public void onItemSelected(AdapterView<?> parent, View view,
        int pos, long id) {
      // An item was selected. You can retrieve the selected item using
      //spinner= parent.getItemAtPosition(pos);
      spinnerText=parent.getSelectedItem().toString();
      if (spinnerText=="2Wheeler's")
        editTextAmount.setText("20");
      else if(spinnerText=="4Wheeler's")
        editTextAmount.setText("50");
    }

    public void onNothingSelected(AdapterView<?> parent) {
      // Another interface callback
    }
  }
}
