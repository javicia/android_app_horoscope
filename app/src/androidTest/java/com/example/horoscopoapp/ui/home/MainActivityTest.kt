package com.example.horoscopoapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import com.example.horoscopoapp.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.horoscopoapp.ui.detail.HoroscopeDetailActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityTest{

    @get:Rule(order=0)
    val hiltRule= HiltAndroidRule(this)

    @get:Rule(order=1)
    var mainActivity= ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun sepUp(){
        hiltRule.inject()
        Intents.init()
    }

    @After
    fun tearDown(){
        Intents.release()
    }


    @Test
    fun when_mainActivity_is_created_then_open_luck_fragment(){
        onView(withId(R.id.luckFragment)).perform(click())
    }

    @Test
    fun when_horoscope_is_selected_then_open_detail(){
        onView(withId(R.id.ivHoroscope))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
            )
        intended(hasComponent(HoroscopeDetailActivity::class.java.name))
    }
}