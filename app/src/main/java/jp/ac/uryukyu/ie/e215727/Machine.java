package jp.ac.uryukyu.ie.e215727;

public class Machine {
    private Items items; // 商品
    private Deposit deposit; // 入金額
 
    // コンストラクタ
    Machine() {
        items = new Items();
        deposit = new Deposit();
    }
 
    // 入金
    void deposit(int amount) {
        deposit.deposit(amount);
    }
 
    // 最低価格商品以上の入金があるか判定
    boolean hasMinDeposit() {
        if (deposit.amount() < items.minPrice()) {
            return false;
        }
        return true;
    }
 
    // 購入可能商品を表示
    void 購入可能商品() {
        items.購入可能商品のリスト作成(deposit.amount());
        items.購入可能商品();
    }
 
    // 購入可能商品であるか判定
    boolean 購入可能可否(String itemName) {
        return items.購入可能可否(itemName, deposit);
    }
 
    // 購入商品を表示
    void selectItem(String itemName) {
        System.out.println(itemName + "です!");
    }
 
    // 課金
    void charge(String itemName) {
        int saleAmount = items.販売価格(itemName);
        deposit.charge(saleAmount);
        System.out.println("おつりは、" + deposit.amount() + "円です。ご利用、ありがとうございました!");
    }
}