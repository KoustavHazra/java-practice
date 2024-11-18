package CollectionFramework;

public class AnimalForComparable implements Comparable<AnimalForComparable> {
    int age;
    String name;
    int weight;

    public AnimalForComparable(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    @Override
    public String toString() {
        return "AnimalForComparable{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}' + "\n";
    }

    @Override
    public int compareTo(AnimalForComparable that) {
        // another condition: if age is same, compare with name
        if (this. age == that.age) {
            return this.name.compareTo(that.name);
        }
        return this.age - that.age;
    }
}
