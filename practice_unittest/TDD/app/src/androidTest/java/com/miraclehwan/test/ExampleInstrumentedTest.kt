package com.miraclehwan.test

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun enter_name_and_output_messsage(){
        onView(withId(R.id.et_firstname)).perform(typeText("DaeHwan"))
        onView(withId(R.id.et_lastname)).perform(typeText("Kim"))
        onView(withId(R.id.btn_submit)).perform(click())
        onView(withId(R.id.tv_message)).check(matches(withText("Hello, DaeHwan Kim")))
    }

    @Test
    fun enter_name_and_output_messsage2(){
        onView(withId(R.id.et_firstname)).perform(typeText("Daniel"))
        onView(withId(R.id.et_lastname)).perform(typeText("Kim"))
        onView(withId(R.id.btn_submit)).perform(click())
        onView(withId(R.id.tv_message)).check(matches(withText("Hello, Daniel Kim")))
    }

    @Test
    fun enter_name_and_output_messsage3(){
        onView(withId(R.id.et_firstname)).perform(typeText("Jacob"))
        onView(withId(R.id.et_lastname)).perform(typeText("Kim"))
        onView(withId(R.id.btn_submit)).perform(click())
        onView(withId(R.id.tv_message)).check(matches(withText("Hello, Jacob Kim")))
    }
}
