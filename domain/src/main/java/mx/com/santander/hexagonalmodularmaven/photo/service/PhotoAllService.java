package mx.com.santander.hexagonalmodularmaven.photo.service;

import java.util.List;

import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.dao.PhotoDao;

public class PhotoAllService {
	private final PhotoDao photoDao;
	
	public PhotoAllService(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}
	
	public List<Photo> execute(){
		return photoDao.getAll();
	}
}
