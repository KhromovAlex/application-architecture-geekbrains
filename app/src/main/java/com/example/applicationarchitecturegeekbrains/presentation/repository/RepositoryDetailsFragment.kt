package com.example.applicationarchitecturegeekbrains.presentation.repository

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.presentation.abs.AbsFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class RepositoryDetailsFragment : AbsFragment(R.layout.fragment_repository_details), RepositoryDetailsView {
    @Inject
    lateinit var repositoryDetailsPresenterFactory: RepositoryDetailsPresenterFactory

    private var argCountForks: Int? = null

    private val repoInfo: TextView by lazy { requireActivity().findViewById(R.id.info) }

    private val presenter: RepositoryDetailsPresenter by moxyPresenter {
        repositoryDetailsPresenterFactory.create(countForks = argCountForks)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            argCountForks = it.getInt(ARG_COUNT_FORKS)
        }
        super.onCreate(savedInstanceState)
    }

    companion object {
        private const val ARG_COUNT_FORKS = "repo count forks"

        fun newInstance(countForks: Int): Fragment =
            RepositoryDetailsFragment().apply {
                arguments = bundleOf(
                    ARG_COUNT_FORKS to countForks
                )
            }

    }

    override fun showInfo(countForks: Int) {
        repoInfo.text = getString(R.string.countForks, countForks)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

}
