package org.example;
import java.util.Scanner;
public class CheckingForLice {
    public static int integer() {
        Scanner sc = new Scanner(System.in);
        int x;
        try {
            x = sc.nextInt();
            return x;
        } catch (Exception e) {
            return -1;
        }
    }
    public static double Double() {
        Scanner sc = new Scanner(System.in);
        double x;
        try {
            x = sc.nextDouble();
            return x;
        } catch (Exception e) {
            return -1;
        }
    }
    public static String string() {
        Scanner sc = new Scanner(System.in);
        String x;
        try {
            x = sc.nextLine();
            return x;
        } catch (Exception e) {
            return "-";
        }
    }
    public static long longe() {
        Scanner sc = new Scanner(System.in);
        long x;
        try {
            x = sc.nextLong();
            return x;
        } catch (Exception e) {
            return -1;
        }
    }
}
