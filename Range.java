package wnb.demo.java8;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Range implements Iterable<Integer> {

    private Range(int start, int end, int step, boolean containsEnd) {
        this.start = start;
        this.end = end;
        this.step = step;
        this.containsEnd = containsEnd;
    }

    private final int start;
    private final int end;
    private final int step;
    private final boolean containsEnd;

    public static Builder from(int start) {
        return new Builder(start);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Itr();
    }

    public Stream<Integer> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    private class Itr implements Iterator<Integer> {

        private int current = start - step;

        @Override
        public boolean hasNext() {
            int next = current + step;
            if (next == end) {
                return containsEnd;
            } else if (end > start) {
                return next < end || (containsEnd && next == end);
            } else {
                return next > end || (containsEnd && next == end);
            }
        }

        @Override
        public Integer next() {
            if(!hasNext())
                throw new NoSuchElementException();
            current = current + step;
            return current;
        }

    }

    public static class Builder {
        private int start;
        private int end;
        private boolean endSeted = false;
        private int step;
        private boolean containsEnd;

        private Builder(int start) {
            this.start = start;
        }

        public Builder to(int end) {
            if(endSeted)
                throw new IllegalStateException("不能重复设置end");
            this.end = end;
            this.endSeted = true;
            this.containsEnd = true;
            return this;
        }

        public Builder until(int end) {
            if(endSeted)
                throw new IllegalStateException("不能重复设置end");
            this.end = end;
            this.endSeted = true;
            this.containsEnd = false;
            return this;
        }

        public Range by(int step) {
            if(!endSeted)
                throw new IllegalStateException("还未设置end");
            if ((end > start && step < 0) || (end < start && step > 0)) {
                throw new IllegalArgumentException("step 必须从 start 指向 end");
            }
            return new Range(start, end, step, containsEnd);
        }

        public Range byDefault() {
            return by(end >= start ? 1 : -1);
        }
    }
}
