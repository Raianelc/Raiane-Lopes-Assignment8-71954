package com.stu71954.raiane_lopes_assignment8_71954

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.provider.Settings

fun initializeMediaPlayer(context: Context): MediaPlayer {
    val notification: Uri = Settings.System.DEFAULT_NOTIFICATION_URI
    return MediaPlayer.create(context, notification)
}