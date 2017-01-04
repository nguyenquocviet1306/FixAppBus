package com.example.admin.appbus1.managers;

import com.example.admin.appbus1.models.StringRealmObject;
import com.example.admin.appbus1.models.University;
import com.example.admin.appbus1.services.UniversityAPI;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;


/**
 * Created by giaqu on 1/2/2017.
 */

public class RealmHandler {
    private static RealmHandler instance;
    private Realm realm;
    private RealmHandler(){

        this.realm = Realm.getDefaultInstance();
    }

    public static RealmHandler getInstance() {
        if (instance == null)
            instance = new RealmHandler();
        return instance;
    }

    public List<University> getUniversityFromRealm(){
        return realm.where(University.class).findAll();
    }

    public RealmList<StringRealmObject> getUniversityBusFromRealm(University university){
        return university.getBus();
    }





    public void addUniversityToRealm(University university){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(university);
        realm.commitTransaction();
    }

    public void clearUniversityInRealm(){
        realm.beginTransaction();
        realm.delete(University.class);
        realm.commitTransaction();
    }

}
