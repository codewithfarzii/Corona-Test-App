package com.example.linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button next;
    RadioGroup radioGroup,q2;
    RadioButton  q1_answer,q2_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup) findViewById(R.id.radiogroup);
        q2=(RadioGroup) findViewById(R.id.Q2);
        name=(EditText) findViewById(R.id.name);
        next=(Button) findViewById(R.id.next);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int q1_id=radioGroup.getCheckedRadioButtonId();
                q1_answer=findViewById(q1_id);
                int q2_id=q2.getCheckedRadioButtonId();
                q2_answer=findViewById(q2_id);

                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("q1",q1_answer.getText().toString());
                i.putExtra("q2",q2_answer.getText().toString());

                startActivity(i);


            }
        });
    }
}
