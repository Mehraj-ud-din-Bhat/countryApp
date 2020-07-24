package com.mehraj.assignment.UI.countryDetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.mehraj.assignment.R;
import com.mehraj.assignment.UI.countries.Model.Country;


public class CountryDeatil extends AppCompatActivity {
    TextView tv_countryName,tv_countryRegion,tv_subregion,tv_capital,tv_population,tv_laguages,tv_border;
    Country countryDetail;
    ImageView flag;
    ImageView img_back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_deatil);



        connectViews();
        Intent intent = getIntent();
       countryDetail = (Country) intent.getExtras().getSerializable("countryDetail");
      setData();



    }

//--------------------------------
//Method Used to Connect XML Views With Java File
//------------------------------
    void connectViews()
    {
        tv_countryName=findViewById(R.id.contry_Name_TV);
        tv_countryRegion=findViewById(R.id.contry_region_TV);
        tv_subregion=findViewById(R.id.contry_subregion_TV);
        tv_capital=findViewById(R.id.contry_capital_TV);
        tv_population=findViewById(R.id.contry_population_TV);
        tv_laguages=findViewById(R.id.contry_laguages_TV);
        tv_border=findViewById(R.id.contry_border_TV);
        flag=findViewById((R.id.contry_flag_IV));
        img_back_btn=findViewById(R.id.back_btn);
        img_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
//---------------------------------------
//METHOD USED TO SET DATA TO VIEWS
//----------------------------------------
    void setData()
    {


        try {
            GlideToVectorYou
                    .init()
                    .with(this)
                    .load(Uri.parse(countryDetail.getFlag()), flag);
            tv_countryName.setText(countryDetail.getName());
            tv_countryRegion.setText(countryDetail.getRegion());
            tv_subregion.setText(countryDetail.getSubregion());
            tv_capital.setText(countryDetail.getCapital());
            tv_population.setText(Integer.toString(countryDetail.getPopulation()));
            String languages = "";
            for (int i = 0; i < countryDetail.getLanguages().size(); i++) {
                languages = languages + countryDetail.getLanguages().get(i).getName();
                if(i!=(countryDetail.getLanguages().size()-1))
                languages = languages + " ,";
            }
            tv_laguages.setText(languages);

            String border="";

            for (int i = 0; i < countryDetail.getBorders().size(); i++) {
                border = border + countryDetail.getBorders().get(i);
                if(i!=(countryDetail.getBorders().size()-1))
                    border = border + " ,";
            }

            tv_border.setText(border);

        }catch (Exception e){}


    }
}
