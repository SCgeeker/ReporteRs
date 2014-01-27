package com.lysis.pptx4r.elements;

import org.pptx4j.jaxb.Context;

public class Footer {

	private static String str = 
			"<p:sp xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\" xmlns:p=\"http://schemas.openxmlformats.org/presentationml/2006/main\">"
			+ "<p:nvSpPr>"
			+ "<p:cNvPr id=\"${element_id}\" name=\"Footer ${element_id}\" />"
			+ "<p:cNvSpPr />"
			+ "<p:nvPr>"
				+ "<p:ph type=\"ftr\" sz=\"half\" idx=\"${idx}\"/>"
			+ "</p:nvPr>"
		+ "</p:nvSpPr>"
		+ "<p:spPr />"
		+ "<p:txBody>"
			+ "<a:bodyPr />"
			+ "<a:lstStyle />"
			+ "<a:p>"
				+ "<a:r>"
					+ "<a:rPr />"
					+ "<a:t>${text}</a:t>"
				+ "</a:r>"
			+ "</a:p>"
		+ "</p:txBody>"
	+ "</p:sp>";

	/**
	 * @param args
	 */
	public static Object getShape(long idx, long shape_id, String text) throws Exception{
		String value = org.apache.commons.lang.StringEscapeUtils.escapeHtml(text);
		java.util.HashMap<String, String>mappings = new java.util.HashMap<String, String>();
        mappings.put("element_id", shape_id+""  );
        mappings.put("idx", idx + ""  );
        mappings.put("text", value );
        
        Object o = org.docx4j.XmlUtils.unmarshallFromTemplate(str, mappings, Context.jcPML) ; 
        
        return o;
	}
}