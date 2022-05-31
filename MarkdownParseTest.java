import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MarkdownParseTest {
    
    @Test
    public void test1() throws IOException{
        String file1 = Files.readString(Path.of("snippet-test1.md"));
        ArrayList<String> links1 = MarkdownParse.getLinks(file1);
        ArrayList<String> result = new ArrayList<>(Arrays.asList("url.com", "`google.com", "google.com", 
                                                                    "ucsd.edu"));
        assertEquals(result,links1);
    }
    @Test
    public void test2() throws IOException{
        String file2 = Files.readString(Path.of("snippet-test2.md"));
        ArrayList<String> links2 = MarkdownParse.getLinks(file2);
        ArrayList<String> result2 = new ArrayList<>(Arrays.asList("b.com","a.com(())", "example.com"));
        assertEquals(result2,
                    links2);
    }
    @Test
    public void test3() throws IOException{ 
        String file3 = Files.readString(Path.of("snippet-test3.md"));
        ArrayList<String> links3 = MarkdownParse.getLinks(file3);
        ArrayList<String> result3 = new ArrayList<>(Arrays.asList("https://www.twitter.com",
                                "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", "https://cse.ucsd.edu/"));
        assertEquals(result3, links3);
    }

}