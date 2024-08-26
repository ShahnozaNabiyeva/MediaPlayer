package com.shahnoza.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.shahnoza.mediaplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var mediaPlayer:MediaPlayer
    lateinit var handler: Handler
   // val musicLink="https://www.soundhelix.com/examples/mp3/SoundHelix-Song-9.mp3"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

     mediaPlayer=MediaPlayer.create(this,R.raw.mymusic)

     //   mediaPlayer=MediaPlayer()   onlayn musiqa
/*
mediaPlayer.setOnPreparedListener { // internet orqali musiqa-metod bu orqali ishlaydi

 mediaPlayer.setDataSource(musicLink)
        binding.seekBar.max=mediaPlayer.duration // seekbar davomiyligini mediaplayer musiqaning uzunligiga tenglaymiz
        mediaPlayer.start()
        handler=Handler(Looper.getMainLooper())
        handler.postDelayed(runnable,1000) // delayMills - o'zgarish oalig'i xar bir sekund
        mediaPlayer.prepareAsync()
        }
 */


       handler=Handler()
       binding.seekBar.max=mediaPlayer.duration
       binding.seekBar.progress=mediaPlayer.currentPosition
       handler.postDelayed(runnable,1000)

        binding.btnPlay.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show()
        }

        binding.btnPaus.setOnClickListener {
            mediaPlayer.start()
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show()
        }

        binding.btnStop.setOnClickListener {
            mediaPlayer.stop()
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
        }

        binding.seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               if (fromUser){//User tomonidab o'zgartirilsagina true bo'ladi
                   mediaPlayer.seekTo(progress)


               }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }
     val runnable = object :Runnable{
         override fun run() {
             binding.seekBar.progress=mediaPlayer.currentPosition
             handler.postDelayed(this,1000)
         }

     }

}