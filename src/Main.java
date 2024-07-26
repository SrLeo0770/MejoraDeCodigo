public class Main {
    public static void main(String[] args) {
        String usbPath = "Z:\\";
        String usbName = "Usb de leo";

        if (!Menu.isUsbConnected(usbPath, usbName)) {
            System.out.println("USB no detectada o incorrecta. No se puede iniciar el programa.");
            return;
        }

        Menu menu = new Menu();
        menu.mostrarMenu();
    }
}
