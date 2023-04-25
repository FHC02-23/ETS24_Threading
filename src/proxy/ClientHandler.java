package proxy;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket client;
    private WebProxy proxy;

    public ClientHandler(Socket client, WebProxy proxy) {
        this.client = client;
        this.proxy = proxy;
    }


    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))
        )   {

            String command;
            while ((command = bufferedReader.readLine()) != null) {
                if (command.equals("bye")) {
                    client.close();
                    return;
                }
                String[] parts = command.split(" ");
                if (parts.length != 2) {
                    bw.write("error: command invalid");
                    bw.newLine();
                    bw.flush();
                    continue;
                }
                switch (parts[0]){
                    case "fetch":

                        try {
                            WebPage page = proxy.fetch(parts[1]);

                            bw.write(page.getContent());
                            bw.newLine();
                            bw.flush();

                        } catch (UrlLoaderException e) {
                            bw.write("error: loading the url fails");
                            bw.newLine();
                            bw.flush();
                        }


                        break;
                    case "stats":

                        if (parts[1].equals("hits"))
                            bw.write(proxy.statsHits());
                        else if (parts[1].equals("misses"))
                            bw.write(proxy.statsMisses());
                        else
                            bw.write("wrong command");
                        bw.newLine();
                        bw.flush();

                        break;
                    default:
                        bw.write("error: command invalid");
                        bw.newLine();
                        bw.flush();
                }

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
