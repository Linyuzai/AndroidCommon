package eason.linyuzai.elib.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class EasonProxy implements InvocationHandler {

    private static final Invoker DEFAULT_INVOKER = new DefaultInvoker();

    private ProxyObject proxyObject;
    private Invoker invoker;
    private Before before;
    private After after;

    private EasonProxy() {
        invoker = DEFAULT_INVOKER;
    }

    public static EasonProxy from(Object object) {
        InvocationHandler handler = Proxy.getInvocationHandler(object);
        if (handler instanceof EasonProxy)
            return (EasonProxy) handler;
        else
            throw new RuntimeException("The InvocationHandler of object is not an EasonProxy Instance");
    }

    public static EasonProxy create() {
        return new EasonProxy();
    }

    public static EasonProxy create(Object obj) {
        return create().with(obj);
    }

    public static EasonProxy create(Object obj, Invoker invoker) {
        return create(obj).setInvoker(invoker);
    }

    public EasonProxy with(Object obj) {
        this.proxyObject = new ProxyObject(obj);
        return this;
    }

    public EasonProxy onBefore(Before before) {
        this.before = before;
        return this;
    }

    public EasonProxy onAfter(After after) {
        this.after = after;
        return this;
    }

    public EasonProxy setInvoker(Invoker invoker) {
        this.invoker = invoker;
        return this;
    }

    public <T> T proxy(Class<?>... interfaces) {
        Object obj = checkObject(proxyObject);
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces, this);
    }

    public <T> T proxy() {
        Object obj = checkObject(proxyObject);
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    private Object checkObject(ProxyObject proxyObject) {
        Object obj = proxyObject.getObject();
        return Objects.requireNonNull(obj);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (before != null)
            before.onBefore(proxyObject, proxy, method, args);
        if (invoker != null)
            result = invoker.invoke(proxyObject, proxy, method, args);
        if (after != null)
            after.onAfter(proxyObject, proxy, method, args);
        return result;
    }

    @FunctionalInterface
    public interface Before {
        void onBefore(ProxyObject object, Object proxy, Method method, Object[] args);
    }

    @FunctionalInterface
    public interface After {
        void onAfter(ProxyObject object, Object proxy, Method method, Object[] args);
    }

    @FunctionalInterface
    public interface Invoker {
        Object invoke(ProxyObject object, Object proxy, Method method, Object[] args) throws Throwable;
    }

    public static class DefaultInvoker implements Invoker {

        @Override
        public Object invoke(ProxyObject object, Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(object.getObject(), args);
        }
    }
}
