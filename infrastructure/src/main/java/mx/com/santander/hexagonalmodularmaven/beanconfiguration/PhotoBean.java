package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import mx.com.santander.hexagonalmodularmaven.photo.port.dao.PhotoDao;
import mx.com.santander.hexagonalmodularmaven.photo.service.PhotoAllService;

@Configuration
public class PhotoBean {
	
	@Value("${photo-base-url}")
	String photoBaseUrl;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.rootUri(photoBaseUrl).build();
	}
	
	@Bean
	public PhotoAllService photoAllService(PhotoDao photoDao) {
		return new PhotoAllService(photoDao);
	}

}
