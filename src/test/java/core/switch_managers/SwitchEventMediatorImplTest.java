package core.switch_managers;

import org.junit.jupiter.api.Test;
import core.switch_managers.switch_events.SwitchEventMediator;
import core.switch_managers.switch_events.SwitchEventMediatorImpl;
import core.switch_managers.switch_events.SwitchEventType;

public class SwitchEventMediatorImplTest {

    @Test
    void testMessage() {
        SwitchEventMediator s = new SwitchEventMediatorImpl();
        assert(!s.ready());
        s.store(SwitchEventType.PAUSE);
        assert(s.ready());
        assert(s.retrieve() == SwitchEventType.PAUSE);
    }

}