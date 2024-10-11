# MyRecipeApp

MyRecipeApp is a simple Android application that fetches recipe categories from [TheMealDB API](https://www.themealdb.com/api.php) and displays them in a grid format. The app is built using Jetpack Compose and follows modern Android development practices.

## Features

- Fetches recipe categories using Retrofit from TheMealDB API.
- Displays categories in a grid format using Jetpack Compose's `LazyVerticalGrid`.
- Includes error handling and loading states with a `ViewModel`.
- Uses Coil for loading images asynchronously.

## Prerequisites

Before running this project, make sure you have the following:

- Android Studio (latest version)
- Minimum SDK version: 21
- Target SDK version: 34
- Gradle 8.6 or above
- Kotlin 1.8 or above
- Internet access for API requests

## How to Run

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Harsh1652/MyRecipeApp.git
