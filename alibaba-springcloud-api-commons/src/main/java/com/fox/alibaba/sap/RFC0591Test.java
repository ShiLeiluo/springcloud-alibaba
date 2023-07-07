package com.fox.alibaba.sap;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
* @author F1337248 ShiLeiluo
* @date 2023-02-11 11:21
* @version 1.0
*/
public class RFC0591Test {
	public static void main(String[] args) {
		RFC_ZCPP_NSBG_0591();
	}
	private static void RFC_ZCPP_NSBG_0591() {
		try {
			JCoDestination destination = null;
			JCoRepository repository = null;
			JCoFunction function = null;
			Properties connectProperties = new Properties();
			connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "10.134.108.111");
			connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "00");
			
			connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "811");
			connectProperties.setProperty(DestinationDataProvider.JCO_USER, "HWV-BG");
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
			
			paramMapContainer.setValue("P_TYPE", "ZNM591");
			function.execute(destination);
			JCoParameterList output = function.getExportParameterList();
			
			String flag = output.getString("FLAG").trim();
			System.out.println("FLAG: " + flag);
			System.out.println("MESSAGE: " + output.getString("MESSAGE"));
//			JCoParameterList outParmList = function.getTableParameterList();
//			JCoTable table = outParmList.getTable("ITAB_"+"ZNM273A");
//			for (int i = 0; i < table.getNumRows(); i++) {
//				table.setRow(i);
//
//				if (("ZL38063LDF1".equals(table.getValue(5).toString()))) {
//					System.out.println(i);
//					
//				}
//			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
