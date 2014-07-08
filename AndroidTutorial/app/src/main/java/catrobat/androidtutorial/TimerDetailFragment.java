package catrobat.androidtutorial;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import catrobat.androidtutorial.clock.ClockContent;
import catrobat.androidtutorial.tools.ButtonNumberTranslation;
import catrobat.androidtutorial.tools.TextViewContentModification;

/**
 * A fragment representing a single Clock detail screen.
 * This fragment is either contained in a {@link catrobat.androidtutorial.ClockListActivity}
 * in two-pane mode (on tablets) or a {@link catrobat.androidtutorial.ClockDetailActivity}
 * on handsets.
 */
public class TimerDetailFragment extends Fragment implements View.OnClickListener {

//    private Button buttonZero;
//    private Button buttonOne;
//    private Button buttonTwo;
//    private Button buttonThree;
//    private Button buttonFour;
//    private Button buttonFive;
//    private Button buttonSix;
//    private Button buttonSeven;
//    private Button buttonEight;
//    private Button buttonNine;

    int selectedFieldID;

    private Button buttonStart;
    private Button buttonStop;
    private Button buttonReset;
    private Button buttonNext;


    private ArrayList<Button> buttonList;

    private ArrayList<TextView> textViews = new ArrayList<TextView>();


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
    public TimerDetailFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_timer_detail, container, false);

        buttonStart = (Button) rootView.findViewById(R.id.buttonStart);
        buttonStop = (Button) rootView.findViewById(R.id.buttonStop);
        buttonReset = (Button) rootView.findViewById(R.id.buttonReset);
        buttonNext = (Button) rootView.findViewById(R.id.buttonNext);


        this.buttonList = ButtonNumberTranslation.generateNumberButtons(0, 9, rootView);

        textViews.add((TextView) rootView.findViewById(R.id.textHours));
        textViews.add((TextView) rootView.findViewById(R.id.textMinutes));
        textViews.add((TextView) rootView.findViewById(R.id.textSeconds));

        for(Button b : buttonList) {
            b.setOnClickListener(this);
        }

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
        buttonNext.setOnClickListener(this);
        this.selectedFieldID = R.id.textHours;

        TextViewContentModification.setColorOfTextView(this.textViews, this.selectedFieldID);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        if(ButtonNumberTranslation.isButtonNumber(getResources().getResourceName(v.getId()))) {
            TextView actualTextView = (TextView) v.getRootView().findViewById(this.selectedFieldID);

            String newText = TextViewContentModification.setTextForTextView(((Button) v).getText().toString(), actualTextView.getText().toString());
            newText = TextViewContentModification.validateText(actualTextView, newText);

            actualTextView.setText(newText);
        }
        else {
            switch(v.getId()){
                case R.id.buttonNext:
                    this.selectedFieldID = TextViewContentModification.getNextTextView(selectedFieldID);
                    break;
                case R.id.buttonReset:
                    break;
                case R.id.buttonStop:
                    break;
                case R.id.buttonStart:
                    break;
            }
        }

        TextViewContentModification.setColorOfTextView(this.textViews, this.selectedFieldID);
    }
}
