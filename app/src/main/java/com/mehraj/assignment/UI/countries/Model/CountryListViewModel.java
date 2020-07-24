package com.mehraj.assignment.UI.countries.Model;

import com.mehraj.assignment.Network.API;
import com.mehraj.assignment.Network.RetrofitClient;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryListViewModel extends ViewModel {
    MutableLiveData<ArrayList<Country>> countryListLiveData;


    public CountryListViewModel() {
        countryListLiveData = new MutableLiveData<>();
        //getAsianCountryList();
        getCountiesofAsia();
    }


    void getCountiesofAsia(){
        RetrofitClient retrofit=new RetrofitClient();
        API myApi=retrofit.getAPIClient();
        Call<ArrayList<Country>> apiCall=myApi.getCountiesofAsia();
        apiCall.enqueue(new Callback<ArrayList<Country>>() {
            @Override
            public void onResponse(Call<ArrayList<Country>> call, Response<ArrayList<Country>> response) {
                if(response.isSuccessful())
                {
                    ArrayList<Country> countryList;
                    countryList=response.body();
                    setData(countryList);
                   // countryListLiveData.setValue(response.body());


                }
            }

            @Override
            public void onFailure(Call<ArrayList<Country>> call, Throwable t) {

            }
        });

    }


    private void setData(ArrayList<Country> data)
    {
       countryListLiveData.setValue(data);
    }


    public MutableLiveData<ArrayList<Country>> getMutableCountryList()
    {
        return  countryListLiveData;
    }

}
