package service;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUserIO implements UserIO {

    Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String readString(String prompt) {
        System.out.println(prompt);

        String a = scanner.nextLine();
        return a;
    }
    
    public double readDouble(String prompt) {
        System.out.println(prompt);
        Double a = scanner.nextDouble();
        return a;
    }

    public BigDecimal readBigDecimal(String prompt) {
        System.out.println(prompt);
        BigDecimal a = scanner.nextBigDecimal();
        scanner.nextLine(); 
        return a;
    }

    public double readDouble(String prompt, double min, double max) {
        Double a;

        do {
            System.out.println(prompt);

            a = Double.parseDouble(scanner.nextLine());

            if (a > max || a < min) {
                System.out.println("Your entry was not within the specified bounds.");
            }

        } while (a > max || a < min);

        return a;
    }

    public float readFloat(String prompt) {
        System.out.println(prompt);
        float a = scanner.nextFloat();
        return a;
    }

    public float readFloat(String prompt, float min, float max) {
        float a;

        do {
            System.out.println(prompt);

            a = scanner.nextFloat();

            if (a > max || a < min) {
                System.out.println("Your entry was not within the specified bounds.");
            }

        } while (a > max || a < min);

        return a;
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
        int a = Integer.parseInt(scanner.nextLine());
        return a;
    }

    public int readInt(String prompt, int min, int max) {
        int a;

        do {
            System.out.println(prompt);

            a = Integer.parseInt(scanner.nextLine());

            if (a > max || a < min) {
                System.out.println("Your entry was not within the specified bounds.");
            }

        } while (a > max || a < min);

        return a;
    }

    public long readLong(String prompt) {
        System.out.println(prompt);
        long a = scanner.nextLong();
        return a;
    }

    public long readLong(String prompt, long min, long max) {
        long a;

        do {
            System.out.println(prompt);

            a = scanner.nextLong();

            if (a > max || a < min) {
                System.out.println("Your entry was not within the specified bounds.");
            }

        } while (a > max || a < min);

        return a;
    }

}
