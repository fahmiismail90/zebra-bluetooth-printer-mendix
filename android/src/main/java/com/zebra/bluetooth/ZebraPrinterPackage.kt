package com.zebra.bluetooth

import com.facebook.react.*
import com.facebook.react.bridge.*

class ZebraPrinterPackage : ReactPackage {

    override fun createNativeModules(
        reactContext: ReactApplicationContext
    ): List<NativeModule> {
        return listOf(ZebraPrinterModule(reactContext))
    }

    override fun createViewManagers(
        reactContext: ReactApplicationContext
    ): List<ViewManager<*, *>> = emptyList()
}
