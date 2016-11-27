package com.wnb.common.util.validator;

import static jdk.internal.dynalink.support.Guards.isNull;

public interface CharSequenceValidator<S extends CharSequence> extends GenericValidator<S> {

    boolean empty();

    boolean notEmpty();

    boolean blank();

    boolean notBlank();
}
