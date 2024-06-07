package com.devnolimit.googlecodescanner.qrCodeScreen

import android.content.Context
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

//Options For QR Code Scanner
val options = GmsBarcodeScannerOptions.Builder()
    .setBarcodeFormats(Barcode.FORMAT_ALL_FORMATS)
    .enableAutoZoom()
    .allowManualInput()
    .build()



// Scan QR Code
fun scanQrResult(
    context: Context,
    result: String.() -> Unit
){
    val scanner = GmsBarcodeScanning.getClient(context, options)
    scanner.startScan().addOnSuccessListener {
        result(it.rawValue.orEmpty())
    }
}