package com.zebra.bluetooth

import com.facebook.react.bridge.*
import com.zebra.sdk.comm.BluetoothConnection
import com.zebra.sdk.printer.discovery.*

class ZebraPrinterModule(
    reactContext: ReactApplicationContext
) : ReactContextBaseJavaModule(reactContext) {

    override fun getName() = "ZebraPrinter"

    @ReactMethod
    fun scanPrinters(promise: Promise) {
        val list = Arguments.createArray()

        BluetoothDiscoverer.findPrinters(
            reactApplicationContext,
            object : DiscoveryHandler {

                override fun foundPrinter(printer: DiscoveredPrinter) {
                    val map = Arguments.createMap()
                    map.putString("name", printer.friendlyName)
                    map.putString("mac", printer.address)
                    list.pushMap(map)
                }

                override fun discoveryFinished() {
                    promise.resolve(list)
                }

                override fun discoveryError(message: String) {
                    promise.reject("DISCOVERY_ERROR", message)
                }
            }
        )
    }

    @ReactMethod
    fun printZPL(mac: String, zpl: String, promise: Promise) {
        try {
            val connection = BluetoothConnection(mac)
            connection.open()
            connection.write(zpl.toByteArray())
            connection.close()
            promise.resolve(null)
        } catch (e: Exception) {
            promise.reject("PRINT_ERROR", e.message)
        }
    }
}
