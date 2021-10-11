package com.example.applicationarchitecturegeekbrains.presentation.repositories

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.data.GitHubRepos
import com.example.applicationarchitecturegeekbrains.presentation.abs.AbsFragment
import com.example.applicationarchitecturegeekbrains.presentation.repositories.adapter.RepositoriesAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class RepositoriesFragment : AbsFragment(R.layout.fragment_repositories), RepositoriesView, RepositoriesAdapter.RepoClickListener {

    @Inject
    lateinit var repositoriesPresenterFactory: RepositoriesPresenterFactory

    private var repoList: RecyclerView? = null
    private val repositoriesAdapter: RepositoriesAdapter = RepositoriesAdapter(this)
    private val argUrl: String by lazy {
        arguments?.getString(ARG_URL).orEmpty()
    }
    private val argUserLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter: RepositoriesPresenter by moxyPresenter {
        repositoriesPresenterFactory.create(
            url = argUrl,
            userLogin = argUserLogin
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repoList = requireActivity().findViewById(R.id.repoList)
        repoList?.layoutManager = LinearLayoutManager(context)
        repoList?.adapter = repositoriesAdapter
    }

    companion object {
        private const val ARG_URL = "repo_url"
        private const val ARG_USER_LOGIN = "user_login"

        fun newInstance(url: String, userLogin: String): Fragment =
            RepositoriesFragment().apply {
                arguments = bundleOf(
                    ARG_URL to url,
                    ARG_USER_LOGIN to userLogin,
                )
            }

    }

    override fun showRepositories(list: List<GitHubRepos>) {
        repositoriesAdapter.submitList(list)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun onClickRepo(repo: GitHubRepos) {
        presenter.displayRepositoryInfo(repo)
    }

}
