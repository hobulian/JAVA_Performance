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
public class ListRemove {
    int LOOP_COUNT = 10;
    List<Integer> arrayList;
    List<Integer> vector;
    LinkedList<Integer> linkedList;
    int result = 0;

    @Setup(Level.Trial)
    public void setUp() {
        arrayList = new ArrayList<>();
        vector = new Vector<>();
        linkedList = new LinkedList<>();
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            arrayList.add(loop);
            vector.add(loop);
            linkedList.add(loop);
        }
    }

    @Benchmark
    public void removeArrayListFromFirst() {
        ArrayList<Integer> tempList = new ArrayList<>(arrayList);
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            tempList.remove(0);
        }
    }

    @Benchmark
    public void removeArrayListFromLast() {
        ArrayList<Integer> tempList = new ArrayList<>(arrayList);
        for (int loop = LOOP_COUNT -1 ; loop >= 0; loop--) {
            tempList.remove(loop);
        }
    }

    @Benchmark
    public void removeVectorFromFirst() {
        List<Integer> tempList = new Vector<>(vector);
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            tempList.remove(0);
        }
    }

    @Benchmark
    public void removeVectorFromLast() {
        List<Integer> tempList = new Vector<>(vector);
        for (int loop = LOOP_COUNT -1 ; loop >= 0; loop--) {
            tempList.remove(loop);
        }
    }

    @Benchmark
    public void removeLinkedListFromFirst() {
        LinkedList<Integer> tempList = new LinkedList<>(linkedList);
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            tempList.remove(0);
        }
    }

    @Benchmark
    public void removeLinkedListFromLast() {
        LinkedList<Integer> tempList = new LinkedList<>(linkedList);
        for (int loop = LOOP_COUNT -1 ; loop >= 0; loop--) {
            tempList.remove(loop);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ListRemove.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
