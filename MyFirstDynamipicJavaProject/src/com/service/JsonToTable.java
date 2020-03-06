package com.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonToTable {

		/**
	 * Get the JSON data formated in HTML
	 * @throws JSONException 
	 */ 
	public static String getHtmlData( String strJsonData ) throws JSONException {
	    return jsonToHtml( new JSONObject( strJsonData ) );
	}

	/**
	 * convert json Data to structured Html text
	 * 
	 * @param json
	 * @return string
	 */
	private static String jsonToHtml( Object obj ) {
	    StringBuilder html = new StringBuilder( );

	    try {
	        if (obj instanceof JSONObject) {
	            JSONObject jsonObject = (JSONObject)obj;
	            String[] keys = JSONObject.getNames( jsonObject );

	            html.append("<div class=\"json_object\">");

	            if (keys.length > 0) {
	            	
	            	System.out.println("keys"+ keys);
	            	
	            	
	                for (String key : keys) {
	                    // print the key and open a DIV
	                    html.append("<div><span class=\"json_key\">")
	                        .append(key).append("</span> : ");

	                    Object val = jsonObject.get(key);
	                    // recursive call
	                    html.append( jsonToHtml( val ) );
	                    // close the div
	                    html.append("</div>");
	                }
	            }

	            html.append("</div>");

	        } else if (obj instanceof JSONArray) {
	            JSONArray array = (JSONArray)obj;
	            for ( int i=0; i < array.length( ); i++) {
	                // recursive call
	                html.append( jsonToHtml( array.get(i) ) );                    
	            }
	        } else {
	            // print the value
	            html.append( obj );
	        }                
	    } catch (JSONException e) { return e.getLocalizedMessage( ) ; }

	    return html.toString( );
	}
	
	
	
	
	
	
	
	
	
	
	
}
