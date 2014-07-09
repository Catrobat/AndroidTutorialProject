package catrobat.androidtutorial.clock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ClockContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<ClockItem> ITEMS = new ArrayList<ClockItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, ClockItem> ITEM_MAP = new HashMap<String, ClockItem>();

    static {
        // NEW: CHANGED IDs; IDs are Strings!!
        addItem(new ClockItem("0", "Stopwatch"));
        addItem(new ClockItem("1", "Timer"));
        addItem(new ClockItem("2", "Clock"));
    }

    private static void addItem(ClockItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class ClockItem {
        public String id;
        public String content;

        public ClockItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
