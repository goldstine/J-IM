package org.jim.core.packets;

public enum ChatType {

    CHAT_TYPE_UNKNOWN(0),
    CHAT_TYPE_PUBLIC(1),
    CHAT_TYPE_PRIVATE(2),
        ;

    public final int getNumber() {
        return value;
    }

    public static ChatType valueOf(int value) {
        return forNumber(value);
    }

    public static ChatType forNumber(int value) {
        switch (value) {
            case 0: return CHAT_TYPE_UNKNOWN;
            case 1: return CHAT_TYPE_PUBLIC;
            case 2: return CHAT_TYPE_PRIVATE;
            default: return null;
        }
    }

    private final int value;

    ChatType(int value) {
        this.value = value;
    }
}
