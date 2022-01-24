# RoomDB

 Mobil Yazılım dünyasında cihazlarda istenilen bilgileri depolamak için birkaç veri tabanı kullanmaktayız.Bunlardan biri SQLite’tır.Google OI’17 gerçekleşmesi ile biz geliştiricilere SQLite kullanımını daha da kolaylaştıracak fazla kod kalabalığından kurtaracak `Room Kütüphanesi` duyurulmuştu.
Room Kütüphanesi sayesinde SQLite ile oluşturduğumuz bir veri tabanın da veri ekleme,silme,güncelleme ve listeleme gibi işlemleri yaparken önümüze çıkan hataları bulmak daha kolay hale gelmektedir.

>Gradle'ın en üstüne “kotlin-kapt” eklentisini ekleyerek başlayalım.
 
 ```
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-kapt'
}
```

>Ardından, Room için gerekli bağımlılıkları ekleyeceğiz.

 ```
  def room_version = "2.3.0"
 
  implementation "androidx.room:room-runtime:$room_version"
  kapt "androidx.room:room-compiler:$room_version"
  implementation "androidx.room:room-ktx:$room_version"
```

>Ardından, coroutines için gerekli bağımlılıkları ekleyeceğiz.
```
  implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2'
  implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2'
```
