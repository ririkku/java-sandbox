package kiku.file;

import org.junit.Before;
import org.junit.Test;

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
}
