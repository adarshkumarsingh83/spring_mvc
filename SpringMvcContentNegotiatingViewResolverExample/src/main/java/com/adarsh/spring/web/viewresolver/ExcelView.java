package com.adarsh.spring.web.viewresolver;

import com.adarsh.spring.web.bean.Employee;
import com.adarsh.spring.web.bean.EmployeeList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
public class ExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        final EmployeeList employeeStore=(EmployeeList)model.get("employeeStore");
        final List<Employee> employeeList = employeeStore.getEmployeeList();

        Sheet sheet = workbook.createSheet("Employee Data");
        CellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        Row row = null;
        Cell cell = null;
        int rowCount = 0;
        int colCount = 0;

        // Create header cells
        row = sheet.createRow(rowCount++);

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("EmpId");

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("EmpName");

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("EmpEmail");

        cell = row.createCell(colCount++);
        cell.setCellStyle(style);
        cell.setCellValue("EmpProject");

        for (Employee employee : employeeList) {
            // Create data cells
            row = sheet.createRow(rowCount++);
            colCount = 0;
            row.createCell(colCount++).setCellValue(employee.getEmpId());
            row.createCell(colCount++).setCellValue(employee.getEmpName());
            row.createCell(colCount++).setCellValue(employee.getEmpEmail());

            StringBuffer project = new StringBuffer("");
            for (String empProject : employee.getEmpProject()) {
                project.append(empProject);
                project.append(" ");
            }
            row.createCell(colCount++).setCellValue(project.toString());
        }
        for (int i = 0; i < employeeList.size(); i++)
            sheet.autoSizeColumn(i, true);
    }

}
