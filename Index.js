import { NativeModules } from "react-native";

const { ZebraPrinter } = NativeModules;

export function scanPrinters() {
  return ZebraPrinter.scanPrinters();
}

export function printZPL(mac, zpl) {
  return ZebraPrinter.printZPL(mac, zpl);
}
