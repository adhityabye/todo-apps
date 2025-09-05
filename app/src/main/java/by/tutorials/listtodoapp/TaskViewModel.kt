package by.tutorials.listtodoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private val _tasks = MutableLiveData<List<Task>>(emptyList())
    val tasks: LiveData<List<Task>> get() = _tasks

    private var nextId = 0L

    fun addTask(taskName: String) {
        val newTask = Task(id = nextId++, name = taskName)
        _tasks.value = _tasks.value.orEmpty() + newTask
    }

    fun deleteTask(task: Task) {
        _tasks.value = _tasks.value.orEmpty().filter { it.id != task.id }
    }

    fun updateTask(task: Task, newName: String) {
        _tasks.value = _tasks.value.orEmpty().map {
            if (it.id == task.id) {
                it.copy(name = newName)
            } else {
                it
            }
        }
    }

    fun toggleTaskCompletion(task: Task) {
        _tasks.value = _tasks.value.orEmpty().map {
            if (it.id == task.id) {
                it.copy(isCompleted = !it.isCompleted)
            } else {
                it
            }
        }
    }
}
