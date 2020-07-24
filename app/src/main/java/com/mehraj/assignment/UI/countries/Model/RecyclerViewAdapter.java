package com.mehraj.assignment.UI.countries.Model;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.mehraj.assignment.R;
import com.mehraj.assignment.UI.countryDetail.CountryDeatil;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    ArrayList<Country> countryList;

    public RecyclerViewAdapter(Activity context, ArrayList<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @NonNull
    @Override


    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.country_list_item,parent,false);
        return new RecyclerViewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        RecyclerViewViewHolder viewHolder= (RecyclerViewViewHolder) holder;
        GlideToVectorYou
                .init()
                .with(context)
                .load(Uri.parse(countryList.get(position).getFlag()), viewHolder.country_flag);
        viewHolder.country_Name.setText(countryList.get(position).getName());
        viewHolder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, CountryDeatil.class);
                i.putExtra("countryDetail",countryList.get(position));
                context. startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }


    class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        com.caverock.androidsvg.SVGImageView country_flag;
        TextView country_Name;
        View root;


        public RecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);
            root=itemView.findViewById(R.id.countrySingleItem_root);
           country_flag = itemView.findViewById(R.id.flagImage_IV);
          country_Name = itemView.findViewById(R.id.countryName_TV);



        }
    }
}
