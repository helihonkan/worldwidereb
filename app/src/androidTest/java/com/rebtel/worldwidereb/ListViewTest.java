package com.rebtel.worldwidereb;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;

/**
 * Created by helena on 12/02/17.
 *
 * Test to check that
 */

public class ListViewTest {

    @Rule
    public ActivityTestRule<CountryListActivity> menuActivityTestRule =
            new ActivityTestRule<>(CountryListActivity.class, true, true);

    @Test
    public void click_listView() {
        onData(anything()).inAdapterView(withId(R.id.list_view_countries)).atPosition(0).perform(click());
    }
}
