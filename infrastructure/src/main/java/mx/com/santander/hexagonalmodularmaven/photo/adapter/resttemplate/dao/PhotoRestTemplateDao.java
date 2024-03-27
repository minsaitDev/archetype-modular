package mx.com.santander.hexagonalmodularmaven.photo.adapter.resttemplate.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.photo.adapter.entity.PhotoEntity;
import mx.com.santander.hexagonalmodularmaven.photo.adapter.mapper.PhotoDBMapper;
import mx.com.santander.hexagonalmodularmaven.photo.adapter.resttemplate.PhotoRestTemplateAdapter;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.dao.PhotoDao;

@Repository
public class PhotoRestTemplateDao implements PhotoDao {

	private final PhotoDBMapper photoDbMapper;
	private final PhotoRestTemplateAdapter resTemplateAdapter;

	public PhotoRestTemplateDao(PhotoDBMapper photoDbMapper, PhotoRestTemplateAdapter resTemplateAdapter) {
		this.photoDbMapper = photoDbMapper;
		this.resTemplateAdapter = resTemplateAdapter;
	}

	@Override
	public Photo getById(Long id) {
		final PhotoEntity photoEntity = resTemplateAdapter.getPhoto(id);
		return photoDbMapper.toDomain(photoEntity);
	}

	@Override
	public List<Photo> getAll() {
		List<PhotoEntity> photos = resTemplateAdapter.getPhotos();
		return photos.stream().map(photoDbMapper::toDomain).collect(Collectors.toList());
	}

}
