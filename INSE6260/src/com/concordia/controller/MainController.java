package com.concordia.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.concordia.dao.StudentDao;
import com.concordia.dao.UserDao;
import com.concordia.dao.impl.StudentDaoImpl;
import com.concordia.dao.impl.UserDaoImpl;
import com.concordia.models.Admin;
import com.concordia.models.User;


@Controller
public class MainController
{
		@Autowired
		private UserDao usedao = new UserDaoImpl();

		@RequestMapping(value={"/","/login"}, method=RequestMethod.GET)
		public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response, User loginUser)
		{
			ModelAndView model = new ModelAndView("login");
			model.addObject("loginUser", loginUser);
			return model;
		}
		
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginUser")User loginUser)
		{
				ModelAndView model= null;
				try
				{
						User user = usedao.isValidUser(loginUser.getUserId(), loginUser.getPassword());
						if(user!=null)
						{		
							request.setAttribute("loggedInUser", user.getFirstName());
							request.setAttribute("userId", user.getUserId());
							if(user instanceof Admin)								
								model = new ModelAndView("admin");
							else
								model = new ModelAndView("index");
						}
						else
						{
								model = new ModelAndView("login");
								request.setAttribute("message", "Invalid credentials");
						}

				}
				catch(Exception e)
				{
						e.printStackTrace();
				}

				return model;
		}
}
