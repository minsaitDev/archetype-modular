package mx.com.santander.hexagonalmodularmaven.photo.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.santander.hexagonalmodularmaven.photo.model.dto.PhotoDto;
import mx.com.santander.hexagonalmodularmaven.photo.query.PhotoAllHandler;

@RestController
@RequestMapping("/photos")
public class PhotoQueryController {

	private final PhotoAllHandler photoAllHandler;
	
	public PhotoQueryController(PhotoAllHandler photoAllHandler) {
		this.photoAllHandler = photoAllHandler;
	}
	
	@GetMapping
	public List<PhotoDto> getAll(){
		return photoAllHandler.execute();
	}
}
