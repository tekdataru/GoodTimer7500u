package ru.tekdata.goodtimer7500u

import android.media.MediaPlayer
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


        val timer = object: CountDownTimer(1000000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                secondsAll++
                binding.editTest.setText(secondsAll.toString())

                //if (binding.editTest.text.equals(binding.editSecondsOnLap.text)) {
                if (binding.editTest.text.toString().equals(binding.editSecondsOnLap.text.toString())){
                    //binding.add30Second.setText("asdf")
                    onFinish()
                }
            }

            override fun onFinish() {
                playSoundEnd()
                cancel()
                binding.editTest.text.clear()
                //binding.button.setText("Gotovo!")
            }
        }

        binding.buttonStart.setOnClickListener {
            playSoundCoin()
            binding.editTest.setText("10")

            timer.cancel()
            timer.start()
            secondsAll = 0
        }

        binding.add30Second.setOnClickListener {
            val buf = if (binding.editSecondsOnLap.text.isEmpty()) {"0"} else binding.editSecondsOnLap.text.toString()
            binding.editSecondsOnLap.setText((buf.toInt() + 30).toString())
        }





    }

    fun playSoundEnd(){
        MediaPlayer.create(this@MainActivity, R.raw.sfx).start()
    }

    fun playSoundCoin(){
        MediaPlayer.create(this@MainActivity, R.raw.moneta).start()
    }


}