class Person {
    String name;
    int age;
    int size;
    String hairColor;

    public Person(String name, int age, int size, String hairColor) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.hairColor = hairColor;
    }

    void Walk(int Distance) {
        System.out.println(name + " walks " + Distance + " km");
    }

    void Eat(String Food) {
        System.out.println(name + " eats " + Food);
    }

    void Speak(String Language) {
        System.out.println(name + " speaks " + Language);
    }
}

class Student extends Person {
    Student(String name, int age, int size, String hairColor) {
        super(name, age, size, hairColor);
    }

    void Study(String Subject) {
        System.out.println(name + " studies " + Subject);
    }
}

class Teacher extends Person {
    Teacher(String name, int age, int size, String hairColor) {
        super(name, age, size, hairColor);
    }

    void Teach(String Subject) {
        System.out.println(name + " teaches " + Subject);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Jannatul", 20, 100, "Brown");
        Teacher t = new Teacher("Tasfia", 40, 120, "Black");

        s.Walk(10);
        s.Eat("Pasta");
        s.Speak("Spanish");
        s.Study("Music");

        System.out.println();

        t.Walk(20);
        t.Eat("Pizza");
        t.Speak("Italian");
        t.Teach("Sports");
    }
}
