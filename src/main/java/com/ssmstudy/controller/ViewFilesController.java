package com.ssmstudy.controller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class ViewFilesController extends HttpServlet {

    @RequestMapping("testDownload")
    public void download(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        // download?filename=abc.pdf
        String filename = request.getParameter("filename");
        ServletContext servletContext = request.getSession().getServletContext();
//        servletContext = this.getServletContext();
        String mimeType = servletContext.getMimeType(filename);

        if (StringUtils.isEmpty(mimeType)) {
            mimeType = "application/octet-stream";
        }

//        resp.addHeader("Content-Type", mimeType);
        resp.setContentType(mimeType);

        // 文件名有中文，出现乱码问题的解决方法
        filename = URLEncoder.encode(filename, "UTF-8");

        // 告诉浏览器下载文件，而不是显示文件
        resp.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        String filePath = servletContext.getRealPath("/WEB-INF/data");
        File file = new File(filePath, filename);

        byte[] buffer = new byte[102400];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = resp.getOutputStream();
//            int i;
//            while ((i = bis.read(buffer)) != -1) {
//                os.write(buffer, 0, i);
//            }

            IOUtils.copy(fis, os);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (bis != null) {
                bis.close();
            }

            if (fis != null) {
                fis.close();
            }
        }
    }
}
