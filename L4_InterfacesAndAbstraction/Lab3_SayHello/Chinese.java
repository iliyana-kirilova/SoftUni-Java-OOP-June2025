package L4_InterfacesAndAbstraction.Lab3_SayHello;

public class Chinese implements Person{
    private String name;

    public Chinese(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
