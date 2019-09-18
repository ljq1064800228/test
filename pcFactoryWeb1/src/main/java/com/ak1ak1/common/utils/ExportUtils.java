package com.ak1ak1.common.utils;
	
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.StringUtils;

/**
 * 生成Excel的工具类
 */
public class ExportUtils {

    /**
     * 添加列表信息
     * sheet excelSheet
     * list 导出主要信息
     * fieldName 属性名称>数组对于表头 扩展属性格式extra.key
     * contextStyle 内容样式
     * isHaveSerial 是否添加序号
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    public static <T> void addContextByList(HSSFSheet sheet, List<T> list, 
            String[] fieldName, HSSFCellStyle contextStyle,boolean isHaveSerial) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

        
            HSSFRow row = null;
            HSSFCell cell = null;
            if (list != null) {
                List<T> tList = (List<T>) list;
                T t = null;
                String value = "";
                for (int i = 0; i < list.size(); i++) {
                    row = sheet.createRow(i + 2);
                    for (int j = 0; j < fieldName.length; j++) {
                        
                        t = tList.get(i);
                        value = objectToString(getFieldValueByName(fieldName[j], t));
                        if(isHaveSerial){
                            //首列加序号
                            /*if(row.getCell(0)!=null && row.getCell(0).getStringCellValue()!=null){
                            }*/
                            cell = row.createCell(0);
                            cell.setCellValue((i + 1) + "");
                            cell = row.createCell(j+1);
                            cell.setCellValue(value);    
                        }else{
                            cell = row.createCell(j);
                            cell.setCellValue(value);    
                        }
                        cell.setCellStyle(contextStyle);
                    }
                }
                for (int j = 1; j < fieldName.length; j++) {
                    sheet.autoSizeColumn(j); // 单元格宽度 以最大的为准
                }
            } else {
                row = sheet.createRow(2);
                cell = row.createCell(0);
            }
       
    }
    
    /**
     * <P>Object转成String类型，便于填充单元格</P>
     * */
    public static String objectToString(Object object){
        String str = "";
        if(object==null){
        }else if(object instanceof Date){
                DateFormat from_type = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                Date date = (Date)object;
                str = from_type.format(date);
        }else if(object instanceof String){
            str = (String)object;
        }else if(object instanceof Integer){
            str = ((Integer)object).intValue()+"";
        }else if(object instanceof Double){
            str = ((Double)object).doubleValue()+"";
        }else if(object instanceof Long){
            str = Long.toString(((Long)object).longValue());
        }else if(object instanceof Float){
            str = Float.toHexString(((Float)object).floatValue());
        }else if(object instanceof Boolean){
            str = Boolean.toString((Boolean)object);
        }else if(object instanceof Short){
            str = Short.toString((Short)object);
        }else if(object instanceof BigDecimal){
            str = ((BigDecimal)object).toString();
        }
        return str;
    }
    
    /**
     * 添加标题(第一行)与表头(第二行)
     * 
     * @param 
     * sheet excelSheet
     * assettitle 表头>数组
     * titleName 标题 
     * headerStyle 标题样式
     * contextStyle  表头样式
     */ 
    public static void addTitle(HSSFSheet sheet, String[] assettitle, String titleName,
            HSSFCellStyle headerStyle, HSSFCellStyle contextStyle) {
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, assettitle.length - 1));
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue(titleName);
        cell.setCellStyle(headerStyle);
        row = sheet.createRow(1);
        for (int i = 0; i < assettitle.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(assettitle[i]);
            cell.setCellStyle(contextStyle);
        }
    }

    /**
     * <p>
     * 根据属性名获取属性值
     * </p>
     * fieldName 属性名 object 属性所属对象
     * 支持Map扩展属性, 不支持List类型属性，
     * return 属性值
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    @SuppressWarnings("unchecked")
    public static Object getFieldValueByName(String fieldName, Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Object fieldValue = null;
        if (StringUtils.hasLength(fieldName) && object != null) {
            String firstLetter = ""; // 首字母
            String getter = ""; // get方法
            Method method = null; // 方法
            String extraKey = null;
            // 处理扩展属性 extraData.key
            if (fieldName.indexOf(".") > 0) {
                String[] extra = fieldName.split("\\.");
                fieldName = extra[0];
                extraKey = extra[1];
            }
            firstLetter = fieldName.substring(0, 1).toUpperCase();
            getter = "get" + firstLetter + fieldName.substring(1);
            method = object.getClass().getMethod(getter, new Class[] {});
            fieldValue = method.invoke(object, new Object[] {});
            if (extraKey != null) {
                Map<String, Object> map = (Map<String, Object>) fieldValue;
                fieldValue = map==null ? "":map.get(extraKey);
            }
        }
        return fieldValue;
    }
    
    
    //标题样式
    public static HSSFCellStyle getHeader(HSSFWorkbook workbook){
        
        HSSFCellStyle format = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  //加粗
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)16);
        format.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        format.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
        format.setFont(font);
        return format;
    }
    
    //内容样式
    public static HSSFCellStyle getContext(HSSFWorkbook workbook){
        HSSFCellStyle format = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontName("微软雅黑");
        format.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        format.setAlignment(HSSFCellStyle.ALIGN_CENTER);    
        format.setFont(font);
        return format;
    }

}
	
	
	
	

