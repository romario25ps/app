package com.example.pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView valueExX, valueExY, valueExZ;
    SensorManager sensorManager;
    Sensor acelerometterSensor;
    SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueExX = findViewById(R.id.exX);
        valueExY = findViewById(R.id.exX);
        valueExZ = findViewById(R.id.exX);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null)
        {
            acelerometterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
        else
        {
            valueExX.setText("Acelerometter is not avaliable.");
            valueExY.setText("Acelerometter is not avaliable.");
            valueExZ.setText("Acelerometter is not avaliable.");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        valueExX.setText((String.format("%f", event.values[0])));
        valueExY.setText((String.format("%f", event.values[1])));
        valueExZ.setText((String.format("%f", event.values[2])));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

