package jmh;


import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import util.Range;

public class RangeBenchmark {

    Range range = Range.from(0).until(100000).by(1);

    @Benchmark
    public void testRange() {
        range.forEach(i -> {
            double d = Math.pow(3, 15);
        }); 
    }

    public void tsetFor() {
        for (int i = 0; i < 100000; i++) {
            double d = Math.pow(3, 15);
        }
    }
    
    public static void main(String[] args) throws RunnerException{
        Options opt = new OptionsBuilder()
                .include(".*"+RangeBenchmark.class.getSimpleName()+".*")
                .forks(1)
                .build();
        new org.openjdk.jmh.runner.Runner(opt).run();
    }
}
