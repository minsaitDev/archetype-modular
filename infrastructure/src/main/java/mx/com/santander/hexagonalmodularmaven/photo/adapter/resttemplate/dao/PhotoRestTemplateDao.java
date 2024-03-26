package mx.com.santander.hexagonalmodularmaven.photo.adapter.resttemplate.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.com.santander.hexagonalmodularmaven.photo.adapter.entity.PhotoEntity;
import mx.com.santander.hexagonalmodularmaven.photo.adapter.mapper.PhotoDBMapper;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.dao.PhotoDao;

@Service
public class PhotoRestTemplateDao implements PhotoDao {

	private final PhotoDBMapper photoDbMapper;
	private final RestTemplate restTemplate;

	public PhotoRestTemplateDao(PhotoDBMapper photoDbMapper, RestTemplate restTemplate) {
		this.photoDbMapper = photoDbMapper;
		this.restTemplate = restTemplate;
	}

	@Override
	public Photo getById(Long id) {
		final PhotoEntity photoEntity = restTemplate.getForObject("/photos/{id}", PhotoEntity.class, id);
		return photoDbMapper.toDomain(photoEntity);
	}

	@Override
	public List<Photo> getAll() {
		ResponseEntity<List<PhotoEntity>> responseEntity = restTemplate.exchange("/photos", HttpMethod.GET, null, new ParameterizedTypeReference<List<PhotoEntity>>() {});
		List<PhotoEntity> photos = responseEntity.getBody();
		return photos.stream().map(photoDbMapper::toDomain).collect(Collectors.toList());
	}

}
