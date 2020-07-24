package com.mehraj.assignment.UI.countries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.mehraj.assignment.R;
import com.mehraj.assignment.UI.countries.Model.Country;
import com.mehraj.assignment.UI.countries.Model.CountryListViewModel;
import com.mehraj.assignment.UI.countries.Model.RecyclerViewAdapter;

import java.util.ArrayList;
//---------------------------------------------------------------------------------------------------
//Created By METHRAJ UD DIN BHAT 23 July 2020 for Glyka Assignment (Internshala) ,contact 8494036469
//------------------------------------------------------------------------------------------------------

public class CountriesList extends AppCompatActivity {

    CountriesList context;
    CountryListViewModel viewModel;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries_list);
         recyclerView=findViewById(R.id.countryList_RV);
         progressBar=findViewById(R.id.progressBar);
         progressBar.setVisibility(View.VISIBLE);
          context=this;

        viewModel = ViewModelProviders.of(context).get(CountryListViewModel.class);
        viewModel.getMutableCountryList().observe(context, countryListobserver);
    }
    //------------------------------------
    //Observer for Recycler View Data
    //------------------------------------
    Observer<ArrayList<Country>> countryListobserver = new Observer<ArrayList<Country>>() {
        @Override
        public void onChanged(ArrayList<Country> countryList) {
            recyclerViewAdapter = new RecyclerViewAdapter(context,countryList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(recyclerViewAdapter);
            progressBar.setVisibility(View.INVISIBLE);
        }
    };
}
