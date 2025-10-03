/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author LENOVO
 */
import model.MenuItem;
import service.RestoranService;
import exception.ValidationException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RestoranService service = new RestoranService();

        System.out.println("=== Selamat Datang di Aplikasi Kasir Restoran ===");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Lihat Daftar Menu");
            System.out.println("2. Tambah Pesanan");
            System.out.println("3. Lihat Pesanan");
            System.out.println("4. Checkout");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    service.tampilkanMenu();
                    break;
                case 2:
                    try {
                        System.out.print("Masukkan ID Menu: ");
                        int id = input.nextInt();
                        System.out.print("Jumlah: ");
                        int qty = input.nextInt();
                        service.tambahPesanan(id, qty);
                    } catch (ValidationException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    service.lihatPesanan();
                    break;
                case 4:
                    service.checkout();
                    break;
                case 5:
                    running = false;
                    System.out.println("Terima kasih, sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
