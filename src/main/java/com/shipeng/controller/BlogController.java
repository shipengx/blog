package com.shipeng.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.shipeng.model.*;
import com.shipeng.daoImpl.*;

import java.util.*;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BlogController extends MultiActionController {
	
	@Autowired
    private EntryDaoImpl entryDaoImpl;
    

    public void setEntryDaoImpl(EntryDaoImpl e) {
    	this.entryDaoImpl = e;
    }
       
    //handler methods go here...
    @RequestMapping(value="/")
        public ModelAndView listEntry(ModelAndView model) throws IOException {
            List<Entry> listEntry = entryDaoImpl.listEntry();
            model.addObject("listEntry", listEntry);
            model.setViewName("home");

            return model;
        }
	
    @RequestMapping(value="/newEntry", method = RequestMethod.GET) 
        public ModelAndView newEntry(ModelAndView model) {
            Entry newEntry = new Entry();
            model.addObject("entry", newEntry);
            model.setViewName("EntryForm");
            return model;
        }

    @RequestMapping(value="/saveEntry", method = RequestMethod.POST)
        public ModelAndView saveEntry(@ModelAttribute Entry entry) {
            entryDaoImpl.saveOrUpdate(entry);
            return new ModelAndView("redirect:/");
        }

    @RequestMapping(value="/deleteEntry", method = RequestMethod.GET)
        public ModelAndView deteleEntry(HttpServletRequest request) {
            int entryId = Integer.parseInt(request.getParameter("id"));
            entryDaoImpl.delete(entryId);
            return new ModelAndView("redirect:/");
        }

    @RequestMapping(value="/editEntry", method = RequestMethod.GET)
        public ModelAndView editEntry(HttpServletRequest request) {
            int entryId = Integer.parseInt(request.getParameter("id"));
            Entry entry = entryDaoImpl.getEntryById(entryId);
            ModelAndView model = new ModelAndView("EntryForm");
            model.addObject("entry", entry);
            return model;
        }
	
}//end Class BlogController
