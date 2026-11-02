class Person {
    String name, Hair_Color;
    int age, size;

    Person(String name, String Hair_Color, int age, int size) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.Hair_Color = Hair_Color;
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
    Student(String name, String Hair_Color, int age, int size) {
        super(name, Hair_Color, age, size);
    }

    void Study(String Subject) {
        System.out.println(name + " studies " + Subject);
    }
}

class Teacher extends Person {
    Teacher(String name, String Hair_Color, int age, int size) {
        super(name, Hair_Color, age, size);
    }

    void Teach(String Subject) {
        System.out.println(name + " teaches " + Subject);
    }
}

public class Main {
    public static void main(String[] args) {

        Student s = new Student("Ronaldo", "Brown", 41, 170);
        Teacher t = new Teacher("Zidan", "Black", 52, 155);

        s.Walk(10);
        s.Eat("Pizza");
        s.Speak("English");
        s.Study("Football");

        System.out.println();

        t.Walk(5);
        t.Eat("Tea");
        t.Speak("English");
        t.Teach("Coach");

    }
}
