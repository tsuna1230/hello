import java.util.Scanner;//ユーティリティのライブラリ？
import java.lang.Math;//数学関数ライブラリ？

import java.util.InputMismatchException;//例外処理用

public class Kazuate {//クラスを作成，ファイル名と一致させる

    public static void main(String[] args) {

        // --- 設定 ---
        // 答えの2桁の正の整数を設定
        int answer = 77;
        // 最大試行回数
        int maxAttempts = 5;
        // -------------

        // ユーザー入力の準備
        Scanner scanner = new Scanner(System.in);//scanf

        System.out.println("【数当てゲーム】");//printf
        System.out.println("私が設定した2桁の正の整数を当ててください。");
        System.out.println("チャンスは" + maxAttempts + "回です。");
        System.out.println("----------------------------------------");

        // 正解したかどうかを追跡する変数
        boolean hasGuessedCorrectly = false;//bool

        for (int i = 1; i <= maxAttempts; i++) {
            try {
                System.out.print(i + "回目の予想: ");
                int userGuess = scanner.nextInt(); // ここで例外が発生する可能性

                // 正解の場合
                if (userGuess == answer) {
                    System.out.println("正解です。");
                    hasGuessedCorrectly = true;
                    break;
                }
                // 不正解の場合
                else {
                    if (userGuess < answer) {
                        System.out.print("もっと大きいです。");
                    } else {
                        System.out.print("もっと小さいです。");
                    }

                    if (Math.abs(userGuess - answer) >= 20) {
                        System.out.println(" (ヒント:20以上離れています)");
                    } else {
                        System.out.println();
                    }
                }
            } catch (InputMismatchException e) {
                //例外処理
                System.out.println("エラー：半角数字で入力してください。");
                scanner.next(); // 不正な入力をバッファからクリア
                i--; // 試行回数を消費させないためにカウンターを1戻す
            }
        }
        // 5回以内に正解できなかった場合の処理
        if (!hasGuessedCorrectly) {
            System.out.println("----------------------------------------");
            System.out.println("入力上限に到達");
            System.out.println("正解は " + answer + " でした。");
        }

        // スキャナーを閉じる
        scanner.close();//閉じる必要がある
    }
}
