package design.pattern.decorator.decorators;

public class ApplicationConfigurator {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSource originSource = new FileDataSource("out/OutputDemo.txt");
        DataSource source = new EncryptionDecorator(originSource);
        source = new CompressionDecorator(source);

        SalaryManager logger = new SalaryManager(source);
        logger.save(salaryRecords);

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(originSource.readData());
        logger.handleSalary();
    }

}
