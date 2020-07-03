package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Button next,home;
    RadioGroup q5;
    RadioButton q5_answer;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent ii = getIntent();
        final String  name=ii.getStringExtra("name");
        final String  q1=ii.getStringExtra("q1");
        final String q2=ii.getStringExtra("q2");
        final String q3=ii.getStringExtra("q3");
        final String q4=ii.getStringExtra("q4");

        q5=(RadioGroup) findViewById(R.id.q5);
        output=(TextView) findViewById(R.id.result);
        next=(Button) findViewById(R.id.next);
        home=(Button) findViewById(R.id.home);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int q5_id=q5.getCheckedRadioButtonId();
                q5_answer=findViewById(q5_id);

                int value=0;
                if(q1.contentEquals("Yes"))
                    value=value+20;
                if(q2.contentEquals("Yes"))
                    value=value+30;
                if(q3.contentEquals("Yes"))
                    value=value+20;
                if(q4.contentEquals("Yes"))
                    value=value+10;
                if(q5_answer.getText().toString().contentEquals("Yes"))
                    value=value+20;

                if(value>=60)
                    output.setText(output.getText().toString()+"\n"+   name+":\nYou are corona patient:Get Quarantine!");
                else
                    output.setText(output.getText().toString()+"\n"+name+":\nYou are not corona patient!");


            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity3.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
