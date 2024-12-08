package com.stu71954.raiane_lopes_assignment8_71954

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.provider.Settings


// Function to Initialize MediaPlayer with the default alarm sound
fun initializeMediaPlayer(context: Context): MediaPlayer {
    val alarm: Uri = Settings.System.DEFAULT_ALARM_ALERT_URI
    return MediaPlayer.create(context, alarm)
}