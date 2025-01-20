Canvas App 📱

A simple Android app built with Kotlin to display posts and user details fetched from <a href="https://jsonplaceholder.typicode.com/">JSONPlaceholder</a>. 
The app follows Clean Architecture principles and uses modern Android development best practices.

Key Features 🚀
	•	Fetch and display posts with user names, titles, and bodies.
	•	Clean architecture using MVVM.
	•	Coroutines/Flows for asynchronous data handling.
	•	Retrofit for API integration.
	•	Dagger/Hilt for dependency injection.
	•	Unit testing with MockK.

Tech Stack ⚙️
	•	MVVM: Clear separation of concerns for maintainable code.
	•	Kotlin Coroutines/Flows: Efficient background tasks and real-time UI updates.
	•	Retrofit: Simplifies network requests and JSON parsing.
	•	Dagger/Hilt: Reduces boilerplate for dependency injection.
	•	MockK: Mocks dependencies for unit tests.

Installation 🛠️
	1.	Clone the repository:

git clone https://github.com/yourusername/CanvasApp.git

	2.	Open in Android Studio.
	3.	Sync Gradle and run the app on an emulator or device.

Dependencies 📦

implementation "com.squareup.retrofit2:retrofit:2.9.0"
implementation "com.google.dagger:hilt-android:2.48"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"
testImplementation "io.mockk:mockk:1.13.5"

API Endpoints 🌐
	•	Posts: https://jsonplaceholder.typicode.com/posts
	•	Users: https://jsonplaceholder.typicode.com/users

Testing 🧪
	•	Unit tests for ViewModel, Repository, and Use Case using:
	•	MockK for mocking.
	•	Kotlin Coroutines Test for coroutine testing.

Happy Coding! 😊
