package com.zjh.administrat.fanse_demo02;

import android.support.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface InJectView {
    @IdRes int value();
}
