package com.svg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.bo.Segment;

public class SvgWriter {
	private StringBuilder htmlBuilder;
	
	public void convert(List<Segment> segments) throws IOException {
		htmlBuilder = new StringBuilder();
		htmlBuilder.append("<html>");
		htmlBuilder.append("<head><title>SVG format</title></head>");
		htmlBuilder.append("<body>");
		htmlBuilder.append("<svg height='"+1000+"' width='"+1000+"'>");
		for(Segment it : segments) {
			int x1=it.getA().getX();
			int y1=it.getA().getY();
			int x2=it.getB().getX();
			int y2=it.getB().getY();
		htmlBuilder.append("<line x1='"+x1+"' y1='"+y1+"' x2='"+x2+"' y2='"+y2+"' style='stroke:rgb(255,22,22); stroke-width:2 '/>");
		}
		htmlBuilder.append("</svg>");
		htmlBuilder.append("</body>");
		htmlBuilder.append("</html>");
		String html= htmlBuilder.toString();
		FileWriter f=new FileWriter(new File("C:\\Users\\DELL\\Desktop\\gi2\\svg.html"));
		f.write(html);
		f.close();
	}

}
