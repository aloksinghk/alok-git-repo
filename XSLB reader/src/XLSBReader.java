/**
 * 
 */
//package alok_xlsb;

import com.smartxls.HyperLink;
import com.smartxls.WorkBook;

import java.io.*;


public class XLSBReader {

	private void write() {
		//workBook.writeXLSB(new java.io.FileOutputStream("result.xlsb"));
	}
	private void read(File in, File out) {
		WorkBook workBook = new WorkBook();
        String version = workBook.getVersionString();
        System.out.println("Ver:" + version);
        
        try
        {
        	// 2G Xslb file reading
        	
        	//workBook.readXLSB(new java.io.FileInputStream(in));
        	workBook.readXLSX(new java.io.FileInputStream(in));
        	// 3G Xslb File reading 
        	//workBook.readXLSX(new java.io.FileInputStream("data/TN_3G_GIS_APR_16.xlsx"));
        	String sheetName = workBook.getSheetName(workBook.getSheet());
        	short tabname = workBook.getShowTabs();
        	System.out.println("Tab name: "+ tabname);
        	//FileOutputStream file = new FileOutputStream(out);
        	//File file = new File();
            FileWriter fwriter = new FileWriter(out);
            BufferedWriter bufferedWriter = new BufferedWriter(fwriter);
        	bufferedWriter.write("S.NO"+"\t"+"Site ID"+"\t"+"MO/Cellname/Cell ID"+"\t"+"Site Name"+"\t"+"Site Address"+"\t"+"Latitude(degree decimal)"+"\t"+"Longitude (degree decimal)"+"\t"+"CGI"+"\t"+"CBT"+"\t"+"Town Name"+"\t"+"LDCA"+"\t"+"SDCA"+"\t"+"Existing/New Town"+"\t"+"ShowCase/Non Showcase"+"\t"+"Pincode"+"\t"+"Shared/Non Shared"+"\t"+"Site Principal Owner (SP)"+"\t"+"Tower Height (m)"+"\t"+"Building Height (m)"+"\t"+"Tower Type"+"\t"+"Site Type"+"\t"+"Cabex Site Catagory (OM/IM/MI/PICO/TT/OM_Pole)"+"\t"+"Date On Air (DD-MMM-YY)"+"\t"+"Band (900/1800/MBC)"+"\t"+"BTS Type- Main Cabinet"+"\t"+"BTS Type- Expansion 1/ MBC Cabinet"+"\t"+"BTS Type- Expansion 2/ MBC Cabinet"+"\t"+"BTS Type- Expansion 3/ MBC Cabinet"+"\t"+"Total  No of BTS"+"\t"+"Tx Power(dB)"+"\t"+"GSM Antenna Type 1- Manufacturer"+"\t"+"GSM Antenna Type 1"+"\t"+"GSM Antenna Type 2- Manufacturer"+"\t"+"GSM Antenna  Type 2"+"\t"+"GSM Antenna Type 3- Manufacturer"+"\t"+"GSM Antenna  Type 3"+"\t"+"Total No of Antenna"+"\t"+"Azimuth (Deg)"+"\t"+"Antenna Height AGL(m)"+"\t"+"Mode of Operation (Combined/Uncombined/TCC/Air Combining)"+"\t"+"TMA Status (Yes/No)"+"\t"+"Antenna Gain (dBi)"+"\t"+"Beam Width (Deg)"+"\t"+"Electrical Tilt (Deg)"+"\t"+"Mechanical Tilt (Deg)"+"\t"+"Feeder Size"+"\t"+"Approximate Feeder Length (m)"+"\t"+"Feeder Loss (dB)"+"\t"+"Edge (Yes/No)"+"\t"+"MSC ID"+"\t"+"MSC Name"+"\t"+"MSC Site (Yes/No)"+"\t"+"BSC Name"+"\t"+"BSC Site (Yes/No)"+"\t"+"Fiber Connected (SP) (Yes/No)"+"\t"+"NET TRX's Available"+"\t"+"Total TS Available"+"\t"+"BCCH"+"\t"+"SDCCH Value (NBH)"+"\t"+"NO Of SDCCH"+"\t"+"FPDCH"+"\t"+"TCH Available For Voice"+"\t"+"Equipped Erlang Capacity for Voice"+"\t"+"TCH Available With"+" 0 "+"Data TS"+"\t"+"Equipped Capacity with"+"0"+"TS Data"+"\t"+"Average BBH Traffic (FR)"+"\t"+"Average BBH Traffic (HR)"+"\t"+"Average BBH Traffic (Total)"+"\t"+"Cell Utilization (%)"+"\t"+"%HR Traffic"+"\t"+"Total No of Data Timeslots"+"\t"+"Average BBH Traffic (AMR FR)"+"\t"+"Average BBH Traffic (AMR HR)"+"\t"+"Random Access Succ Rate (%)"+"\t"+"SDCCH Blocking (%)"+"\t"+"TCH Blocking (%)"+"\t"+"TCH Assignment Succ Rate (%)"+"\t"+"SD Drop (%)"+"\t"+"TCH Drop (%)"+"\t"+"TSQIGOOD%"+"\t"+"TSQIACCPT%"+"\t"+"TSQIBAD%"+"\t"+"Total Monthly Calls (TASSALL)"+"\t"+"Total Monthly Traffic (Erlang)"+"\t"+"Average of last 05 Working Days"+"\t"+"Remarks"+"\t"+"Sector Status"+"\t"+"Sector locked(Date)"+"\n");
            
        	System.out.println("Sheet Name - "+ sheetName);
        	
        	
        	for (int i = 1; i< 25000; i++) {
        		for (int j = 0; j< 88; j++) {
		        	String cellValue = workBook.getText(i,j);
		        	System.out.print(cellValue + "\t");
        	         
		        	bufferedWriter.write(cellValue + "\t");   
		        	
        		}   	
        		
        		System.out.println("");
        		bufferedWriter.write("\n");
        			
	             //bufferedWriter.close(); 
        	}
        	
        
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		

	}
	
	public static void main(String[] args) {
		
		//File inputFile = new File(args[0]);
		//File in = new File(args[0]);
		System.out.println(args[0]);
		System.out.println(args[1]);
		File in=null;
		File out=null;
		if(0 < args.length)
		{
		in = new File(args[0]);
		out = new File(args[1]);
		}
		
		else
		{
			System.err.println("Invalid arguments count:" + args.length);
			  
		}
		
		XLSBReader r = new XLSBReader();
		
		r.read(in, out);
		
		
	}
}

