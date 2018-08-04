package com.android.vanshika.parking;

public class Vehicle {
  String number,time;
  int payment;

  public Vehicle() {
  }

  public Vehicle(String number, String time, int payment) {
    this.number = number;
    this.time = time;
    this.payment = payment;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public int getPayment() {
    return payment;
  }

  public void setPayment(int payment) {
    this.payment = payment;
  }
}
