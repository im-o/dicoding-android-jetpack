package rivaldy.dicoding.jetpack.mvvm.ui.main

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import rivaldy.dicoding.jetpack.mvvm.R
import rivaldy.dicoding.jetpack.mvvm.utils.UtilConst.DELAY_2000
import rivaldy.dicoding.jetpack.mvvm.utils.UtilExtensions.openActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(mainLooper).postDelayed({
            openActivity(MainActivity::class.java)
            finish()
        }, DELAY_2000)
    }
}