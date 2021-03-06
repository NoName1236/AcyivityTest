package com.hui.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button=findViewById(R.id.button_2);
//        final Intent intent=getIntent();
//        final String data= intent.getStringExtra("extra_data");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = getIntent();
                Bundle bundle_second= intent1.getBundleExtra("data_name");
                String str_second=bundle_second.getString("data_key");
                Toast.makeText(SecondActivity.this,str_second,Toast.LENGTH_SHORT).show();
//                Intent intent1=new Intent();
//                intent1.putExtra("data_return","Hello FirstActivity!");
//                setResult(RESULT_OK,intent1);
//                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(SecondActivity.this,"保存成功！",Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

}