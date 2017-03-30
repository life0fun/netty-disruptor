package com.logicmonitor.research.logserver.server.dcft;

import com.logicmonitor.research.logserver.server.asyncrpc.AsyncRpcManager;
import com.logicmonitor.research.logserver.server.state.State;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by jsong on 7/29/15.
 */
public class MembershipNotifierModule implements Runnable {
    private final State _state;
    private final DcftMembershipTask _task;
    private final AtomicLong _txnSeq = new AtomicLong(1);
    private final AsyncRpcManager _rpcMgr;

    public MembershipNotifierModule(final State state, final AsyncRpcManager rpcMgr) {
        _state = state;
        _task = new DcftMembershipTask(state, this, rpcMgr);
        _rpcMgr = rpcMgr;
    }

    @Override
    public void run() {
        while (true) {     // dead loop to iteration to apply Rules until goals reached.
            _state.lock();
            try {
                while (_task.reachGoal()) {
                    System.out.printf("MembershipNotifierModule Sleep at %d\n", System.currentTimeMillis());
                    _state.conditionAwait();
                    System.out.printf("MembershipNotifierModule wakeup at %d\n", System.currentTimeMillis());
                }

                _task.applyRules();
            }
            catch (InterruptedException e) {
                System.out.printf("Interrupted, quit\n");
                Thread.currentThread().interrupt();
                break;
            }
            finally {
                _state.unlock();
            }
        }
    }

    public long nextTxnId() {
        return _txnSeq.incrementAndGet();
    }
}
