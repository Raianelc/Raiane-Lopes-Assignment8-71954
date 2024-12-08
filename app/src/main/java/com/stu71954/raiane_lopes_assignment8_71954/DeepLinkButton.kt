package com.stu71954.raiane_lopes_assignment8_71954

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext


// DeepLinkButton composable function that takes a deepLinkUrl as a parameter and creates a Button composable that when clicked opens the deepLinkUrl in the browser.
@Composable
fun DeepLinkButton(deepLinkUrl: String?) {
    val context = LocalContext.current
    deepLinkUrl?.let {
        Button(
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Text("Go to DeepLink")
        }
    }
}