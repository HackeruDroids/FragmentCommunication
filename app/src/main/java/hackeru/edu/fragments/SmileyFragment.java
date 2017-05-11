package hackeru.edu.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SmileyFragment extends Fragment {
    ImageView ivSmiley;
    int[] images = new int[]{R.drawable.ic_color_lens_black_24dp, R.drawable.ic_color_lens_black_24dp, R.drawable.ic_dashboard_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_notifications_black_24dp, R.drawable.ic_timer_black_24dp};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smily, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivSmiley = (ImageView) view.findViewById(R.id.ivSmiley);
    }
}
