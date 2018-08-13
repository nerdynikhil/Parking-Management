package com.android.vanshika.parking.framework;
import com.android.vanshika.parking.framework.Post;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
  //@Headers("Accept: application/json")
  @POST("/post/new/")
  @FormUrlEncoded
  Call<Post> savePost(@Field("vehicleType") String type,
      @Field("number") String number,
      @Field("amount") int amount,
      @Field("timeIn") String timeIn);

  @GET(".")
  Call <Post> getPost();
}
