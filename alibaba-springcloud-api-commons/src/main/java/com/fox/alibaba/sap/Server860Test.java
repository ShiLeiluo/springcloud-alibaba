package com.fox.alibaba.sap;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
* @author F1337248 ShiLeiluo
* @date 2023-01-05 09:07
* @version 1.0
*/
public class Server860Test {
	public static void main(String[] args) {
		System.out.println("---------------------------------------------------");
		System.out.println("860, ZCPP_NSBG_0592");
		System.out.println("参数: P_TYPE = OBSOLETE, P_DOWNLOAD = X");
		RFC_ZCPP_NSBG_0592();
		System.out.println("测试成功!");
		System.out.println("---------------------------------------------------");
		System.out.println("860, ZCPP_NSBG_0591");
		System.out.println("参数: ZNM66,ZNM24,ZNM273A,ZNM591,ZNP22AV3");
		String[] pType = {"ZNM66","ZNM24","ZNM273A","ZNM591","ZNP22AV3"};
		for (int i = 0; i < pType.length; i++) {
			System.out.println("参数: "+pType[i]);
			RFC_ZCPP_NSBG_0591(pType[i]);	
		}
		System.out.println("测试成功!");
		System.out.println("---------------------------------------------------");
		System.out.println("860, ZCMM_NSBG_0380");
		System.out.println("参数: PLANT = ACGA");
		RFC_ZCMM_NSBG_0380();
		System.out.println("测试成功!");
		System.out.println("---------------------------------------------------");
	}
	private static void RFC_ZCMM_NSBG_0380() {
		try {
			JCoDestination destination = null;
			JCoRepository repository = null;
			JCoFunction function = null;
			Properties connectProperties = new Properties();
			connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "10.134.165.30");
			connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "00");
			
			connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "860");
			connectProperties.setProperty(DestinationDataProvider.JCO_USER, "NSGBG");
			connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "MESEDICU");
			connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "EN");

			connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "0");
			connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "1");

			File cfg = new File("ConnectionPool" + "." + "jcoDestination");
			FileOutputStream fos = new FileOutputStream(cfg);
			connectProperties.store(fos, "ShiLeiluo:F1337248");
			fos.close();
			destination = JCoDestinationManager.getDestination("ConnectionPool");
			repository = destination.getRepository();
			function = repository.getFunction("ZCMM_NSBG_0380");
			JCoParameterList importParameterList = function.getImportParameterList();
			importParameterList.setValue("PLANT", "ACGA");
//			JCoParameterList tableParameterList = function.getTableParameterList();
//			JCoTable importTable = tableParameterList.getTable("IN_TABLE");

			function.execute(destination);
			JCoParameterList output = function.getExportParameterList();
			System.out.println("O_FLAG"+output.getString("O_FLAG"));
			System.out.println("O_MESSAGE"+output.getString("O_MESSAGE"));
			
			JCoTable table = function.getTableParameterList().getTable("OUT_TABLE");
			int tableNums = table.getNumRows();
			System.out.println("ROWS: "+tableNums);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void RFC_ZCPP_NSBG_0591(String pType) {
		try {
			JCoDestination destination = null;
			JCoRepository repository = null;
			JCoFunction function = null;
			Properties connectProperties = new Properties();
			connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "10.134.165.30");
			connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "00");
			
			connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "860");
			connectProperties.setProperty(DestinationDataProvider.JCO_USER, "NSGBG");
			connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "MESEDICU");
			connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "EN");

			connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "0");
			connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "1");

			File cfg = new File("ConnectionPool" + "." + "jcoDestination");
			FileOutputStream fos = new FileOutputStream(cfg);
			connectProperties.store(fos, "ShiLeiluo:F1337248");
			fos.close();
			destination = JCoDestinationManager.getDestination("ConnectionPool");
			repository = destination.getRepository();
			function = repository.getFunction("ZCPP_NSBG_0591");
			JCoParameterList paramMapContainer = function.getImportParameterList();
			
			paramMapContainer.setValue("P_TYPE", pType);
			function.execute(destination);
			JCoParameterList output = function.getExportParameterList();
			
			String flag = output.getString("FLAG").trim();
			System.out.println("FLAG: " + flag);
			System.out.println("MESSAGE: " + output.getString("MESSAGE"));
			JCoParameterList outParmList = function.getTableParameterList();
			JCoTable table = outParmList.getTable("ITAB_"+pType);
			System.out.println("ROWS: "+table.getNumRows());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private static void RFC_ZCPP_NSBG_0592() {
		try {
			JCoDestination destination = null;
			JCoRepository repository = null;
			JCoFunction function = null;
			Properties connectProperties = new Properties();
			connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "10.134.165.30");
			connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "00");
			
			connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "860");
			connectProperties.setProperty(DestinationDataProvider.JCO_USER, "NSGBG");
			connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "MESEDICU");
			connectProperties.setProperty(DestinationDataProvider.JCO_LANG, "EN");

			connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "0");
			connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "1");

			File cfg = new File("ConnectionPool" + "." + "jcoDestination");
			FileOutputStream fos = new FileOutputStream(cfg);
			connectProperties.store(fos, "ShiLeiluo:F1337248");
			fos.close();
			destination = JCoDestinationManager.getDestination("ConnectionPool");
			repository = destination.getRepository();
			function = repository.getFunction("ZCPP_NSBG_0592");
			JCoParameterList paramMapContainer = function.getImportParameterList();
			paramMapContainer.setValue("P_TYPE", "OBSOLETE");
			paramMapContainer.setValue("P_DOWNLOAD", "X");
			function.execute(destination);
			JCoParameterList output = function.getExportParameterList();
			
			String flag = output.getString("FLAG").trim();
			System.out.println("FLAG: " + flag);
			System.out.println("MESSAGE: " + output.getString("MESSAGE"));
			JCoParameterList outParmList = function.getTableParameterList();
			JCoTable table = outParmList.getTable("OTAB");
			System.out.println("ROWS: "+table.getNumRows());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
