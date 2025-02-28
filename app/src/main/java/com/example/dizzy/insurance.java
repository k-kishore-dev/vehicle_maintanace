package com.example.dizzy;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class insurance extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView startDateView, endDateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insuranceui);

        calendarView = findViewById(R.id.calendar);
        startDateView = findViewById(R.id.start_date_view);
        endDateView = findViewById(R.id.end_date_view);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String startDate = dayOfMonth + "-" + (month + 1) + "-" + year;
                startDateView.setText("Start Date: " + startDate);

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                calendar.add(Calendar.YEAR, 1);
                int endYear = calendar.get(Calendar.YEAR);
                int endMonth = calendar.get(Calendar.MONTH) + 1;
                int endDay = calendar.get(Calendar.DAY_OF_MONTH);

                String endDate = endDay + "-" + endMonth + "-" + endYear;
                endDateView.setText("End Date: " + endDate);
            }
        });
    }
}
