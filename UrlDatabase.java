import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UrlDatabase {
    private static final Scanner input = new Scanner(System.in);
    private static final Map<String, Integer> urls = new HashMap<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter a command: ");
            String command = input.nextLine();

            if (command.startsWith("storeurl ")) {
                storeUrl(command.split(" ")[1]);
            } else if (command.startsWith("get ")) {
                get(command.split(" ")[1]);
            } else if (command.startsWith("count ")) {
                count(command.split(" ")[1]);
            } else if (command.equals("list")) {
                list();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    private static void storeUrl(String url) {
        if (!urls.containsKey(url)) {
            String key = generateKey();
            urls.put(url, 0);
            System.out.println("Url stored with key: " + key);
        } else {
            System.out.println("Url already stored");
        }
    }

    private static void get(String url) {
        if (urls.containsKey(url)) {
            int count = urls.get(url);
            urls.put(url, count + 1);
            System.out.println("Url retrieved. Usage count incremented to: " + (count + 1));
        } else {
            System.out.println("Url not found");
        }
    }

    private static void count(String url) {
        if (urls.containsKey(url)) {
            System.out.println("Usage count: " + urls.get(url));
        } else {
            System.out.println("Url not found");
        }
    }

    private static void list() {
        System.out.println("Urls: ");
        for (Map.Entry<String, Integer> entry : urls.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String generateKey() {
        String key = "";
        for (int i = 0; i < 8; i++) {
            key += (char) (random.nextInt(26) + 'a');
        }
        return key;
    }
}