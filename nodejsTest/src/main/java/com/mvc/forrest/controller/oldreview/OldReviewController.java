package com.mvc.forrest.controller.oldreview;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.forrest.service.domain.OldReview;
import com.mvc.forrest.service.oldreview.OldReviewService;




@Controller
@RequestMapping("/oldReview/*")
public class OldReviewController {
	
	@Autowired
	public OldReviewService oldReviewService;
	
	@GetMapping("addOldReview")
	public String addOldReview(Model model) throws Exception {
				
		return "/oldReview/addOldReview";
	}
		
	@PostMapping("addOldReview")
	public String addOldReview(@ModelAttribute("oldReview") OldReview oldReview, Model model) throws Exception {
		
		oldReviewService.addOldReview(oldReview);
		
		return null;
	}
	
	@PostMapping("listOldReview")
	public String listOldReview(@ModelAttribute("oldReview") OldReview oldReview, Model model) throws Exception {
		
		oldReviewService.getOldReviewList(oldReview.getReviewedUserId());
		
		return null;
	}	
	
}