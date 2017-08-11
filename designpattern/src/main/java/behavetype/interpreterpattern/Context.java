package behavetype.interpreterpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 保存变量
 * @author Administrator
 *
 */

public class Context {
	
	private Map<Variable, Boolean> map = new HashMap<Variable, Boolean>();

	public void assign(Variable var, boolean value) {
		map.put(var, new Boolean(value));
	}

	/**
	 * 反回一个变量
	 * @param var
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean lookup(Variable var) throws IllegalArgumentException {
		Boolean value = map.get(var);
		if (value == null) {
			throw new IllegalArgumentException();
		}
		return value.booleanValue();
	}
}
