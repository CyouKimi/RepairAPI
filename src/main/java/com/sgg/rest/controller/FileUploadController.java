package com.sgg.rest.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.sgg.rest.util.SystemConstants.UPLOADFILEPATH;
@RestController
@RequestMapping("/file")
public class FileUploadController {
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(UPLOADFILEPATH + file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，文件为空.";
        }
    }
	 @RequestMapping(value="/batch/upload", method=RequestMethod.POST) 
	    public String handleFileUpload(@RequestParam("files") List<MultipartFile> files){ 
	        MultipartFile file = null;
	        BufferedOutputStream stream = null;
	        for (int i =0; i< files.size(); ++i) { 
	            file = files.get(i); 
	            if (!file.isEmpty()) { 
	                try { 
	                    byte[] bytes = file.getBytes(); 
	                    stream = 
	                            new BufferedOutputStream(new FileOutputStream(new File(UPLOADFILEPATH + file.getOriginalFilename()))); 
	                    stream.write(bytes); 
	                    stream.close(); 
	                } catch (Exception e) { 
	                    stream =  null;
	                    return "You failed to upload " + i + " =>" + e.getMessage(); 
	                } 
	            } else { 
	                return "You failed to upload " + i + " becausethe file was empty."; 
	            } 
	        } 
	        return "upload successful"; 

	    } 
}
