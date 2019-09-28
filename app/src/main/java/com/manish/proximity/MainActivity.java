package com.manish.proximity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView ProximitySensor,data;
    SensorManager mySensorManager;
    Sensor myProximitySensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProximitySensor =(TextView)findViewById(R.id.proximitySensor);
        data =(TextView)findViewById(R.id.data);
        mySensorManager =(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        myProximitySensor = mySensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (myProximitySensor == null)
        {
            ProximitySensor.setText("NO Proximity Sensor !!");
        }
        else
        {
            mySensorManager.registerListener(proximitySensorEventListener,myProximitySensor,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    SensorEventListener proximitySensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() ==Sensor.TYPE_PROXIMITY)
            {
                if (event.values[0] == 0)
                {
                    data.setText("NEAR");
                }
                else
                {
                    data.setText("AWAY");
                }
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //TODO autu-generated

        }
    };
}
