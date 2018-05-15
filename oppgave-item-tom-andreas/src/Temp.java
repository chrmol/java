import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.*;


public class Temp {

    final String SEPERATOR = File.separator;
    public final String TEMP_ITEM = this.createTempDir("item").getAbsolutePath();
    // System.out.println(TEMP_PATH);
    public Temp() throws IOException {
    }



    public static String findTempDir() throws IOException {
        String finalPath = null;
        try {
            File tmp = File.createTempFile("temp-file-name",".tmp");

            String absPath = tmp.getAbsolutePath();
            finalPath = absPath.substring(0,absPath.lastIndexOf(File.separator));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return finalPath;
    }

    public File createTempDir(String prefix) throws IOException {
        String tmpDirStr = findTempDir();
        if (tmpDirStr == null) {
            throw new IOException(
                    "System property 'java.io.tmpdir' finner ingen tmp dir");
        }

        File tmpDir = new File(tmpDirStr);
        if (!tmpDir.exists()) {
            boolean created = tmpDir.mkdirs();
            if (!created) {
                throw new IOException("klarte ikke å lage tmp dir " + tmpDir);
            }
        }

        File resultDir = null;

        resultDir = new File(tmpDir, prefix);


        if (resultDir.exists()) {
            //FileUtils.cleanDirectory(resultDir);

        }
        boolean created = resultDir.mkdir();
        if (!created) {
            // throw new IOException("klarte ikke å lage tmp mappen");
        }
        return resultDir;
    }
}

