package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class onlineUserCount implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
       ServletContext sc = se.getSession().getServletContext();
       Integer count = (Integer) sc.getAttribute("onlineUserCount");
       if(count==null){
           count = new Integer(1);
       }else{
          int counttemp = count.intValue();
           count = new Integer(counttemp+1);
       }
       sc.setAttribute("onlineUserCount",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext sc = se.getSession().getServletContext();
        Integer count = (Integer) sc.getAttribute("onlineUserCount");
        System.out.println("数量:"+count);
        if(count !=null&&count>0){
            int temp = count.intValue()-1;
            count = new Integer(temp);
        }
        sc.setAttribute("onlineUserCount",count);
    }
}

