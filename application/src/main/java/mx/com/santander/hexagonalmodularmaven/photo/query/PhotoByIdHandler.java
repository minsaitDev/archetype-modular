package mx.com.santander.hexagonalmodularmaven.photo.query;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.photo.mapper.PhotoDtoMapper;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.PhotoDto;
import mx.com.santander.hexagonalmodularmaven.photo.service.PhotoByIdService;

@Component
public class PhotoByIdHandler {

	private final PhotoDtoMapper photoDtoMapper;
	private final PhotoByIdService photoByIdService;
	
	public PhotoByIdHandler(PhotoDtoMapper photoDtoMapper, PhotoByIdService photoByIdService) {
		this.photoDtoMapper = photoDtoMapper;
		this.photoByIdService = photoByIdService;
	}
	
	public PhotoDto execute(Long id) {
		return photoDtoMapper.toDto(photoByIdService.execute(id));
	}
}
