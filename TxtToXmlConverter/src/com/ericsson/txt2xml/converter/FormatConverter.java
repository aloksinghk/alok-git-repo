package com.ericsson.txt2xml.converter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FormatConverter
{
  private TxtFileHandler txtHandler;
  private XMLParser xmlParser;
  private BufferedWriter bw;
  
  public FormatConverter(String origPath, String targPath)
  {
    try
    {
      this.bw = new BufferedWriter(new FileWriter(new File(targPath)));
      this.xmlParser = new XMLParser();
      this.txtHandler = new TxtFileHandler(origPath);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void outputXMLFile()
  {
    try
    {
      this.txtHandler.startHandling();
      this.bw.write(this.xmlParser.createXML(this.txtHandler.getRncList()));
      this.bw.flush();
      this.bw.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args)
    throws Exception
  {
    String origfile = null;
    String targfile = null;
    switch (args.length)
    {
    case 0: 
      System.out.println("Insufficient arguments (0)");
      System.out.println("Usage: command txtfile");
      System.out.println("       command txtfile xmlfilename");
      System.exit(0);
      break;
    case 1: 
      origfile = args[0];
      System.out.println("origfile " + origfile);
      targfile = "WCDMA.xml";
      break;
    case 2: 
      origfile = args[0];
      targfile = args[1];
      break;
    default: 
      System.out.println("Error! arguments (> 3)");
      System.out.println("Usage: command txtfile");
      System.out.println("       command txtfile xmlfilename");
      System.exit(0);
    }
    FormatConverter converter = new FormatConverter(origfile, targfile);
    converter.outputXMLFile();
  }
}
