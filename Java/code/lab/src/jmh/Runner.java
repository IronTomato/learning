package jmh;

import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.*;

public class Runner {

   public static void main(String[] args) throws RunnerException{
       Options opt = new OptionsBuilder()
               .include(RangeBenchmark.class.getSimpleName())
               .forks(1)
               .build();
       new org.openjdk.jmh.runner.Runner(opt).run();
   }
}
