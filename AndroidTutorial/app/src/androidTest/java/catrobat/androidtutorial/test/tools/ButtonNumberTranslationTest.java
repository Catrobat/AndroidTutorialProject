package catrobat.androidtutorial.test.tools;

import android.widget.Button;

import junit.framework.TestCase;

import java.util.ArrayList;

import catrobat.androidtutorial.tools.ButtonNumberTranslation;

/**
 * Created by stephan on 09.07.14.
 */
public class ButtonNumberTranslationTest extends TestCase {

    public void testIsStringNumber() {
        assertTrue(ButtonNumberTranslation.isStringNumber("buttonOne"));
    }

    public void testIsStringNumber1() {
        assertFalse(ButtonNumberTranslation.isStringNumber("buttonDelete"));
    }

    public void testIsStringNumber2() {
        assertTrue(ButtonNumberTranslation.isStringNumber("One"));
    }

    public  void testIsStringNumber3() {
        assertFalse(ButtonNumberTranslation.isStringNumber("Susi"));
    }

}
