package com.logicmonitor.research.logserver.message;

import com.google.common.annotations.VisibleForTesting;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import static java.util.Objects.requireNonNull;


/**
 * {@link InetSocketAddress} does not support finding out whether an IP address has been reverse looked up or not.
 * However, we need to avoid triggering a name service lookup unless specifically asked to.
 * This class exists to make the reverse lookup step explicit in the code.
 */
public class ResolvableInetSocketAddress {
    private final InetSocketAddress inetSocketAddress;
    private boolean reverseLookedUp = false;

    @VisibleForTesting
    protected ResolvableInetSocketAddress(InetSocketAddress inetSocketAddress) {
        this.inetSocketAddress = requireNonNull(inetSocketAddress);
    }

    public static ResolvableInetSocketAddress wrap(InetSocketAddress socketAddress) {
        if (socketAddress == null) {
            return null;
        }
        return new ResolvableInetSocketAddress(socketAddress);
    }

    public String reverseLookup() {
        final String hostName = inetSocketAddress.getHostName();
        reverseLookedUp = true;
        return hostName;
    }

    public boolean isReverseLookedUp() {
        return reverseLookedUp;
    }

    public boolean isUnresolved() {
        return inetSocketAddress.isUnresolved();
    }

    public InetAddress getAddress() {
        return inetSocketAddress.getAddress();
    }

    public byte[] getAddressBytes() {
        return inetSocketAddress.getAddress().getAddress();
    }

    public int getPort() {
        return inetSocketAddress.getPort();
    }

    public String getHostName() {
        if (isReverseLookedUp()) {
            return inetSocketAddress.getHostName();
        }
        return null;
    }

    public InetSocketAddress getInetSocketAddress() {
        return inetSocketAddress;
    }

    @Override
    public String toString() {
        if (isReverseLookedUp()) {
            return getHostName() + ":" + getPort();
        } else {
            return getAddress().getHostAddress() + ":" + getPort();
        }
    }
}
