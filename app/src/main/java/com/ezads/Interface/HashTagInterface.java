package com.ezads.Interface;

import com.ezads.Pojo.HashTagsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HashTagInterface {

    @GET("/ezads/rest/fetch/hashtag")
    Call<HashTagsList> getHashtags(@Query("version") String version);
}
