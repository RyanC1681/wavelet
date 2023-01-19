import java.io.IOException;
import java.net.URI;

import javax.lang.model.util.ElementScanner14;

public class SearchEngine {
    class Handler implements URLHandler {
        // The one bit of state on the server: a number that will be manipulated by
        // various requests.
        String word = "Dauntless";

        public String searchRequest(URI url) {
            if (url.getPath().equals("/")) {
                return String.format("Ryan Chen's String: %d", word);
            }

            else {
                System.out.println("Path: " + url.getPath());
                if (url.getPath().contains("/add")) {
                    String[] parameters = url.getQuery().split("=");
                    if (parameters[0].equals("s")) {
                        word += parameters[1]; // .nextLine();
                    }

                }

                if (url.getPath().contains("/search")) 
                {
                    String[] parameters = url.getQuery().split("=");
                    if (parameters[0].equals("s")) 
                    {
                        String[] extractWords = word.split(" ");
                        
                        for(int i = 0; i < word.length(); i ++)
                        {
                            int findWord = word.indexOf(parameters[1]);
                            
                        }
                        
                    }
            }

        }

        class NumberServer {
            public static void main(String[] args) throws IOException {
                if (args.length == 0) {
                    System.out.println("Missing port number! Try any number between 1024 to 49151");
                    return;
                }

                int port = Integer.parseInt(args[0]);

                Server.start(port, new Handler());
            }
        }

    }
}
