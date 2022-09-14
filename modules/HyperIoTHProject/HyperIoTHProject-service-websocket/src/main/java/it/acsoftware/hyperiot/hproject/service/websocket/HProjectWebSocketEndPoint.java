package it.acsoftware.hyperiot.hproject.service.websocket;

import it.acsoftware.hyperiot.websocket.api.HyperIoTWebSocketEndPoint;
import it.acsoftware.hyperiot.websocket.api.HyperIoTWebSocketSession;
import org.eclipse.jetty.websocket.api.Session;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true)
public class HProjectWebSocketEndPoint implements HyperIoTWebSocketEndPoint {

    /**
     * Gets the relative path name of this WebSocket endpoint
     *
     * @return The path name
     */
    public String getPath() {
        return "project";
    }

    /**
     * Get the WebSocket handler for a given session
     *
     * @param session The session instance
     * @return The WebSocket session handler
     */
    public HyperIoTWebSocketSession getHandler(Session session) {
        return new HProjectWebSocketSession(session);
    }

}
