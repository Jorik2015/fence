package com.abner;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class GeneralSqlForm5Base {
	
	private static String filePath = "K:\\整理后图片\\老婆自选\\big";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File fileDir = new File(filePath);
		File[] files = fileDir.listFiles(new FileFilter(){
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".jpg");
			}
		});
		if(files == null)
			return;
		
		
		for(File file : files){
			
			try {
				System.out.println(new FileInputStream(file).available());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			StringBuilder sb = new StringBuilder("insert into cms_galleryphoto (sectionid,createdby,modifiedby,albumid,filepath,title,filesize,nrofviews,imagewidth,imageheight,thumbwidth,thumbheight,rating,inerttimestamp,updatetimestamp) values (");
			sb.append(16);
			
		}
	}

}
