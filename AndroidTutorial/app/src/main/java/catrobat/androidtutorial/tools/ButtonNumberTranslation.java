package catrobat.androidtutorial.tools;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import catrobat.androidtutorial.R;

/**
 * Created by stephan on 08.07.14.
 */
public class ButtonNumberTranslation {

    private final static String buttonExtension = "button";

    private static enum Numbers {
        Zero,
        One,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine
    };

    private ButtonNumberTranslation() { }

    public static ArrayList<Button> generateNumberButtons(int startNumber, int endNumber, View rootView) {
        ArrayList<Button> buttonList = new ArrayList<Button>();

        for(int i = startNumber; i <= endNumber; i ++) {
            int id = rootView.getResources().getIdentifier(buttonExtension + Numbers.values()[i].toString(), "id", R.class.getPackage().getName());
                buttonList.add(((Button) rootView.findViewById(id)));
        }

        return buttonList;
    }

    public static boolean isButtonNumber(String buttonName) {
        String helpString = (buttonName.split(buttonExtension))[1];

        try {
            Numbers.valueOf(helpString);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
