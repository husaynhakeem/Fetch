# Fetch

This project contains 2 modules:
- The "Fetch" library
- A sample application using the "Fetch" library

The sample application was developped using the MVP (Model View Presenter) pattern


### Libraries used in this project
- [RxJava2 and RxAndroid2](https://github.com/ReactiveX/RxJava)
- [ButterKnife](http://jakewharton.github.io/butterknife/)
- [Gson](https://github.com/google/gson)
- [Parceler](https://github.com/johncarl81/parceler)
- [Picasso](http://square.github.io/picasso/)
- [Gradle Retrolambda plugin](https://github.com/evant/gradle-retrolambda)
- [RecyclerView and CardView (DesignLibrary)](https://developer.android.com/training/material/lists-cards.html)
- [HttpUrlConnection](https://developer.android.com/reference/java/net/HttpURLConnection.html)


### Fetch Library

Just as its name indicates, "Fetch" is a library that fetches for data over the network. The idea behind this library is to centralise loading different types of data (be it images, videos, files, text -Json, xml, etc-). 

So far, the supported data types are images and text. 


### Fetch Sample Application

This is an sample application based on the Master/Detail navigation flow. 
- The master displays a list of images. The images and all their information are fetched using the "Fetch" library.
- The detail view displays the details of a photo.


### Demo

