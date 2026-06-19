import java.util.OptionalInt;
import java.util.Objects;

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

    // Возможность изменения адреса
    public void setAddress(String address) {
        this.address = address;
    }

    // День рождения увеличивает возраст на 1 год
    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }


    // Создание билдера для ребенк
    public PersonBuilder newChildBuilder() {

        PersonBuilder builder = new PersonBuilder()
                .setSurname(surname);

        if (hasAddress()) {
            builder.setAddress(address);
        }

        if (hasAge()) {
            builder.setAge(Math.max(0, age - 20));
        }

        return builder;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(name)
                .append(" ")
                .append(surname);

        if (hasAge()) {
            sb.append(", возраст: ")
                    .append(age);
        }

        if (hasAddress()) {
            sb.append(", живет в городе ")
                    .append(address);
        }

        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                surname,
                age,
                address
        );
    }
}
