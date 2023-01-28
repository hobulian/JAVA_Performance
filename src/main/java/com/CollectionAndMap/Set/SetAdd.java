package com.CollectionAndMap.Set;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SetAdd {
    int LOOP_COUNT = 1000;
    Set<String> set;
    String data = "abcdefghijklmnopqrstuvwxyz";

    @Benchmark
    public void addHashSet() {
        set = new HashSet<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            set.add(data + loop);
        }
    }
    @Benchmark
    public void addHashSetWithInitialSize() {
        set = new HashSet<String>(LOOP_COUNT);
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            set.add(data + loop);
        }
    }
    @Benchmark
    public void addTreeSet() {
        set = new TreeSet<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            set.add(data + loop);
        }
    }

    @Benchmark
    public void addLinkedHashSet() {
        set = new LinkedHashSet<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            set.add(data + loop);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SetAdd.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
