package com.android.vanshika.parking.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.vanshika.parking.R;
import com.android.vanshika.parking.Room.User;
import com.android.vanshika.parking.Room.myuser;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
  List<myuser> carsParked;
  Context context;

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

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    myuser vehicle=carsParked.get(position);
    holder.vehicleNumber.setText(vehicle.getNumber());
    holder.amount.setText(vehicle.getAmount());
    holder.time.setText(vehicle.getTimeIn());
    final ViewHolder finalHolder=holder;
    holder.button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        finalHolder.cardViewObject.removeView(view);
      }
    });
  }

  @Override public int getItemCount() {
    return carsParked.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    TextView button,vehicleNumber,amount,time;
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
