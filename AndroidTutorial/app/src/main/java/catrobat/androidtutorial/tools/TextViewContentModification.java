package catrobat.androidtutorial.tools;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import catrobat.androidtutorial.R;

/**
 * Created by stephan on 08.07.14.
 */
public class TextViewContentModification {
    private TextViewContentModification() {};

    public static String setTextForTextView(String newContentToAdd, String oldText ) {
        String newText;

       if(oldText.startsWith("0"))
            newText = oldText.substring(1) + newContentToAdd;
        else
            newText = "0" + newContentToAdd;

       return newText;
    }

    public static int getNextTextView(int selectedFieldID) {
        switch (selectedFieldID) {
            case R.id.textHours:
                return R.id.textMinutes;
            case  R.id.textMinutes:
                return R.id.textSeconds;
            case R.id.textSeconds:
                return R.id.textHours;
        }
        return 0;
    }

    //TODO UI TEST
    public static void setColorOfTextView(ArrayList<TextView> views, int selectedViewID) {
        for(TextView view : views) {
            if(view.getId() == selectedViewID) {
                view.setTextColor(Color.parseColor("#00CED1"));
            }
            else
                view.setTextColor((Color.parseColor("#000000")));
        }
    }

    public static String validateText(String newText) {
        int numberToValidate = Integer.parseInt(newText);

        if(numberToValidate > 59) {
            return "59";
        }

        return newText;
    }
}
