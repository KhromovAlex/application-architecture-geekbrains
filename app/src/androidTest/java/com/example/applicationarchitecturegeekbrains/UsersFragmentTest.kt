package com.example.applicationarchitecturegeekbrains

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import com.example.applicationarchitecturegeekbrains.presentation.repositories.adapter.RepositoriesViewHolder
import com.example.applicationarchitecturegeekbrains.presentation.users.UsersFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UsersFragmentTest {
    private lateinit var scenario: FragmentScenario<UsersFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer()
    }

    @Test
    fun fragment_testShowInfo() {
        Thread.sleep(5000)

        scenario.onFragment {
            it.showUsers(listOf(
                GitHubUser(
                    idUser = 0,
                    GITHUB_LOGIN,
                    GITHUB_PROFILE_URL
                )
            ))
        }

        Espresso.onView(ViewMatchers.withId(R.id.userList))
            .perform(
                RecyclerViewActions.scrollTo<RepositoriesViewHolder>(
                    ViewMatchers.hasDescendant(ViewMatchers.withText(GITHUB_LOGIN))
                )
            )
    }
}
