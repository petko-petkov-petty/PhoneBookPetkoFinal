import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;

    @Override
    public int compareTo(Person person) {
        return this.getName().compareTo(person.getName());
    }

    public Person(String name) {
        setName(name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
