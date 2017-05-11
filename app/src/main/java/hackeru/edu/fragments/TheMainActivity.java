package hackeru.edu.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class TheMainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, new ColorFragment()).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_color:
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new ColorFragment()).commit();
                break;
            case R.id.navigation_culinary:
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new CulinaryFragment()).commit();
                break;
            case R.id.navigation_notifications:
                getSupportFragmentManager().beginTransaction().replace(R.id.content, new ColorFragment()).commit();
                break;
        }
        return false;
    }
}
