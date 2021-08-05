# basic-calculator
Stage 4 of 4 for JetBrains Academy - Android - [Basic Calculator project](https://hyperskill.org/projects/190/stages/952/implement).       
The app can do basic calculations. The files are just a skeleton off the files needed to run in Android Studio. 
## Requirements
### Description
Your app can calculate things. But you can still improve the app by automating some of its features.
### Objectives
1. Clean `editText` automatically after choosing an operation. Let's also set the entered value as a hint, so that users can see that they have typed everything correctly.
2. If you're using `Double`, you get `.0` in your result. Get rid of it when a result is a whole number.
### Example
![stage4](https://user-images.githubusercontent.com/64429863/127025721-9cd6e848-d148-4d92-be33-2c9f18195326.gif)
### Notes
The files are just a skeleton of the files needed to run in Android Studio. I'm not comfortable with just uploading everything in the project folder ( I'm not sure what files are specific to my computer, as some files are encoded in a way that I don't know what is in them ), so to get this to work you'll need to create an empty project with the same name and add the files to it and make changes to the gradle files accordingly. There's some things in the two gradle files that will not be needed, as they are specific to the class project for testing the app. The only things I personally added was:
```
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    implementation "androidx.activity:activity-ktx:1.2.3"
```
Inside the dependencies of the build.gradle Module file. And then also inside that file:
```
    buildFeatures {
        viewBinding true
    }
```
