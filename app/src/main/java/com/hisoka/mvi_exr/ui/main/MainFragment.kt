package com.hisoka.mvi_exr.ui.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.hisoka.mvi_exr.databinding.MainFragmentBinding

class MainFragment : Fragment() {

				companion object {
								fun newInstance() = MainFragment()
				}

				private lateinit var viewModel : MainViewModel
				private lateinit var binding : MainFragmentBinding
				override fun onCreateView(
												inflater : LayoutInflater, container : ViewGroup?,
												savedInstanceState : Bundle?,
				) : View {
								binding = MainFragmentBinding.inflate(layoutInflater, container, false)
								return binding.root
				}

				override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
								super.onViewCreated(view, savedInstanceState)
								viewModel = MainViewModel()


								viewModel.subscribeToStateChanges { state ->
												if (state.toastMessage != null)
																showToast(state.toastMessage)
								}
								binding.buttonSave.setOnClickListener {
												viewModel.onAction(MainViewModel.Action.AddClicked)
								}
								binding.etFirstname.addTextChangedListener {
												viewModel.onAction(MainViewModel.Action.FirstnameETChanged(it!!.toString()))

								}

								binding.etLastname.addTextChangedListener {
												viewModel.onAction(MainViewModel.Action.LastnameETChanged(it!!.toString()))
								}

				}

				private fun showToast(message : String) {
								Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
				}

}