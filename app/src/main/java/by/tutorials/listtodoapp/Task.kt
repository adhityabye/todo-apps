package by.tutorials.listtodoapp

data class Task(
    val id: Long,
    var name: String,
    var isCompleted: Boolean = false
)
