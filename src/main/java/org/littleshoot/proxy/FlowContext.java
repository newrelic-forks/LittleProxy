package org.littleshoot.proxy;

import org.littleshoot.proxy.impl.ClientToProxyConnection;

import javax.net.ssl.SSLSession;
import java.lang.ref.WeakReference;
import java.net.InetSocketAddress;

/**
 * Encapsulates contextual information for flow information that's being
 * reported to a {@link ActivityTracker}.
 * <p/>
 * NOTE: <code>WeakReference<ProxyToServerConnection></code> is used to hold
 * flow information. This means that, when all strong references to this object
 * are gone, successive calls to this objects might return <code>null</code>.
 */
public class FlowContext {
    private final WeakReference<ClientToProxyConnection> clientToProxyConnection;

    public FlowContext(ClientToProxyConnection clientToProxyConnection) {
        this.clientToProxyConnection =
                new WeakReference<ClientToProxyConnection>(
                        clientToProxyConnection);
    }

    /**
     * The address of the client.
     *
     * @return
     */
    public InetSocketAddress getClientAddress() {
        ClientToProxyConnection connection = this.clientToProxyConnection.get();
        return null == connection ? null : connection.getClientAddress();
    }

    /**
     * If using SSL, this returns the {@link SSLSession} on the client
     * connection.
     *
     * @return
     */
    public SSLSession getClientSslSession() {
        ClientToProxyConnection connection = this.clientToProxyConnection.get();
        if (null != connection && null != connection.getSslEngine()) {
            return connection.getSslEngine().getSession();
        }
        return null;
    }

    /**
     * The ClientToProxyConnection associated with this comms.
     *
     * @return
     */
    public ClientToProxyConnection getClientToProxyConnection() {
        return clientToProxyConnection.get();
    }
}
