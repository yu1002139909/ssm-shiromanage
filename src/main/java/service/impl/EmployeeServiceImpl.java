package service.impl;

import entity.Employee;
import mapper.EmployeeMapper;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.EmployeeService;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/5/31 10:57
 *emp实现类
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getall() {
        return employeeMapper.getall();
    }

    public void add(Employee employee) {
        employeeMapper.add(employee);
    }

    public void delete(String employeeId) {
        employeeMapper.delete(employeeId);
    }

    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    public Employee findById(String employeeId) {
        return employeeMapper.findById(employeeId);
    }

    public List<Employee> findbyEmployeeByDepeId(String deptId) {
        return employeeMapper.findbyEmployeeByDepeId(deptId);
    }
    public void exportExcel(List<Employee> employeeList, ServletOutputStream outputStream) {
        try {
        //创建工作簿
        HSSFWorkbook workbook  = new HSSFWorkbook();
       //1.1创建合并单元格
        CellRangeAddress cellRangeAddress =  new CellRangeAddress(0,0,0,9);
       //1.2头标题样式
        HSSFCellStyle heartStyle = createCellStyle(workbook, (short) 16);
       //1.3列标题样式
        HSSFCellStyle columStyle = createCellStyle(workbook, (short) 13);
       //2创建工作表
        HSSFSheet workbookSheet = workbook.createSheet("职工列表");
           //2.
            workbookSheet.addMergedRegion(cellRangeAddress);
            //自适应
       //3创建行
       //3.1创建头标题行；并设置头标题
        HSSFRow row = workbookSheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(heartStyle);
        cell.setCellValue("职工列表");
        //3.2创建列标题行；并设置列标题
        HSSFRow row1 = workbookSheet.createRow(1);
        String[] titels = {"职工id","职工姓名","性别","开始工作时间","照片","入职部门","当前部门","在职状态","退休时间"};
        for (int i= 0;i<titels.length;i++){
            HSSFCell cell1 = row1.createCell(i);
            cell1.setCellStyle(columStyle);
            cell1.setCellValue(titels[i]);
        }

        //4操作单元格，将用户类别写入excel
          if(employeeList!=null && employeeList.size()>0){
                for (int j = 0; j < employeeList.size(); j++) {
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    String strendDate = sdf.format(employeeList.get(j).getEnterDate());
                    HSSFRow row2 = workbookSheet.createRow(j + 2);
                    HSSFCell cell1 = row2.createCell(0);
                    cell1.setCellValue(employeeList.get(j).getEmpId());
                    HSSFCell cell2 = row2.createCell(1);
                    cell2.setCellValue(employeeList.get(j).getEmpName());
                    HSSFCell cell3 = row2.createCell(2);
                    cell3.setCellValue(employeeList.get(j).getEmpGrade());
                    HSSFCell cell4 = row2.createCell(3);
                    cell4.setCellValue(strendDate);
                    HSSFCell cell5 = row2.createCell(4);
                    cell5.setCellValue(employeeList.get(j).getPhoto());
                    HSSFCell cell6 = row2.createCell(5);
                    cell6.setCellValue(employeeList.get(j).getEnterDept().getDeptName());
                    HSSFCell cell7 = row2.createCell(6);
                    cell7.setCellValue(employeeList.get(j).getOverDept().getDeptName());
                    HSSFCell cell8 = row2.createCell(7);
                    cell8.setCellValue(employeeList.get(j).getState());
                    HSSFCell cell9 = row2.createCell(8);
                    cell9.setCellValue("2015-12-12");

            }
        }
            workbookSheet.autoSizeColumn((short)0);
            workbookSheet.autoSizeColumn((short)1);
            workbookSheet.autoSizeColumn((short)2);
            workbookSheet.autoSizeColumn((short)3);
            workbookSheet.autoSizeColumn((short)4);
            workbookSheet.autoSizeColumn((short)5);
            workbookSheet.autoSizeColumn((short)6);
            workbookSheet.autoSizeColumn((short)7);
            workbookSheet.autoSizeColumn((short)8);
           //5输出

            workbook.write(outputStream);
            workbook.close();
           } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**@author yu
     * @version 1.0
     * @Date 2017/6/6
     *样式方法
     */

    private HSSFCellStyle createCellStyle(HSSFWorkbook workbook,short fontsize){
        //1.2头标题样式
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        //1.2.1创建字体
        HSSFFont  font  = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//字体加粗
        font.setFontHeightInPoints((short) 13);
        //加载字体
        cellStyle.setFont(font);
        return cellStyle;
    }
}
