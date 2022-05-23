package com.tour.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tour.app.domain.TourArea;
import com.tour.app.service.TourAreaService;

//import com.example.demo4.model.FileBoard;
//import com.example.demo4.service.FileService;

@RequestMapping("/file/*")
@Controller
public class TourAreaController {
	@Autowired
	private TourAreaService tourAreaService;

	  @GetMapping("insert")
	  public String insert() {
		  return "/file/fileboardInsert";
	  }
	  
	  //file insert
	  @PostMapping("fileInsert")
	  public String insert(TourArea fboard,HttpSession session) {
		  String uploadFolder = session.getServletContext().getRealPath("/")+"\\resources\\img";
		  tourAreaService.fileInsert(fboard,uploadFolder);
		  return "redirect:list";
		  
	  }
	  //file list
	  @GetMapping("list")
	  public String list(Model model) {
		  model.addAttribute("files", tourAreaService.findAll());
		  return "/file/fileList";
	  }
}

