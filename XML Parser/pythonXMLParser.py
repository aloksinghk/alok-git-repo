#!/usr/bin/python

import xml.sax

class XMLCdrHandler( xml.sax.ContentHandler ):
   def __init__(self):
      self.e5 = ""

   # Call when an element starts
   def startElement(self, tag):
      self.e5 = tag
      if tag == "TE0":
         print ("*****TE0*****")
         

   # Call when an elements ends
   def endElement(self, tag):
      if self.e5 == "E5":
         print ("URL:", self.E5)
		 

   # Call when a character is read
   def characters(self, content):
      if self.e5 == "E5":
         self.type = content
      self.e5	 
  
if ( __name__ == "__main__"):
   
   # create an XMLReader
   parser = xml.sax.make_parser()
   # turn off namepsaces
   parser.setFeature(xml.sax.handler.feature_namespaces, 0)

   # override the default ContextHandler
   Handler = XMLCdrHandler()
   parser.setContentHandler( Handler )
   
   parser.parse("sampleCDR1.xml")
