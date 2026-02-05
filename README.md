\# Zebra Bluetooth Printer for Mendix Native

Reusable npm module that enables \*\*Bluetooth printing to Zebra printers\*\* from \*\*Mendix Native Mobile apps\*\* using \*\*Zebra Link-OS SDK (Android)\*\*.
This module is designed for \*\*internal enterprise usage\*\* where Mendix Native apps need direct access to Zebra printers.

---

\## 📦 Features


\- 🔗 Bluetooth printer connection
\- 🖨 Send raw ZPL commands
\- 📱 Android native implementation (Kotlin)
\- 🧩 Reusable npm module
\- ⚙ Built for Mendix Native Mobile

---

\## 🧱 Architecture Overview

Mendix Native App
        ↓
JavaScript Action (index.js)
        ↓
React Native Bridge
        ↓
Android Native Module (Kotlin)
        ↓
Zebra Link-OS SDK
        ↓
Zebra Bluetooth Printer

---

\## 📥 Installation

Install directly from GitHub:


npm install git+https://github.com/fahmiismail90/zebra-bluetooth-printer-mendix.git


\##📱 Android Requirements

\-Android 8.0+
\-Zebra printer with Link-OS
\-Bluetooth enabled on device
\-Bluetooth permissions granted


\##🔐 Android Permissions

Make sure the following permissions exist in AndroidManifest.xml:

<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.BLUETOOTH\_ADMIN" />
<uses-permission android:name="android.permission.BLUETOOTH\_CONNECT" />

\##⚠️ On Android 12+, Bluetooth permission must be granted at runtime.

\##🧩 Usage Example (JavaScript)

import ZebraPrinter from 'zebra-bluetooth-printer-mendix';
// Send ZPL to printer
ZebraPrinter.printZPL(`
^XA
^FO50,50^ADN,36,20^FDHello Zebra^FS
^XZ
`);

\##🛠 Mendix Integration Notes

Call this module from a JavaScript Action
Use it only in Native Mobile profiles
Not supported in Web profile

\##⚠️ Limitations

❌ iOS not supported yet
❌ USB / Network printing not included
✅ Bluetooth only
✅ Android only

\##🧪 Tested With

Zebra ZQ / ZD / TC series
Android 10+
Mendix Native (React Native)

\##👤 Maintainer

Fahmi Ismail
Internal enterprise module for Mendix Native projects







