package it.acsoftware.hyperiot.hproject.algorithm.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;

import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithm;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for HProjectAlgorithm Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface HProjectAlgorithmRepository extends HyperIoTBaseRepository<HProjectAlgorithm> {

    Collection<HProjectAlgorithm> findAllHProjectAlgorithmByHProjectId(long hProjectId);
	
}
