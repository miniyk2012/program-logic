package design.pattern.decorator.decorators;


public abstract class DataSourceDecorator implements DataSource {
    private DataSource wrappee;

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }
}
