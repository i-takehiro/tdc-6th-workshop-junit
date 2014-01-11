package tdc6th.sample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BasisSample {

    @BeforeClass
    public static void setUpClass() throws Exception {
        // テストクラスに含まれるいずれか最初のテストメソッドが実行される前に１回だけ実行される
        System.out.println("setUpClass が実行されました");
    }

    @Before
    public void setUp() throws Exception {
        // 各テストメソッドの実行前に処理を行う
        System.out.println("setUp が実行されました");
    }

    @Test
    public void テスト１() throws Exception {
        System.out.println("テスト１ が実行されました");
    }

    @Test(expected = NullPointerException.class)
    public void 例外のテスト() throws Exception {
        // expected 属性に指定したクラスの例外がスローされることを検証する
        System.out.println("例外のテスト が実行されました");
        throw new NullPointerException();
    }

    // Ignore アノテーションを付与すると実行をスキップする
    @Ignore
    @Test(timeout = 1000)
    public void タイムアウトのテスト() throws Exception {
        // timeout 属性に指定した時間(単位:ミリ秒)以上経過するとテストが失敗する
        System.out.println("タイムアウトのテスト が実行されました");
        for (;;) {

        }
    }

    @After
    public void tearDown() throws Exception {
        // 各テストメソッドの実行後に処理を行う
        System.out.println("tearDown が実行されました");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // テストクラスに含まれる全てのテストメソッドが実行された後に１回だけ実行される
        System.out.println("tearDownClass が実行されました");
    }
}
