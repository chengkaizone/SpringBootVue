package com.smile.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomExceptionHandler {

//    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public void uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {
//
//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = resp.getWriter();
//        out.write("上传文件大小超出限制！");
//        out.flush();
//        out.close();
//    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView uploadException(MaxUploadSizeExceededException e, HttpServletResponse resp) throws IOException {

        ModelAndView view = new ModelAndView();
        view.addObject("msg", "上传文件大小超出限制~");
        view.setViewName("error");
        return view;
    }

}
