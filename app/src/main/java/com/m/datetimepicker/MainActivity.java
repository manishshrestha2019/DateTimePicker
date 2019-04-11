package com.m.datetimepicker;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDate=findViewById(R.id.tvDate);

        // tvTime=findViewById(R.id.tvTime);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });
    }
    private void loadDatePicker(){
        final Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, this, year,month,day);
        datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
       //
        // c.add(Calendar.DATE,3);
        c.add(Calendar.DATE,+3);
        datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis());
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month,int dayOfMonth){
        String date="Month/Date/Year : \n"+month+"/"+dayOfMonth+"/"+year;
        tvDate.setText(date);

    }
}
