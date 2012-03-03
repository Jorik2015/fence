/**
 * 
 */
package com.abner.fence.renderkit;

import java.io.IOException;

import javax.faces.context.FacesContext;

import ext.data.ArrayReader;
import ext.data.DataReader;
import ext.data.JsonReader;
import ext.util.StringUtil;

/**
 * @author Administrator
 * 
 */
public class ExtDataReaderRenderer extends ExtBasicRenderer<DataReader> {
	@Override
	public void beforeEncodeBegin(FacesContext context, DataReader dataReader) throws IOException {
		if (dataReader instanceof JsonReader) {
			JsonReader jsonReader = (JsonReader) dataReader;
			if (StringUtil.isEmpty(jsonReader.getIdProperty())) {
				jsonReader.setIdProperty("id");
			}

			if (StringUtil.isEmpty(jsonReader.getRoot())) {
				jsonReader.setRoot("data");
			}
		}

		if (dataReader instanceof ArrayReader) {
			ArrayReader arrayReader = (ArrayReader) dataReader;
			if (StringUtil.isEmpty(arrayReader.getIdProperty())) {
				arrayReader.setIdProperty("id");
			}

			if (StringUtil.isEmpty(arrayReader.getRoot())) {
				arrayReader.setRoot("data");
			}
		}
	}
}
