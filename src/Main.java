// Shift を 2 回押して 'どこでも検索' ダイアログを開き、`show whitespaces` と入力して
// Enter キーを押します。これでコードに空白文字が表示されます。
public class Main {
    public static void main(String[] args) {
        // ハイライトされたテキストにキャレットがある状態で Opt+Enter を押して
        // IntelliJ IDEA が提案する修正方法を表示します。
        System.out.printf("Hello and welcome!");

        // コードを実行するには Ctrl+R を押すか、ガターにある緑の矢印ボタンをクリックします。
        for (int i = 1; i <= 5; i++) {

            // Ctrl+D を押してコードのデバッグを開始します。ブレークポイントを 1 つ設定しましたが、
            // Cmd+F8 を押すといつでも他のブレークポイントを追加できます。
            System.out.println("i = " + i);
        }
    }
}