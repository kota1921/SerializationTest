plugins {
	id("com.android.application")
	id("kotlin-android")
	kotlin("plugin.serialization") version "1.5.0"
}

android {
	compileSdk = 30
	buildToolsVersion = "30.0.3"
	
	defaultConfig {
		applicationId = "com.kota.serializationtest"
		minSdk = 21
		targetSdk = 30
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
	
	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		viewBinding = true
	}
}

dependencies {
	
	implementation("androidx.core:core-ktx:1.5.0")
	implementation("androidx.appcompat:appcompat:1.3.0")
	implementation("com.google.android.material:material:1.3.0")
	
	implementation("com.jakewharton.timber:timber:4.7.1")
	
	implementation("com.alibaba:fastjson:1.1.72.android")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.10")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.1")
	implementation("com.fasterxml.jackson.core:jackson-core:2.12.3")
	implementation("com.fasterxml.jackson.core:jackson-annotations:2.12.3")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.12.3")
	implementation("com.google.code.gson:gson:2.8.7")
	implementation("com.squareup.moshi:moshi:1.12.0")
	implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
	
	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.2")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}