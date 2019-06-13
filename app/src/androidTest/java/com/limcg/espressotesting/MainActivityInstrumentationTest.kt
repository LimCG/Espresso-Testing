package com.limcg.espressotesting

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentationTest {

    private val username = "limcg"
    private val correct_password = "password"
    private val wrong_password = "password123"

    //rule is initialized
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    companion object {

        private val TAG = MainActivityInstrumentationTest::class.simpleName

        @BeforeClass
        @JvmStatic
        fun before_class_method() {

            Log.e(TAG,"run before_class_method()")
        }

        @AfterClass
        @JvmStatic
        fun after_class_method() {

            Log.e(TAG,"run after_class_method()")
        }
    }

    @Before
    fun before_test_method() {

        Log.e(TAG,"run before_test_method")
    }


    @Test
    fun login_success() {

        Log.e(TAG,"Performing login success test")

        Espresso.onView((withId(R.id.user_name)))
                .perform(ViewActions.typeText(username))

        Espresso.onView(withId(R.id.password))
                .perform(ViewActions.typeText(correct_password))

        Espresso.onView(withId(R.id.login_button))
                .perform(ViewActions.click())

        // Matching with Toast msg
        Espresso.onView(withText(R.string.login_success))
                .inRoot(ToastMatcher())
                .check(matches(withText(R.string.login_success)))

    }

    @Test
    fun login_failure() {

        Log.e(TAG,"Performing login failure test")

        Espresso.onView((withId(R.id.user_name)))
                .perform(ViewActions.typeText(username))

        Espresso.onView(withId(R.id.password))
                .perform(ViewActions.typeText(wrong_password))

        Espresso.onView(withId(R.id.login_button))
                .perform(ViewActions.click())

        // Matching with Toast msg
        Espresso.onView(withText(R.string.login_failed))
                .inRoot(ToastMatcher())
                .check(matches(withText(R.string.login_failed)))
    }

    @After
    fun after_test_method() {

        Log.e(TAG, "run after_test_method")
    }


}