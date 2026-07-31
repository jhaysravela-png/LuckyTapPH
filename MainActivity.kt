
package com.jayson.cointap
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var coins = 0
    var timeLeft = 30
    var playing = false
    lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tapBtn = findViewById<Button>(R.id.tapBtn)
        val scoreTxt = findViewById<TextView>(R.id.scoreTxt)
        val timeTxt = findViewById<TextView>(R.id.timeTxt)
        val msgTxt = findViewById<TextView>(R.id.msgTxt)
        tapBtn.setOnClickListener {
            if (!playing) {
                playing = true
                coins = 0
                timeLeft = 30
                timer = object: CountDownTimer(30000, 1000) {
                    override fun onTick(m: Long) {
                        timeLeft--
                        timeTxt.text = "Time: $timeLeft"
                    }
                    override fun onFinish() {
                        playing = false
                        msgTxt.text = "Game Over! Coins: $coins"
                        timeTxt.text = "Time: 0"
                    }
                }.start()
            }
            if (playing) {
                coins++
                scoreTxt.text = "Coins: $coins"
            }
        }
    }
}
