package com.example.wahyu.myapplication.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.wahyu.myapplication.Activity.MainActivity;
import com.example.wahyu.myapplication.R;
import com.example.wahyu.myapplication.db.BpjsDbHelper;
import com.example.wahyu.myapplication.dto.Page;
import com.example.wahyu.myapplication.dto.Tagihan;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by wahyu on 12/15/2016.
 */

public class TerimaFirebaseMessageService extends FirebaseMessagingService {

    private static final String TAG = "FCMMessage";

    @Override
    public void onMessageReceived(RemoteMessage msg) {
        Log.d(TAG, "FCM Message From : "+msg.getFrom());
        Log.d(TAG, "FCM Message To : "+msg.getTo());
        Log.d(TAG, "FCM Message Content : "+msg.getData());

        Map<String, String> data = msg.getData();
        String idPeserta = data.get("id");
        updateDataTagihan(idPeserta);
    }

    private void updateDataTagihan(String idPeserta){
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... id) {
                String nama = null;

                try {

                    BackendService service = new BackendService();
                    Page<Tagihan> hasil = service.semuaTagihan(id[0]);
                    Log.d(TAG, "Jumlah data : "+hasil.getTotalElements());
                    List<Tagihan> data = hasil.getContent();

                    BpjsDbHelper db = new BpjsDbHelper(TerimaFirebaseMessageService.this);
                    if(!data.isEmpty()){
                        db.kosongkanTabelTagihan();
                    }
                    for(Tagihan t : data){
                        Log.d(TAG, "Tanggal Tagihan : "+t.getTanggalTagihan());
                        Log.d(TAG, "Nilai Tagihan : "+t.getNilai());
                        db.insertTagihan(t);
                        nama = t.getPeserta().getNama();
                    }
                } catch (Exception err){
                    Log.e(TAG, err.getMessage());
                }

                return nama;
            }

            @Override
            protected void onPostExecute(String nama) {
                // activity yang mau ditampilkan pada saat notifikasi diklik
                Intent screenTagihan = new Intent(TerimaFirebaseMessageService.this, MainActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(TerimaFirebaseMessageService.this);
                stackBuilder.addParentStack(MainActivity.class);
                stackBuilder.addNextIntent(screenTagihan);
                PendingIntent tagihanPendingIntent =
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );

                // tampilkan notifikasi
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(TerimaFirebaseMessageService.this)
                                .setSmallIcon(R.drawable.ic_drawer)
                                .setContentTitle("Tagihan Baru")
                                .setContentText("Ada tagihan baru untuk peserta "
                                        +nama);
                mBuilder.setContentIntent(tagihanPendingIntent);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                int notificationId = 100;
                mNotificationManager.notify(notificationId, mBuilder.build());
            }
        }.execute(idPeserta);
    }
}