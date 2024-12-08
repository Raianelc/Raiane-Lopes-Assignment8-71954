package com.stu71954.raiane_lopes_assignment8_71954

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stu71954.raiane_lopes_assignment8_71954.ui.theme.RaianeLopesAssignment871954Theme


// MainActivity class that extends ComponentActivity and initializes a MediaPlayer object.
class MainActivity : ComponentActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private var _deepLinkUrl = mutableStateOf<String?>(null)
    private var deepLinkUrl: String?
        get() = _deepLinkUrl.value
        set(value) {
            _deepLinkUrl.value = value
        }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize MediaPlayer
        mediaPlayer = initializeMediaPlayer(this)

        // Handle DeepLink
        deepLinkUrl = "https://www.adjust.com/resources/guides/deep-linking/"

        setContent {
            RaianeLopesAssignment871954Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(title = { Text("Assignment 8") })
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))
                        SoundControlButtons(mediaPlayer)
                        Spacer(modifier = Modifier.height(16.dp))
                        DeepLinkButton(deepLinkUrl)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}