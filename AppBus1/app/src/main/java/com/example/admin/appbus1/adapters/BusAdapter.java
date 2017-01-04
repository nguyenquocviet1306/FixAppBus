package com.example.admin.appbus1.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.appbus1.R;
import com.example.admin.appbus1.managers.RealmHandler;
import com.example.admin.appbus1.models.StringRealmObject;
import com.example.admin.appbus1.models.University;
import com.example.admin.appbus1.services.UniversityAPI;
import com.example.admin.appbus1.viewholders.BusViewholder;
import com.example.admin.appbus1.viewholders.UniversityViewholder;

import java.util.List;

import io.realm.RealmList;

/**
 * Created by Admin on 1/4/2017.
 */

public class BusAdapter extends RecyclerView.Adapter<BusViewholder> {
    private University university;
    List<University> universityList = RealmHandler.getInstance().getUniversityFromRealm();

    RealmList<StringRealmObject> universityBusList = RealmHandler.getInstance().getUniversityBusFromRealm(university);

    private View.OnClickListener onItemClickListener;

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }



    @Override
    public BusViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView =  layoutInflater.inflate(R.layout.item_bus, parent, false);
        return new BusViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(BusViewholder holder, int position) {
        holder.itemView.setOnClickListener(onItemClickListener);
        holder.setDataBus(universityBusList.get(position));
    }

    @Override
    public int getItemCount() {
        return universityBusList.size();
    }
}
