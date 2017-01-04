package com.example.admin.appbus1.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.admin.appbus1.R;
import com.example.admin.appbus1.models.StringRealmObject;
import com.example.admin.appbus1.models.University;
import com.example.admin.appbus1.services.UniversityAPI;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Admin on 1/4/2017.
 */

public class BusViewholder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_bus)
    TextView tv_bus;

    public BusViewholder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setDataBus(StringRealmObject bus){

//        Picasso.with(itemView.getContext())
//                .load(breath.getImage())
//                .fit()
//                .centerCrop()
//                .into(imageView);

        tv_bus.setText(bus.getNumber());
        itemView.setTag(tv_bus);

    }
}
