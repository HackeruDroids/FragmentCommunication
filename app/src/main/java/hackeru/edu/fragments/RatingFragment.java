package hackeru.edu.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnRatingChangedListener} interface
 * to handle interaction events.
 */
public class RatingFragment extends Fragment implements RatingBar.OnRatingBarChangeListener {
    private RatingBar ratingBar;
    private OnRatingChangedListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_rating, container, false);
        ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(this);
        return v;
    }



    public void onRatingChanged(float rating) {
        if (mListener != null) {
            mListener.onRatingChanged(rating);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRatingChangedListener) {
            mListener = (OnRatingChangedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRatingChangedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
        onRatingChanged(rating);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnRatingChangedListener {
        void onRatingChanged(float rating);
    }
}
