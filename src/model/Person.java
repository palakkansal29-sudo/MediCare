package model;

public abstract class Person {

    protected int id;
    protected String name;
    protected int age;
    protected String gender;
    protected String phone;

    public Person(int id, String name, int age,
                  String gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }
}