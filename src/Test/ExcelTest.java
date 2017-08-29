import entity.Employee;
import mapper.EmployeeMapper;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author qq_emial1002139909@qq.com
 * @Date 2017/6/6 10:45
 */
public class ExcelTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    // 从spring容器中获取mapper代理对象
    EmployeeMapper employeeMapper = context.getBean(EmployeeMapper.class);
    @Test
    public void poiDo() throws IOException {
        /**
         * @see <a href="http://poi.apache.org/hssf/quick-guide.html#NewWorkbook">For more</a>
         */
        // 创建新的Excel 工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 在Excel工作簿中建一工作表，其名为缺省值, 也可以指定Sheet名称
        HSSFSheet sheet = workbook.createSheet();
        //HSSFSheet sheet = workbook.createSheet("SheetName");
        // 用于格式化单元格的数据
        HSSFDataFormat format = workbook.createDataFormat();

        // 创建新行(row),并将单元格(cell)放入其中. 行号从0开始计算.
        HSSFRow row = sheet.createRow((short) 1);

        // 设置字体
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 20); //字体高度
        font.setColor(HSSFFont.COLOR_RED); //字体颜色
        font.setFontName("黑体"); //字体
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
        font.setItalic(true); //是否使用斜体

        // 设置单元格类型
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平布局：居中
        cellStyle.setWrapText(true);

        // 添加单元格注释
        // 创建HSSFPatriarch对象,HSSFPatriarch是所有注释的容器.

        // 创建单元格
        HSSFCell cell = row.createCell((short) 1);
        HSSFRichTextString hssfString = new HSSFRichTextString("Hello World!");
        cell.setCellValue(hssfString);//设置单元格内容
        cell.setCellStyle(cellStyle);//设置单元格样式
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);//指定单元格格式：数值、公式或字符串

        List<Employee> employeeList = employeeMapper.getall();
        //格式化数据
        row = sheet.createRow((short) 2);
        cell = row.createCell((short) 2);
        cell.setCellValue(11111.25);
        cellStyle = workbook.createCellStyle();
        cell.setCellStyle(cellStyle);

        row = sheet.createRow((short) 4);
        cell = row.createCell((short) 4);
        cell.setCellValue(9736279.073);
        cellStyle = workbook.createCellStyle();
        cell.setCellStyle(cellStyle);
        sheet.autoSizeColumn((short)0); //调整第一列宽度
        sheet.autoSizeColumn((short)1); //调整第二列宽度
        sheet.autoSizeColumn((short)2); //调整第三列宽度
        sheet.autoSizeColumn((short)4); //调整第四列宽度

        try {
            FileOutputStream fileOut = new FileOutputStream("D:/8.xls");
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

     }
    @Test
    public  void exportimg(){
        //建立输出流
        FileOutputStream fileOutputStream = null;
        BufferedImage bufferedImage1 = null;
        BufferedImage bufferedImage2 = null;
        ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            bufferedImage1 = ImageIO.read(new File("F:\\作业\\ssm-shiromanage\\src\\main\\webapp\\static\\images\\0ebe3e04d3594141b4d6852aa4fe4f80.jpg"));
            bufferedImage2 = ImageIO.read(new File("F:\\作业\\ssm-shiromanage\\src\\main\\webapp\\static\\images\\1f4ce444beb94c39aca3acbbe51316fa.jpg"));
            ImageIO.write(bufferedImage1,"jpg",byteArrayOutputStream1);
            ImageIO.write(bufferedImage2,"jpg",byteArrayOutputStream2);

            // 创建一个工作薄
            HSSFWorkbook wb = new HSSFWorkbook();
            //创建一个sheet
            HSSFSheet sheet = wb.createSheet("out put excel");

            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            /**
             * 该构造函数有8个参数
             * 前四个参数是控制图片在单元格的位置，分别是图片距离单元格left，top，right，bottom的像素距离
             * 后四个参数，前连个表示图片左上角所在的cellNum和 rowNum，后天个参数对应的表示图片右下角所在的cellNum和 rowNum，
             * excel中的cellNum和rowNum的index都是从0开始的
             *
             */
            //图片一导出到单元格B2中
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,
                    (short) 1, 1, (short) 2, 2);
            //图片二导出到单元格C3到E5中，且图片的left和top距离边框50
            HSSFClientAnchor anchor1 = new HSSFClientAnchor(50, 50, 0, 0,
                    (short) 2, 2, (short) 5, 5);

            // 插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOutputStream1
                    .toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
            patriarch.createPicture(anchor1, wb.addPicture(byteArrayOutputStream2
                    .toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

            fileOutputStream = new FileOutputStream("D:/o.xls");
            // 写入excel文件
            wb.write(fileOutputStream);
         } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io erorr : " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
