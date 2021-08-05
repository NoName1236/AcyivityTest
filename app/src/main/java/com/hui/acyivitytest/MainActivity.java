package com.hui.acyivitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "you clicked button 1", Toast.LENGTH_SHORT).show();
//                finish();
//                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);
//                Intent intent=new Intent("com.hui.acyivitytest.ACTION_START");
//                intent.addCategory("com.hui.acyivitytest.MY_CATEGORY");
//                startActivity(intent);
//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.bilibili.com"));
//                startActivity(intent);
//                Intent intent=new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);
                //Intent向下一个活动传递数据
                String data="Hello SecondActivity!";
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);//键值
//                startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(MainActivity.this,"Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this,"Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this,TAG+"pressed back key",Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String returned_data = data.getStringExtra("data_return");
                Toast.makeText(MainActivity.this, returned_data, Toast.LENGTH_SHORT).show();
            }
        }
    }
}