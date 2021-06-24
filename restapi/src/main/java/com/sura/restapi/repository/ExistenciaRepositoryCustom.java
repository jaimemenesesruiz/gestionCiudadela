package com.sura.restapi.repository;

import java.util.List;

public interface ExistenciaRepositoryCustom<Existencia> {
	public List<Existencia>getByIdMaterial(Integer id);
}
