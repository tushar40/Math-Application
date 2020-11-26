# MathApplication

An app to perform basic math operations (addition & subtraction) The app has
have 2 modules:
### Library Module
- Create a MathOps interface (addition, subtraction) and its implementation.
- Interface will be called by the App module to perform the math operations.
### App Module:
- This contains all the UI elements having dependency on the library module.
- There will be 2 activities in the app.
- Activity 1 will have 2 text boxes (number 1 & number 2) and 2 buttons (addition, subtraction)
- On button click, the math operation is performed using the interface and the result is sent to activity 2.
- Activity 2 will display the result of the math operation.
- Errors and exceptions to be handled gracefully.

​![alt text](https://github.com/tushar40/Math-Application/blob/master/readme-images/compute_screen.png)
​![alt text](https://github.com/tushar40/Math-Application/blob/master/readme-images/result_screen.png)


This project is built using Kotlin and AndroidX.

# Contents at a Glance
* [Getting Started](#getting-started)
  * [Clone the Repository](#clone-the-repository)
  * [Open and Run Project in Android Studio](#open-and-run-project-in-android-studio)
  * [Generating APK](#generating-apk)
  * [Components](#components)
* [Dependencies](#dependencies)
  * [Libraries Used](#libraries-used)
  * [Licenses](#licenses)
## Getting Started

### Clone the Repository

```
$ git clone https://github.com/tushar40/Math-Application.git
```

### Open and Run Project in Android Studio

- Open the project up in Android Studio.
- Click on the `Run App` (Green play button in top bar)

At this point, you *should* be able to build and run the project in the Android device or emulator.

### Generating APK

From Android Studio:

1. ***Build*** menu
2. ***Build Bundle(s) / APK(s)***
3. ***Build APK***

### Components
- Activities
  - ***ComputeActivity*** - The activity which is presented to the user when the app is launched. It is used to present textView for entering data and button for computing the result.
  - ***ResultActivity*** - It is dused to present the result computed by the ComputActivity.

- Fragments
  - ***SearchTweetFragment*** - This fragment is displaying the list of tweets with the top search bar for searching the tweets.
  
  - ***SplashFragment*** - This fragment is displaying the device registration process on app start.

- ViewModels
  - ***ComputeViewModel*** - The viewModel for Math operation in Home Screen
  - ***ResultViewModel*** - The viewModel to show the result in the Result Screen

- Utils
  1. LiveEvent - Returns the content and prevents the use of LiveData again.

- MathLibrary
  - MathOps - A class for handling mathematical operations (Addition, Subtraction).

## Dependencies

### Libraries Used
  1. [Lottie Android](https://github.com/airbnb/lottie-android)
  2. [Google Material](https://github.com/material-components/material-components-android)

### Licenses

- Android native dependencies (Data Binding, Kotlin, Testing etc) - Apache 2.0
- lottie-android - Apache 2.0
- material-components-android - Apache 2.0
