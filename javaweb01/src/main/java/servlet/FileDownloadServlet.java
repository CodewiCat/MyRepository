package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filepath = this.getServletContext().getRealPath("/download");
        String filename = "视频.mp4";
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        FileInputStream in = new FileInputStream(filepath+"\\"+filename);
        System.out.println("下载文件"+filepath+"\\"+filename);
        //缓冲区
        byte[] bt = new byte[1024];
        ServletOutputStream ot = resp.getOutputStream();
        while(in.read(bt)>0){
            ot.write(bt);
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
