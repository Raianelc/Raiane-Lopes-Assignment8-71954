package com.stu71954.raiane_lopes_assignment8_71954

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.media.MediaPlayer
import androidx.compose.ui.Alignment

@Composable
fun SoundControlButtons(mediaPlayer: MediaPlayer) {
    var isPlaying by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                if (!isPlaying) {
                    mediaPlayer.start()
                    isPlaying = true
                }
            },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Start Sound")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (isPlaying) {
                    mediaPlayer.pause()
                    isPlaying = false
                }
            },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Stop Sound")
        }
    }
}