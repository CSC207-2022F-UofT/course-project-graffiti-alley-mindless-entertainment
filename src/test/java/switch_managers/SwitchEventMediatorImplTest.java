package switch_managers;

import org.junit.jupiter.api.Test;

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