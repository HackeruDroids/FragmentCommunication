package hackeru.edu.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class CulinaryFragment extends Fragment implements View.OnClickListener {
    private TextView tvCulinary;
    String[] culinaryInspirations = new String[]{
            "Nachos smoothie has to have a dried, gooey ginger component.",
            "Instead of varnishing hardened emeril's essence with nachos, use one container BBQ sauce and twelve oz anise grinder.",
            "Dry nine seaweeds, chocolate, and garlic in a large plastic bag over medium heat, simmer for fifteen minutes and rinse with some apple.",
            "With asparagus drink hollandaise sauce.",
            "Garnish each side of the watermelon with one cup of noodles."
    };
    Random r  = new Random();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_culinary, container, false);
        tvCulinary = (TextView) v.findViewById(R.id.tvCulinary);
        culinary();
        tvCulinary.setOnClickListener(this);
        return v;
    }
    private void culinary() {
        int rand = r.nextInt(culinaryInspirations.length);
        String culinary = culinaryInspirations[rand];
        tvCulinary.setText(culinary);
    }

    @Override
    public void onClick(View view) {
        culinary();
    }
}
