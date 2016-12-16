package com.example.wahyu.myapplication.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.wahyu.myapplication.R;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // menampilkan tulisan di log
        Log.d(TAG, "Menjalankan onCreate dalam LoginActivity");
    }

    public void btnLoginClicked(View v){
        Intent i = new Intent(this, Drawer.class);
        startActivity(i);
    }

    public void btnRegistrasiClicked(View v){

    }
}


//    private static final String TAG = "login Activity";
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Log.d(TAG, "Menjalankan onCreate dalam LoginActivity");
//    }
//
//    public void btnLoginClicked(View v){
//               Intent pindahActivityIntent = new Intent(this, Drawer.class);
//                startActivity(pindahActivityIntent);
//            }
//
//    public void btnRegistrasiClicked(View v){
//
//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... voids) {
//                try {
//
//                    BackendService service = new BackendService();
//                    Page<Tagihan> hasil = service.semuaTagihan("p001");
//                    Log.d(TAG, "Jumlah data : "+hasil.getTotalElements());
//                    List<Tagihan> data = hasil.getContent();
//
//                    BpjsDbHelper db = new BpjsDbHelper(MainActivity.this);
//                    if(!data.isEmpty()){
//                        db.kosongkanTabelTagihan();
//                    }
//
//                    for(Tagihan t : data){
//                        Log.d(TAG, "Tanggal Tagihan : "+t.getTanggalTagihan());
//                        Log.d(TAG, "Nilai Tagihan : "+t.getNilai());
//                        db.insertTagihan(t);
//                    }
//                } catch (Exception err){
//                    Log.e(TAG, err.getMessage());
//                }
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(String s) {
//                Toast.makeText(MainActivity.this, "Request Tagihan Selesai",
//                        Toast.LENGTH_LONG).show();
//            }
//        }.execute();
//
//    }
//}