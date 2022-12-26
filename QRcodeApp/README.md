# QR code Generating App
<br>

## How to use

* first pull this project
* open with android studio and build it
* Run this app using you phone or virtual matchine
<br>

## Used 

* Bitmap
<br>

## Coverd Area

* Bitmap for QR
* Show in Image View
<br>

## Additional Dependancies

>```kotlin
>implementation('com.journeyapps:zxing-android-embedded:4.3.0') { transitive = false }
>implementation 'com.google.zxing:core:3.3.0'
>```
<br>

## Code

#### :point_right: declare compounents  [`>>`](./app/src/main/java/com/example/qrcodeapp/MainActivity.kt)
```kotlin
ivQRcode = findViewById(R.id.ivQRCode)
etData = findViewById(R.id.etData)
btnGenerate = findViewById(R.id.btn_generator)
```

#### :point_right: get the data  [`>>`](./app/src/main/java/com/example/qrcodeapp/MainActivity.kt)
```kotlin
val data = etData.text.toString().trim()
```

#### :point_right: generate QR code [`>>`](./app/src/main/java/com/example/qrcodeapp/MainActivity.kt)
```kotlin
val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 512, 512)
val width = bitMatrix.width
val height = bitMatrix.height
val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
for(x in 0 until height) {
    for(y in 0 until height) {
        bmp.setPixel(x,y,if(bitMatrix[x,y]) Color.BLACK else Color.WHITE)
    }
}
```

#### :point_right: show QR code [`>>`](./app/src/main/java/com/example/qrcodeapp/MainActivity.kt)
```kotlin
ivQRcode.setImageBitmap(bmp)
```
* `ivQRcode is the id of image view`
                    

