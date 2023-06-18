package com.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.web.domain.Board;
import com.web.domain.Reply;
import com.web.domain.User;
import com.web.service.BoardServiceImpl;
import com.web.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private BoardServiceImpl s;
	 
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String root() {
		return "index";
				
		
	}
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/loginindex", method=RequestMethod.GET)
	public String loginindex() {
		return "loginindex";
	}
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String board() {
		return "board";
	}
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "write";
	}
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view() {
		return "view";
	}
	@RequestMapping(value="/writeAction", method=RequestMethod.POST)
	public String writeAction(
			HttpServletRequest req,@RequestParam("file") MultipartFile file,
			@RequestParam("title")String title, 
			@RequestParam("contents")String contents) 
					throws IllegalStateException, IOException {
		String PATH = req.getSession().getServletContext().getRealPath("/") + "resources/";
		if (!file.getOriginalFilename().isEmpty()) {
			file.transferTo(new File(PATH + file.getOriginalFilename()));
		}
		s.addBoard(new Board(0, title, contents, file.getOriginalFilename()));
		return "board";
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	@ResponseBody
	public List<Board> boardList(){
		return s.getBoard();
	}
	@RequestMapping(value="/boardView", method=RequestMethod.GET)
	@ResponseBody
	public Board boardList(@RequestParam("idx")int idx){
		return s.getBoardOne(idx);
	}
	@RequestMapping(value="/replyList", method=RequestMethod.GET)
	@ResponseBody
	public List<Reply> replyList(@RequestParam("idx")int boardIdx){
		return s.getReply(boardIdx);
	}
	@RequestMapping(value="/writeReply", method=RequestMethod.POST)
	public String writeReply(
			@RequestParam("idx")int idx,
			@RequestParam("replyIdx")int replyIdx,
			@RequestParam("contents")String contents) {
		s.addReply(new Reply(0, idx, replyIdx, contents));
		return "redirect:view?idx=" + idx;
	}
	
    @RequestMapping(value="/deleteBoard", method=RequestMethod.GET)
    public String deleteBoard(@RequestParam("idx") int idx) {
        s.deleteBoard(idx);
        return "redirect:/";
    }
    
    @GetMapping("/mypage")
    public String showUser(HttpSession session,Model model) {
    	
    	String id = (String)session.getAttribute("userid");
    	User user = userservice.showUser(id);
    	if(id.equals("gjsl1945")) {
    		return "redirect:/cars";
    	}else {
    	
    	model.addAttribute("user", user);
        return "mypage";
    	}
    	}
    
}
 