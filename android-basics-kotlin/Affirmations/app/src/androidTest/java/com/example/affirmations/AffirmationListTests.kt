package com.example.affirmations

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


//테스트 할때 개발자 도구 가서, 모든 애니메이션 배율들 꺼야함.
@RunWith(AndroidJUnit4::class)
class AffirmationListTests {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun scroll_to_item(){

        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions
//               .scrollToPosition<RecyclerView.ViewHolder>(9))
                .scrollTo<RecyclerView.ViewHolder>(
                    hasDescendant(withText(R.string.affirmation10))
                )
        )
        onView(withText(R.string.affirmation10))
            .check(matches(isDisplayed())
        )
    }
}