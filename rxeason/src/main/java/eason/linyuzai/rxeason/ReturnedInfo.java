package eason.linyuzai.rxeason;

public class ReturnedInfo<T> {

    private T returnValue;

    public ReturnedInfo(T returnValue) {
        this.returnValue = returnValue;
    }

    public T getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(T returnValue) {
        this.returnValue = returnValue;
    }
}
