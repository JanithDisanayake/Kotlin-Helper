# Weather App with Volly
<br>

## How to Use
* first pull this project
* open in android studio and build it
* replace the api key with your own key ([MainActivity.kt](./app/src/main/java/com/example/weatherapp/MainActivity.kt) file line 48)
<br>

## Used
* Volly
* Open Weather API (https://openweathermap.org/)
<br>

## Coverd area
* dynimically add values to spinner (drop down list)
* volly request handling
<br>

## Additional Dependancies
> ```kotlin
>  implementation("com.android.volley:volley:1.2.1") 
>  ```
<br>

## Code

#### :point_right: set array adapter  [`>>`](./app/src/main/java/com/example/weatherapp/MainActivity.kt)
```kotlin
val spn_city = findViewById<Spinner>(R.id.spn_city)
var city = ArrayList<Any>()
city.add("Colombo")
city.add("Washington")
city.add("London")
city.add("Tokyo")
var adapter = ArrayAdapter<Any> (this, android.R.layout.simple_spinner_item, city)
spn_city.adapter = adapter
```
* `spn_city is the id of spinner`

#### :point_right: function of the spinner  [`>>`](./app/src/main/java/com/example/weatherapp/MainActivity.kt)
```kotlin
var selected_city = if(spn_city.selectedItem == "Colombo") "colombo"
else if(spn_city.selectedItem == "Washington") "washington"
else if(spn_city.selectedItem == "London") "london"
else if(spn_city.selectedItem == "Tokyo") "tokyo"
else "colombo"
getWeatherData(selected_city)
```

#### :point_right: make Volley Request  [`>>`](./app/src/main/java/com/example/weatherapp/MainActivity.kt)
```kotlin
var request = JsonObjectRequest(
    com.android.volley.Request.Method.GET,
    "https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=69f503e650105171a22c295f2a7ce03c",
    JSONObject(),
    {   response ->
        val txt_desc = findViewById<TextView>(R.id.txt_desc)
        val txt_temp = findViewById<TextView>(R.id.txt_temp)
        val txt_wind = findViewById<TextView>(R.id.txt_wind)
        val txt_hum = findViewById<TextView>(R.id.txt_hum)

        txt_desc.setText("Description: \t ${response.getJSONArray("weather").getJSONObject(0).get("description").toString()}",)
        txt_temp.setText("Temp: \t ${response.getJSONObject("main").get("temp").toString()}")
        txt_wind.setText("Wind: \t ${response.getJSONObject("wind").get("speed").toString()}")
        txt_hum.setText("Humidity: \t ${response.getJSONObject("main").get("humidity").toString()}")
    },
    {   error ->
        Log.e("error", error.toString())
    }
)
```

#### :point_right: send Volly Request  [`>>`](./app/src/main/java/com/example/weatherapp/MainActivity.kt)
```kotlin
Volley.newRequestQueue(applicationContext).add(request) 
```

