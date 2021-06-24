package com.sura.restapi.repository;

import java.util.List;

public interface ConstruccionMaterialRepositoryCustom<ConstruccionMaterial> {
	public List<ConstruccionMaterial> getByIdConstruccion(Integer id);
}
