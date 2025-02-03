package javabase;
import java.util.HashSet;
import java.util.Set;


public class Homework {

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        // Используем StringBuilder для переворота строки
        String reversedString = new StringBuilder(string).reverse().toString();
        // Выводим перевернутую строку на консоль
        System.out.println(reversedString);
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        // Создаем множество для хранения уникальных значений
        Set<Integer> uniqueNumbers = new HashSet<>();

        // Добавляем все элементы массива в множество
        for (int num : ints) {
            uniqueNumbers.add(num);
        }

        // Выводим уникальные значения в консоль
        for (int uniqueNum : uniqueNumbers) {
            System.out.print(uniqueNum + " ");
        }
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {

        if (arr == null || arr.length < 2) {
            // Если массив пуст или содержит меньше двух элементов, второго максимума нет
            return null;
        }

        int max = Integer.MIN_VALUE; // Инициализируем максимальное значение
        int secondMax = Integer.MIN_VALUE; // Инициализируем второе максимальное значение

        // Проходим по массиву
        for (int num : arr) {
            if (num > max) {
                // Если текущий элемент больше max, обновляем secondMax и max
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                // Если текущий элемент меньше max, но больше secondMax, обновляем secondMax
                secondMax = num;
            }
        }

        // Если secondMax остался равен Integer.MIN_VALUE, значит, второго максимума нет
        if (secondMax == Integer.MIN_VALUE) {
            return null;
        }

        return secondMax;
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        if (string == null || string.trim().isEmpty()) {
            return 0;
        }
        string = string.trim();

        // Разделяем строку на слова
        String[] words = string.split("\\s+");

        // Возвращаем длину последнего слова
        return words[words.length - 1].length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        if (string == null) {
        return false; // или true, в зависимости от требований
    }

        int left = 0; // Указатель на начало строки
        int right = string.length() - 1; // Указатель на конец строки

        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false; // Если символы не совпадают, строка не палиндром
            }
            left++; // Двигаем левый указатель вправо
            right--; // Двигаем правый указатель влево
        }

        return true; // Все символы совпали, строка палиндром
    }

    public static void main(String[] args) {

        // Первое задание
        System.out.println("\nЗадание 1 \n");
        String string = "I love Java";
        turnString(string);

        // Второе задание
        System.out.println("\nЗадание 2 \n");
        int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
        getDistinctNumbers(ints);

        //Третье задание
        System.out.println("\nЗадание 3 \n");
        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        Integer result = findSecondMaxElement(arr);

        if (result != null) {
            System.out.println("Второй по величине элемент: " + result);
        } else {
            System.out.println("Второго по величине элемента нет.");
        }

        //Четвертое задание
        System.out.println("\nЗадание 4 \n");
        System.out.println(lengthOfLastWord("Hello world")); // 5
        System.out.println(lengthOfLastWord("    fly me    to the moon    ")); // 4
        System.out.println(lengthOfLastWord("   ")); // 0
        System.out.println(lengthOfLastWord("")); // 0
        System.out.println(lengthOfLastWord(null)); // 0

        //Пятое задание
        System.out.println("\nЗадание 5 \n");
        System.out.println(isPalindrome("abc")); // false
        System.out.println(isPalindrome("112233")); // false
        System.out.println(isPalindrome("aba")); // true
        System.out.println(isPalindrome("112211")); // true
        System.out.println(isPalindrome("")); // true (пустая строка считается палиндромом)
        System.out.println(isPalindrome("a")); // true (строка из одного символа считается палиндромом)
        System.out.println(isPalindrome(null)); // false (или true, в зависимости от требований)
    }

}
