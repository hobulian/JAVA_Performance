package com.SystemTimer;

import java.util.ArrayList;
import java.util.HashMap;

public class CompareTimer {
    public static void main(String[] args) {
        CompareTimer timer = new CompareTimer();
        for(int loop=0;loop<10;loop++) {
            timer.checkNanoTime();
            timer.checkCurrentTimeMillis();
        }
    }
    private DummyData dummy;

    private void checkCurrentTimeMillis() {
        long start = System.currentTimeMillis();
        dummy = timeMakeObjects();
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("Milli="+elapsed);
    }

    private void checkNanoTime() { // 나노 타이머가 더 정확한 프로피일링 가능.
        long start = System.nanoTime();
        dummy = timeMakeObjects();
        long end = System.nanoTime();
        double elapsed = (end - start)/1000000.0;
        System.out.println("Nano="+elapsed);
    }

    private DummyData timeMakeObjects() {
        HashMap<String, String> map = new HashMap<String, String>(1000000);
        ArrayList<String> list = new ArrayList<String>(1000000);
        return new DummyData(map, list);
    }
}
