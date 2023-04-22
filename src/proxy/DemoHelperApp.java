package proxy;

public class DemoHelperApp {
    public static void main(String[] args) throws UrlLoaderException {


        PageCache pageCache = new PageCache();
        pageCache.warmUp("./data/urls.txt");

        System.out.println(pageCache.getCache());


    }
}
