package com.CollectionAndMap.List;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ListAdd {
    int LOOP_COUNT = 1000;
    List<Integer> arrayList;
    List<Integer> vector;
    List<Integer> linkedList;

    @Benchmark
    public void addArrayList() {
        arrayList = new ArrayList<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            arrayList.add(loop);
        }
    }

    @Benchmark
    public void addVector() {
        vector = new Vector<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            vector.add(loop);
        }
    }

    @Benchmark
    public void addLinkedList() {
        linkedList = new LinkedList<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            linkedList.add(loop);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ListAdd.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
