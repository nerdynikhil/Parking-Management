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

}
