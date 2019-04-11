package com.vclyfe.firstapplication

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class Testtou {

    @get:Rule
    var mActivity: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testOne() {
        assert(mActivity.activity.recyclerView.isClickable)
    }


}