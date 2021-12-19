package com.example.applicationarchitecturegeekbrains

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.applicationarchitecturegeekbrains.presentation.repository.RepositoryDetailsFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepositoryDetailsFragmentTest {
    private lateinit var scenario: FragmentScenario<RepositoryDetailsFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer()
    }

    @Test
    fun fragment_testShowInfo() {
        val fragmentArgs = bundleOf(
            RepositoryDetailsFragment.ARG_COUNT_FORKS to 10
        )
        val scenario = launchFragmentInContainer<RepositoryDetailsFragment>(fragmentArgs)
        scenario.moveToState(Lifecycle.State.RESUMED)

        val assertion = ViewAssertions.matches(ViewMatchers.withText("Count Forks 10"))
        Espresso.onView(withId(R.id.info)).check(assertion)
    }

    @Test
    fun fragment_testNullBundle() {
        val fragmentArgs = bundleOf("TOTAL_COUNT_EXTRA" to null)
        val scenario = launchFragmentInContainer<RepositoryDetailsFragment>(fragmentArgs)
        scenario.moveToState(Lifecycle.State.RESUMED)

        val assertion = ViewAssertions.matches(ViewMatchers.withText("Count Forks 0"))
        Espresso.onView(withId(R.id.info)).check(assertion)
    }
}
