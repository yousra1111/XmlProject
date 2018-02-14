package com.xml;


import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.bo.Segment;

public class XmlWriter {
	private Document doc;
	
	public void convert(List<Segment> segments) throws XmlException{
		try{
			DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
			doc=dBuilder.newDocument();
			Element rootElement=doc.createElement("segment");
			doc.appendChild(rootElement);

			
					for(Segment it:  segments){
												Element ligne=doc.createElement("ligne");
						// son point a : <point x="100" y="200" />
						Element pointA=doc.createElement("pointA");
						pointA.setAttribute("x",String.valueOf(it.getA().getX()));
						pointA.setAttribute("y",String.valueOf(it.getA().getY()));
						//son point b :  <point x="100" y="200" />
						Element pointB=doc.createElement("pointB");
						pointB.setAttribute("x",String.valueOf(it.getB().getX()));
						pointB.setAttribute("y",String.valueOf(it.getB().getY()));
						
						ligne.appendChild(pointA);
						ligne.appendChild(pointB);
						
						rootElement.appendChild(ligne);
					}
			
	         // write the content into xml file
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result = new StreamResult(new File("C:\\Users\\DELL\\Desktop\\gi2\\xmlfile.xml"));
	         transformer.transform(source, result);
	         
	         // Output to console for testing
	         StreamResult consoleResult = new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
		}catch(Exception ex){
			throw new XmlException(ex);
		}

	}
	
}
