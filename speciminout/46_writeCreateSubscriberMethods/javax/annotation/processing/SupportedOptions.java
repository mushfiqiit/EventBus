package javax.annotation.processing;

@java.lang.annotation.Target({ java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.TYPE_USE })
public @interface SupportedOptions {

    public String[] value();
}
