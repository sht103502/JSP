package com.icia.board.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

// @Data를 사용할 경우 변수가 변하더라도
// 따로 Getter, Setter를 힘들게 변경하지 않고도
// 자동적으로 Getter, Setter를 변수를 사용할 수 있다.
@Data

public class BoardDTO {
	private int bnum;
	private String bwriter;
	private String bpassword;
	private String btitle;
	private String bcontents;
	private Date bdate;
	private int bhit;
	
	// 교수님이 넘겨준 파일에 MultipartFile을 
	// import할 수 있는 설정이 담겨져 있다.
	private MultipartFile bfile;
	private String bfilename;
}
