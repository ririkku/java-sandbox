package kiku.file;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSampleTest {

    private FileSample sut;

    @Before
    public void setUp() {
        sut = new FileSample();
    }

    @Test
    public void ファイルが存在するか() {
        boolean b = sut.ファイルが存在するか();
        assertThat(b).isTrue();
    }

    @Test
    public void ディレクトリ() {
        String[] b = sut.ディレクトリ();
        assertThat(b).contains("fileSample.txt", "FileSample.java");
    }

    @Test
    public void 一文字ずつ表示してみる() {
        sut.バイナリファイルを読み込んでみる();
    }

    @Test
    public void 書いてみる() {
        sut.バイナリファイルに書き込んでみる();
    }

    @Test
    public void テキストファイルを読み込んでみる() {
        sut.テキストファイルを読み込んでみる();
    }

    @Test
    public void テキストファイルに書き込んでみる() {
        sut.テキストファイルに書き込んでみる();
    }

    @Test
    public void テキストファイルの特定文字列を取得してみる() {
        List<String> actual = sut.テキストファイルの人の部分を取得してみる();
        assertThat(actual).contains("hosomi", "ubukata", "takada", "takahashi");
    }
}
