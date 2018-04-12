package kiku.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileSample {

    private String dirPath = String.join(File.separator, "src", "main", "java", "kiku", "file");
    private String filePath = String.join(File.separator, "src", "main", "java", "kiku", "file", "fileSample.txt");

    public boolean ファイルが存在するか() {
        Path path = Paths.get(filePath);
        File file = path.toFile();
        return file.exists();
    }

    public String[] ディレクトリ() {
        File file = Paths.get(dirPath).toFile();
        return file.list();
    }

    public void バイナリファイルを読み込んでみる() {
        Path path = Paths.get(filePath);
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
        byte[] data = new byte[]{0x41, 0x42, 0x43};
        Path path = Paths.get(filePath);
        try (OutputStream stream = Files.newOutputStream(path, StandardOpenOption.APPEND, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            stream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void テキストファイルを読み込んでみる() {
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            for (String line; (line = reader.readLine()) != null; ) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void テキストファイルに書き込んでみる() {
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write("hosomi test1 test2");
            writer.newLine();
            writer.write("ubukata test1 test2");
            writer.newLine();
            writer.write("takada test1 test2");
            writer.newLine();
            writer.write("takahashi test1 test2");
            writer.newLine();
            writer.write("hosomi test1 test2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> テキストファイルの人の部分を取得してみる() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            return reader.lines().map(line -> line.split(" ")[0]).distinct().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void テキストファイルをコピーしてみる(String fileName) {
        Path from = Paths.get(filePath);
        Path to = Paths.get(dirPath + File.separator + fileName);
        try {
            Files.copy(from, to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void テキストファイルを削除してみる(String fileName) {
        Path path = Paths.get(dirPath + File.separator + fileName);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void テキストファイルを作成してみる(String fileName) {
        Path path = Paths.get(dirPath + File.separator + fileName);
        try {
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
