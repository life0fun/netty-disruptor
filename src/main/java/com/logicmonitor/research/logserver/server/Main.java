package com.logicmonitor.research.logserver.server;

import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.eventbus.EventBus;
import com.logicmonitor.research.logserver.buffer.InputBuffer;
import com.logicmonitor.research.logserver.buffer.InputBufferImpl;
import com.logicmonitor.research.logserver.codecs.RawCodec;
import com.logicmonitor.research.logserver.configuration.BaseConfiguration;
import com.logicmonitor.research.logserver.configuration.Configuration;
import com.logicmonitor.research.logserver.configuration.ServerConfiguration;
import com.logicmonitor.research.logserver.inputs.Codec;
import com.logicmonitor.research.logserver.inputs.IOState;
import com.logicmonitor.research.logserver.inputs.Importer;
import com.logicmonitor.research.logserver.inputs.InputLauncher;
import com.logicmonitor.research.logserver.inputs.InputRegistry;
import com.logicmonitor.research.logserver.inputs.MessageInput;
import com.logicmonitor.research.logserver.inputs.MessageInputFactory;
import com.logicmonitor.research.logserver.server.asyncrpc.AsyncRpcManager;
import com.logicmonitor.research.logserver.server.asyncrpc.IHeartbeatListener;
import com.logicmonitor.research.logserver.server.dcft.MembershipNotifierModule;
import com.logicmonitor.research.logserver.server.eventengine.EventEngine;
import com.logicmonitor.research.logserver.server.eventengine.HeartbeatEvent;
import com.logicmonitor.research.logserver.server.eventengine.TimerEvent;
import com.logicmonitor.research.logserver.server.state.ServerStatus;
import com.logicmonitor.research.logserver.server.state.State;
import com.logicmonitor.research.logserver.transport.HttpTransport;
import com.logicmonitor.research.logserver.transport.NettyTransport;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by jsong on 7/27/15.
 */
public class Main {
    public final static int SERVER_PORT = 8989;

    public static void main(String[] args) throws Exception {
        final State state = new State();

        // init single thread executor engine. used for execute all tasks to proess events.
        final EventEngine eventEngine = EventEngine.getInstance();
        eventEngine.init();

        final AsyncRpcManager rpcMgr = new AsyncRpcManager(SERVER_PORT);
        rpcMgr.addListener(new IHeartbeatListener() {
            @Override
            public void onHeartbeat(int cliId, long memberListVer) {
                eventEngine.submitEvent(new HeartbeatEvent(state, cliId, memberListVer));
            }
        });
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(new Runnable() {
            @Override public void run() {
                eventEngine.submitEvent(new TimerEvent(state));
            }
        }, 5, 1, TimeUnit.SECONDS);

        // dead loop iteration on apply rules until goals reached.
        final MembershipNotifierModule module = new MembershipNotifierModule(state, rpcMgr);
        executor.execute(module);

        launchMessageInputServer();
//        importLaunch();
    }

    /**
     * launch netty transport to accept requests.
     */
    private static void launchMessageInputServer() throws Exception {
        MetricRegistry registry = new MetricRegistry();
        Configuration configuration = new Configuration(Maps.newHashMap());

        BaseConfiguration serverConfiguration = new ServerConfiguration();
        Set<ServerStatus.Capability> caps = Sets.newHashSet();
        caps.add(ServerStatus.Capability.LOCALMODE);
        EventBus eventBus = new EventBus();
        ServerStatus serverStatus = new ServerStatus(serverConfiguration, caps, eventBus);

        NettyTransport nettyServer = new NettyTransport();
        HttpTransport httpServer = new HttpTransport(configuration);
        RawCodec rawCodec = new RawCodec();

        InputBuffer inputBuffer = new InputBufferImpl(registry, serverConfiguration, serverStatus);

        MessageInput input = new MessageInput(registry, configuration, httpServer, rawCodec, serverStatus);
        input.setPersistId("1");
        input.launch(inputBuffer);
    }

    private static void importLaunch() throws Exception {
//        InputLauncher inputLauncher = new InputLauncher(new IOState.Factory<MessageInput>.(). );
//        InputRegistry inputRegistry = new InputRegistry();
//        MessageInputFactory msgFacotry = new MessageInputFactory();
//        Importer importer = new Importer(inputLauncher, inputRegistry, msgFacotry);
//        importer.createInputs();
    }
}
