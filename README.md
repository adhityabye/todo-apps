# List TODO App 📝
​
 A simple, modern, and efficient TODO list application for Android, built with Kotlin and following modern Android development practices. This application allows users to manage their daily tasks through a clean and intuitive user interface. All data is managed locally and persists through configuration changes like screen rotation.
​
 ## Features
​
 - **Add Tasks**: Quickly add new tasks via an input field.
 - **View Tasks**: All tasks are displayed in a clean, scrollable list.
 - **Edit Tasks**: Modify the name of an existing task.
 - **Delete Tasks**: Remove tasks you no longer need.
 - **Mark as Complete**: Tap a button to mark a task as complete, which visually strikes through the task name and disables editing.
 - **Data Persistence**: Uses `ViewModel` to ensure your task list survives screen rotations and other configuration changes.
 - **Modern UI**: A visually appealing interface built with Material Design components, a blue color theme, and custom-styled elements.
​
 ## Tech Stack & Architecture
​
 - **Language**: [Kotlin](https://kotlinlang.org/)
 - **Architecture**: MVVM (Model-View-ViewModel)
 - **Core Android Components**:
     - **ViewModel**: To store and manage UI-related data in a lifecycle-conscious way.
     - **LiveData**: To build data objects that notify views of any database changes.
     - **RecyclerView**: For displaying the list of tasks efficiently.
     - **ViewBinding**: To more easily write code that interacts with views.
 - **UI**:
     - Android XML Layouts
     - **Material Design Components**: For a modern and consistent look and feel.
     - **CardView**: To display each task item in a distinct card.
     - Custom Drawable Resources for shapes and backgrounds.
​
 ## Prerequisites
​
 Before you begin, ensure you have the following installed:
​
 - **Android Studio**: 2023.2.1 or later.
 - **Android SDK**: API level 21 or higher.
 - **Git**: For cloning the repository.
​
 ## How to Run
​
 Follow these steps to get the project up and running on your local machine.
​
 1.  **Clone the Repository**
     Open your terminal or command prompt and clone the project using Git:
     ```bash
     git clone <YOUR_REPOSITORY_URL_HERE>
     ```
​
 2.  **Open in Android Studio**
     - Launch Android Studio.
     - Select **File** > **Open**.
     - Navigate to the directory where you cloned the project and select it.
​
 3.  **Sync Gradle**
     - Android Studio should automatically start a Gradle sync process. This will download all the necessary dependencies for the project.
     - If it doesn't start automatically, you can trigger it by clicking the **Sync Project with Gradle Files** icon in the toolbar.
​
 4.  **Run the Application**
     - Select a target device (either a physical device connected via USB or an Android emulator).
     - Click the **Run 'app'** button (the green play icon) in the top toolbar.
​
 The app will now build, install, and launch on your selected device.
Happy Coding! :D
