package it.acsoftware.hyperiot.hproject.service;

import it.acsoftware.hyperiot.area.model.Area;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionsUtil;
import it.acsoftware.hyperiot.base.action.util.HyperIoTCrudAction;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.HyperIoTOwnershipResourceService;
import it.acsoftware.hyperiot.base.api.HyperIoTUser;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTSharingEntityService;
import it.acsoftware.hyperiot.base.exception.HyperIoTEntityNotFound;
import it.acsoftware.hyperiot.base.exception.HyperIoTRuntimeException;
import it.acsoftware.hyperiot.base.exception.HyperIoTUnauthorizedException;
import it.acsoftware.hyperiot.base.security.annotations.AllowPermissions;
import it.acsoftware.hyperiot.base.security.util.HyperIoTSecurityUtil;
import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntityServiceImpl;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.actions.HyperIoTHProjectAction;
import it.acsoftware.hyperiot.hproject.algorithm.model.dto.ImportLogReport;
import it.acsoftware.hyperiot.hproject.algorithm.model.dto.ExportProjectDTO;
import it.acsoftware.hyperiot.hproject.api.HProjectApi;
import it.acsoftware.hyperiot.hproject.api.HProjectSystemApi;
import it.acsoftware.hyperiot.hproject.model.AutoRegisterChallengeRequest;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.hproject.model.HyperIoTTopicType;
import it.acsoftware.hyperiot.huser.api.HUserSystemApi;
import it.acsoftware.hyperiot.huser.model.HUser;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.persistence.NoResultException;
import javax.security.auth.x500.X500PrivateCredential;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Aristide Cittadino Implementation class of HProjectApi interface. It
 * is used to implement all additional methods in order to interact with
 * the system layer.
 */
@Component(service = HProjectApi.class, immediate = true)
public final class HProjectServiceImpl extends HyperIoTBaseEntityServiceImpl<HProject> implements HProjectApi, HyperIoTOwnershipResourceService {

    /**
     * Injecting the HProjectSystemApi
     */
    private HProjectSystemApi systemService;

    /**
     * Injecting the HUserSystemApi
     */
    private HUserSystemApi hUserSystemApi;

    /**
     * Constructor for a HProjectServiceImpl
     */
    public HProjectServiceImpl() {
        super(HProject.class);
    }

    /**
     * @return The current HProjectSystemApi
     */
    protected HProjectSystemApi getSystemService() {
        getLog().debug( "invoking getSystemService, returning: {}", this.systemService);
        return systemService;
    }

    /**
     * @param hProjectSystemService Injecting via OSGi DS current systemService
     */
    @Reference
    protected void setSystemService(HProjectSystemApi hProjectSystemService) {
        getLog().debug( "invoking setSystemService, setting: {}", systemService);
        this.systemService = hProjectSystemService;
    }

    /**
     * @return The current HUserSystemApi
     */
    protected HUserSystemApi gethUserSystemApi() {
        getLog().debug( "invoking gethUserSystemApi, returning: {}", this.hUserSystemApi);
        return hUserSystemApi;
    }

    /**
     * @param hUserSystemApi Injecting via OSGi DS current systemService
     */
    @Reference
    protected void sethUserSystemApi(HUserSystemApi hUserSystemApi) {
        getLog().debug( "invoking sethUserSystemApi, setting: {}", hUserSystemApi);
        this.hUserSystemApi = hUserSystemApi;
    }

    @Override
    @AllowPermissions(actions = HyperIoTCrudAction.Names.SAVE)
    public HProject save(HProject entity, HyperIoTContext ctx) {
        HUser loggedUser =  hUserSystemApi.find(ctx.getLoggedEntityId(),ctx);
        entity.setUser(loggedUser);
        return super.save(entity, ctx);
    }

    @Override
    @AllowPermissions(actions = HyperIoTCrudAction.Names.UPDATE)
    public HProject update(HProject entity, HyperIoTContext ctx) {
        HProject dbEntity ;
        try {
            dbEntity = this.find(entity.getId(), ctx);
        } catch (NoResultException e){
            throw new HyperIoTEntityNotFound();
        }
        if(entity.getUser() == null) {
            entity.setUser(dbEntity.getUser());
        }
        else{
            if(entity.getUser().getId() != dbEntity.getUser().getId())
               throw new HyperIoTUnauthorizedException();
        }
        return systemService.update(entity,ctx);
    }

    @Override
    @AllowPermissions(actions = HyperIoTHProjectAction.Names.AREAS_MANAGEMENT, checkById = true, idParamIndex = 1)
    public Collection<Area> getAreasList(HyperIoTContext context, long projectId) {
        return systemService.getAreasList(projectId);
    }

