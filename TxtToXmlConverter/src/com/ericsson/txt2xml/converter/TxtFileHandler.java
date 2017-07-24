package com.ericsson.txt2xml.converter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.ericsson.txt2xml.util.CellData;
import com.ericsson.txt2xml.util.RNCData;

public class TxtFileHandler
{
  private BufferedReader br;
  private ArrayList<RNCData> rncList;
  
  public TxtFileHandler(String filepath)
    throws FileNotFoundException
  {
    this.br = new BufferedReader(new FileReader(filepath));
    this.rncList = new ArrayList<RNCData>();
  }
  
  public final ArrayList<RNCData> getRncList()
  {
    return this.rncList;
  }
  
  public void startHandling()
  {
    try
    {
      String header = this.br.readLine();
      String newLine = null;
      if ((header != null) && (headerChecker(header, ""))) {
        do
        {
          if ((newLine != null) && (newLine != "") && (newLine != " ")) {
            handleNewLine(newLine);
          }
          if ((newLine = this.br.readLine()) == null) {
            break;
          }
        } while (formatChecker(newLine));
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  private boolean headerChecker(String header, String template)
  {
    return true;
  }
  
  private boolean formatChecker(String newLine)
  {
    return true;
  }
  
  private String addPrefix(String orig, int bits)
  {
    StringBuffer result = new StringBuffer(orig);
    while (result.length() < bits) {
      result.insert(0, '0');
    }
    return result.toString();
  }
  
  private String formatChangeLat(String orig)
  {
    String degrees = null;
    String minutes = null;
    String seconds = null;
    Double rest = Double.valueOf(Double.parseDouble(orig));
    degrees = addPrefix(
      Integer.toString((int)Math.floor(rest.doubleValue())), 2);
    rest = Double.valueOf(rest.doubleValue() % 1.0D * 60.0D);
    minutes = addPrefix(
      Integer.toString((int)Math.floor(rest.doubleValue())), 2);
    rest = Double.valueOf(rest.doubleValue() % 1.0D * 60.0D * 10.0D);
    seconds = addPrefix(
      Integer.toString((int)Math.rint(rest.doubleValue())), 3);
    return degrees + minutes + "." + seconds;
  }
  
  private String formatChangeLong(String orig)
  {
    String degrees = null;
    String minutes = null;
    String seconds = null;
    Double rest = Double.valueOf(Double.parseDouble(orig));
    degrees = addPrefix(
      Integer.toString((int)Math.floor(rest.doubleValue())), 3);
    rest = Double.valueOf(rest.doubleValue() % 1.0D * 60.0D);
    minutes = addPrefix(
      Integer.toString((int)Math.floor(rest.doubleValue())), 2);
    rest = Double.valueOf(rest.doubleValue() % 1.0D * 60.0D * 10.0D);
    seconds = addPrefix(
      Integer.toString((int)Math.rint(rest.doubleValue())), 3);
    return degrees + minutes + "." + seconds;
  }
  
  private void handleNewLine(String newLine)
  {
    try
    {
      StringTokenizer st = new StringTokenizer(newLine, "\t");
      
      boolean isNewRNC = true;
      
      RNCData newRNC = new RNCData();
      newRNC.setMcc(st.nextToken());
      newRNC.setMnc(st.nextToken());
      newRNC.setMncLength(st.nextToken());
      newRNC.setRncID(st.nextToken());
      
      CellData newCell = new CellData();
      st.nextToken();
      newCell.setSac(st.nextToken());
      newCell.setPrimarySchPower(st.nextToken());
      newCell.setPrimaryCpichPower(st.nextToken());
      newCell.setcId(st.nextToken());
      newCell.setUarfcnUI(st.nextToken());
      newCell.setUarfcnDI(st.nextToken());
      newCell.setPrimaryScramblingCode(st.nextToken());
      newCell.setLac(st.nextToken());
      st.nextToken();
      newCell.setVsDataType(st.nextToken());
      newCell.setLatitude(formatChangeLat(st.nextToken()));
      newCell.setLatHemisphere(st.nextToken());
      newCell.setLongitude(formatChangeLong(st.nextToken()));
      newCell.setLongHemisphere(st.nextToken());
      newCell.setBeamDirection(bMConvert(st.nextToken()));
      newCell.setqRxLevMin(st.nextToken());
      
      Iterator<RNCData> iterator = this.rncList.iterator();
      while (iterator.hasNext())
      {
        RNCData tempRNC = iterator.next();
        if (tempRNC.equals(newRNC))
        {
          isNewRNC = false;
          tempRNC.getCellList().add(newCell);
          break;
        }
      }
      if (isNewRNC)
      {
        newRNC.getCellList().add(newCell);
        this.rncList.add(newRNC);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private String bMConvert(String SzBeam)
  {
    if (SzBeam.length() == 1) {
      return "00" + SzBeam;
    }
    if (SzBeam.length() == 2) {
      return "0" + SzBeam;
    }
    return SzBeam;
  }
}
