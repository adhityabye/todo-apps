package by.tutorials.listtodoapp

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.tutorials.listtodoapp.databinding.ListItemTaskBinding

class TaskAdapter(
    private val onEditClick: (Task) -> Unit,
    private val onDeleteClick: (Task) -> Unit,
    private val onCompleteClick: (Task) -> Unit
) : ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ListItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TaskViewHolder(private val binding: ListItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(task: Task) {
            binding.tvTaskName.text = task.name

            if (task.isCompleted) {
                binding.tvTaskName.paintFlags = binding.tvTaskName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                binding.btnEdit.isEnabled = false
                binding.btnComplete.setImageResource(R.drawable.ic_undo)
            } else {
                binding.tvTaskName.paintFlags = binding.tvTaskName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                binding.btnEdit.isEnabled = true
                binding.btnComplete.setImageResource(R.drawable.ic_complete)
            }

            binding.btnEdit.setOnClickListener { onEditClick(task) }
            binding.btnDelete.setOnClickListener { onDeleteClick(task) }
            binding.btnComplete.setOnClickListener { onCompleteClick(task) }
        }
    }

    class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
    }
}