package mx.com.santander.hexagonalmodularmaven.photo.adapter.resttemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import mx.com.santander.hexagonalmodularmaven.photo.adapter.entity.PhotoEntity;

@Repository
public class PhotoRestTemplateAdapter {

	@Value("${rest-template.photo-resource}")
	private String photoResource;
	
	private final RestTemplate restTemplate;
	
	public PhotoRestTemplateAdapter(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public PhotoEntity getPhoto(Long id) {
		return restTemplate.getForObject(photoResource+"/{id}", PhotoEntity.class, id);
	}
	
	public List<PhotoEntity> getPhotos(){
		ResponseEntity<List<PhotoEntity>> responseEntity = restTemplate.exchange(photoResource, HttpMethod.GET, null, new ParameterizedTypeReference<List<PhotoEntity>>() {});
		return responseEntity.getBody();
	}
	
	public PhotoEntity create(PhotoEntity photo) {
		ResponseEntity<PhotoEntity> responseEntity = restTemplate.postForEntity(photoResource, photo, PhotoEntity.class);
		return responseEntity.getBody();
		
	}
	
	
	
	
	
}
