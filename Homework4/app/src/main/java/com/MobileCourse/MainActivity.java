package com.MobileCourse;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void myClick(View view)
    {
        //用EditText前，请先:import android.widget.EditText;
        //获取文本框1的文本
        String InputString1 = "";
        EditText TheEditTest1 =(EditText)findViewById(R.id.num1);
        InputString1 = TheEditTest1.getText().toString();

        //获取文本框2的文本
        String InputString2 = "";
        EditText TheEditTest2 =(EditText)findViewById(R.id.num2);
        InputString2 = TheEditTest2.getText().toString();

        String JudgeModel = "^[+-]?\\d+$";
        int GetInt1 = 0;
        if(InputString1.matches(JudgeModel))
        {
            GetInt1 = Integer.parseInt(InputString1);
        }
        int GetInt2 = 0;
        if(InputString2.matches(JudgeModel))
        {
            GetInt2 = Integer.parseInt(InputString2);
        }
        int Result = GetInt1 + GetInt2;

        TextView TheTextView = (TextView) findViewById(R.id.addResult);
        TheTextView.setText(Result + "");
    }


}
