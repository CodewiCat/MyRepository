
package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(!ServletFileUpload.isMultipartContent(req)){
            System.out.println("普通表单");
            return;
        }
        System.out.println("文件表单");
        String uploadpath =this.getServletContext().getRealPath("/WEB-INF/upload");

        if(!new File(uploadpath).exists()&&!new File(uploadpath).isDirectory()){
            new File(uploadpath).mkdir();
        }

        String uploadpathtemp =this.getServletContext().getRealPath("/WEB-INF/upload/temp");
        if(!new File(uploadpathtemp).exists()&&!new File(uploadpathtemp).isDirectory()){
            new File(uploadpathtemp).mkdir();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //factory.setSizeThreshold(1024*1024);
        //factory.setRepository(new File(uploadpathtemp));
        ServletFileUpload upload = new ServletFileUpload();
        upload.setFileItemFactory(factory);

        upload.setHeaderEncoding("utf-8");

        //上传进度
        upload.setProgressListener(new ProgressListener(){
            @Override
            public void update(long l, long l1, int i) {
                //System.out.println("l:"+l+" l1:"+l1+" i:"+i);
            }
        });

        //解析请求
        try {
            List<FileItem> list = upload.parseRequest(req);
            for(FileItem fileitem:list){
                if(fileitem.isFormField()){
                    System.out.println("普通表单");
                }else{
                    String filaname = fileitem.getName();
                    System.out.println("文件表单:"+filaname);

                    File uploadfile = new File(uploadpath+"/"+filaname);
                    InputStream  in = fileitem.getInputStream();
                    byte[] bt = new byte[(int) fileitem.getSize()];
                    in.read(bt);

                    DataOutputStream dataout = new DataOutputStream(new FileOutputStream(uploadfile));
                    dataout.write(bt);


                    dataout.close();
                    in.close();


                }


            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
