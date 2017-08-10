package factorypattern.factorymethod;

public interface ExportFactory {
	public ExportFile factory(String type);
}
