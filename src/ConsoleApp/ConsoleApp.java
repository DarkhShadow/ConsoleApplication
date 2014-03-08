package ConsoleApp;

public class ConsoleApp {

	// jvm entry point
	public static void main(String[] args) {
		new ConsoleApp();
	}

	// class constructor
	public ConsoleApp() {
		print("Initializing application!");
		new ConsoleListener();
	}

	public static void print(String theMessage) {
		System.out.println("[APP] " + theMessage);
	}
}