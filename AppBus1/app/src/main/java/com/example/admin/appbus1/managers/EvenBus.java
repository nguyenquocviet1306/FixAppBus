package com.example.admin.appbus1.managers;

import com.example.admin.appbus1.models.StringRealmObject;
import com.example.admin.appbus1.models.University;

/**
 * Created by Admin on 1/4/2017.
 */

public class EvenBus {
    private StringRealmObject busList;

    public StringRealmObject getBusList() {
        return busList;
    }

    public void setBusList(StringRealmObject busList) {
        this.busList = busList;
    }

    public EvenBus(StringRealmObject busList) {
        this.busList = busList;
    }
}
