package it.acsoftware.hyperiot.hproject.algorithm.api;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntityApi;

import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithm;
import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithmConfig;

import java.util.Collection;

/**
 *
 * @author Aristide Cittadino Interface component for HProjectAlgorithmApi. This interface
 *         defines methods for additional operations.
 *
 */
public interface HProjectAlgorithmApi extends HyperIoTBaseEntityApi<HProjectAlgorithm> {

    /**
     * It returns algorithms which have been defined for given HProject
     * @param hyperIoTContext hyperIoTContext
     * @param hProjectId ID of HProject
     * @return Collection of Algorithm
     */
    Collection<HProjectAlgorithm> findByHProjectId(HyperIoTContext hyperIoTContext, long hProjectId);


    /**
     * It updates configuration of HProjectAlgorithm with given ID
     * @param context hyperIoTContext
     * @param hProjectAlgorithmId ID of HProjectAlgorithm
     * @param config configuration to be updated
     * @return Updated HProjectAlgorithm
     */
    HProjectAlgorithm updateConfig(HyperIoTContext context, long hProjectAlgorithmId, HProjectAlgorithmConfig config);

}
