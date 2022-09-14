package it.acsoftware.hyperiot.kit.template.model;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTProtectedEntity;
import it.acsoftware.hyperiot.base.model.HyperIoTAbstractEntity;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Embeddable
public class HyperIoTBaseEntityTemplate extends HyperIoTAbstractEntity implements HyperIoTProtectedEntity {
}
