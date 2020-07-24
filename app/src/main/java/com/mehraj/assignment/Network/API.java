package com.mehraj.assignment.Network;

import com.mehraj.assignment.UI.countries.Model.Country;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("/rest/v2/region/asia")
    Call<ArrayList<Country>> getCountiesofAsia( );




}
