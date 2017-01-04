package com.example.admin.appbus1.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.appbus1.R;
import com.example.admin.appbus1.adapters.BusAdapter;
import com.example.admin.appbus1.adapters.UniversityAdapter;
import com.example.admin.appbus1.managers.EvenBus;
import com.example.admin.appbus1.managers.EventDataReady;
import com.example.admin.appbus1.managers.EventUniversity;
import com.example.admin.appbus1.models.StringRealmObject;
import com.example.admin.appbus1.models.University;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoUniFragment extends Fragment {
    private BusAdapter busAdapter;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.tv_address)
    TextView tv_address;
    @BindView(R.id.iv_university)
    ImageView iv_university;
    //@BindView(R.id.tv_bus)
    //TextView tv_bus;
    @BindView(R.id.rv_listbus)
    RecyclerView rv_listbus;

    private University university;
    private StringRealmObject bus;


    public InfoUniFragment() {
        // Required empty public constructor
    }

    @Subscribe(sticky = true)
    public void setAdapterView(EventDataReady event){


        busAdapter = new BusAdapter();
        //busAdapter.setOnItemClickListener(this);
        rv_listbus.setAdapter(busAdapter);
        busAdapter.notifyDataSetChanged();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_info_uni, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        setupUI();
        return view;
    }

    @Subscribe(sticky = true)
    public void receiveInfo(EventUniversity event){

        this.university = event.getUniversity();

    }

    @Subscribe(sticky = true)
    public void receiveInfo(EvenBus event){

        this.bus = event.getBusList();

    }

    private void setupUI() {
        tv_name.setText(university.getName());
        //tv_abbreviation.setText(university.getAbbreviation());
        tv_address.setText(university.getAddress());
        //tv_bus.setText(bus.getNumber());
        Glide.with(this).load(Uri.parse("file:///android_asset/logo/" + university.getLogo())).centerCrop().into(iv_university);

    }

}
