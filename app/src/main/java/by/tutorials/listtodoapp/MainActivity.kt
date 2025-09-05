package by.tutorials.listtodoapp

import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.tutorials.listtodoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val taskAdapter = TaskAdapter(
            onEditClick = { task ->
                showEditTaskDialog(task)
            },
            onDeleteClick = { task ->
                taskViewModel.deleteTask(task)
            },
            onCompleteClick = { task ->
                taskViewModel.toggleTaskCompletion(task)
            }
        )

        binding.rvTaskList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = taskAdapter
        }

        binding.btnAddTask.setOnClickListener {
            val taskName = binding.etTaskInput.text.toString()
            if (taskName.isNotBlank()) {
                taskViewModel.addTask(taskName)
                binding.etTaskInput.text.clear()
            }
        }

        taskViewModel.tasks.observe(this) { tasks ->
            taskAdapter.submitList(tasks)
        }
    }

    private fun showEditTaskDialog(task: Task) {
        val editText = EditText(this)
        editText.setText(task.name)
        editText.setPadding(48, 24, 48, 24)

        AlertDialog.Builder(this)
            .setTitle("Edit Task")
            .setView(editText)
            .setPositiveButton("Save") { dialog, _ ->
                val newName = editText.text.toString()
                if (newName.isNotBlank()) {
                    taskViewModel.updateTask(task, newName)
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }
            .create()
            .show()
    }
}