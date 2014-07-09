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

    public static enum Numbers {
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

    public static boolean isStringNumber(String buttonName) {
        String helpString = buttonName;

        if(buttonName.contains(buttonExtension)) {
            helpString = (buttonName.split(buttonExtension))[1];
        }

        try {
            Numbers.valueOf(helpString);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
