package hackeru.edu.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ButtonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);
    }

    public void color(View view) {
        //FragmentManager.
        FragmentManager fragmentManager = getSupportFragmentManager();

        //transactions: add, remove, replace
        fragmentManager.beginTransaction().replace(R.id.content, new ColorFragment()).commit();

        //findFragmentsById,findFragmentsByTag

    }

    public void culinary(View view) {
        //FragmentManager.
        FragmentManager fragmentManager = getSupportFragmentManager();

        //transactions: add, remove, replace
        fragmentManager.beginTransaction().replace(R.id.content, new CulinaryFragment()).commit();

        //findFragmentsById,findFragmentsByTag
    }
}
