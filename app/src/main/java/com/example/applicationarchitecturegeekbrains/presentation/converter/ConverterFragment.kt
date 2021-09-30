package com.example.applicationarchitecturegeekbrains.presentation.converter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.applicationarchitecturegeekbrains.R
import com.example.applicationarchitecturegeekbrains.data.ConverterRepositoryFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class ConverterFragment : MvpAppCompatFragment(R.layout.fragment_converter), ConverterView {
    private val converterButton: Button by lazy {
        requireActivity().findViewById(R.id.converterButton)
    }

    private val presenter: ConverterPresenter by moxyPresenter {
        ConverterPresenter(repository = ConverterRepositoryFactory.create(context = requireContext()))
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Uri? = result.data?.data

                presenter.convertImage(data)
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        converterButton.setOnClickListener(presenter::selectImage)
    }

    companion object {
        @JvmStatic
        fun newInstance(): Fragment =
            ConverterFragment()
    }

    override fun showSuccess(path: String) {
        Toast.makeText(context, path, Toast.LENGTH_LONG).show()
    }

    override fun showEmpty() {
        Toast.makeText(context, getString(R.string.noImageSelected), Toast.LENGTH_LONG).show()
    }

    override fun pickImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        resultLauncher.launch(intent)
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

}
