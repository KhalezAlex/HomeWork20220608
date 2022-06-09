import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class task3 {
    private static void log(String str, int onScr) throws IOException {
        boolean onScreen = onScr != 0;
        Logger.getLogger(onScreen).log(str);
    }

    public static void writeFile(String str, String path, int onScr) throws IOException {
        FileWriter fWr = new FileWriter(path, false);

        fWr.write(str);
        fWr.close();
        log(" Запущен метод writeFile(): записывает строку  \"" + str + "\"  в файл  " + path, onScr);
    }

    public static int[] getIntFromFile(String path, int onScr) throws IOException {
        BufferedReader bR = new BufferedReader(new FileReader(path));
        String str = bR.readLine();
        String[] strArr = str.split(" ");
        int[] arrInt = new int[strArr.length];

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = Integer.parseInt(strArr[i]);
        }
        log(" Запущен метод getIntFromFile: считывает строку  \"" + str + "\"  из файла  " + path, onScr);
        return arrInt;
    }

    public static void print(int[] arr, int onScr) throws IOException {
        System.out.println(Arrays.toString(arr));
        log(" Запущен метод print: отображает на экран введенные числа", onScr);
    }

    private static void writeMinMax(String minMax, int value, String path) throws IOException {
        Files.writeString(Paths.get(path), "\n" + minMax + " " + value, StandardOpenOption.APPEND);
    }

    public static void max(int[] arr, String path, int onScr) throws IOException {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        writeMinMax("max", max, path);
        log(" Запущен метод max: находит максимум и записывает в файл  " + path, onScr);
    }

    public static void min(int[] arr, String path, int onScr) throws IOException {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        writeMinMax("min", min, path);
        log(" Запущен метод min: находит минимум и записывает в файл  " + path, onScr);
    }

    public static void printMinMax(String path, int onScr) throws IOException {
        BufferedReader bR = new BufferedReader(new FileReader(path));
        String str;
        while ((str = bR.readLine()) != null) {
            if (str.split(" ")[0].equals("max")) {
                System.out.println("Максимум = " + str.split(" ")[1]);
            }
            if (str.split(" ")[0].equals("min")) {
                System.out.println("Минимум = " + str.split(" ")[1]);
            }
        }
        log(" Запущен метод minMax: считывает максимум и минимум из файла  " + path + "  и выводит на экран ", onScr);
    }
}
