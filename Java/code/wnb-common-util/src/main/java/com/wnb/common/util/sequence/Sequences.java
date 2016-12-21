package com.wnb.common.util.sequence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import static com.wnb.common.util.validator.Validators.*;

public class Sequences {

    public static <T> Iterable<T> iter(final T[] array) {
        if (is(array).empty()) {
            return new EmptyIterable<T>();
        }
        return () -> new Iterator<T>() {
            private int i = 0;
            @Override
            public boolean hasNext() {
                return i < array.length;
            }

            @Override
            public T next() {
                return array[i++];
            }
        };
    }

    public static Iterable<String> iter(final File file) {
        if (is(file).aFile() && is(file).canRead()) {
            return () -> {
                try {
                    return new Iterator<String>() {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line = null;
                        boolean consumed = true;
                        @Override
                        public boolean hasNext() {
                            if (consumed) {
                                try {
                                    line = reader.readLine();
                                } catch (IOException e) {
                                    return false;
                                }
                            }
                            return line != null;
                        }

                        @Override
                        public String next() {
                            if (hasNext()) {
                                consumed = true;
                                return line;
                            } else {
                                try {
                                    reader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return null;
                            }
                        }
                    };
                } catch (Exception e) {
                    return new EmptyIterator<>();
                }

            };
        } else {
            return new EmptyIterable<>();
        }
    }
}
