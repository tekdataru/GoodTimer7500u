package ru.tekdata.goodtimer7500u

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import ru.tekdata.goodtimer7500u.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var secondsAll: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timer = object: CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                //binding.button.setText(millisUntilFinished.toString())
                secondsAll++
                //binding.editTest.setText(Math.round((millisUntilFinished / 1000).toDouble()).toString())
                binding.editTest.setText(secondsAll.toString())
            }

            override fun onFinish() {}
        }

        binding.button.setOnClickListener {
            //binding.button.text = "234"
            binding.editTest.setText("10")

            timer.start()
            secondsAll = 0
        }

        binding.add30Second.setOnClickListener {
            binding.editSecondsOnLap.setText((binding.editSecondsOnLap.text.toString().toInt() + 30).toString())
        }

//        CountDownTimer(60000, 1000){
//            @Override
//            fun onTick(1) {
//                binding.button.setText("" + 1)
//            }
//        }



    }


}