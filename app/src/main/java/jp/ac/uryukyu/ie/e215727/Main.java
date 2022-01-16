package jp.ac.uryukyu.ie.e215727;

import java.util.Scanner;

 //メインロジック(これがないと動かない。)
public class Main {

    public static void main(String[] args) {
        // ①商品の初期化
        Machine vendingMachine = new Machine();
 
        // 購入最低金額の場合、追加入金
        Scanner scanner = new Scanner(System.in);
        do {
            // ②入金
            System.out.println("お金を入れて下さい。");
            int amount = scanner.nextInt();
            vendingMachine.deposit(amount);
 
            // ③金額チェック（最低購入金額）
        } while (!vendingMachine.hasMinDeposit());
 
        // ④購入可能商品を表示
        System.out.println("");
        System.out.println("購入可能な商品です。");
        vendingMachine.購入可能商品();
 
        // ⑤商品を選択
        String itemName;
        do {
            System.out.println("");
            System.out.println("商品名を入力して下さい。");
            itemName = scanner.next();
        } while (!vendingMachine.購入可能可否(itemName));
        vendingMachine.selectItem(itemName);
        scanner.close();
 
        // ⑥課金機能
        vendingMachine.charge(itemName);
    }
 
}