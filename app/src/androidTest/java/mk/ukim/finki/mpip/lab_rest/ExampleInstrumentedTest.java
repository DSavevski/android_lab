package mk.ukim.finki.mpip.lab_rest;

import android.content.Context;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("mk.ukim.finki.mpip.lab_rest", appContext.getPackageName());
    }

    @Test
    public void testQuantityStringSingular() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Resources res = appContext.getResources();
        String qty = res.getQuantityString(R.plurals.qty, 1);
        assertEquals(qty, "One item");
    }

    @Test
    public void testQuantityStringPlural() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Resources res = appContext.getResources();
        String qty = res.getQuantityString(R.plurals.qty, 2);
        assertEquals(qty, "More items");
    }
}
