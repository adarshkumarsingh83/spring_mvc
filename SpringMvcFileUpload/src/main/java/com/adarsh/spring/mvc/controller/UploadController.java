package com.adarsh.spring.mvc.controller;

import com.adarsh.spring.mvc.model.UploadedFile;
import com.adarsh.spring.mvc.validator.FileValidator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @Autowired
    private FileValidator fileValidator;

    @RequestMapping("/fileUploadForm")
    public ModelAndView getUploadForm(@ModelAttribute("uploadedFile") UploadedFile uploadedFile
            , BindingResult result) {
        return new ModelAndView("uploadForm");
    }

    @RequestMapping("/fileUpload")
    public ModelAndView fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile
            , BindingResult result) {

        final MultipartFile file = uploadedFile.getFile();
        this.fileValidator.validate(uploadedFile, result);
        final String fileName = file.getOriginalFilename();

        if (result.hasErrors()) {
            return new ModelAndView("uploadForm");
        }
        try {
            File newFile = new File("d:" + File.separator + System.getProperty("user.name") + File.separator + fileName);
            if (!newFile.exists()) {
                FileUtils.forceMkdir(new File("d:" + File.separator + System.getProperty("user.name")));
                newFile.createNewFile();
            }
            FileCopyUtils.copy(file.getBytes(), newFile);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return new ModelAndView("showFile", "message", fileName);
    }
}
