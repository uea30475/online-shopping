package vn.pmt.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ASB_PATH = "C:\\Users\\uea30\\git\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static  String REAL_PATH = "";
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		
		//to make sure all directory  exist
		//please create the directories
		
		if(!new File(ASB_PATH).exists()) {
			
			new File(ASB_PATH).mkdirs();
			
		}
		
		if(!new File(REAL_PATH).exists()) {
			
			new File(REAL_PATH).mkdirs();
			
		}
		
		try {
			//server upload
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			//product directory upload
			file.transferTo(new File(ASB_PATH+code+".jpg"));
		}catch(IOException ex) {
			
		}
		
		
		
	}

}
