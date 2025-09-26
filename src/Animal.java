class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void eat() {
        System.out.println(name + " is eating.");
    }
}

class Lion extends Animal {


    public Lion(String name, int age) {
        super(name, age);
    }

    void roar() {
        System.out.println(name + " is roaring.");
    }
}
