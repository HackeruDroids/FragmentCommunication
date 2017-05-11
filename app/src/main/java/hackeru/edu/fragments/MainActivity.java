package hackeru.edu.fragments;

import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void timer(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Intents.startTimer(this, "Turn off the oven", 40);
        } else
            Toast.makeText(this, "No Timer intent on device", Toast.LENGTH_SHORT).show();
    }
}
