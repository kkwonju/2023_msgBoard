package com.kkwo.msgBoard.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kkwo.msgBoard.demo.vo.MemberRequestDto;

@Controller
@RequestMapping("/api/members")
public class UsrMemberController {
	@Autowired
	private MemberRequestDto memberRequestDto;
	
	 // 회원 가입 요청을 처리하는 핸들러 메서드
    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody MemberRequestDto memberRequestDto) {
        // memberRequestDto에는 클라이언트에서 전달한 회원 정보가 포함됩니다.
        // 회원 생성 로직을 수행하고, 성공 또는 실패에 따른 응답을 반환합니다.
        // 성공 시 HttpStatus.CREATED(201) 반환, 실패 시 HttpStatus.BAD_REQUEST(400) 등을 반환할 수 있습니다.
        
        // 예시: 실제 회원 가입 로직 호출
        boolean isSuccess = memberService.registerMember(memberRequestDto);
        
        if (isSuccess) {
            return ResponseEntity.status(HttpStatus.CREATED).body("회원 가입 성공");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원 가입 실패");
        }
    }
    
 // 회원 탈퇴 요청을 처리하는 핸들러 메서드
    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable String memberId) {
        // memberId에는 삭제하려는 회원의 고유 식별자가 들어옵니다.
        // 회원 탈퇴 로직을 수행하고, 성공 또는 실패에 따른 응답을 반환합니다.
        // 성공 시 HttpStatus.NO_CONTENT(204) 반환, 실패 시 HttpStatus.BAD_REQUEST(400) 등을 반환할 수 있습니다.
        
        // 예시: 실제 회원 탈퇴 로직 호출
        boolean isSuccess = memberService.deleteMember(memberId);
        
        if (isSuccess) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("회원 탈퇴 성공");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원 탈퇴 실패");
        }
    }
}