package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button next,home;
    RadioGroup q3,q4;
    RadioButton q3_answer,q4_answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent ii = getIntent();
        final String  name=ii.getStringExtra("name");
        final String  q1=ii.getStringExtra("q1");
        final String q2=ii.getStringExtra("q2");
        q3=(RadioGroup) findViewById(R.id.q3);
        q4=(RadioGroup) findViewById(R.id.q4);
        next=(Button) findViewById(R.id.next);
        home=(Button) findViewById(R.id.home);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int q3_id=q3.getCheckedRadioButtonId();
                q3_answer=findViewById(q3_id);
                int q4_id=q4.getCheckedRadioButtonId();
                q4_answer=findViewById(q4_id);

                Intent i=new Intent(MainActivity2.this,MainActivity3.class);
                i.putExtra("name",name);
                i.putExtra("q1",q1);
                i.putExtra("q2",q2);
                i.putExtra("q3",q3_answer.getText().toString());
                i.putExtra("q4",q4_answer.getText().toString());
                startActivity(i);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
            }
        });
            }
}
