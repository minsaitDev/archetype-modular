package mx.com.santander.hexagonalmodularmaven.photo.port.dao;

import java.util.List;

import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;

public interface PhotoDao {
	
    Photo getById(Long id);
    List<Photo> getAll();


}
