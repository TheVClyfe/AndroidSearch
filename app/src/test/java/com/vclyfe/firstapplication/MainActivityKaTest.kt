package com.vclyfe.firstapplication

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainActivityKaTest {

    @Before
    fun setUp() {

    }

    @Test
    fun firstTest() {
        assert(MainActivity().chutiyapaTest()=="TESTLOL")
    }

    @After
    fun tearDown() {

    }
}