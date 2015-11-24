package com.adarsh.spring.web.viewresolver;

import com.adarsh.spring.web.bean.Employee;
import com.adarsh.spring.web.bean.EmployeeList;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.List;
import java.util.*;


/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 */
public class PdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        final EmployeeList employeeStore=(EmployeeList)model.get("employeeStore");
        final java.util.List<Employee> employeeList = employeeStore.getEmployeeList();

        PdfPTable table = new PdfPTable(4);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBackgroundColor(Color.lightGray);

        table.addCell("EmpId");
        table.addCell("EmpName");
        table.addCell("EmpEmail");
        table.addCell("EmpProject");

        for (Employee employee : employeeList) {
            table.addCell(employee.getEmpId() + "");
            table.addCell(employee.getEmpName());
            table.addCell(employee.getEmpEmail());

            StringBuffer project = new StringBuffer("");
            for (String projects : employee.getEmpProject()) {
                project.append(projects);
                project.append(" ");
            }
            table.addCell(project.toString());
        }
        document.add(table);
    }
}
