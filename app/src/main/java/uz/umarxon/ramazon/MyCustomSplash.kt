package uz.umarxon.ramazon

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.umarxon.ramazon.databinding.ActivitySplashBinding

class MyCustomSplash : AppCompatActivity() {
    lateinit var binding:ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        binding.lottieAnimationView.setMaxFrame(225)

        window.navigationBarColor = resources.getColor(R.color.purple2)
        window.statusBarColor = resources.getColor(R.color.purple2)

        binding.lottieAnimationView.addAnimatorListener(object: Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                Constants.isFirst = false
                finish()
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationRepeat(p0: Animator?) {

            }
        })

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}