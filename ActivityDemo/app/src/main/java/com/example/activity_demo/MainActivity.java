package com.example.activity_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Activity第一次被创建的时候 回调
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","onCreate");

        if (savedInstanceState != null) {
            String data = savedInstanceState.getString("datakey");
            Log.d("MainActivity","datakey"+data);
        }

        Button btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    // Activity由不可见到可见的时候 回调
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    // Activity正在运行的状态，必须是栈的最顶层。
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    // 准备去启动另外一个Activity的时候去调用
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    // Activity完全不可见的时候起调用，比如当弹出一个dialog的时候，会回调onPause并不会回调onStop
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    // Activity被销毁之前调用
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    // Activity由停止状态变为运行状态
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }


    // Activity被回收之前会 回调
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        // 这里把数据保存起来，然后重启开启这个Activity的时候会带入到 onCreate的生命周期回调的参数里
        String data = "这里是假数据";
        outState.putString("datakey",data);
    }
}
