package machine;

public enum MachineState {
    READY {
        @Override
        public MachineState nextState() {
            return null;
        }
    },
    TRANSACTION_STARTED {
        @Override
        public MachineState nextState() {
            return MachineState.SELECT_COFFEE;
        }
    },
    SELECT_COFFEE {
        @Override
        public MachineState nextState() {
            return MachineState.READY;
        }
    },
    REFILL_INITIATED {
        @Override
        public MachineState nextState() {
            return MachineState.FILLING_WATER;
        }
    },
    FILLING_WATER {
        @Override
        public MachineState nextState() {
            return MachineState.FILLING_MILK;
        }
    },
    FILLING_MILK {
        @Override
        public MachineState nextState() {
            return MachineState.FILLING_BEANS;
        }
    },
    FILLING_BEANS {
        @Override
        public MachineState nextState() {
            return MachineState.FILLING_CUPS;
        }
    },
    FILLING_CUPS {
        @Override
        public MachineState nextState() {
            return MachineState.READY;
        }
    },
    WITHDRAWING_MONEY {
        @Override
        public MachineState nextState() {
            return MachineState.READY;
        }
    },
    REPORTING_STATUS {
        @Override
        public MachineState nextState() {
            return MachineState.READY;
        }
    },
    POWERED_DOWN {
        @Override
        public MachineState nextState() {
            return MachineState.POWERED_DOWN;
        }
    };

    public abstract MachineState nextState();
}

/* ref: State-machine using Abstract method in enum
 * https://www.baeldung.com/java-enum-simple-state-machine
 * https://www.mirkosertic.de/blog/2013/04/implementing-state-machines-with-java-enums/
 */