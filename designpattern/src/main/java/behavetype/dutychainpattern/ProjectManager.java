package behavetype.dutychainpattern;

public class ProjectManager extends Handler {
	@Override
	public String handleFeeRequest(String user, double fee) {
		String str = "";
		// 项目经理权限比较小，只能在500以内
		if (fee < 500) {
			str = "成功：项目经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
		} else {
			// 超过500，继续传递给级别更高的人处理
			if (getSuccessor() != null) {
				return getSuccessor().handleFeeRequest(user, fee);
			}
		}
		return str;
	}
}
