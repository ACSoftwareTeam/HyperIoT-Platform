package it.acsoftware.hyperiot.dashboard.service;

import it.acsoftware.hyperiot.area.model.Area;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionsUtil;
import it.acsoftware.hyperiot.base.api.HyperIoTAction;
import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntitySystemServiceImpl;
import it.acsoftware.hyperiot.dashboard.actions.HyperIoTDashboardAction;
import it.acsoftware.hyperiot.dashboard.api.DashboardRepository;
import it.acsoftware.hyperiot.dashboard.api.DashboardSystemApi;
import it.acsoftware.hyperiot.dashboard.model.Dashboard;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.permission.api.PermissionSystemApi;
import it.acsoftware.hyperiot.role.util.HyperIoTRoleConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.List;

/**
 * @author Aristide Cittadino Implementation class of the DashboardSystemApi
 * interface. This class is used to implements all additional methods to
 * interact with the persistence layer.
 */
@Component(service = DashboardSystemApi.class, immediate = true)
public final class DashboardSystemServiceImpl extends HyperIoTBaseEntitySystemServiceImpl<Dashboard>
        implements DashboardSystemApi {

    /**
     * Injecting the DashboardRepository to interact with persistence layer
     */
    private DashboardRepository repository;

    /**
     * Injecting the PermissionSystemApi to interact with persistence layer
     */
    private PermissionSystemApi permissionSystemApi;

    /**
     * Constructor for a DashboardSystemServiceImpl
     */
    public DashboardSystemServiceImpl() {
        super(Dashboard.class);
    }

    /**
     * Return the current repository
     */
    protected DashboardRepository getRepository() {
        getLog().debug( "invoking getRepository, returning: {}" , this.repository);
        return repository;
    }

    /**
     * @param dashboardRepository The current value of DashboardRepository to
     *                            interact with persistence layer
     */
    @Reference
    protected void setRepository(DashboardRepository dashboardRepository) {
        getLog().debug( "invoking setRepository, setting: {}" , dashboardRepository);
        this.repository = dashboardRepository;
    }

    /**
     * @param permissionSystemApi Injecting via OSGi DS current PermissionSystemApi
     */
    @Reference
    public void setPermissionSystemApi(PermissionSystemApi permissionSystemApi) {
        this.permissionSystemApi = permissionSystemApi;
    }

    /**
     * On Bundle activated
     */
    @Activate
    public void onActivate() {
        this.checkRegisteredUserRoleExists();
    }

    /**
     * Register permissions for new users
     */
    private void checkRegisteredUserRoleExists() {
        String resourceName = Dashboard.class.getName();
        List<HyperIoTAction> actions = HyperIoTActionsUtil.getHyperIoTCrudActions(resourceName);
        actions.add(HyperIoTActionsUtil.getHyperIoTAction(resourceName, HyperIoTDashboardAction.FIND_WIDGETS));
        this.permissionSystemApi.checkOrCreateRoleWithPermissions(HyperIoTRoleConstants.ROLE_NAME_REGISTERED_USER, actions);
    }

    @Override
    public void createHProjectDashboard(HProject project) {
        this.repository.createHProjectDashboard(project);
    }

    @Override
    public void createAreaDashboard(Area area) {
        this.repository.createAreaDashboard(area);
    }

    @Override
    public void removeByAreaId(long areaId) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("areaId", areaId);
        repository.executeUpdateQuery("delete from Dashboard dashboard where dashboard.area.id = :areaId", params);
    }

    @Override
    public void removeByHProjectId(long hProjectId) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("hProjectId", hProjectId);
        repository.executeUpdateQuery("delete from Dashboard dashboard where dashboard.HProject.id = :hProjectId", params);
    }

}
