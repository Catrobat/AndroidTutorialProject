package catrobat.androidtutorial.test.tools;

import android.widget.TextView;

import junit.framework.TestCase;

import java.util.ArrayList;

import catrobat.androidtutorial.R;
import catrobat.androidtutorial.tools.TextViewContentModification;

/**
 * Created by stephan on 09.07.14.
 */
public class TextViewContentModificationTest extends TestCase {

    public void testGetNextTextView() {
        assertEquals(R.id.textMinutes, TextViewContentModification.getNextTextView(R.id.textHours));
    }

    public void testGetNextTextView1() {
        assertEquals(0, TextViewContentModification.getNextTextView(R.id.buttonDelete));
    }

    public void testGetNextTextView2() {
        assertEquals(R.id.textHours, TextViewContentModification.getNextTextView(R.id.textSeconds));
    }

    public void testGetNextTextView3() {
        assertEquals(R.id.textSeconds, TextViewContentModification.getNextTextView(R.id.textMinutes));
    }

    public void testSetTextForTextView() {
        assertEquals("00", TextViewContentModification.setTextForTextView("0", "10"));
    }

    public void testSetTextForTextView1() {
        assertEquals("34", TextViewContentModification.setTextForTextView("4", "03"));
    }

    public void testSetTextForTextView2() {
        assertEquals("02", TextViewContentModification.setTextForTextView("2", "00"));
    }

    public void testSetTextForTextView3() {
        assertEquals("03", TextViewContentModification.setTextForTextView("3", "103"));
    }

    public void testSetTextForTextView4() {
        assertEquals("08", TextViewContentModification.setTextForTextView("8", "34"));
    }

    public void testValidateText() {
        assertEquals("23", TextViewContentModification.validateText("23"));
    }

    public void testValidateText1() {
        assertEquals("03", TextViewContentModification.validateText("03"));
    }

    public void testValidateText2() {
        assertEquals("59", TextViewContentModification.validateText("78"));
    }

    public void testValidateText3() {
        assertEquals("-1", TextViewContentModification.validateText("-1"));
    }

}
