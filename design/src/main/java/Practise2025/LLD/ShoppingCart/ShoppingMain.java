package Practise2025.LLD.ShoppingCart;

import java.util.*;

class Item{
    private int itemId;
    private float price;
    private String itemName;
    public Item(int itemId, float price, String itemName){
        this.itemId = itemId;
        this.price = price;
        this.itemName = itemName;
    }
    // getter and setter
    public float getPrice(){
        return this.price;
    }
}

interface Promotion{
    float calculateDiscount(float currPrice);
}

class PercentageStrategy implements Promotion{
    float promotionValue;
    public PercentageStrategy(float promotionValue){
        this.promotionValue = promotionValue;
    }
    public float calculateDiscount(float currPrice){
        float discountPrice = ((currPrice * promotionValue) / 100);
        return discountPrice;
    } 
}

class Cart{
    HashSet<Item> listOfItems;
    public Cart(){
        listOfItems = new HashSet<>();
    }
    public float getTotalPrice(){
        float totalPrice = 0;
        for(Item item: listOfItems){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    public void addItem(Item item){
        listOfItems.add(item);
    }
    public float checkoutPrice(List<Promotion> listOfPromotions){
        float currPrice = getTotalPrice();
        for(Promotion promotion: listOfPromotions){
            float discount = promotion.calculateDiscount(currPrice);
            if(discount <= currPrice){
                currPrice -= discount;   
            }
            else{
                currPrice = 0;
            }
        }
        return currPrice;
    }
}




public class ShoppingMain {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Item item1 = new Item(1, 100, "book");
        Item item2 = new Item(2, 200, "book2");
        Promotion ps = new PercentageStrategy(80);
        List<Promotion> listOfPromotion = new ArrayList<>();
        listOfPromotion.add(ps);
        Cart cart = new Cart();
        cart.addItem(item1);
        cart.addItem(item2);
        System.out.println(cart.checkoutPrice(listOfPromotion));
    }
}