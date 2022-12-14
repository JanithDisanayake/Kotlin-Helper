# Weather App with Volly

## USED
* Volly
* Open Weather API (https://openweathermap.org/)

## CODE

#### set array adapter
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
---
#### function of the spinner
```kotlin
var selected_city = if(spn_city.selectedItem == "Colombo") "colombo"
else if(spn_city.selectedItem == "Washington") "washington"
else if(spn_city.selectedItem == "London") "london"
else if(spn_city.selectedItem == "Tokyo") "tokyo"
else "colombo"
getWeatherData(selected_city)
```
