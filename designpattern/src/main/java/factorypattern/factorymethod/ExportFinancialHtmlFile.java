package factorypattern.factorymethod;

public class ExportFinancialHtmlFile implements ExportFile {

    public boolean export(String data) {
        /**
         * 业务逻辑
         */
        System.out.println("导出财务版HTML文件");
        return true;
    }

}
