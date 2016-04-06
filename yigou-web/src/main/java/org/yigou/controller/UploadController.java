package org.yigou.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.yigou.utils.FileUtil;

@Controller
@RequestMapping(value="upload")
public class UploadController {
	@RequestMapping(value="uploadFile")  
	  
	@ResponseBody  
	  
	public String uploadFile(@RequestParam("pic")CommonsMultipartFile pic,HttpServletRequest req,HttpServletResponse response) throws IOException{  
	  
	//设置文件保存的本地路径  
	//String filePath = req.getContextPath() + "/uploadFiles/";
	
	String filePath = req.getSession().getServletContext().getRealPath("/uploadFiles/");  
	  
	String fileName = pic.getOriginalFilename();  
	  
	String fileType = fileName.split("[.]")[1];  
	  
	//为了避免文件名重复，在文件名前加UUID  
	  
	String uuid = UUID.randomUUID().toString().replace("-","");  
	  
	String uuidFileName = uuid + fileName;  
	  
	File f = new File(filePath+"/"+uuid+"."+fileType);  
	  
	//将文件保存到服务器  
	  
	FileUtil.upFile(pic.getInputStream(), uuidFileName, filePath);  
	  
	return uuidFileName;  
	  
	}  
}
