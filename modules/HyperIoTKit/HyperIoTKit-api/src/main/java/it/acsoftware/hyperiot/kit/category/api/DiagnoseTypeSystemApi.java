package it.acsoftware.hyperiot.kit.category.api;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;
import it.acsoftware.hyperiot.kit.category.model.DiagnoseType;
import it.acsoftware.hyperiot.kit.model.Kit;

import java.util.Collection;

public interface DiagnoseTypeSystemApi extends HyperIoTBaseEntitySystemApi<DiagnoseType> {

    DiagnoseType addKitToDiagnoseTypeCategory(HyperIoTContext ctx, long diagnoseTypeId , long kitId);

    void removeKitFromDiagnoseTypeCategory(HyperIoTContext ctx, long aleId , long buildingId);

    Collection<Kit> getKitByDiagnoseTypeCategory(HyperIoTContext ctx, long diagnoseTypeId);

    Collection<DiagnoseType> getDiagnoseTypeByKit(HyperIoTContext ctx, long kitId);
}
