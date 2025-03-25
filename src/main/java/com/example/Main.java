package com.example;

import StatePattern.Canvas;
import StatePattern.EraserTool;
import StatePattern.SelectionTool;
import StatePattern.stopWatch.StopWatch;

public class Main {
    public static void main(String[] args) {
        var stopWatch = new StopWatch();
        stopWatch.click();
        stopWatch.click();
        stopWatch.click();
    }
}