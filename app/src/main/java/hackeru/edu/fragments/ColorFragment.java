package hackeru.edu.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment implements SeekBar.OnSeekBarChangeListener, TextWatcher {
    EditText etRed, etGreen, etBlue, etResult;
    SeekBar sbRed, sbGreen, sbBlue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //v.findViewById()
        //No findViewById()

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_color, container, false);

        etRed = (EditText) v.findViewById(R.id.etRed);
        etGreen = (EditText) v.findViewById(R.id.etGreen);
        etBlue = (EditText) v.findViewById(R.id.etBlue);
        etResult = (EditText) v.findViewById(R.id.etResult);

        sbRed = (SeekBar) v.findViewById(R.id.sbRed);
        sbGreen = (SeekBar) v.findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) v.findViewById(R.id.sbBlue);

        sbRed.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);

        etRed.addTextChangedListener(this);
        etGreen.addTextChangedListener(this);
        etBlue.addTextChangedListener(this);

        //more listeners:
        //etRed.addTextChangedListener(this);
        return v;
    }

    boolean userIsCurrentlyScrolling = false;

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        userIsCurrentlyScrolling = fromUser;
        int red = sbRed.getProgress();
        int green = sbGreen.getProgress();
        int blue = sbBlue.getProgress();

        int color = Color.rgb(red, green, blue);

        etResult.setBackgroundColor(color);
        String hex = "#" + Integer.toHexString(color).toUpperCase();

        etResult.setText(hex);

        if (fromUser) {
            etRed.setText(String.valueOf(red));
            etGreen.setText(String.valueOf(green));
            etBlue.setText(String.valueOf(blue));
        }

        userIsCurrentlyScrolling = false;

        if (getActivity() instanceof OnColorChangedListener){
            OnColorChangedListener a = (OnColorChangedListener) getActivity();
            a.onColorChanged(color);
        }

//        MainActivity a = (MainActivity) getActivity();
//        a.onColorChanged(color);
    }

    public interface OnColorChangedListener {
        void onColorChanged(int color);
    }




    private void notifyListener(int color) {
        if (getActivity() instanceof OnColorChangedListener)
            listener = (OnColorChangedListener) getActivity();

        if (listener != null) {
            listener.onColorChanged(color);
        }
    }


    OnColorChangedListener listener = null;



    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (userIsCurrentlyScrolling) return;
        //take the text from the editTexts...
        String redText = etRed.getText().toString();
        String greenText = etGreen.getText().toString();
        String blueText = etBlue.getText().toString();

        //start with a default int value for the colors:
        int red = 0, blue = 0, green = 0;

        //try to convert the strings to numbers.
        try {
            red = Integer.valueOf(redText);
        } catch (NumberFormatException ignored) {
        }
        try {
            blue = Integer.valueOf(blueText);

        } catch (NumberFormatException ignored) {
        }
        try {
            green = Integer.valueOf(greenText);
        } catch (NumberFormatException ignored) {
        }

        //take the numbers and put them in the seekbars.
        sbRed.setProgress(red);
        sbGreen.setProgress(green);
        sbBlue.setProgress(blue);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
