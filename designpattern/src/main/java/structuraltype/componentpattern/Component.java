package structuraltype.componentpattern;

public abstract class Component {
	public String name;  
    public abstract void add(Component c);  
    public abstract void remove(Component c);  
    public abstract void eachChild();  
}
