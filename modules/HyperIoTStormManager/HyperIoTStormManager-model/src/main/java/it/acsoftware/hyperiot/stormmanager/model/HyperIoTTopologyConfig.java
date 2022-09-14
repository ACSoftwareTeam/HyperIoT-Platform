package it.acsoftware.hyperiot.stormmanager.model;

import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.model.HProject;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @Author Aristide Cittadino
 * This class is used to collect all info related to packet and device configuration of storm topology.
 */
public class HyperIoTTopologyConfig {
    public HProject project;
    public HDevice device;
    public Collection<HPacket> packets = new LinkedList<>();
    public StringBuilder packetConfig = new StringBuilder();
    public StringBuilder properties = new StringBuilder();
}
