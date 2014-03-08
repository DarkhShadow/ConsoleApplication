package ConsoleApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ConsoleListener implements Runnable {

	public BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	public HashMap<String, String> factoids = new HashMap<String, String>();

	public ConsoleListener() {
		new Thread(this).start();
	}

	public void onConsoleInput(String input) {
		boolean done = false;
		if (input.equalsIgnoreCase("test")) {
			ConsoleApp.print("Test Success!");
			return;

		}
		if (input.equals("factoids")) {
			ConsoleApp.print("usage: factoid <add/remove> <key> [value]!");
			done = true;
		}
		if (input.startsWith("factoid ")) {
			String[] inp = input.split(" ");
			if (inp.length > 1) {
				if (inp[1].equalsIgnoreCase("add")) {
					if (inp.length > 3) {
						String key = inp[2];
						String value = input.substring((inp[0] + " " + inp[1]
								+ " " + inp[2] + " ").length());
						factoids.put(key, value);
						}
					} else if (inp[1].equalsIgnoreCase("remove")) {
						if (factoids.containsKey(inp[2])) {
							factoids.remove(inp[2]);
							ConsoleApp.print("Factoid removed!");
						}
					} else {
						ConsoleApp.print("Usage: factoid <add/remove> <key> [value]!");
					}
				}
				done = true;

			}

			if (!done) {
				ConsoleApp.print("Unrecognized command!");
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				String line = null;
				while ((line = in.readLine()) != null)
					onConsoleInput(line);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
		}
	}
}