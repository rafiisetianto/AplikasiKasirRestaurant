/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */

public class OrderItem {
    private final MenuItem menuItem;
    private final int qty;

    public OrderItem(MenuItem menuItem, int qty) {
        this.menuItem = menuItem;
        this.qty = qty;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQty() {
        return qty;
    }

    public double getTotalHarga() {
        return menuItem.getHarga() * qty;
    }

    @Override
    public String toString() {
        return menuItem.getNama() + " x " + qty + " = Rp " + getTotalHarga();
    }
}
