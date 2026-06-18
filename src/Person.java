import java.util.OptionalInt;

public class Person {
    // Имя и фамилия после создания меняться не должны
    private final String name;
    private final String surname;

    // Возраст может быть неизвестен.
    // Используем Integer вместо int:
    // null -> возраст неизвестен
    private Integer age;

    // Адрес может отсутствовать
    private String address;

    public Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    // Проверка наличия возраста
    public boolean hasAge(){
        return age != null;
    }

    // Проверка наличия адреса
    public boolean hasAddress() {
        return address != null && !address.isBlank();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return hasAge()
                ? OptionalInt.of(age)
                : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }
}
