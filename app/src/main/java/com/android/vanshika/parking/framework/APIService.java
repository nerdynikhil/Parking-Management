package com.android.vanshika.parking.framework;
import com.android.vanshika.parking.Global;
import com.android.vanshika.parking.framework.Post;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface APIService {
  //@Headers("Accept: application/json")
  //try{
    @POST("/post/new")
    @FormUrlEncoded
    Call<Post> savePost(@Field("number") String number,
        @Field("date") String date,
        @Field("type") String type,
    @Field("amount") int amount
    );
  //}

  @GET("api/post_get/")
  Call <List<Global>> getPost();
  /*@GET("api/v1/")
    Call<SearchRestaurantResponse[]> getRestaurantsList(@Query("format") String format, @Query("location") String location,
                                               @Query("rtype") String rtype);
  * */

  @FormUrlEncoded
  @POST("/post/add")
  Call<Post> addExistingPost(
      @Field("number") String number,
      @Field("date") String date,
      @Field("amount") int amount
      );

  //@PUT("/post/{number}/")
  //Call<PUT> updatePost(@Path("number") String number, @Body String timeOut);
}
