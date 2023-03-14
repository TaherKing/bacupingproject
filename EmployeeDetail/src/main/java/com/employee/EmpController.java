package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EmpController 
{

	
		@RequestMapping("/search")
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
		{
			String id = req.getParameter("Id");
			
			EmpDao dao = new EmpDao();
			try {
				EmpDto dto = dao.getEmployeeDto(Integer.parseInt(id));
				
				resp.setContentType("text/html");
				
				PrintWriter pw = resp.getWriter();
				pw.print(" iD:"+ dto.getId());
				pw.print("  name:"+ dto.getName());
				pw.print("  role:"+ dto.getRole());
				pw.print("  contact:"+ dto.getContact());
				pw.print("  email:"+ dto.getEmail());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		@RequestMapping(value="/viewallemp")
		public void employeeList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
		{
			EmpDao dao = new EmpDao();
			RequestDispatcher dispatcher = null;
			
			List<EmpDto> list = dao.getAllData();
			req.setAttribute("list", list);
			
			dispatcher = req.getRequestDispatcher("viewall.jsp");
			dispatcher.forward(req, res);	
		}
		
		
	}

