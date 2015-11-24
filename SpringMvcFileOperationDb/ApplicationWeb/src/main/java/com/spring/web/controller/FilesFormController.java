package com.spring.web.controller;

import com.spring.persistence.domain.Files;
import com.spring.persistence.repository.FilesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 1595 $, $Date:: 5/9/12 11:16 AM#$
 */
@Controller
public class FilesFormController {

    private static final Logger logger = LoggerFactory.getLogger(FilesFormController.class);

    @RequestMapping(value = "/fileOperation.do")
    protected ModelAndView fileOperationPage(HttpServletRequest request,
                                             HttpServletResponse response) throws Exception {
        logger.info("Request for fileOperationPage in FilesFormController");
        List<Files> files = this.filesService.listAll();
        return new ModelAndView("fileOperation", "files", files);
    }

    /**
     * upload
     */
    @RequestMapping(value = "/upload.do")
    public ModelAndView upload(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        logger.info("Request for upload in FilesFormController");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("uploadFile");
        if (multipartFile == null || multipartFile.getBytes().length == 0) {
            logger.error("No File is Selected for Upload");
            return new ModelAndView(new RedirectView("fileOperation.do"), "error", "EMPTY");
        }
        Files file = new Files();
        file.setFilename(multipartFile.getOriginalFilename());
        file.setNotes(ServletRequestUtils.getStringParameter(request, "notes"));
        file.setType(multipartFile.getContentType());
        file.setFile(multipartFile.getBytes());
        try {
            this.filesService.save(file);
            return new ModelAndView(new RedirectView("fileOperation.do"), "error", "SUCCESSFUL");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ModelAndView(new RedirectView("fileOperation.do"), "error", "FAILS");
        }

    }

    /**
     * download
     */
    @RequestMapping(value = "/download.do")
    public ModelAndView download(HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        logger.info("Request for download in FilesFormController");
        int id = ServletRequestUtils.getRequiredIntParameter(request, "id");
        Files file = this.filesService.find(id);
        response.setContentType(file.getType());
        response.setContentLength(file.getFile().length);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getFilename() + "\"");
        FileCopyUtils.copy(file.getFile(), response.getOutputStream());
        return null;
    }

    /**
     * delete
     */
    @RequestMapping(value = "/delete.do")
    public ModelAndView delete(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        logger.info("Request for delete in FilesFormController");
        int id = ServletRequestUtils.getRequiredIntParameter(request, "id");
        this.filesService.delete(id);
        return new ModelAndView(new RedirectView("fileOperation.do"));
    }

    @Autowired
    private FilesService filesService;

    public void setFilesService(FilesService filesService) {
        this.filesService = filesService;
    }
}
