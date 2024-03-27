package mx.com.santander.hexagonalmodularmaven.photo.service;

import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.dao.PhotoDao;

public class PhotoByIdService {

	private final PhotoDao photoDao;
	
	public PhotoByIdService(PhotoDao photoDao) {
		this.photoDao = photoDao;
	}
	
	public Photo execute(Long id) {
		return photoDao.getById(id);
	}
}
