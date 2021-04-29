package com.wrlus.hiddenapireflector.reflector.android.app;

import android.content.Context;

import java.lang.reflect.Method;

public class ContextImpl {

    public static Context createSystemContext(Object mainThread) {
        try {
            Method method = Class.forName("android.app.ContextImpl")
                    .getDeclaredMethod("createSystemContext",
                            Class.forName("android.app.ActivityThread"));
            method.setAccessible(true);
            return (Context) method.invoke(null, mainThread);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
