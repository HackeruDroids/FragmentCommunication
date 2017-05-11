package hackeru.edu.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class RatingMainActivity extends AppCompatActivity implements RatingFragment.OnRatingChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_main);

        //
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new RatingFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame2, new SmileyFragment(), "SmileyFragmentTag").commit();
    }

    @Override
    public void onRatingChanged(float rating) {
        SmileyFragment smileyFragment = (SmileyFragment) getSupportFragmentManager().findFragmentByTag("SmileyFragmentTag");

        int rate = Math.round(rating);
        smileyFragment.ivSmiley.setImageResource(smileyFragment.images[rate]);
    }
}
