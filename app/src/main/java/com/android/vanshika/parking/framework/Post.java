package com.android.vanshika.parking.framework;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
  @SerializedName("type")
  @Expose
  private String type;
  @SerializedName("number")
  @Expose
  private String number;
  @SerializedName("amount")
  @Expose
  private String amount;
  @SerializedName("timeIn")
  @Expose
  private String timeIn;
  @SerializedName("timeOut")
  @Expose
  private String timeOut;
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @SerializedName("id")
  @Expose
  private Integer id;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getTimeIn() {
    return timeIn;
  }

  public void setTimeIn(String timeIn) {
    this.timeIn = timeIn;
  }

  public String getTimeOut() {
    return timeOut;
  }

  public void setTimeOut(String timeOut) {
    this.timeOut = timeOut;
  }

  @Override public String toString() {
    return "Post{" +
        "vehicleType='" + type + '\'' +
        ", number='" + number + '\'' +
        ", amount=" + amount +
        ", timeIn=" + timeIn +
        ", timeOut=" + timeOut +
        '}';
  }

}
