package com.example.wahyu.myapplication.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.wahyu.myapplication.R;
import com.example.wahyu.myapplication.adapter.TagihanListAdapter;
import com.example.wahyu.myapplication.db.BpjsDbHelper;
import com.example.wahyu.myapplication.service.BackendService;
/**
 * A simple {@link Fragment} subclass.
 */
public class TagihanFragment extends Fragment {

    private BpjsDbHelper dbHelper;

    public TagihanFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        dbHelper = new BpjsDbHelper(getActivity());

        TagihanListAdapter tagihanListAdapter = new TagihanListAdapter(getActivity(),
                R.layout.lv_tagihan,
                dbHelper.semuaTagihan());

        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_tagihan, container, false);
        ListView lvTagihan = (ListView) fragmentView.findViewById(R.id.lvTagihan);
        lvTagihan.setAdapter(tagihanListAdapter);

        return fragmentView;
    }

}