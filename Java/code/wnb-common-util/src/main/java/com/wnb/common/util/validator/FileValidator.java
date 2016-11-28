package com.wnb.common.util.validator;

import java.io.File;

public interface FileValidator<F extends File> extends ComparableValidator<File> {
    boolean exists();

    boolean absolute();

    boolean aFile();

    boolean aDirecroty();

    boolean canExecute();

    boolean canRead();

    boolean canWrite();

    boolean hidden();

}
