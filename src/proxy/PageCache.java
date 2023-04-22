package proxy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PageCache {
    private HashMap<String, WebPage> cache = new HashMap<>();

    public HashMap<String, WebPage> getCache() {
        return cache;
    }

    public WebPage readFromCache(String url) throws CacheMissException {
        if (cache.containsKey(url))
            return cache.get(url);
        // else / sonst
        throw new CacheMissException(url + " konnte nicht im Cache gefunden werden");
    }

    public void writeToCache(WebPage webPage) {
        cache.put(webPage.getUrl(), webPage);
    }

    public void warmUp(String pathToUrls) throws UrlLoaderException {

        try (BufferedReader br = new BufferedReader(new FileReader(pathToUrls))) {
            String urlFromFile;
            while ((urlFromFile = br.readLine()) != null) {
                try {
                    WebPage page = UrlLoader.loadWebPage(urlFromFile);
                    writeToCache(page);
                } catch (UrlLoaderException e) {
                    e.printStackTrace();
                    // Exception nicht weiter werfen, es soll die nächste URL geladen werden
                }
            }
        } catch (FileNotFoundException e) {
            throw new UrlLoaderException(e);
        } catch (IOException e) {
            throw new UrlLoaderException(e);
        }
    }
}
