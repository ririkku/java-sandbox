package kiku.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileSample {

    public boolean ファイルが存在するか() {
        String filePath = String.join(File.separator, "src", "main", "java", "kiku", "file", "fileSample.txt");
        Path path = Paths.get(filePath);
        File file = path.toFile();
        return file.exists();
    }

    public String[] ディレクトリ() {
        String dirPath = String.join(File.separator, "src", "main", "java", "kiku", "file");
        File file = Paths.get(dirPath).toFile();
        return file.list();
    }

    public void バイナリファイルを読み込んでみる() {
        String fileName = String.join(File.separator, "src", "main", "java", "kiku", "file", "fileSample.txt");
        Path path = Paths.get(fileName);
        try (InputStream stream = Files.newInputStream(path)) {
            for (int ch; (ch = stream.read()) != -1; ) {
                System.out.println(String.format("%c : %s", (char) ch, Integer.toHexString(ch)));
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void バイナリファイルに書き込んでみる() {
        String fileName = String.join(File.separator, "src", "main", "java", "kiku", "file", "fileSample.txt");
        byte[] data = new byte[]{0x41, 0x42, 0x43};
        Path path = Paths.get(fileName);
        try (OutputStream stream = Files.newOutputStream(path, StandardOpenOption.APPEND, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            stream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
