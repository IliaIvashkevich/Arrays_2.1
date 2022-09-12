import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] products = {"Хлеб", "Колбаса", "Сыр", "Молоко", "Пиво", "Куриное филе", "Кетчуп"};
    int[] prices = {40, 300, 150, 75, 65, 300, 120};

    int sumProducts = 0;
    int[] basket = new int[products.length];
    int[] totalPriceOfProduct = new int[products.length];

    System.out.println("В магазине следующий ассортимент товаров:");
    for (int i = 0; i < products.length; i++) {
      System.out.println(i + 1 + ". Продукт " + products[i] + " стоит: " + prices[i] + " рублей");
    }

    while (true) {
      System.out.println("Введите номер товара, который вы хотите добавить в корзину, и его количество через пробел. \n" +
      "Для завершения и вывода состава корзины введите end");

      String input = scanner.nextLine();

      if (input.equals("end")) {
        System.out.println("Ваша корзина:");
        System.out.println("Наименование товара   Количество   Цена/за.ед   Общая стоимость");
        for (int i = 0; i < products.length; i++) {
          if (basket[i] != 0) {
            System.out.println(products[i] + "    " + basket[i] + "    " + prices[i] + "    " + totalPriceOfProduct[i]);
          }
        }
        System.out.println("Итого: " + sumProducts);
        break;

      } else {
        String[] parts = input.split(" ");
        int productNumber = Integer.parseInt(parts[0]) - 1;
        int productCount = Integer.parseInt(parts[1]);
        int cost = prices[productNumber] * productCount;
        sumProducts += cost;
        basket[productNumber] += productCount;
        totalPriceOfProduct[productNumber] += cost;
      }
    }
  }
}