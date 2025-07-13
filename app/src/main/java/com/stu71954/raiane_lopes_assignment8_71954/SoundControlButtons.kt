package com.stu71954.raiane_lopes_assignment8_71954

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import android.media.MediaPlayer
import androidx.compose.material.icons.outlined.Refresh


@Composable
fun SoundControlButtons(mediaPlayer: MediaPlayer) {
    var isPlaying by remember { mutableStateOf(false) }

    DisposableEffect(mediaPlayer) {
        val listener = MediaPlayer.OnCompletionListener { isPlaying = false }
        mediaPlayer.setOnCompletionListener(listener)
        onDispose { mediaPlayer.setOnCompletionListener(null) }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sound Player",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Play or stop the default alarm sound.",
            style = MaterialTheme.typography.bodyMedium
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1976D2)),
                elevation = CardDefaults.cardElevation(16.dp),
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier.size(width = 160.dp, height = 80.dp)
            ) {
                Button(
                    onClick = {
                        if (!isPlaying) {
                            mediaPlayer.start()
                            isPlaying = true
                        }
                    },
                    enabled = !isPlaying,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
                ) {
                    Icon(
                        Icons.Filled.PlayArrow,
                        contentDescription = "Play",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(12.dp))
                    Text("Play", color = Color.White)
                }
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFD32F2F)),
                elevation = CardDefaults.cardElevation(16.dp),
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier.size(width = 160.dp, height = 80.dp)
            ) {
                Button(
                    onClick = {
                        if (isPlaying) {
                            mediaPlayer.pause()
                            isPlaying = false
                        }
                    },
                    enabled = isPlaying,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC62828))
                ) {
                    Icon(
                        Icons.Outlined.Refresh,
                        contentDescription = "Stop",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(Modifier.width(12.dp))
                    Text("Stop", color = Color.White)
                }
            }
        }
    }
}