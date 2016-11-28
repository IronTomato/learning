package com.wnb.common.util.validator.impl;

import com.wnb.common.util.validator.FileValidator;

import java.io.File;

public class DefaultFileValidator<F extends File> extends DefaultComparableValidator<File>
        implements FileValidator<F> {
    public DefaultFileValidator(File file) {
        super(file);
    }

    @Override
    public boolean exists() {
        return notNull() && value.exists();
    }

    @Override
    public boolean absolute() {
        return notNull() && value.isAbsolute();
    }

    @Override
    public boolean aFile() {
        return notNull() && value.isFile();
    }

    @Override
    public boolean aDirecroty() {
        return notNull() && value.isDirectory();
    }

    @Override
    public boolean canExecute() {
        return notNull() && value.canExecute();
    }

    @Override
    public boolean canRead() {
        return notNull() && value.canRead();
    }

    @Override
    public boolean canWrite() {
        return notNull() && value.canWrite();
    }

    @Override
    public boolean hidden() {
        return notNull() && value.isHidden();
    }
}
