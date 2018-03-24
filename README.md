# weatherapp
ABSTRACT
This is a simple android application which has two activities. It uses Accuweather API to fetch the weather Information. And displays up to 5 upcoming days of forecast including Max, Min Temperature.
INTRODUCTION
•	The app is developed for Target Android API 25. 
•	The main Activity displays the current weather conditions for the city Vellore. It shows Current temperature and the current weather conditions. And contains a button which links to another activity.
•	The second Activity displays the forecast for next 5 days in the list form as Max Temperature and Min temperature.
METHODOLOGY
First thing I did was create an API key from https://developer.accuweather.com/ 
 
Next find the location key for the Vellore city from API reference page.
 
Get the JSON for current weather and 5 days forecast by entering your API key and location key.
 
Now we start developing in Android studio. We need NetworkUtils java files to connect to Accuweather
 
We need to fetch the weather details in JSON from the Accuweather website
 
And parse the JSON fetched
 
Parsed JSON can be seen from the Logcat window when we run the app. Validate the JSON just to be safe from JSON Validator
 
Weather Adapter java file is used to parse the JSON and convert view in to the required list format
 
   
SOME PROBLEMS FACED DURING EXECUTION:
I was getting an Access denied error for mainActivity.java and NetworkUtils.java when it was trying to access Accuweather website
 
 
 

REFERENCES AND RESOURCES
1.	https://developer.accuweather.com/
2.	https://jsonlint.com/
3.	https://www.androidhive.info/2012/01/android-json-parsing-tutorial/
4.	https://stackoverflow.com/questions/4186021/how-to-start-new-activity-on-button-click
5.	https://www.tutorialspoint.com/android/android_list_view.htm
