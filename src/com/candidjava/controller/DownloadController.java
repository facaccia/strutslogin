package com.candidjava.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
public class DownloadController extends ActionSupport{	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private InputStream fileInputStream;
	
	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public String execute() throws Exception {
	    fileInputStream = new FileInputStream(new File("C:\\Users\\fabio.caccia\\Documents\\ciao.txt"));
	    return SUCCESS;
	}
	
	public String executeWord() throws Exception {
	    fileInputStream = new FileInputStream(new File("C:\\Users\\fabio.caccia\\Documents\\ciao.docx"));
	    return SUCCESS;
	}
	public String executeImage() throws Exception {
	    fileInputStream = new FileInputStream(new File("C:\\Users\\fabio.caccia\\Documents\\ciao1.png"));
	    return SUCCESS;
	}
}
