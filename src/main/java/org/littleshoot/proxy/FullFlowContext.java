package org.littleshoot.proxy;

import org.littleshoot.proxy.impl.ClientToProxyConnection;
import org.littleshoot.proxy.impl.ProxyToServerConnection;

import java.lang.ref.WeakReference;

/**
 * Extension of {@link FlowContext} that provides additional information (which
 * we know after actually processing the request from the client).
 * <p/>
 * NOTE: <code>WeakReference<ProxyToServerConnection></code> is used to hold
 * flow information. This means that, when all strong references to this object
 * are gone, successive calls to this objects might return <code>null</code>.
 */
public class FullFlowContext extends FlowContext {
    private final WeakReference<ProxyToServerConnection> proxyToServerConnection;

    public FullFlowContext(ClientToProxyConnection clientConnection,
                           ProxyToServerConnection proxyToServerConnection) {
        super(clientConnection);
        this.proxyToServerConnection = new WeakReference<ProxyToServerConnection>(proxyToServerConnection);
    }

    /**
     * The host and port for the server (i.e. the ultimate endpoint).
     *
     * @return
     */
    public String getServerHostAndPort() {
        ProxyToServerConnection connection = proxyToServerConnection.get();
        return null == connection ? null : connection.getServerHostAndPort();
    }

    /**
     * The chained proxy (if proxy chaining).
     *
     * @return
     */
    public ChainedProxy getChainedProxy() {
        ProxyToServerConnection connection = proxyToServerConnection.get();
        return null == connection ? null : connection.getChainedProxy();
    }

    /**
     * The ProxyToServer connection associated with this comms.
     *
     * @return
     */
    public ProxyToServerConnection getProxyToServerConnection() {
        return proxyToServerConnection.get();
    }
}
