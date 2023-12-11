package com.mikestudio.Spring_first;



import javax.servlet.http.HttpServletRequest;

public class Utility {
    public  String getSiteURL(HttpServletRequest request){
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(),"http://localhost:3000/0/forgotPassword");
    }
}
