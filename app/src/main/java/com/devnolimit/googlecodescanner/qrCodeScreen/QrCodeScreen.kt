package com.devnolimit.googlecodescanner.qrCodeScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun QrCodeScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    var scanText by remember { mutableStateOf("") }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    scanQrResult(context = context){
                        scanText = this
                    }
                }) {
                    Text(text = "Scan QR Code")
                }
                Button(onClick = {
                    scanText = ""
                }) {
                    Text(text = "Clear")
                }
            }
            AnimatedVisibility(visible = scanText.isNotEmpty()) {
                Spacer(modifier = Modifier.padding(20.dp))
                Text(text = scanText)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QrCodeScreenPreview(){
    QrCodeScreen()
}