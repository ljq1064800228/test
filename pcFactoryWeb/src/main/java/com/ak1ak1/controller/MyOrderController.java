package com.ak1ak1.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ak1ak1.common.utils.ExportUtils;
import com.ak1ak1.entity.MyOrder;
import com.ak1ak1.entity.query.MyOrderQuery;
import com.ak1ak1.entity.query.QueryResult;
import com.ak1ak1.service.MyOrderService;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping(value = "/order")
public class MyOrderController {
	
	@Autowired
	private MyOrderService myOrderService;
	
	// 查询所有订单
	@RequestMapping(value ="getOrders")
	@ResponseBody
	public Map<String, Object> getOrders(MyOrderQuery query){
		Map<String, Object> map = new HashMap<>();	
		QueryResult<MyOrder> data = myOrderService.getMyOrders(query);
		if(data==null){
			map.put("code", "0");
			map.put("msg", "");
			map.put("count",0);
			map.put("data", null);
			return map;		
		}
		map.put("code", "0");
		map.put("msg", "");
		map.put("count",data.getmRecords());
		map.put("data", data.getmItems());
		return map;	
}
	
	// 导出全部数据
	@RequestMapping(value = "exportMyOrderInfo")
	public void exportMyOrderInfo(HttpServletResponse response, HttpServletRequest request,MyOrderQuery query) {

		// 清空输出流
		response.reset();
		// 文件名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(new Date());				
		BufferedOutputStream bufferedOutPut = null;
		OutputStream output = null;
		try {
			// 处理不同浏览器下文件名中文乱码问题
			String header = request.getHeader("User-Agent").toUpperCase();
			if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {// ie浏览器
				fileName = URLEncoder.encode(fileName, "utf-8");
			} else {
				fileName = new String(fileName.getBytes(), "ISO8859-1");// 其他浏览器
			}
			// 设置响应头
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			HSSFWorkbook workbook = new HSSFWorkbook();
			List<MyOrder> exprot = myOrderService.exportMyOrderInfo(query);

			String[] requireShowName = { "订单编号","下单人","课程","订单价格","下单时间","状态","支付方式","支付时间","订单来源"};
			String[] requireFieldName = { "mo.order_num","mu.name", "mc.course_name", "mo.payment", "mo.created", "mo.status", "mo.payment_type", "mo.pay_time", "mo.source"};// 创建一个execl对象
			// 创建一个工作表对象
			HSSFSheet sheet = workbook.createSheet("订单信息");
			// 设置样式 设置表头
			ExportUtils.addTitle(sheet, requireShowName, "订单信息导出", ExportUtils.getHeader(workbook),
					ExportUtils.getContext(workbook));

			// 加入内容
			ExportUtils.addContextByList(sheet, exprot, requireFieldName, ExportUtils.getContext(workbook), true);
			// 写出
			output = response.getOutputStream();
			bufferedOutPut = new BufferedOutputStream(output);
			workbook.write(bufferedOutPut);
			bufferedOutPut.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedOutPut.close();
				output.close();
			} catch (IOException e) {

			}
		}	
	
		
	}
	
	// 导出筛选数据
	@RequestMapping(value = "exportMyOrderselect")
	public void exportMyOrderselect(HttpServletResponse response, HttpServletRequest request, MyOrderQuery query) {

		// 清空输出流
		response.reset();
		// 文件名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName = sdf.format(new Date());				
		BufferedOutputStream bufferedOutPut = null;
		OutputStream output = null;
		try {
			// 处理不同浏览器下文件名中文乱码问题
			String header = request.getHeader("User-Agent").toUpperCase();
			if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {// ie浏览器
				fileName = URLEncoder.encode(fileName, "utf-8");
			} else {
				fileName = new String(fileName.getBytes(), "ISO8859-1");// 其他浏览器
			}
			// 设置响应头
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			HSSFWorkbook workbook = new HSSFWorkbook();
			List<MyOrder> exprot = myOrderService.exportMyOrderInfo(query);

			String[] requireShowName = { "订单编号","下单人","课程","订单价格","下单时间","状态","支付方式","支付时间","订单来源"};
			String[] requireFieldName = { "mo.order_num","mu.name", "mc.course_name", "mo.payment", "mo.created", "mo.status", "mo.payment_type", "mo.pay_time", "mo.source"};// 创建一个execl对象
			// 创建一个工作表对象
			HSSFSheet sheet = workbook.createSheet("订单信息");
			// 设置样式 设置表头
			ExportUtils.addTitle(sheet, requireShowName, "订单信息导出", ExportUtils.getHeader(workbook),
					ExportUtils.getContext(workbook));

			// 加入内容
			ExportUtils.addContextByList(sheet, exprot, requireFieldName, ExportUtils.getContext(workbook), true);
			// 写出
			output = response.getOutputStream();
			bufferedOutPut = new BufferedOutputStream(output);
			workbook.write(bufferedOutPut);
			bufferedOutPut.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedOutPut.close();
				output.close();
			} catch (IOException e) {

			}
		}	
	
		
	}
	

	
}