package uz.umarxon.ramazon

import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData

object Constants {
    var pause_all = MutableLiveData(false)
    var title = MutableLiveData("Asosiy sahifa")
    var player = MediaPlayer()
    var player2 = MediaPlayer()
    var isFirst = true
    var today = MutableLiveData("")
    var todayUz = MutableLiveData("")
}