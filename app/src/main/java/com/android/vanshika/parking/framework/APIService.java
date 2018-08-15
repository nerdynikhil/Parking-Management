package com.android.vanshika.parking.framework;
import com.android.vanshika.parking.framework.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
  //@Headers("Accept: application/json")
  @POST("/post/new/")
  @FormUrlEncoded
  Call<Post> savePost(@Field("vehicleType") String type,
      @Field("number") String number,
      @Field("amount") int amount,
      @Field("timeIn") String timeIn,
      @Field("timeOut") String timeOut);

  @GET(".")
  Call <Post> getPost();

  @FormUrlEncoded
  @PUT("/post/new/")
  Call<PUT> updatePost(@Field("vehicleType") String type,
      @Field("number") String number,
      @Field("amount") int amount,
      @Field("timeIn") String timeIn,
      @Field("timeOut") String timeOut);

  //@PUT("/post/{number}/")
  //Call<PUT> updatePost(@Path("number") String number, @Body String timeOut);
}
