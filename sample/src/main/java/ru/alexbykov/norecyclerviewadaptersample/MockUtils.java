package ru.alexbykov.norecyclerviewadaptersample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Bykov
 *         Date: 08.01.2018.
 *         <p>
 *         You can contact me at me@alexbykov.ru
 */

public class MockUtils {

    private MockUtils() {

    }


    public static List<String> getItems() {
        List<String> items = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            items.add(String.valueOf(i));
        }
        return items;
    }

}
