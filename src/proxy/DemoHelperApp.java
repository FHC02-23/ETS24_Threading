package proxy;

public class DemoHelperApp {
    public static void main(String[] args) throws UrlLoaderException {


        WebPage webPage = UrlLoader.loadWebPage("https://orf.at");

        System.out.println(webPage);


    }
}
