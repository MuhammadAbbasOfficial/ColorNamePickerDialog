Color Name Picker Android Library

> Step 1. Add the JitPack repository to your build file

'''dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}'''


if you are using kotlin DSL then add this line
        '''maven { url = uri("https://jitpack.io") }'''


 Step 2. Add the dependency

'''dependencies {
	        implementation 'com.github.MuhammadAbbasOfficial:ColorNamePickerDialog:1.0'
	}'''
