package it.acsoftware.hyperiot.algorithm.service.postaction;

import it.acsoftware.hyperiot.algorithm.model.Algorithm;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPostSaveAction;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPostUpdateAction;
import it.acsoftware.hyperiot.hbase.connector.api.HBaseConnectorSystemApi;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class crates HBase table of Algorithm
 *
 * @param <T>
 */
@Component(service = {HyperIoTPostSaveAction.class, HyperIoTPostUpdateAction.class}, property = {"type=it.acsoftware.hyperiot.algorithm.model.Algorithm"})
public class AlgorithmPostSaveAction<T extends HyperIoTBaseEntity> implements HyperIoTPostSaveAction<T>, HyperIoTPostUpdateAction<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlgorithmPostSaveAction.class.getName());
    private HBaseConnectorSystemApi hBaseConnectorSystemApi;
    private List<String> columnFamilies;    // Column families of HBase table

    @Activate
    private void init() {
        columnFamilies = new ArrayList<>();
        columnFamilies.add("value");
    }

    @Override
    public void execute(T entity) {
        Runnable r = () -> {
            Algorithm algorithm = (Algorithm) entity;
            LOGGER.debug("Create HBase table of Algorithm with ID {}", algorithm.getId());
            try {
                String tableName = "algorithm_" + algorithm.getId();
                if (!hBaseConnectorSystemApi.tableExists(tableName))
                    hBaseConnectorSystemApi.createTable(tableName, columnFamilies);
                LOGGER.debug("HBase table {} has been created", tableName);
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        };
        hBaseConnectorSystemApi.executeTask(r);
    }

    @Reference
    protected void setHBaseConnectorSystemApi(HBaseConnectorSystemApi hBaseConnectorSystemApi) {
        this.hBaseConnectorSystemApi = hBaseConnectorSystemApi;
    }

}
