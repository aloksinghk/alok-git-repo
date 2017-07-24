package com.ericsson.txt2xml.util;

import java.util.ArrayList;

public class RNCData
{
  private String mcc;
  private String mnc;
  private String mncLength;
  private String rncID;
  private ArrayList cellList;
  
  public RNCData()
  {
    this(null, null, null, null);
  }
  
  public RNCData(String mcc, String mnc, String mncLength, String rncID)
  {
    this.mcc = mcc;
    this.mnc = mnc;
    this.mncLength = mncLength;
    this.rncID = rncID;
    this.cellList = new ArrayList();
  }
  
  public final ArrayList getCellList()
  {
    return this.cellList;
  }
  
  public final void setCellList(ArrayList cellList)
  {
    this.cellList = cellList;
  }
  
  public final String getMcc()
  {
    return this.mcc;
  }
  
  public final void setMcc(String mcc)
  {
    this.mcc = mcc;
  }
  
  public final String getMnc()
  {
    return this.mnc;
  }
  
  public final void setMnc(String mnc)
  {
    this.mnc = mnc;
  }
  
  public final String getMncLength()
  {
    return this.mncLength;
  }
  
  public final void setMncLength(String mncLength)
  {
    this.mncLength = mncLength;
  }
  
  public final String getRncID()
  {
    return this.rncID;
  }
  
  public final void setRncID(String rncID)
  {
    this.rncID = rncID;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + (this.mcc != null ? this.mcc.hashCode() : 0);
    result = 31 * result + (this.mnc != null ? this.mnc.hashCode() : 0);
    result = 31 * result + (this.mncLength != null ? this.mncLength.hashCode() : 0);
    result = 31 * result + (this.rncID != null ? this.rncID.hashCode() : 0);
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (obj == null) {
      return false;
    }
    if ((obj instanceof RNCData))
    {
      RNCData other = (RNCData)obj;
      return (other.getMcc().equals(this.mcc)) && (other.getMnc().equals(this.mnc)) && (other.getMncLength().equals(this.mncLength)) && (other.getRncID().equals(this.rncID));
    }
    return false;
  }
}
