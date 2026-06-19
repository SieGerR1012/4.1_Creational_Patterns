public class Main {

    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(42)
                .setAddress("Москва")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Никита")
                .build();

        System.out.println(
                "У " + mom + " есть сын, " + son
        );

        son.happyBirthday();

        System.out.println();
        System.out.println("После дня рождения:");
        System.out.println(son);

        System.out.println();

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            new PersonBuilder()
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}