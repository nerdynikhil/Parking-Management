package com.android.vanshika.parking.Room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "cars")
public class myuser {
  @PrimaryKey(autoGenerate = true)
  int id;

  @ColumnInfo(name="vehicleType")
  String vehicleType;

  @ColumnInfo(name = "number")
  String number;

  @ColumnInfo(name = "amount")
  int amount;

  @ColumnInfo(name = "timeIn")
  String timeIn;

  public myuser(String vehicleType, String number, int amount, String timeIn) {
    this.vehicleType = vehicleType;
    this.number = number;
    this.amount = amount;
    this.timeIn = timeIn;
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getTimeIn() {
    return timeIn;
  }

  public void setTimeIn(String timeIn) {
    this.timeIn = timeIn;
  }
}
