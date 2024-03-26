package mx.com.santander.hexagonalmodularmaven.photo.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.photo.mapper.PhotoDtoMapper;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.PhotoDto;
import mx.com.santander.hexagonalmodularmaven.photo.service.PhotoAllService;

@Component
public class PhotoAllHandler {

	private final PhotoAllService photoAllService;
	private final PhotoDtoMapper photoDtoMapper;

	public PhotoAllHandler(PhotoAllService photoAllService, PhotoDtoMapper photoDtoMapper) {
		this.photoAllService = photoAllService;
		this.photoDtoMapper = photoDtoMapper;
	}

	public List<PhotoDto> execute() {
		return photoAllService.execute().stream().map(photoDtoMapper::toDto).collect(Collectors.toList());
	}

}
