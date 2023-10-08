# Android MVVM Example

This is an Android project template written in Kotlin, designed to serve as a starting point for Android projects. This project incorporates various modern Android development practices and libraries to make it robust and maintainable.

## Features and Technologies Used

- **Kotlin**: The project is written in Kotlin, a modern, expressive, and concise programming language for Android development.
- **Ktlint**: Ktlint is used for code formatting to ensure a consistent and clean codebase.
- **MVVM Architecture**: This project follows the Model-View-ViewModel (MVVM) architecture pattern, promoting separation of concerns and maintainability.
- **Dagger (Hilt)**: Dagger Hilt is used for dependency injection, making it easy to manage and test dependencies.
- **Retrofit (Moshi)**: Retrofit is used for making network requests, and Moshi is used for JSON parsing.
- **Epoxy Recycler View**: Epoxy is utilised to simplify and enhance RecyclerView implementations.
- **Firebase**: Firebase is integrated for various features such as authentication, analytics, and cloud functions.
- **NYT API**: The app fetches book information from the New York Times (NYT) API. To use the API, you need to obtain your own API Key from the [NYT API](https://developer.nytimes.com/apis).
- **Google Services File**: You also need to provide your own Google Services file for Firebase integration.

## Getting Started

1. Clone this repository to your local machine:

   ```bash
   git clone <repository_url>
   ```
2. Obtain your NYT API Key from the NYT Developer Portal and add it to the app/secret.properties file:

   ```secret.properties
   apiKey=xxxxxx
   ```
3. Provide your own Google Services file for Firebase integration.
4. Build and run the app on your Android device or emulator.

## Fastlane Support
This project includes Fastlane integration for automating common development tasks. You can customise Fastlane configurations according to your needs.

## Contributing
If you would like to contribute to this project or have suggestions for improvements, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Submit a pull request with a detailed description of your changes.

## License
Apache License 2.0
