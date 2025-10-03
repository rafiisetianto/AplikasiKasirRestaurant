/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author LENOVO
 */

import model.MenuItem;
import model.OrderItem;
import exception.ValidationException;

import java.util.ArrayList;

public class RestoranService {
    private final ArrayList<MenuItem> daftarMenu = new ArrayList<>();
    private final ArrayList<OrderItem> pesanan = new ArrayList<>();

    public RestoranService() {
        daftarMenu.add(new MenuItem(1, "Nasi Goreng Spesial", 20000));
        daftarMenu.add(new MenuItem(2, "Ayam Bakar", 25000));
        daftarMenu.add(new MenuItem(3, "Sate Ayam", 22000));
        daftarMenu.add(new MenuItem(4, "Es Teh Manis", 5000));
        daftarMenu.add(new MenuItem(5, "Jus Jeruk", 8000));
    }

    public void tampilkanMenu() {
        System.out.println("=== Daftar Menu Restoran ===");
        for (MenuItem item : daftarMenu) {
            System.out.println(item);
        }
    }

    public void tambahPesanan(int id, int qty) throws ValidationException {
        if (qty <= 0) throw new ValidationException("Jumlah harus lebih dari 0!");

        MenuItem pilihMenu = null;
        for (MenuItem item : daftarMenu) {
            if (item.getId() == id) {
                pilihMenu = item;
                break;
            }
        }

        if (pilihMenu == null) throw new ValidationException("Menu tidak ditemukan!");

        pesanan.add(new OrderItem(pilihMenu, qty));
        System.out.println("Pesanan ditambahkan: " + pilihMenu.getNama() + " x " + qty);
    }

    public void lihatPesanan() {
        if (pesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
            return;
        }

        System.out.println("=== Daftar Pesanan ===");
        double total = 0;
        for (OrderItem o : pesanan) {
            System.out.println(o);
            total += o.getTotalHarga();
        }
        System.out.println("Total sementara: Rp " + total);
    }

    public void checkout() {
        if (pesanan.isEmpty()) {
            System.out.println("Pesanan kosong, tidak bisa checkout.");
            return;
        }

        double total = 0;
        System.out.println("=== Struk Pembayaran ===");
        for (OrderItem o : pesanan) {
            System.out.println(o);
            total += o.getTotalHarga();
        }
        System.out.println("Total Bayar: Rp " + total);
        System.out.println("=== Terima kasih sudah makan di restoran kami! ===");

        pesanan.clear();
    }
}
