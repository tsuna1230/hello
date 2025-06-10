import java.util.Scanner;
import java.lang.Math;

public class NumberGuessingGame {

    public static void main(String[] args) {

        // --- 設定 ---
        // プログラマが答えとなる2桁の正の整数を設定します
        int answer = 77;
        // 最大試行回数
        int maxAttempts = 5;
        // -------------

        // ユーザー入力の準備
        Scanner scanner = new Scanner(System.in);

        System.out.println("【数当てゲーム】");
        System.out.println("私が設定した2桁の正の整数を当ててください。");
        System.out.println("チャンスは" + maxAttempts + "回です。");
        System.out.println("----------------------------------------");

        // 正解したかどうかを追跡する変数
        boolean hasGuessedCorrectly = false;

        // ゲームのメインループ (最大5回繰り返す)
        for (int i = 1; i <= maxAttempts; i++) {
            System.out.print(i + "回目の予想: ");

            // ユーザーからの整数入力を受け取る
            int userGuess = scanner.nextInt();

            // 正解の場合
            if (userGuess == answer) {
                System.out.println("🎉 当たり！おめでとうございます！");
                hasGuessedCorrectly = true;
                break; // ループを終了
            }
            // 不正解の場合
            else {
                // 入力された数が答えより小さいか大きいかを表示
                if (userGuess < answer) {
                    System.out.print("もっと大きいです。");
                } else {
                    System.out.print("もっと小さいです。");
                }

                // 答えとの差が20以上あるか判定
                if (Math.abs(userGuess - answer) >= 20) {
                    System.out.println(" (ヒント: 20以上離れています)");
                } else {
                    System.out.println(); // 通常の改行
                }
            }
        }

        // 5回以内に正解できなかった場合の処理
        if (!hasGuessedCorrectly) {
            System.out.println("----------------------------------------");
            System.out.println("残念！回数切れです。");
            System.out.println("正解は " + answer + " でした。");
        }

        // スキャナーを閉じる
        scanner.close();
    }
}
