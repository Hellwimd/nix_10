package ua.com.alevel.entity;

public class Elephant {
    private Long id;
    private String name;
    private int weight;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", age=" + age +
                '}';
    }
}

