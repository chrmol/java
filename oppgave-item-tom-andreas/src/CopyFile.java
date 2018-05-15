import java.io.*;

public class CopyFile {
    final String SEPERATOR = File.separator;
    Temp tmp = new Temp();
    int i = 0;

    public final String TEMP_ITEM = tmp.createTempDir("item").getAbsolutePath();

    public CopyFile() throws IOException {
    }


    public  void checkAndCopy(String sourceDir, String filename, String filetype){

        File directory = new File(tmp.TEMP_ITEM);
        File[] fList = directory.listFiles();

        for (File file : fList){
            if (file.isFile()){
                }if (file.getName().contains("abc("+i+")")){
                    i += 1;
                } else if (file.getName().contains("abc")){
                    i += 1;
            }
        }


        try{
            File checkFile = new File (tmp.TEMP_ITEM,filename+filetype);

            if (checkFile.exists()){
                //int i++;
                checkFile = new File(tmp.TEMP_ITEM, filename + "(" + i + ")" + filetype);
            }
            File source = new File(sourceDir, filename+filetype);
            this.copy(source, checkFile);
        }catch (IOException e) {
        e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copy(File src, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            // buffer size 1K
            byte[] buf = new byte[1024];

            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead);

            } } finally {
            is.close();
            os.close();
        }
    }

}
