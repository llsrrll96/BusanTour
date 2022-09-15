package com.tour.app.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tour.app.domain.AttractionService;
import com.tour.app.dto.APIMessage;
import com.tour.app.service.ManageService;

@RequestMapping("/manage/api/*")
@Controller
public class ManageApiController 
{
	private ManageService manageService;
	
	public ManageApiController(ManageService manageService) {
		this.manageService = manageService;
	}

	@PostMapping("attraction")
	@ResponseBody
	public ResponseEntity<APIMessage> attraction(@RequestBody HashMap<String, Object> pageData, Model model)
	{
		List<AttractionService>attractionList= manageService.requestAttraction((String)pageData.get("pageNo"), (String)pageData.get("numOfRows"));
		APIMessage apiMessage = new APIMessage();
		apiMessage.setData(attractionList);
		return new ResponseEntity<>(apiMessage, HttpStatus.OK);
	}
}
