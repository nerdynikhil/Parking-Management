package com.android.vanshika.parking.adapter;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.vanshika.parking.AddVehicle;
import com.android.vanshika.parking.R;
import com.android.vanshika.parking.Room.AppDatabase;
import com.android.vanshika.parking.Room.User;
import com.android.vanshika.parking.Room.myuser;
import com.android.vanshika.parking.framework.APIService;
import com.android.vanshika.parking.framework.ApiUtils;
import com.android.vanshika.parking.framework.Post;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
  private APIService mAPIService;
  List<myuser> carsParked;
  Context context;
  AppDatabase db;
  //public CarAdapter(List<User> carsParked) {
  //  this.carsParked = carsParked;
  //}

  public CarAdapter(Context context, List<myuser> carsParked) {
    this.context=context;
    this.carsParked=carsParked;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.card_view, parent, false);

    return new ViewHolder(itemView);
  }

  @Override public void onBindViewHolder(ViewHolder holder1, int position1) {
    long mil = System.currentTimeMillis();
    Date date = new Date(mil);
    @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("hh:mm a");
    final String hms = formatter.format(date);
    Date c = Calendar.getInstance().getTime();
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    final String formattedDate = df.format(c);
    mAPIService = ApiUtils.getAPIService();
    final int position=position1;
    final myuser vehicle=carsParked.get(position);
    final ViewHolder holder=holder1;
    //holder.vehicleNumber.setText(vehicle.getNumber());
    holder.amount.setText(String.valueOf(vehicle.getNumber()));
    holder.time.setText(vehicle.getTimeIn());
    final ViewHolder finalHolder=holder;
    holder.button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        mAPIService.savePost(holder.vehicleNumber.getText().toString(),formattedDate,vehicle.getVehicleType(),Integer.parseInt(holder.amount.getText().toString())).enqueue(new Callback<Post>() {
          @Override public void onResponse(Call<Post> call, Response<Post> response) {
            if (response.isSuccessful()) {
              removeItem(position,vehicle.getNumber(),vehicle.getAmount());
              Log.v("addvehicleactivity", response.message());
            }
          }

          @Override public void onFailure(Call<Post> call, Throwable t) {
            Toast.makeText(context, "Can't add, please try again", Toast.LENGTH_SHORT).show();
            removeItem(position,vehicle.getNumber(),vehicle.getAmount());
            Log.v("addvehicleactivity", t.getMessage());
          }
        });
      }
    });
      }

  @SuppressLint("CommitPrefEdits") private void removeItem(int position, String number,int amount) {
    final int pos=position;
    final String num=number;
    AsyncTask.execute(new Runnable() {
      @Override public void run() {
        db = Room.databaseBuilder(context, AppDatabase.class, "cars")
            .build();
        carsParked.remove(pos);
        db.userDao().deleteCar(num);
      }
    });
    Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
    int que= PreferenceManager.getDefaultSharedPreferences(context).getInt("CarNumber",0);
    PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("CarNumber",que+1).commit();
    notifyDataSetChanged();
  }


  @Override public int getItemCount() {
    return carsParked.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    TextView vehicleNumber,amount,time;
    ImageView button;
    CardView cardViewObject;
    public ViewHolder(View itemView) {
      super(itemView);
      button=itemView.findViewById(R.id.button);
      cardViewObject=itemView.findViewById(R.id.cardView);
      vehicleNumber=itemView.findViewById(R.id.vehicleNumber);
      amount=itemView.findViewById(R.id.amount);
      time=itemView.findViewById(R.id.time);
    }
  }
}
