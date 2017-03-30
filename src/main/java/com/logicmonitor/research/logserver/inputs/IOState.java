package com.logicmonitor.research.logserver.inputs;

import com.google.common.eventbus.EventBus;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import com.logicmonitor.research.logserver.helpers.Tools;
import org.joda.time.DateTime;

import java.util.Objects;

public class IOState<T extends Stoppable> {
    public interface Factory<T extends Stoppable> {
        IOState<T> create(T stoppable);
        IOState<T> create(T stoppable, Type state);
    }
    public enum Type {
        CREATED,
        INITIALIZED,
        INVALID_CONFIGURATION,
        STARTING,
        RUNNING,
        FAILED,
        STOPPING,
        STOPPED,
        TERMINATED
    }

    protected T stoppable;
    private EventBus eventbus;
    protected Type state;
    protected DateTime startedAt;
    protected String detailedMessage;

    @AssistedInject
    public IOState(EventBus eventbus, @Assisted T stoppable) {
        this(eventbus, stoppable, Type.CREATED);
    }

    @AssistedInject
    public IOState(EventBus eventbus, @Assisted T stoppable, @Assisted Type state) {
        this.eventbus = eventbus;
        this.state = state;
        this.stoppable = stoppable;
        this.startedAt = Tools.nowUTC();
    }

    /**
     * install(new FactoryModuleBuilder().build(new TypeLiteral<IOState.Factory<MessageInput>>(){}))
     */
    public class factory implements Factory<T> {
        @Override
        public IOState<T> create(T stoppable) {
            return new IOState(new EventBus(), stoppable);
        }

        @Override
        public IOState<T> create(T stoppable, Type state) {
            return new IOState(new EventBus(), stoppable, state);
        }
    }

    public T getStoppable() {
        return stoppable;
    }

    public void setStoppable(T stoppable) {
        this.stoppable = stoppable;
    }

    public Type getState() {
        return state;
    }

    public void setState(Type state) {
//        final IOStateChangedEvent<T> evt = IOStateChangedEvent.create(this.state, state, this);

        this.state = state;
        this.setDetailedMessage(null);
//        this.eventbus.post(evt);
    }

    public DateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(DateTime startedAt) {
        this.startedAt = startedAt;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

    @Override
    public String toString() {
        return "InputState{" +
            "stoppable=" + stoppable +
            ", state=" + state +
            ", startedAt=" + startedAt +
            ", detailedMessage='" + detailedMessage + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IOState that = (IOState) o;

        return Objects.equals(this.stoppable, that.stoppable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.stoppable);
    }
}
