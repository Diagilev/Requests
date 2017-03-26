package com.regcontract.Servlets;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet("/Uploader")
public class Uploader extends HttpServlet {
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 20 * 1024*1024;
    private File file;
    public void init(){
        filePath = getServletContext().getInitParameter("file-upload");
    }


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            resp.setContentType("text/html");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            ServletFileUpload.isMultipartContent(req);
            PrintWriter out = resp.getWriter();
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax( maxFileSize );

            try{
                List fileItems = upload.parseRequest(req);

                Iterator i = fileItems.iterator();
                while ( i.hasNext () )
                {
                    FileItem fi = (FileItem)i.next();
                    if ( !fi.isFormField () )
                    {
                        String fieldName = fi.getFieldName();
                        String fileFormat =  fi.getName().substring(fi.getName().indexOf('.'), fi.getName().length());
                        String newfileName = String.valueOf(System.currentTimeMillis())+fileFormat;
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();

                        if( newfileName.lastIndexOf("\\") >= 0 ){
                            file = new File( filePath + newfileName.substring( newfileName.lastIndexOf("\\")));
                        }else{
                            file = new File( filePath +
                                    newfileName.substring(newfileName.lastIndexOf("\\")+1)) ;
                        }
                        fi.write( file ) ;
                        resp.setContentType("text/html");
                        resp.getWriter().write(newfileName);
                    }
                }
            }catch(Exception ex) {
                System.out.println(ex);
            }
        }}
