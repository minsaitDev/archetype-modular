package mx.com.santander.hexagonalmodularmaven.photo.adapter.resttemplate.repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.photo.adapter.mapper.PhotoDBMapper;
import mx.com.santander.hexagonalmodularmaven.photo.adapter.resttemplate.PhotoRestTemplateAdapter;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.repository.PhotoRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class PhotoRestemplateRepository implements PhotoRepository {

	private final PhotoRestTemplateAdapter resTemplateAdapter;
	private final PhotoDBMapper photoDbMapper;
	
	@Override
	public Photo create(Photo photo) {
		var photoToSave = photoDbMapper.toDboCreate(photo);
		var photoSaved = resTemplateAdapter.create(photoToSave);
		return photoDbMapper.toDomain(photoSaved);
	}

}
