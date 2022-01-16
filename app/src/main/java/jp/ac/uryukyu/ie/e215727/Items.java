package jp.ac.uryukyu.ie.e215727;

import java.util.HashMap;
import java.util.Map;

public class Items {
    private Map<String, Integer> items; // 商品リスト
    private Map<String, Integer> availablePurchases; // 購入可能商品
 
    // コンストラクタ（商品リストの初期化）
    Items() {
        this.items = new HashMap<String, Integer>();
        items.put("コーラ", 160);
        items.put("お茶", 130);
        items.put("水", 100);
        items.put("コーヒー",120);
        items.put("エナジードリンク",200);
        items.put("サイダー",150);
    }
 
    // 最低購入金額の取得
    int minPrice() {
        int 最低価格 = 0;
        int 金額を取得した回数 = 0;
        for (String itemKey : items.keySet()) {
            最低価格 = 最低購入金額(金額を取得した回数, 最低価格, 商品の値段(itemKey));
            金額を取得した回数++;
        }
        return 最低価格;
    }
 
    // 最低購入金額の判定
    int 最低購入金額(int 金額を取得した回数, int 最低金額, int 金額) {
        if (金額を取得した回数 == 0 || 最低金額 > 金額) {
            最低金額 = 金額;
        }
        return 最低金額;
    }
 
    // 商品金額
    private int 商品の値段(String itemKey) {
        return items.get(itemKey);
    }
 
    // 購入可能商品金額
    private int 購入可能な商品の価格(String itemKey) {
        return availablePurchases.get(itemKey);
    }
 
    // 購入可能商品リストの取得
    void 購入可能商品のリスト作成(int 入金額) {
        availablePurchases = new HashMap<String, Integer>();
        for (String itemKey : items.keySet()) {
            購入可能商品の追加(入金額, itemKey);
        }
    }
 
    // 購入可能商品リストの追加
    private void 購入可能商品の追加(int deposit, String itemKey) {
        if (deposit >= items.get(itemKey)) {
            availablePurchases.put(itemKey, items.get(itemKey));
        }
    }
 
    // 購入可能商品の表示
    void 購入可能商品() {
        for (String itemKey : availablePurchases.keySet()) {
            System.out.println(itemKey + ":" + items.get(itemKey) + "円");
        }
    }
 
    // 購入可能商品であるかの判定
    boolean 購入可能可否(String 商品名, Deposit 入金額) {
        return availablePurchases.containsKey(商品名);
    }
 
    // 販売価格
    int 販売価格(String 商品名) {
        return 購入可能な商品の価格(商品名);
    }
}
