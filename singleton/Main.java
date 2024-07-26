class PrinterSpooler {
    private static PrinterSpooler instance;

    private PrinterSpooler() {
        // private constructor to prevent instantiation
    }

    public static PrinterSpooler getInstance() {
        if (instance == null) {
            instance = new PrinterSpooler();
        }
        return instance;
    }

    public void print(String document) {
        System.out.println("Printing document: " + document);
    }
}

public class Main {
    public static void main(String[] args) {
        PrinterSpooler spooler1 = PrinterSpooler.getInstance();
        PrinterSpooler spooler2 = PrinterSpooler.getInstance();

        spooler1.print("Document 1");
        spooler2.print("Document 2");

        System.out.println("Are both spoolers the same instance? " + (spooler1 == spooler2));
    }
}
