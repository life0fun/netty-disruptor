package com.logicmonitor.research.logserver.configuration;

import java.net.URI;

import static com.logicmonitor.research.logserver.helpers.Tools.normalizeURI;

public class ServerConfiguration extends BaseConfiguration {
    public static final int DEFAULT_PORT = 8989;
    private String nodeIdFile = "/tmp/server/node-id";
    private URI restListenUri = URI.create("http://127.0.0.1:" + DEFAULT_PORT + "/api/");
    private URI webListenUri = URI.create("http://127.0.0.1:" + DEFAULT_PORT + "/");

    @Override
    public String getNodeIdFile() {
        return nodeIdFile;
    }

    @Override
    public URI getRestListenUri() {
        return normalizeURI(restListenUri, getRestUriScheme(), DEFAULT_PORT, "/");
    }

    @Override
    public URI getWebListenUri() {
        return normalizeURI(webListenUri, getWebUriScheme(), DEFAULT_PORT, "/");
    }
}
