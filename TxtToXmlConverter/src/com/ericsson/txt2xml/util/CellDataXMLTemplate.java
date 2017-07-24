package com.ericsson.txt2xml.util;

public class CellDataXMLTemplate
{
  public static final String SYMBOL1 = "<";
  public static final String SYMBOL2 = "</";
  public static final String END_SYMBOL = ">";
  public static final String SPACE = " ";
  public static final String ENTER = "\n";
  public static final String TEMPLATE_HEADER = "<bulkCmConfigDataFile xmlns:gn=\"geranNrm.xsd\" xmlns:un=\"utranNrm.xsd\" xlmns=\"bulkCmSessionLogFile.xsd\" xmlns:esmpc=\"EricssonMpcSpecificAttributes.1.0.xsd\" xmlns:xn=\"genericNrm.xsd\">\n<configData>\n<xn:SubNetwork>\n<xn:SubNetwork>\n</xn:SubNetwork>\n</xn:SubNetwork>\n</configData>\n</bulkCmConfigDataFile>\n";
  public static final String HEADER_CONFIGDATA = "configData";
  public static final String HEADER_SUBNETWORK = "xn:SubNetwork";
  public static final String RNC_TEMPLATE = "<xn:MeContext>\n<xn:ManagedElement>\n<un:RncFunction>\n<un:mcc>240</un:mcc>\n<un:mnc>44</un:mnc>\n<esmpc:mncLength>3</esmpc:mncLength>\n<un:rncId>0</un:rncId>\n</un:RncFunction>\n</xn:ManagedElement>\n</xn:MeContext>\n";
  public static final String RNC_MeContext = "xn:MeContext";
  public static final String RNC_ManagedElement = "xn:ManagedElement";
  public static final String RNC_RncFunction = "un:RncFunction";
  public static final String RNC_RncFunction_MCC = "un:mcc";
  public static final String RNC_RncFunction_MNC = "un:mnc";
  public static final String RNC_RncFunction_MNCLength = "esmpc:mncLength";
  public static final String RNC_RncFunction_RNCID = "un:rncId";
  public static final String CELL_TEMPLATE = "<un:UtranCell id=\"1\">\n<un:sac>5</un:sac>\n<un:primarySchPower>0</un:primarySchPower>\n<un:cId>0</un:cId>\n<un:uarfcnUl>0</un:uarfcnUl>\n<un:uarfcnDl>0</un:uarfcnDl>\n<un:primaryScramblingCode>0</un:primaryScramblingCode>\n<un:lac>1</un:lac>\n<xn:VsDataContainer id=\"1\">\n<xn:vsDataType>vsDataExtendedUtranCell</xn:vsDataType>\n<esmpc:vsDataExtendedUtranCell>\n<esmpc:latitude>0100.000</esmpc:latitude>\n<esmpc:latHemisphere>S</esmpc:latHemisphere>\n<esmpc:longitude>00059.599</esmpc:longitude>\n<esmpc:longHemisphere>E</esmpc:longHemisphere>\n</esmpc:vsDataExtendedUtranCell>\n</xn:VsDataContainer>\n</un:UtranCell>\n";
  public static final String CELL_ATTRIBUTE = "id";
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
}
