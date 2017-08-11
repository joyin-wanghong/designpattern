package behavetype.iteratorpattern;

public interface Aggregate {
	/**
     * 工厂方法，创建相应迭代子对象的接口
     */
    public abstract Iterator createIterator();
}
