package behavetype.visitorpattern;

public class VisitorA implements Visitor {
	/**
	 * 对应于NodeA的访问操作
	 */
	public void visit(NodeA node) {
		System.out.println(node.operationA());
	}

	/**
	 * 对应于NodeB的访问操作
	 */
	public void visit(NodeB node) {
		System.out.println(node.operationB());
	}
}
