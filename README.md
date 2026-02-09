Zebra Bluetooth Printer for Mendix Native

A reusable npm module enabling Bluetooth printing to Zebra devices directly from Mendix Native Mobile apps. This module leverages the Zebra Link-OS SDK for Android to bridge JavaScript actions with physical hardware.

Features

Direct Connectivity: Seamless Bluetooth pairing and communication.
ZPL Support: Send raw Zebra Programming Language (ZPL) commands directly.
Enterprise Ready: Built with Kotlin for high-performance Android native bridging.
Mendix Optimized: Specifically designed for use within Mendix JavaScript Actions.

Architecture

The data flows from the Mendix UI through the React Native bridge to the hardware:
Mendix Native App: Triggers a JavaScript Action.
React Native Bridge: Serializes data to the native layer.
Kotlin Module: Interfaces with the Zebra Link-OS SDK.
Hardware: Data is transmitted via Bluetooth to the Zebra Printer.


Installation

Install the package via npm using the GitHub repository:
Bash:
npm install git+https://github.com/fahmiismail90/zebra-bluetooth-printer-mendix.git


Configuration & Requirements

Android Requirements

OS Version: Android 8.0 (API Level 26) or higher.
Hardware: Zebra Printer with Link-OS support.
Connectivity: Bluetooth must be enabled on the mobile device.

Permissions

Add the following to your AndroidManifest.xml.

[!IMPORTANT]For Android 12+, you must request BLUETOOTH_CONNECT at runtime within your Mendix flow or a custom permission activity.

XML

<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />


Usage ExampleIn your Mendix JavaScript Action, import the module and pass your ZPL string:

JavaScript

import ZebraPrinter from 'zebra-bluetooth-printer-mendix';

export async function ACT_PrintLabel(zplData) {
    try {
        // Example ZPL: ^XA^FO50,50^ADN,36,20^FDHello Zebra^FS^XZ
        await ZebraPrinter.printZPL(zplData);
        return true;
    } catch (error) {
        console.error("Printing failed", error);
        return false;
    }
}


Limitations & Scope

Feature 	        Status	                Notes
Android Support	        ✅ Supported	        Tested on Android 10+
iOS Support	        ❌ Not Supported	        Future roadmap
Bluetooth	        ✅ Supported	        Primary connection method
USB / Network	        ❌ Not Supported	        Not included in this module
Web Profile	        ❌ Not Supported	        Native Mobile profiles only

Compatibility

This module has been verified with:

Devices: Zebra ZQ, ZD, and TC series.

Environment: Mendix Native (React Native) internal enterprise projects.

Maintainer
Fahmi Ismail

Internal enterprise module for Mendix Native projects.
