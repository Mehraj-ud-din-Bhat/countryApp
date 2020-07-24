package com.mehraj.assignment.UI.countries.Model;

import com.google.gson.internal.$Gson$Preconditions;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Language implements Serializable {


    private        String iso639_1;
    private        String iso639_2;
    private        String name;
    private         String     nativeName;

    public Language() {
    }

    public Language(String iso639_1, String iso639_2, String name, String nativeName) {
        this.iso639_1 = iso639_1;
        this.iso639_2 = iso639_2;
        this.name = name;
        this.nativeName = nativeName;
    }

    public String getName() {
        return name;
    }
}
