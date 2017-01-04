package com.example.admin.appbus1.services;

import android.app.IntentService;
import android.content.Intent;
import android.provider.SyncStateContract;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Admin on 1/3/2017.
 */

public class BusService extends IntentService {
    private static final String TAG = BusService.class.toString();

    public BusService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Retrofit dataRetrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}
