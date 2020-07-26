package design.pattern.decorator.decorators;

public class SalaryManager {
    private DataSource source;

    public SalaryManager(DataSource source) {
        this.source = source;
    }

    public String load() {
        return source.readData();
    }

    public void save(String data) {
        source.writeData(data);
    }

    public void handleSalary() {
        System.out.println("- Decoded --------------");
        System.out.println(load());
    }
}
