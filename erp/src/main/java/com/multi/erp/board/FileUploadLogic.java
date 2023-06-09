package com.multi.erp.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.multi.erp.member.MemberDTO;

@Service
public class FileUploadLogic {
	// 파일 업로드를 하고 업로드 정보를 DeptFileDTO로 변환해서 리턴하는 메소드
	public List<BoardFileDTO> uploadFiles(List<MultipartFile> multipartFiles, String path)
			throws IllegalStateException, IOException {
		List<BoardFileDTO> filedtolist = new ArrayList<BoardFileDTO>();
		int count = 1;
		for (MultipartFile multipartFile : multipartFiles) {
			// 클라이언트가 업로드한 파일명
			if (!multipartFile.isEmpty()) {
				String originalFilename = multipartFile.getOriginalFilename();
				// 서버에서 식별할 수 있도록 파일명을 변경
				String storeFilename = createStoreFilename(originalFilename);
				// File객체를 실제 경로에 저장
				multipartFile.transferTo(new File(path + File.separator + storeFilename));
				filedtolist.add(new BoardFileDTO(null, originalFilename, storeFilename, count + ""));
				count++;
			}

		}

		return filedtolist;

	}

	public MemberDTO uploadFile(MultipartFile multipartFile, String path, MemberDTO member) throws IllegalStateException, IOException {

		String originalFilename = multipartFile.getOriginalFilename();
		// 서버에서 식별할 수 있도록 파일명을 변경
		String storeFilename = createStoreFilename(originalFilename);
		// File객체를 실제 경로에 저장
		multipartFile.transferTo(new File(path + File.separator + storeFilename));
		
		member.setProfile_photo(storeFilename);
		
		return member;

	}

	// 파일명을 변경하는 메소드
	private String createStoreFilename(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		String ext = originalFilename.substring(pos + 1);
		String uuid = UUID.randomUUID().toString();
		return uuid + "." + ext;
	}
}
