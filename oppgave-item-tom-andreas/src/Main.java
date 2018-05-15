import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final String TEMP_PATH = Temp.findTempDir();

        final String SEPERATOR = File.separator;

        Temp tmp = new Temp();

        tmp.createTempDir("item");




         CopyFile copy = new CopyFile();
         String targetdir = "C:"+SEPERATOR+"Users"+SEPERATOR+"Christian"+SEPERATOR+"item-oppgave"+SEPERATOR;
        System.out.println(targetdir);
         copy.checkAndCopy("C:"+SEPERATOR+"Users"+SEPERATOR+"Christian"+SEPERATOR+"item-oppgave"+SEPERATOR,"abc", ".pdf");
    }
}
