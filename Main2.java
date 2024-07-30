import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Link Shortener!");
        while (true) {
            System.out.println("\nEnter a command (shorten, expand, exit): ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "shorten":
                    System.out.println("Enter the long URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = urlShortener.shortenUrl(longUrl);
                    System.out.println("Short URL: " + shortUrl);
                    break;
                case "expand":
                    System.out.println("Enter the short URL: ");
                    String shortUrlToExpand = scanner.nextLine();
                    String expandedUrl = urlShortener.expandUrl(shortUrlToExpand);
                    System.out.println("Long URL: " + expandedUrl);
                    break;
                case "exit":
                    System.out.println("Exiting the Link Shortener. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
