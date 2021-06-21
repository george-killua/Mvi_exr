package com.hisoka.mvi_exr.data

import android.view.*
import androidx.recyclerview.widget.*
import com.hisoka.mvi_exr.BR
import com.hisoka.mvi_exr.data.model.UserEntity
import com.hisoka.mvi_exr.databinding.RecyclerviewItemBinding


class UserListAdapter(diffCallback : DiffUtil.ItemCallback<UserEntity>) :
				ListAdapter<UserEntity, UserViewHolder>(diffCallback) {




				override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : UserViewHolder {
								return UserViewHolder.create(parent)
				}

				override fun onBindViewHolder(holder : UserViewHolder, position : Int) {
								val current : UserEntity = getItem(position)
								holder.bind(current)
				}

				class UserDiff : DiffUtil.ItemCallback<UserEntity>() {
								override fun areItemsTheSame(oldItem : UserEntity, newItem : UserEntity) : Boolean {
												return oldItem === newItem
								}

								override fun areContentsTheSame(oldItem : UserEntity, newItem : UserEntity) : Boolean {
												return oldItem.uId == newItem.uId&&oldItem.date==newItem.date
								}
				}
}

class UserViewHolder private constructor(itemView : RecyclerviewItemBinding) :
				RecyclerView.ViewHolder(itemView.root) {
				val binding = itemView
				fun bind(user : UserEntity) {
								binding.setVariable(BR.item, user)
								binding.executePendingBindings()

				}

				companion object {
								fun create(parent : ViewGroup) : UserViewHolder {
												val view : RecyclerviewItemBinding = RecyclerviewItemBinding.inflate(
																LayoutInflater.from(parent.context), parent,
																false
												)
												return UserViewHolder(view)
								}
				}


}