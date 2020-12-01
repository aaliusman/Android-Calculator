package academy.learnprogramming.calculator

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun test_IsActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_IsCalculatorFunctioningCorrectly() {
        //Given
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        val result = (5.0 * 2.0).toString()
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.newNumber)).check(matches(withText("2")))
        onView(withId(R.id.operation)).check(matches(withText("")))
        onView(withId(R.id.buttonMultiply)).perform(click())
        onView(withId(R.id.operation)).check(matches(withText("*")))
        onView(withId(R.id.button5)).perform(click())
        onView(withId(R.id.buttonEquals)).perform(click())
        onView(withId(R.id.result)).check(matches(withText(result)))
        onView(withId(R.id.operation)).check(matches(withText("=")))
        onView(withId(R.id.newNumber)).check(matches(withText("")))


    }
}