# Google Map App (Get Current Location)
<br>

## How to Use
* first pull this project
* open in android studio and build it
* add your own google api key ([MainActivity.kt](./app/src/main/AndroidManifest.xml) file line 30)
* run using your emulator or phone
<br>

## Used
* Google Maps
<br>

## Coverd area
* Google maps getting current location
* View Binding
<br>

## Permissions
>```xml
><uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
>```
<br>

## Code

#### :point_right: declare variables  [`>>`](./app/src/main/java/com/example/googlemapapp_currentlocation/MapsActivity.kt)
```kotlin
private lateinit var binding: ActivityMapsBinding
private lateinit var currentLocation: Location
private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
private val permissionCode = 101
```

#### :point_right: fetch location  [`>>`](./app/src/main/java/com/example/googlemapapp_currentlocation/MapsActivity.kt)
```kotlin
fusedLocationProviderClient =  LocationServices.getFusedLocationProviderClient(this@MapsActivity)
fetchLocation()
```

#### :point_right: fetch location function [`>>`](./app/src/main/java/com/example/googlemapapp_currentlocation/MapsActivity.kt)
```kotlin
private fun fetchLocation() {
    if (ActivityCompat.checkSelfPermission(
            this, android.Manifest.permission.ACCESS_FINE_LOCATION) !=
        PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
            this, android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
        PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), permissionCode)
        return
    }
    val task = fusedLocationProviderClient.lastLocation
    task.addOnSuccessListener { location ->
        if (location != null) {
            currentLocation = location
            Toast.makeText(applicationContext, currentLocation.latitude.toString() + "" +
                    currentLocation.longitude, Toast.LENGTH_SHORT).show()
            val supportMapFragment = (supportFragmentManager.findFragmentById(R.id.map) as
                    SupportMapFragment?)!!
            supportMapFragment.getMapAsync(this@MapsActivity)
        }
    }
}
```
#### :point_right: implements OnMapReadyCallBack interface  [`>>`](./app/src/main/java/com/example/googlemapapp_currentlocation/MapsActivity.kt)
```kotlin
class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
}
```

#### :point_right: override functions of OnMapReadyCallback interface [`>>`](./app/src/main/java/com/example/googlemapapp_currentlocation/MapsActivity.kt)
```kotlin
override fun onMapReady(googleMap: GoogleMap) {
    val latLng = LatLng(currentLocation.latitude, currentLocation.longitude)
    val markerOptions = MarkerOptions().position(latLng).title("I am here!")
    googleMap?.animateCamera(CameraUpdateFactory.newLatLng(latLng))
    googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5f))
    googleMap?.addMarker(markerOptions)
}

override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
) {
    when (requestCode) {
        permissionCode ->
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            fetchLocation()
        }
    }

    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
}
```

