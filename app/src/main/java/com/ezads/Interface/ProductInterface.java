package com.ezads.Interface;

import com.ezads.Pojo.ListingProduct;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductInterface {

    @GET("/ezads/rest/list/product/by/promotinal/offer")
    Call<Map<String, List<ListingProduct>>> getPromotionalOffer();
}
