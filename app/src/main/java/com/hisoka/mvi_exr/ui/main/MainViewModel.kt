package com.hisoka.mvi_exr.ui.main

import androidx.databinding.*
import com.hisoka.mvi_exr.data.*
import com.hisoka.mvi_exr.data.UserListAdapter.UserDiff
import com.hisoka.mvi_exr.data.model.UserEntity
import org.koin.core.component.*

class MainViewModel : BaseObservable(), KoinComponent {
				private val userRepository : UserRepository by inject()

				@Bindable
				val adapter : UserListAdapter = UserListAdapter(UserDiff())

				data class State(
												val firstname : String = "",
												val lastname : String = "",
												val toastMessage : String? = null,
				)
				sealed class Action {
								object LoadUsers : Action()
								data class FirstnameETChanged(val firstname : String) : Action()
								data class LastnameETChanged(val lastname : String) : Action()
								object AddClicked : Action()
				}

				private var currentState : State = State()

				private var onStateChanged : ((State) -> Unit)? = null

				fun onAction(action : Action) {
								currentState = when (action) {
												is Action.LoadUsers -> {
																				adapter.submitList(userRepository.getAllUser())
																currentState.copy(
																				toastMessage=null
																)
												}
												is Action.FirstnameETChanged -> currentState.copy(
																firstname = action.firstname,
																toastMessage = null
												)
												is Action.LastnameETChanged -> currentState.copy(
																lastname = action.lastname,
																toastMessage = null
												)
												is Action.AddClicked -> (
																				when {
																								currentState.firstname.isBlank() -> {
																												currentState.copy(
																																toastMessage = "Firstname is missed"
																												)
																								}
																								currentState.lastname.isBlank() -> {
																												currentState.copy(
																																toastMessage = "Lastname is missed"
																												)
																								}
																								else -> {
																												currentState.apply {
																																userRepository.insertUser(UserEntity(firstname = firstname,
																																				lastname = lastname))
																																adapter.submitList(userRepository.getAllUser())
																																this.copy(
																																				firstname = "",
																																				lastname = "",
																																				toastMessage = "User Added"
																																)
																												}
																								}
																				}
												                        )
								}
								onStateChanged?.invoke(currentState)
				}

				fun subscribeToStateChanges(onStateChanged : (State) -> Unit) {
								onStateChanged.invoke(currentState)
								this.onStateChanged = onStateChanged
				}

}