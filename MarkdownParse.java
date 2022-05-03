//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        

        String[] mdList = markdown.split("");
        int openParenIndex = 0;
        int closeParenIndex = 0;

        for (int i = 0; i < markdown.length(); ++i) {
            if (mdList[i].equals("(")) {
                openParenIndex = i;
                if (mdList[i+1].equals(")")) {
                    toReturn.add("Missing Link");
                }
                else {
                    int currentIndex = openParenIndex;
                    Boolean found = false;
                    while (found == false) {
                        if (mdList[currentIndex].equals(")")) {
                            closeParenIndex = currentIndex;
                            found = true;
                        }
                        currentIndex++;
                    }
                    String link = "";
                    for (int j = openParenIndex+1; j < closeParenIndex; ++j) {

                        link += mdList[j];
                    }

                    toReturn.add(link);
                }
            }
            
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
