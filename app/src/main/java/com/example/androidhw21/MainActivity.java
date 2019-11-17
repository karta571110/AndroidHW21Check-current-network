package com.example.androidhw21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=findViewById(R.id.textview);
        ConnectivityManager mConnectivityManager = (ConnectivityManager) getSystemService(MainActivity.this.CONNECTIVITY_SERVICE);
        NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();

        if(mNetworkInfo != null)
        {
            //網路是否已連線(true or false)
            //mNetworkInfo.isConnected();
               textView.setText("有網路~");
               new AlertDialog.Builder(MainActivity.this)
                       .setTitle("網路狀態")
                       .setMessage("有網路可用~")
                       .setIcon(R.mipmap.ic_launcher)
                       .setPositiveButton("關閉視窗", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.dismiss();//dismiss:關閉回傳值 ；cancel:尚未完成工作關閉
                           }
                       })
                       .show();



            //網路連線方式名稱(WIFI or mobile)
            //textView.setText( mNetworkInfo.getTypeName());
            //網路連線狀態
           // mNetworkInfo.getState();
            //網路是否可使用
           // mNetworkInfo.isAvailable();
            //網路是否已連接or連線中
           // mNetworkInfo.isConnectedOrConnecting();
            //網路是否故障有問題
           // mNetworkInfo.isFailover();
            //網路是否在漫遊模式
           // mNetworkInfo.isRoaming();
        }
        else {
            textView.setText("沒網路~");
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("網路狀態")
                    .setMessage("目前沒有網路，是否前往設定?")
                    .setIcon(R.mipmap.ic_launcher)
                    .setNegativeButton("不用設定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();//dismiss:關閉回傳值 ；cancel:尚未完成工作關閉
                        }
                    })
                    .setPositiveButton("設定網路", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        }
                    })
                    .show();

        }
    }
}