    @Override
    public List<String> getUserProjectTopics(HyperIoTContext context, HyperIoTTopicType type, long projectId) {
        ArrayList<String> topics = new ArrayList<>();
        try {
            HProject p = this.find(projectId, context);
            if (p != null) {
                topics.addAll(this.systemService.getUserProjectTopics(type, p.getId()));
            }
            return topics;
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<String> getUserProjectRealtimeTopics(HyperIoTContext context, HyperIoTTopicType type, long projectId) {
        ArrayList<String> topics = new ArrayList<>();
        try {
            HProject p = this.find(projectId, context);
            if (p != null) {
                topics.addAll(this.systemService.getUserRealtimeProjectTopics(type, projectId));
            }
            return topics;
        } catch (NoResultException e) {
            return Collections.emptyList();
        }
    }

    @Override
    @AllowPermissions(actions = HyperIoTHProjectAction.Names.DEVICE_LIST, checkById = true, idParamIndex = 1)
    public Collection<HPacket> getProjectTreeViewJson(HyperIoTContext context, long projectId) {
        return this.systemService.getProjectTreeViewJson(projectId);
    }

    @Override
    public boolean autoRegister(String cipherTextChallenge, long projectId, List<HPacket> packets) {
        HProject p = this.getSystemService().find(projectId, null);
        if (p != null) {
            String plainTextChallenge = p.getGeneratedChallenge();
            if (plainTextChallenge != null && cipherTextChallenge != null && p.getPubKey() != null) {
                try {
                    if (HyperIoTSecurityUtil.checkChallengeMessage(plainTextChallenge, cipherTextChallenge, p.getPubKey())) {
                        return this.getSystemService().autoRegister(p, packets);
                    } else {
                        throw new HyperIoTUnauthorizedException();
                    }
                } catch (Exception e) {
                    getLog().error( e.getMessage(), e);
                    return false;
                }
            }
            getLog().warn( "Public key is null  or plainTextChallenge or cipherTextChallenge for project {}", p.getId());
            throw new HyperIoTRuntimeException("Public key is null  or plainTextChallenge or cipherTextChallenge for project: " + p.getId());
        }
        throw new HyperIoTEntityNotFound();
    }

    @Override
    public AutoRegisterChallengeRequest createAutoRegisterChallenge(long projectId) {
        String challenge;
        try {
            challenge = this.systemService.createAutoRegisterChallenge(projectId);
        } catch (NoResultException e) {
            throw new HyperIoTEntityNotFound();
        }
        AutoRegisterChallengeRequest arcr = new AutoRegisterChallengeRequest();
        arcr.setPlainTextChallenge(challenge);
        return arcr;
    }

    @Override
    @AllowPermissions(actions = HyperIoTCrudAction.Names.FIND, checkById = true, idParamIndex = 1)
    public ExportProjectDTO loadHProjectForExport(HyperIoTContext ctx,long projectId) {
        try {
            HProject projectToExport = find(projectId, ctx);
            if (!HyperIoTSecurityUtil.checkPermissionAndOwnership(ctx, projectToExport,
                    HyperIoTActionsUtil.getHyperIoTAction(HProject.class.getName(), HyperIoTCrudAction.FIND),
                    projectToExport)) {
                throw new HyperIoTUnauthorizedException();
            }
            return systemService.loadHProjectForExport(projectToExport);
        }catch (NoResultException e ){
            throw new HyperIoTEntityNotFound();
        }
    }

    @Override
    @AllowPermissions(actions = HyperIoTCrudAction.Names.SAVE)
    public ImportLogReport importHProject(ExportProjectDTO dtoProject,HProject project, HyperIoTContext context) {
        return this.getSystemService().importHProject(dtoProject, context);
    }

    @Override
    public HProject updateHProjectOwner(HyperIoTContext ctx, long projectId, long userId) {
        HProject project ;
        HUser user ;
        try {
            project = this.find(projectId, ctx);
            user = this.hUserSystemApi.find(ctx.getLoggedEntityId(), ctx);
        } catch (NoResultException e){
            throw new HyperIoTEntityNotFound();
        }
        if (!HyperIoTSecurityUtil.checkUserOwnsResource(ctx, user, project)) {
            throw new HyperIoTUnauthorizedException();
        }
        return this.systemService.updateHProjectOwner(ctx, projectId, userId);
    }

    @Override
    @AllowPermissions(actions =HyperIoTCrudAction.Names.SAVE)
    public X500PrivateCredential createEmptyAutoRegisterProject(HProject project, HyperIoTContext ctx) {
        this.getLog().debug( "Service Saving project for auto register devices {}: {} with context: {}",
                HProject.class.getName(), project, ctx);
        return this.getSystemService().createEmptyAutoRegisterProject(project, ctx);
    }

    @Override
    public String getOwnerFieldPath() {
        return "user.id";
    }
}
