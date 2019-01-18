# health-tracker

## Description

# LAB 26 

<p float="left">
 <img src="./screenshots/lab_26.jpg" width="150" />
</p>
###Finger Exercises
One key part of health is building finger strength and endurance. On the main page, display a number and a button. The number should increase when the button is clicked.

###Stopwatch
Still on the main page, add a stopwatch. Have a button to [Start/Pause] and [Reset] the clock. The start/pause button should toggle between saying “start” and “pause.” And you should only be able to reset when the stopwatch is paused.

Have the view update as fast as possible while still leaving the buttons responsive.

Display the clock as 0:00:00.000 so it should be able to track up to 9 hours, 59 minutes, 59 seconds and 999 milliseconds.

You can use System.currentTimeMillis() to track the start and current time at the millisecond-level.

Sources used: https://www.youtube.com/watch?v=Dr-VtCbev10, http://www.zoftino.com/android-chronometer-timer-stopwatch-tutorial

###Inspiring Image Carousel
At the top of our main page, we want to inspire our users with images of the type of person they can become. Display an image with a caption below it. (The caption should NOT be part of the image; it should be text.) Allow users to cycle through images and read the captions. Pressing next should go to the next image and its caption, pressing prev should go back. The app should display a (1/N), (2/N) … indicator so users know how many items are in the list.

You may choose the images and captions. Have fun.
Your app must use a class to model the images and their captions. Use the class to manually instantiate each unique item. Add all of the items to an array.
Your app should use the array of image objects to cycle through what it’s showing.

# LAB 27

 <p float="left">
 <img src="./screenshots/lab_27.jpg" width="150" />
</p>

Navigation
Yesterday, all of your app’s features were on the home page. Let’s clear up that homepage and allow users to visit individual pages for those various features.

Move your Finger Exercises and Stopwatch into their own pages of your app. Add buttons on the homepage to link to those pages, and ensure that the user can use the back button on the device to return to the app homepage. (It’s good practice to include some sort of back button on the page as well.)

It’s up to you whether you’d like to use the Navigation Architecture Component, or plain intents-and-activities, or something else to implement this navigation.

Health Notifications
Create a new activity for Notifications. Allow users to set up reminders to drink water, which should appear every 2 hours in the notification bar. (For testing, you might want to shorten this to 15 or 30 seconds.)

Styling
Apply consistent styling across the various Activities in your app. Make sure they have a consistent look and feel, and that buttons are in similar locations on each screen.

## Daily Log
1/8/2018: Finished most funcionality
1/9/2018: no work completed
1/10/2018: seperated into to new activities
1/11/2018: fixed code, finished lab 26, 27, 28

## ScreenShots

![lab_26](./screenshots/lab_26.jpg)
![lab_27](./screenshots/lab_27.jpg)
![lab_27](./screenshots/lab_27_2nd.jpg)