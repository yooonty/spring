package com.multi.mvc901;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 스프링에서 제어하는 역할로 등록!
public class MemberController {

	@Autowired // 만들어둔 싱글톤 주소 넣어줌.
	MemberDAO dao; // 전역변수(글로벌 변수)

	@RequestMapping("insert")
	public void insert(MemberVO bag) {
		System.out.println(bag);
		// dao에게 insert요청!
		dao.insert(bag);
	}

	@RequestMapping("delete")
	public void delete(String id) {
		System.out.println(id);
		dao.delete(id);
	}

	@RequestMapping("update")
	public void update(MemberVO bag) {
		System.out.println(bag);
		dao.update(bag);
	}

	@RequestMapping("one")
	public void one(String id, Model model) {
		System.out.println(id);
		MemberVO vo = dao.one(id);
		// views아래까지 전달할 데이터를 model객체를 이용해서
		// 속성으로 지정해주세요.
		model.addAttribute("vo", vo); //속성으로 지정
	}
	
	@RequestMapping("list")
	public void list(Model model) {
		List<MemberVO> list = dao.list();
		// views아래까지 전달할 데이터를 model객체를 이용해서
		// 속성으로 지정해주세요.
		model.addAttribute("list", list); //속성으로 지정
	}
}
