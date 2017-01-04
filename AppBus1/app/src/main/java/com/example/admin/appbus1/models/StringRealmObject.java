package com.example.admin.appbus1.models;

import io.realm.RealmObject;

/**
 * Created by giaqu on 1/3/2017.
 */

public class StringRealmObject extends RealmObject {
   private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
