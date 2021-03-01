/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.victor.ko.companies

import android.R
import android.view.View
import android.widget.ArrayAdapter
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.victor.ko.companies.ui.main.view.MainActivity
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CompanyFragmentTest {
/*
    @Rule
    var rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun ensureListViewIsPresent() {
        val activity: MainActivity = rule.getActivity()
        val viewById: View = activity.findViewById(R.id.listview)
        assertThat(viewById, notNullValue())
        assertThat(viewById, instanceOf(ListView::class.java))
        val listView: ListView = viewById as ListView
        val adapter: ListAdapter = listView.getAdapter()
        assertThat(adapter, instanceOf(ArrayAdapter::class.java))
        assertThat(adapter.getCount(), greaterThan(5))
    }*/

    @Rule @JvmField
    val mainActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun ensureListViewIsPresent() {
        val activity: MainActivity = mainActivityTestRule.getActivity()
        //val viewById: View = activity.findViewById(R.id.listview)
        assertThat(activity, notNullValue())
        /*assertThat(viewById, instanceOf(ListView::class.java))
        val listView: ListView = viewById as ListView
        val adapter: ListAdapter = listView.getAdapter()
        assertThat(adapter, instanceOf(ArrayAdapter::class.java))
        assertThat(adapter.getCount(), greaterThan(5))*/
    }

    /*
    MyFragmentClass test = (MyFragmentClass) getSupportFragmentManager().findFragmentByTag("testID");
if (test != null && test.isVisible()) {
     //DO STUFF
}
else {
    //Whatever
}
     */
    /*@Test
    fun clickCompanyList() {



        // When the "Add Plant" button is clicked
        onView(withId(R.id.company_list)).perform(click())

        // Then the ViewPager should change to the Plant List page
        onView(withId(R.id.company_detail_fragment)).check(matches(isDisplayed()))
    }*/
}
