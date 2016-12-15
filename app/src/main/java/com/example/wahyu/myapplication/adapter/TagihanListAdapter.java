package com.example.wahyu.myapplication.adapter;

/**
 * Created by wahyu on 12/13/2016.
 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wahyu.myapplication.R;
import com.example.wahyu.myapplication.dto.Tagihan;

import java.text.SimpleDateFormat;
import java.util.List;

//import com.brainmatics.bpjs.bpjskesehatan.R;
//import com.brainmatics.bpjs.bpjskesehatan.dto.Tagihan;

public class TagihanListAdapter extends ArrayAdapter<Tagihan> {
    private int layout;
    private SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy");

    public TagihanListAdapter(Context context, int resource, List<Tagihan> objects) {
        super(context, resource, objects);
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View row, ViewGroup parent) {
        if(row == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(layout, parent, false);
        }

        Tagihan t = getItem(position);

        TextView txtTanggalTagihan = (TextView) row.findViewById(R.id.txtTanggalTagihan);
        txtTanggalTagihan.setText(formatter.format(t.getTanggalTagihan()));

        TextView txtJatuhTempo = (TextView) row.findViewById(R.id.txtJatuhTempo);
        txtJatuhTempo.setText(formatter.format(t.getTanggalJatuhTempo()));

        TextView txtPeserta = (TextView) row.findViewById(R.id.txtPeserta);
        txtPeserta.setText(t.getPeserta().getNomor() + " - " + t.getPeserta().getNama());

        TextView txtNilai = (TextView) row.findViewById(R.id.txtNilaiTagihan);
        txtNilai.setText("Rp. "+t.getNilai().toString());

        return row;
    }
}