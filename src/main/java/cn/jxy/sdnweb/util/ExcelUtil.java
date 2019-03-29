package cn.jxy.sdnweb.util;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class ExcelUtil {
	
		
		/**
	     * 创建2003版本的Excel文件
	     */
	    public static void creat2003Excel(List<Routes> list,OutputStream output) throws Exception {
	        HSSFWorkbook workbook = new HSSFWorkbook();// 创建 一个excel文档对象

	        HSSFSheet sheet = workbook.createSheet();// 创建一个工作薄对象

	        // 添加表头行
	        HSSFRow hssfRow = sheet.createRow(0);
	        // 设置单元格格式居中
	        HSSFCellStyle cellStyle = workbook.createCellStyle();
	        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	        sheet.setColumnWidth(1, 10000);//设置第2列列宽
	        sheet.setColumnWidth(2, 10000);//设置第3列列宽
	        sheet.setColumnWidth(3, 4000);//设置第4列列宽

	        // 添加表头内容
	        HSSFCell headCell = hssfRow.createCell(0);
	        headCell.setCellValue("编号");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(1);
	        headCell.setCellValue("路径");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(2);
	        headCell.setCellValue("权值");
	        headCell.setCellStyle(cellStyle);

	        headCell = hssfRow.createCell(3);
	        headCell.setCellValue("长度");
	        headCell.setCellStyle(cellStyle);
	        
	       
	        // 添加数据内容
	        StringBuilder weghts=new StringBuilder();
	        for (int i = 0; i < list.size(); i++) {
	            hssfRow = sheet.createRow((int) i + 1);
	            Routes routes = list.get(i);

	            // 创建单元格，并设置值
	            HSSFCell cell = hssfRow.createCell(0);
	            cell.setCellValue(i+1);
	            cell.setCellStyle(cellStyle);

	            cell = hssfRow.createCell(1);
	            cell.setCellValue(routes.getRoute());
	            cell.setCellStyle(cellStyle);

	            for(int j=0;j<routes.getWeights().size();j++) {
	            	if(j!=routes.getWeights().size()-1) {
	            		weghts.append(routes.getWeights().get(j)+",");
	            	}else {
	            		weghts.append(routes.getWeights().get(j));
	            	}
	            	
	            }
	            cell = hssfRow.createCell(2);
	            cell.setCellValue(weghts.toString());
	            cell.setCellStyle(cellStyle);
	            
	            cell = hssfRow.createCell(3);
	            cell.setCellValue(routes.getLength());
	            cell.setCellStyle(cellStyle);
	            
	        }
	      
	        // 保存Excel文件
	        try {
	            workbook.write(output);
	            System.out.println("创建成功 office 2003 excel");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
 
}
