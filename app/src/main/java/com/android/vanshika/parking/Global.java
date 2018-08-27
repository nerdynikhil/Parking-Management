package com.android.vanshika.parking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Global {
  @SerializedName("number")
  @Expose
  String number;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Global(String number) {

    this.number = number;
  }
}
