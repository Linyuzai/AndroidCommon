package eason.linyuzai.rxeason.event;

public class EventMessage {
    private int messageCode;
    private String messageName;
    private Object messageBody;

    public EventMessage() {
    }

    private EventMessage(int messageCode, String messageName, Object messageBody) {
        this.messageCode = messageCode;
        this.messageName = messageName;
        this.messageBody = messageBody;
    }

    public static EventMessage of(int code) {
        return new EventMessage(code, null, null);
    }

    public static EventMessage of(String name) {
        return new EventMessage(0, name, null);
    }

    public static EventMessage of(Object body) {
        return new EventMessage(0, null, body);
    }

    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public Object getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Object messageBody) {
        this.messageBody = messageBody;
    }
}
