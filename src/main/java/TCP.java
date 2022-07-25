import java.util.HashMap;
import java.util.Map;

public class TCP {
    private enum Event {
        APP_PASSIVE_OPEN,
        APP_ACTIVE_OPEN,
        APP_SEND,
        APP_CLOSE,
        APP_TIMEOUT,
        RCV_SYN,
        RCV_ACK,
        RCV_SYN_ACK,
        RCV_FIN,
        RCV_FIN_ACK,
        ERROR
    }

    private enum State {
        CLOSED,
        LISTEN,
        SYN_SENT,
        SYN_RCVD,
        ESTABLISHED,
        CLOSE_WAIT,
        LAST_ACK,
        FIN_WAIT_1,
        FIN_WAIT_2,
        CLOSING,
        TIME_WAIT,
        ERROR
    }


    public static String traverseStates(String[] events) {
        State state = State.CLOSED; // initial state, always

        // и создаем бооольшой словарь ))
        Map<State, HashMap<Event, State>> stateTCP = new HashMap<>();
        giveBigMap(stateTCP);
// получили массив строк бежим по нему и возращаем конечный автомат(значение) или ошибку
        for (String e : events) {

            HashMap<Event, State> foo = stateTCP.getOrDefault(state, stateTCP.get(State.ERROR));
            state = foo.getOrDefault(Event.valueOf(e), State.ERROR);
            // пришло ["APP_PASSIVE_OPEN", "APP_SEND", "RCV_SYN_ACK"]
            // next  state = LISTEN
            //["APP_SEND", "RCV_SYN_ACK"]
            // next  state = SYN_SENT
            //[ "RCV_SYN_ACK"]
            // и в конце state = ESTABLISHED
        }
        return String.valueOf(state);
    }

    public static void giveBigMap(Map<State, HashMap<Event, State>> stateTCP) {
        stateTCP.put(State.CLOSED, new HashMap<Event, State>() {{
            put(Event.APP_PASSIVE_OPEN, State.LISTEN);
            put(Event.APP_ACTIVE_OPEN, State.SYN_SENT);
        }}); // две стрелки на диаграмме
        stateTCP.put(State.LISTEN, new HashMap<Event, State>() {{
            put(Event.RCV_SYN, State.SYN_RCVD);
            put(Event.APP_SEND, State.SYN_SENT);
            put(Event.APP_CLOSE, State.CLOSED);
        }}); // три стрелки на диаграмме
        stateTCP.put(State.SYN_RCVD, new HashMap<Event, State>() {{
            put(Event.APP_CLOSE, State.FIN_WAIT_1);
            put(Event.RCV_ACK, State.ESTABLISHED);
        }}); // две стрелки на диаграмме
        stateTCP.put(State.SYN_SENT, new HashMap<Event, State>() {{
            put(Event.RCV_SYN, State.SYN_RCVD);
            put(Event.RCV_SYN_ACK, State.ESTABLISHED);
            put(Event.APP_CLOSE, State.CLOSED);
        }});// три стрелки на диаграмме
        stateTCP.put(State.ESTABLISHED, new HashMap<Event, State>() {{ // две стрелки на диаграмме
            put(Event.APP_CLOSE, State.FIN_WAIT_1);
            put(Event.RCV_FIN, State.CLOSE_WAIT);
        }});
        stateTCP.put(State.FIN_WAIT_1, new HashMap<Event, State>() {{ // 3
            put(Event.RCV_FIN, State.CLOSING);
            put(Event.RCV_FIN_ACK, State.TIME_WAIT);
            put(Event.RCV_ACK, State.FIN_WAIT_2);
        }});
// далее по одному
        stateTCP.put(State.CLOSING, new HashMap<Event, State>() {{ //1
            put(Event.RCV_ACK, State.TIME_WAIT);
        }});
        stateTCP.put(State.FIN_WAIT_2, new HashMap<Event, State>() {{
            put(Event.RCV_FIN, State.TIME_WAIT);
        }});
        stateTCP.put(State.TIME_WAIT, new HashMap<Event, State>() {{
            put(Event.APP_TIMEOUT, State.CLOSED);
        }});
        stateTCP.put(State.CLOSE_WAIT, new HashMap<Event, State>() {{
            put(Event.APP_CLOSE, State.LAST_ACK);
        }});
        stateTCP.put(State.LAST_ACK, new HashMap<Event, State>() {{
            put(Event.RCV_ACK, State.CLOSED);
        }});
        stateTCP.put(State.ERROR, new HashMap<Event, State>() {{
            put(Event.ERROR, State.ERROR);
        }});
    }

    public static void main(String[] args) {
        System.out.println(TCP.traverseStates(new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK"}));


        System.out.println(TCP.traverseStates(new String[]{"APP_ACTIVE_OPEN", "RCV_SYN_ACK", "RCV_FIN", "APP_CLOSE"}));
        System.out.println(TCP.traverseStates(new String[]{"APP_ACTIVE_OPEN"}));
        System.out.println(TCP.traverseStates(new String[]{"APP_PASSIVE_OPEN", "RCV_SYN", "RCV_ACK", "APP_CLOSE", "APP_SEND"}));
    }
}