package edu.unicauca.lookapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import edu.unicauca.lookapp.core.utils.StartupInitializer
import javax.inject.Inject

@HiltAndroidApp
class LookappApp: Application() {
    @Inject
    lateinit var startupInitializer: StartupInitializer

    override fun onCreate() {
        super.onCreate()
        startupInitializer.initialize()
    }
}