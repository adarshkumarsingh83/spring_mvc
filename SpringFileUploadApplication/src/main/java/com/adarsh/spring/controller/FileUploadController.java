package com.adarsh.spring.controller;

import com.adarsh.spring.model.FileUpload;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class FileUploadController extends SimpleFormController {

    public FileUploadController() {
        setCommandClass(FileUpload.class);
        setCommandName("fileUploadForm");
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response
            , Object command, BindException errors) throws Exception {

        final FileUpload file = (FileUpload) command;
        final MultipartFile multipartFile = file.getFile();
        String fileName = "";
        if (multipartFile != null) {
            fileName = multipartFile.getOriginalFilename();
            //do whatever you want
            File upFile = new File("d:" + File.separator + fileName);
            upFile.createNewFile();
            FileCopyUtils.copy(file.getFile().getBytes(), upFile);
        }
        return new ModelAndView("FileUploadSuccess", "fileName", fileName);
    }
}