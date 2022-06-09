import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class Loger {
    boolean onScreen;
    private static Loger log;
    private static final String pathL = "log.txt";


    public Loger(boolean onScreen) throws IOException {
        this.onScreen = onScreen;
        if (!onScreen) {
            new FileWriter(pathL, false);
        }
    }

    public static synchronized Loger getLoger(boolean onScreen) throws IOException {
        if (log == null) {
            log = new Loger(onScreen);
        }
        return log;
    }

    public void log(String str) throws IOException {
        Date date = new Date();
        if (this.onScreen) {
            System.out.println(date + " " + str);
        }
        else {
            Files.writeString(Paths.get(pathL),date + " " + str + "\n", StandardOpenOption.APPEND);
        }
    }
}
