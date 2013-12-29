GALib
=====

kotlin for android lib

需要预先安装好kotlin for gradle, 下面是一个例子:

```
buildscript {
    ext.kotlin_version = '0.6.1910'
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:0.7.+'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$ext.kotlin_version"
    }
}
apply plugin: 'android'
apply plugin: 'kotlin-android'

repositories {
    mavenCentral()
    maven {
        url "https://github.com/mjason/mvn-repo/raw/master"
    }
}

android {
    compileSdkVersion 17
    buildToolsVersion "19.0.1"

    defaultConfig {
        minSdkVersion 14
        targetSdkVersion 19
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            runProguard false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.txt'
        }
    }
    sourceSets {
        main.java.srcDirs += 'src/main/kotlin'
    }
}

dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib:$ext.kotlin_version"
    compile "co.geekku:GALib:0.0.1@aar"
}

```

调用例子:
```java
package com.example.app

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import co.geekku.lib.GActivity
import android.widget.Button
import android.widget.Toast


public open class MainActivity() : GActivity() {

    var text : TextView? = null

    protected override fun onCreate(savedInstanceState: Bundle?): Unit {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        text = R.id.txt1.view<TextView>()

        text?.setOnClickListener {
            init()
        }

        R.id.click.view<Button>()?.setOnClickListener {
            Toast.makeText(this, "hello word", Toast.LENGTH_SHORT).show();
        }
    }

    fun init(): Unit {
        text?.setText("hello word")
    }
}

```