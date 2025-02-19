package accounts;

import java.util.Scanner;

public class Main {
    static CreditAccount credit = new CreditAccount(-200_000);
    static SimpleAccount debit = new SimpleAccount();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        accountStatus();

        while (true) {
            System.out.println();
            System.out.println("Введите номер операции (или для завершения работы программы напишите <end>): ");
            System.out.println("1. Пополнение дебетовой и кредитной карты: ");
            System.out.println("2. Оплата с дебетовой или кредитной карты: ");
            System.out.println("3. Перемещение средств с дебетовой на кредитную карту: ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                accountStatus();
                System.out.println("Программа завершена! ");
                break;
            }
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:

                    System.out.println("Введите сумму пополнения дебетовой карты: ");
                    int money1 = Integer.parseInt(scanner.nextLine());
                    debit.add(money1);
                    System.out.println("Введите сумму пополнения кредитной карты (лимит кредитования - 200 000 руб): ");
                    int money2 = Integer.parseInt(scanner.nextLine());
                    credit.add(money2);
                    accountStatus();
                    break;
                case 2:
                    System.out.println("Введите сумму оплаты с дебетовой карты: ");
                    int money3 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите сумму оплаты с кредитной карты (лимит кредитования - 200 000 руб): ");
                    int money4 = Integer.parseInt(scanner.nextLine());
                    debit.pay(money3);
                    credit.pay(money4);
                    accountStatus();
                    break;
                case 3:
                    System.out.println("Введите сумму перевода средств с дебетовой на кредитную карты: ");
                    int transferAmount = Integer.parseInt(scanner.nextLine());
                    debit.transfer(credit, transferAmount);
                    accountStatus();
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }

    }

    private static void accountStatus() {
        System.out.println("На счету дебитовой карты: " + debit.getBalance());
        System.out.println("На счету кредитной карты: " + credit.getBalance());
    }
}