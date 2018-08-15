package com.android.vanshika.parking.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

@Dao
public interface UserDao {
  @Query("SELECT * FROM users")
  List<User> getAllItems();

  @Insert
  void InsertAll(User... userList);

  @Query("DELETE FROM users WHERE number=:number")
  public void deleteBike(String number);


  @Query("SELECT * FROM cars")
  List<myuser> getAllCars();

  @Insert
  void InsertAllCars(myuser... userList);

  @Query("DELETE FROM cars WHERE number=:number")
  public void deleteCar(String number);

}
