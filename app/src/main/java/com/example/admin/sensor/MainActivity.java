package com.example.admin.sensor;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    Sensor accelerometer;
    TextView xValue,yValue,zValue;

    private static final String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xValue=(TextView)findViewById(R.id.xValue);
        yValue=(TextView)findViewById(R.id.yValue);
        zValue=(TextView)findViewById(R.id.zValue);

        Log.d(TAG, "onCreate: Initializing sensor service");

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(MainActivity.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        Log.d(TAG, "onCreate: Registered accelerometer listener");
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "onSensorChanged: X:"+sensorEvent.values[0] + "Y: "+sensorEvent.values[1] + "Z: "+sensorEvent.values[2]);
        xValue.setText("XValue: "+sensorEvent.values[0]);
        yValue.setText("YValue: "+sensorEvent.values[1]);
        zValue.setText("ZValue: "+sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
