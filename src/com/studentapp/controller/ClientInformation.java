package com.studentapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "clientInformation", urlPatterns = { "/clientInformation" })
public class ClientInformation extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 
	    public ClientInformation() {
	        super();
	    }
	 
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	
	    	HashMap<String, String> infoList = new HashMap<String, String>();
	    	
//	        ServletOutputStream out = response.getOutputStream();
	 
	        String requestURL = request.getRequestURL().toString();
	        String requestURI = request.getRequestURI();
	        String contextPath = request.getContextPath();
	        String servletPath = request.getServletPath();
	        String queryString = request.getQueryString();
	        String param1 = request.getParameter("text1");
	        String param2 = request.getParameter("text2");
	 
	        // Server Infos
	        String serverName = request.getServerName();
	        int serverPort = request.getServerPort();
	        
	        // Client Infos
	        String remoteAddr = request.getRemoteAddr();
	        String remoteHost = request.getRemoteHost();
	        String remoteUser = request.getRemoteUser();
	 
	        // Header Infos
	        Enumeration<String> headers = request.getHeaderNames();
	        while (headers.hasMoreElements()) {
	            String header = headers.nextElement();
	            infoList.put(header + " ", request.getHeader(header));
	        }
	        
	        // add infoList to the request
	        request.setAttribute("infoList", infoList);
	 
	        // Servlet Context info:
	        ServletContext servletContext = request.getServletContext();
	 
	        // Местоположение веб приложения на жестком диске (hard disk).
	        String realPath = servletContext.getRealPath("");
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("clientinformation.jsp");
	        dispatcher.forward(request, response);

	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        this.doGet(request, response);
	    }

}