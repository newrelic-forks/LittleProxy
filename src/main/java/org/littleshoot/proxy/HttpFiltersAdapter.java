package org.littleshoot.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

import java.net.InetSocketAddress;

/**
 * Convenience base class for implementations of {@link HttpFilters}.
 */
public class HttpFiltersAdapter implements HttpFilters {
    protected final HttpRequest originalRequest;
    protected final ChannelHandlerContext ctx;

    public HttpFiltersAdapter(HttpRequest originalRequest,
            ChannelHandlerContext ctx) {
        this.originalRequest = originalRequest;
        this.ctx = ctx;
    }

    public HttpFiltersAdapter(HttpRequest originalRequest) {
        this(originalRequest, null);
    }

    @Override
    public HttpResponse clientToProxyRequest(HttpObject httpObject) {
        return null;
    }

    @Override
    public HttpResponse proxyToServerRequest(HttpObject httpObject) {
        return null;
    }

    @Override
    public void proxyToServerBytesSending(int numberOfBytes) {
    }

    @Override
    public void proxyToServerBytesSent(int numberOfBytes) {
    }

    @Override
    public void proxyToServerRequestSending() {
    }

    @Override
    public void proxyToServerRequestSent() {
    }

    @Override
    public HttpObject serverToProxyResponse(HttpObject httpObject) {
        return httpObject;
    }

    @Override
    public void serverToProxyBytesReceiving(int numberOfBytes) {
    }

    @Override
    public void serverToProxyBytesReceived(int numberOfBytes) {
    }

    @Override
    public void serverToProxyResponseReceiving() {
    }

    @Override
    public void serverToProxyResponseReceived() {
    }

    @Override
    public HttpObject proxyToClientResponse(HttpObject httpObject) {
        return httpObject;
    }

    @Override
    public void proxyToServerConnectionQueued() {
    }

    @Override
    public InetSocketAddress proxyToServerResolutionStarted(
            String resolvingServerHostAndPort) {
        return null;
    }

    @Override
    public void proxyToServerResolutionSucceeded(String serverHostAndPort,
            InetSocketAddress resolvedRemoteAddress) {
    }

    @Override
    public void proxyToServerConnectionStarted() {
    }

    @Override
    public void proxyToServerConnectionSSLHandshakeStarted() {
    }

    @Override
    public void proxyToServerConnectionFailed() {
    }

    @Override
    public void proxyToServerConnectionSucceeded() {
    }

    @Override
    public void clientToProxyExceptionCaught(String message, Throwable cause) {
    }

    @Override
    public void proxyToServerExceptionCaught(String message, Throwable cause) {
    }
}
