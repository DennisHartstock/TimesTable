package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Integer> numbers;

    private final int maxNumber = 20;
    private final int minNumber = 1;
    private final int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        ListView listViewNumbers = findViewById(R.id.listViewNumbers);
        numbers = new ArrayList<>();
        seekBar.setMax(maxNumber);
        seekBar.setMin(minNumber);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
        listViewNumbers.setAdapter(arrayAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numbers.clear();
                if (progress < minNumber) {
                    seekBar.setProgress(minNumber);
                }
                for (int i = minNumber; i <= count; i++) {
                    numbers.add(seekBar.getProgress() * i);
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(10);
    }
}