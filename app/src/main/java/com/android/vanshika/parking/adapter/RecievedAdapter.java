package com.android.vanshika.parking.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.vanshika.parking.Global;
import com.android.vanshika.parking.R;
import java.util.List;

public class RecievedAdapter extends RecyclerView.Adapter<RecievedAdapter.ViewHolder> {
  List<Global> queue;
  Context context;
  public RecievedAdapter(Context context,List<Global> queue) {
    this.queue = queue;
    this.context=context;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.recieved_card_view, parent, false);

    return new ViewHolder(itemView);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Global list=queue.get(position);
      holder.numberPlate.setText(list.getNumber());
      holder.totalBill.setText(list.getTotal());
  }

  @Override public int getItemCount() {
    return queue.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    TextView numberPlate,totalBill;
    public ViewHolder(View itemView) {
      super(itemView);
      numberPlate=itemView.findViewById(R.id.numberPlate);
      totalBill=itemView.findViewById(R.id.totalBill);
    }
  }
}
