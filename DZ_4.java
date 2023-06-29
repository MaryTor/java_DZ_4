import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DZ_4 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Вывести список пользователей");
            System.out.println("3. Вывести список пользователей, отсортированный по возрасту");
            System.out.println("4. Вывести список пользователей, отсортированный по возрасту и полу");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.println("Введите ФИО пользователя:");
                    String fullName = scanner.nextLine();
                    System.out.println("Введите возраст пользователя:");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера
                    System.out.println("Введите пол пользователя:");
                    String gender = scanner.nextLine();
                    User user = new User(fullName, age, gender);
                    users.add(user);
                    System.out.println("Пользователь успешно добавлен.");
                    break;
                case 2:
                    System.out.println("Список пользователей:");
                    for (User u : users) {
                        System.out.println(u.getFormattedInfo());
                    }
                    break;
                case 3:
                    System.out.println("Список пользователей, отсортированный по возрасту:");
                    sortByAge(users);
                    for (User u : users) {
                        System.out.println(u.getFormattedInfo());
                    }
                    break;
                case 4:
                    System.out.println("Список пользователей, отсортированный по возрасту и полу:");
                    sortByAgeAndGender(users);
                    for (User u : users) {
                        System.out.println(u.getFormattedInfo());
                    }
                    break;
                case 5:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
        }
    }

    private static void sortByAge(List<User> users) {
        users.sort(Comparator.comparingInt(User::getAge));
    }

    private static void sortByAgeAndGender(List<User> users) {
        users.sort(Comparator.comparingInt(User::getAge).thenComparing(User::getGender));
    }
}

class User {
    private String fullName;
    private int age;
    private String gender;

    public User(String fullName, int age, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFormattedInfo() {
        String[] names = fullName.split(" ");
        StringBuilder formattedName = new StringBuilder();
        for (String name : names) {
            formattedName.append(name.charAt(0)).append(".");
        }
        return formattedName + " " + age + " " + gender;
    }
}