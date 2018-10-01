package com.android.vanshika.parking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Global {
  @SerializedName("number")
  @Expose
  String number;

  @SerializedName("total")
  @Expose
  String total;

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Global(String number, String total) {
    this.number = number;
    this.total = total;
  }
}
