import java.util.HashMap;
import java.util.Random;

public class URLShortener {
    private static final String BASE_URL = "http://short.url/";
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    private HashMap<String, String> urlMap;
    private HashMap<String, String> reverseUrlMap;
    private Random random;

    public URLShortener() {
        urlMap = new HashMap<>();
        reverseUrlMap = new HashMap<>();
        random = new Random();
    }

    public String shortenUrl(String longUrl) {
        if (reverseUrlMap.containsKey(longUrl)) {
            return BASE_URL + reverseUrlMap.get(longUrl);
        }

        String shortUrl = generateShortUrl();
        while (urlMap.containsKey(shortUrl)) {
            shortUrl = generateShortUrl();
        }

        urlMap.put(shortUrl, longUrl);
        reverseUrlMap.put(longUrl, shortUrl);
        return BASE_URL + shortUrl;
    }

    public String expandUrl(String shortUrl) {
        String key = shortUrl.replace(BASE_URL, "");
        return urlMap.getOrDefault(key, "URL not found!");
    }

    private String generateShortUrl() {
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortUrl.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }
        return shortUrl.toString();
    }
}
