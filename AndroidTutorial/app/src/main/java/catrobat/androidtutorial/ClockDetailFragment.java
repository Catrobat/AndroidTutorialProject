package catrobat.androidtutorial;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.TextView;


import catrobat.androidtutorial.clock.ClockContent;

/**
 * A fragment representing a single Clock detail screen.
 * This fragment is either contained in a {@link ClockListActivity}
 * in two-pane mode (on tablets) or a {@link ClockDetailActivity}
 * on handsets.
 */
public class ClockDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private ClockContent.ClockItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ClockDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = ClockContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_clock_detail, container, false);
        AnalogClock analogClock = (AnalogClock) rootView.findViewById(R.id.analogClock);
        TextClock textClock = (TextClock) rootView.findViewById(R.id.textClock);
        return rootView;
    }
}
