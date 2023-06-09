package com.multi.erp.board;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	String board_no;
	String id;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	Date write_date;
	String title;
	String content;
	String category;
	
	//클라이언트가 전송하는 바이너리파일 데이터를 스프링MVC가 내부에서 MultipartFile객체로 만들어서 관리
	//첨부파일이 여러개인 경우 list에 넣거나 배열로 관리
	List<MultipartFile> files;
	
//	public BoardDTO() {
//		
//	}
//	public BoardDTO(String board_no, String id, Date write_date, String title, String content, String category) {
//		super();
//		this.board_no = board_no;
//		this.id = id;
//		this.write_date = write_date;
//		this.title = title;
//		this.content = content;
//		this.category = category;
//	}
//	
//
//	
//	@Override
//	public String toString() {
//		return "BoardDTO [board_no=" + board_no + ", id=" + id + ", write_date=" + write_date + ", title=" + title
//				+ ", content=" + content + ", category=" + category +"]";
//	}
//	
//	
//	public String getBoard_no() {
//		return board_no;
//	}
//	public void setBoard_no(String board_no) {
//		this.board_no = board_no;
//	}
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public Date getWrite_date() {
//		return write_date;
//	}
//	public void setWrite_date(Date write_date) {
//		this.write_date = write_date;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getCategory() {
//		return category;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	
}
