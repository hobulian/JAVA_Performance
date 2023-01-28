package com.CollectionAndMap.Map;

import com.CollectionAndMap.Set.RandomKeyUtil;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MapGet {
    int LOOP_COUNT = 1000;
    Map<Integer, String> hashMap;
    Map<Integer, String> hashTable;
    Map<Integer, String> treeMap;
    Map<Integer, String> linkedHashMap;
    int[] keys;

    @Setup(Level.Trial)
    public void setUp() {
        if (keys == null || keys.length != LOOP_COUNT) {
            hashMap = new HashMap<>();
            hashTable = new Hashtable<>();
            treeMap = new TreeMap<>();
            linkedHashMap = new LinkedHashMap<>();
            String data = "abcdefghijklmnopqrstuvwxyz";
            for (int loop = 0; loop < LOOP_COUNT; loop++) {
                String tempData = data+loop;
                hashMap.put(loop, tempData);
                hashTable.put(loop, tempData);
                treeMap.put(loop, tempData);
                linkedHashMap.put(loop, tempData);
            }
            keys = RandomKeyUtil.generateRandomNumberKeysSwap(LOOP_COUNT);
        }
    }

    @Benchmark
    public void getSeqHashMap() {
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            hashMap.get(loop);
        }
    }

    @Benchmark
    public void getRandomHashMap() {
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            hashMap.get(keys[loop]);
        }
    }

    @Benchmark
    public void getSeqHashtable() {
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            hashTable.get(loop);
        }
    }

    @Benchmark
    public void getRandomHashtable() {
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            hashTable.get(keys[loop]);
        }
    }

    @Benchmark
    public void getSeqTreeMap() {
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            treeMap.get(loop);
        }
    }

    @Benchmark
    public void getRandomTreeMap() {
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            treeMap.get(keys[loop]);
        }
    }

    @Benchmark
    public void getSeqLinkedHashMap() {
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            linkedHashMap.get(loop);
        }
    }

    @Benchmark
    public void getRandomLinkedHashMap() {
        for (int loop = 0; loop < LOOP_COUNT; loop++) {
            linkedHashMap.get(keys[loop]);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MapGet.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
