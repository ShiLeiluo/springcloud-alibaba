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
* @date 2023-04-01 11:15
* @version 1.0
*/
//828,808,878,860,811,800,806
public class GroupServerTest {
	public static void main(String[] args) {
		
		
		String[] s828 = {"CN1","10.134.108.111","CNSBG_800","828","CBT-BG","foxconn8"};
		String[] s808 = {"CN1","10.134.108.111","CNSBG_800","808","NSGBG","MESEDICU"};
		String[] s878 = {"KPD","10.62.205.75","CNSBG_868","878","NSGBG","12345678"};
		String[] s860 = {"CNP","10.134.167.168","CNSBG_860","860","NSGBG","MESEDICU"};
		String[] s811 = {"CN1","10.134.108.111","CNSBG_800","811","HWV-BG","MESEDICU"};
		String[] s800 = {"CN1","10.134.108.111","CNSBG_800","800","NSGBG","MESEDICU"};
		String[] s806 = {"CN1","10.134.108.111","CNSBG_800","806","NWEIT","admin806"};
		System.out.println("******测试828");
		connect(s828);
		System.out.println("******测试808");
		connect(s808);
		System.out.println("******测试878");
		connect(s878);
		System.out.println("******测试860");
		connect(s860);
		System.out.println("******测试811");
		connect(s811);
		System.out.println("******测试800");
		connect(s800);
		System.out.println("******测试806");
		connect(s806);
	}
	private static void connect(String[] str) {
		try {
			JCoDestination destination = null;
			JCoRepository repository = null;
			JCoFunction function = null;
			Properties connectProperties = new Properties();
			connectProperties.setProperty(DestinationDataProvider.JCO_R3NAME, str[0]);
			connectProperties.setProperty(DestinationDataProvider.JCO_MSHOST, str[1]);
			connectProperties.setProperty(DestinationDataProvider.JCO_GROUP, str[2]);
			connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, str[3]);
			connectProperties.setProperty(DestinationDataProvider.JCO_USER, str[4]);
			connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, str[5]);


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
			JCoParameterList outParmList = function.getTableParameterList();
			JCoTable table = outParmList.getTable("ITAB_ZNM591");
			System.out.println("ROWS: "+table.getNumRows());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
