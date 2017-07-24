package com.ericsson.txt2xml.converter;

import com.ericsson.txt2xml.util.CellData;
import com.ericsson.txt2xml.util.RNCData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class XMLParser
{
  public static final String SYMBOL1 = "<";
  public static final String SYMBOL2 = "</";
  public static final String END_SYMBOL = ">";
  public static final String END_SYMBOL_ENTER = ">\n";
  public static final String SPACE = " ";
  public static final String ENTER = "\n";
  public static final String DQUOTATION = "\"";
  public static final String HEADER = "<bulkCmConfigDataFile xmlns:gn=\"geranNrm.xsd\" xmlns:un=\"utranNrm.xsd\" xlmns=\"bulkCmSessionLogFile.xsd\" xmlns:esmpc=\"EricssonMpcSpecificAttributes.1.0.xsd\" xmlns:xn=\"genericNrm.xsd\">\n";
  public static final String END = "</bulkCmConfigDataFile>\n";
  public static final String HEADER_CONFIGDATA = "configData";
  public static final String HEADER_SUBNETWORK = "xn:SubNetwork";
  public static final String RNC_MeContext = "xn:MeContext";
  public static final String RNC_ManagedElement = "xn:ManagedElement";
  public static final String RNC_RncFunction = "un:RncFunction";
  public static final String RNC_RncFunction_MCC = "un:mcc";
  public static final String RNC_RncFunction_MNC = "un:mnc";
  public static final String RNC_RncFunction_MNCLength = "esmpc:mncLength";
  public static final String RNC_RncFunction_RNCID = "un:rncId";
  public static final String CELL_ATTRIBUTE = "id=\"";
  public static final String CELL_UTRANCELL = "un:UtranCell";
  public static final String CELL_SAC = "un:sac";
  public static final String CELL_PrimarySchPower = "un:primarySchPower";
  public static final String CELL_CID = "un:cId";
  public static final String CELL_UARFCNUL = "un:uarfcnUl";
  public static final String CELL_UARFCNDL = "un:uarfcnDl";
  public static final String CELL_PrimaryScramblingCode = "un:primaryScramblingCode";
  public static final String CELL_LAC = "un:lac";
  public static final String CELL_VsDataContainer = "xn:VsDataContainer";
  public static final String CELL_VsDataCon_vsDataType = "xn:vsDataType";
  public static final String CELL_VsDataCon_vsDataExt = "esmpc:vsDataExtendedUtranCell";
  public static final String CELL_VsDataCon_vsDataExt_Latitude = "esmpc:latitude";
  public static final String CELL_VsDataCon_vsDataExt_LatHemisphere = "esmpc:latHemisphere";
  public static final String CELL_VsDataCon_vsDataExt_Longitude = "esmpc:longitude";
  public static final String CELL_VsDataCon_vsDataExt_LongHemisphere = "esmpc:longHemisphere";
  
  public String createXML(List<?> rncList)
  {
    StringBuffer sb = new StringBuffer(
      "<bulkCmConfigDataFile xmlns:gn=\"geranNrm.xsd\" xmlns:un=\"utranNrm.xsd\" xlmns=\"bulkCmSessionLogFile.xsd\" xmlns:esmpc=\"EricssonMpcSpecificAttributes.1.0.xsd\" xmlns:xn=\"genericNrm.xsd\">\n");
    MyFormat1(sb, "configData");
    MyFormat1(sb, "xn:SubNetwork");
    MyFormat1(sb, "xn:SubNetwork");
    List<String> rncXmlList = handleRNC2(rncList);
    for (int i = 0; i < rncXmlList.size(); i++) {
      sb.append((String)rncXmlList.get(i));
    }
    MyFormat3(sb, "xn:SubNetwork");
    MyFormat3(sb, "xn:SubNetwork");
    MyFormat3(sb, "configData");
    sb.append("</bulkCmConfigDataFile>\n");
    return sb.toString();
  }
  
  private ArrayList<String> handleRNC2(List<?> rncList)
  {
    RNCData tempRNC = null;
    ArrayList<String> rncXmlList = new ArrayList<String>();
    StringBuffer sb = null;
    for (int i = 0; i < rncList.size(); i++)
    {
      tempRNC = (RNCData)rncList.get(i);
      sb = new StringBuffer();
      MyFormat1(sb, "xn:MeContext");
      MyFormat1(sb, "xn:ManagedElement");
      MyFormat1(sb, "un:RncFunction");
      MyFormat2(sb, "un:mcc", tempRNC.getMcc());
      MyFormat2(sb, "un:mnc", tempRNC.getMnc());
      MyFormat2(sb, "esmpc:mncLength", tempRNC.getMncLength());
      MyFormat2(sb, "un:rncId", tempRNC.getRncID());
      List<String> cellList = handleCell2(tempRNC.getCellList());
      for (int j = 0; j < cellList.size(); j++) {
        sb.append((String)cellList.get(j));
      }
      MyFormat3(sb, "un:RncFunction");
      MyFormat3(sb, "xn:ManagedElement");
      MyFormat3(sb, "xn:MeContext");
      rncXmlList.add(sb.toString());
    }
    return rncXmlList;
  }
  
  private ArrayList<String> handleCell2(List<?> cellList)
  {
    CellData tempCell = null;
    ArrayList<String> cellXmlList = new ArrayList<String>();
    StringBuffer sb = null;
    for (int i = 0; i < cellList.size(); i++)
    {
      tempCell = (CellData)cellList.get(i);
      sb = new StringBuffer();
      MyFormat1WithAttribute(sb, "un:UtranCell", tempCell.getcId());
      MyFormat2(sb, "un:sac", tempCell.getSac());
      MyFormat2(sb, "un:primarySchPower", tempCell.getPrimarySchPower());
      //MyFormat2(sb, "un:primaryCpichPower", tempCell.getPrimaryCpichPower());
      MyFormat2(sb, "un:cId", tempCell.getcId());
      MyFormat2(sb, "un:uarfcnUl", tempCell.getUarfcnUI());
      MyFormat2(sb, "un:uarfcnDl", tempCell.getUarfcnDI());
      MyFormat2(sb, "un:primaryScramblingCode", 
        tempCell.getPrimaryScramblingCode());
      MyFormat2(sb, "un:lac", tempCell.getLac());
      MyFormat1WithAttribute(sb, "xn:VsDataContainer", tempCell.getcId());
      MyFormat2(sb, "xn:vsDataType", tempCell.getVsDataType());
      MyFormat1(sb, "esmpc:vsDataExtendedUtranCell");
      MyFormat2(sb, "esmpc:latitude", tempCell.getLatitude());
      MyFormat2(sb, "esmpc:latHemisphere", tempCell.getLatHemisphere()
        .substring(0, 1).toUpperCase(Locale.ENGLISH));
      MyFormat2(sb, "esmpc:beamDirection", tempCell.getBeamDirection());
      MyFormat2(sb, "esmpc:qRxLevMin", tempCell.getqRxLevMin());
      MyFormat2(sb, "esmpc:longitude", tempCell.getLongitude());
      MyFormat2(sb, "esmpc:longHemisphere", tempCell.getLongHemisphere()
        .substring(0, 1).toUpperCase(Locale.ENGLISH));
      MyFormat3(sb, "esmpc:vsDataExtendedUtranCell");
      MyFormat3(sb, "xn:VsDataContainer");
      MyFormat3(sb, "un:UtranCell");
      cellXmlList.add(sb.toString());
    }
    return cellXmlList;
  }
  
  private void MyFormat1WithAttribute(StringBuffer sb, String element, String value)
  {
    sb.append("<");
    sb.append(element);
    sb.append(" ");
    sb.append("id=\"");
    sb.append(value);
    sb.append("\"");
    sb.append(">\n");
  }
  
  private void MyFormat1(StringBuffer sb, String element)
  {
    sb.append("<");
    sb.append(element);
    sb.append(">\n");
  }
  
  private void MyFormat2(StringBuffer sb, String element, String value)
  {
    sb.append("<");
    sb.append(element);
    sb.append(">");
    sb.append(value);
    sb.append("</");
    sb.append(element);
    sb.append(">\n");
  }
  
  private void MyFormat3(StringBuffer sb, String element)
  {
    sb.append("</");
    sb.append(element);
    sb.append(">\n");
  }
}
