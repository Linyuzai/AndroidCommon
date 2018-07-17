package eason.linyuzai.elib.proxy;

public class ProxyObject {
    private Object object;

    public ProxyObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
