package L4_InterfacesAndAbstraction.Lab3_SayHello;

public class Bulgarian implements Person{
    private String name;

    public Bulgarian(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }

    public void setName(String name) {
        this.name = name;
    }
}
