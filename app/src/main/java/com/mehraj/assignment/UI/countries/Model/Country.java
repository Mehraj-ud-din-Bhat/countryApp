package com.mehraj.assignment.UI.countries.Model;

import java.io.Serializable;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class Country implements Serializable {
  private   String name;
  private  String region;
  private String subregion;
  private int    population;
  private ArrayList<String> borders;
  private ArrayList<Language> languages;
    private String flag;
    private String capital;

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getSubregion() {
        return subregion;
    }

    public int getPopulation() {
        return population;
    }

    public ArrayList<String> getBorders() {
        return borders;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public String getFlag() {
        return flag;
    }

    public String getCapital() {
        return capital;
    }
}



