package com.fox.alibaba.concurrentForkJoin;

import java.util.concurrent.RecursiveTask;

/**
* @author F1337248 ShiLeiluo
* @date 2024-05-07 16:56
* @version 1.0
*/
public class WordCountTask extends RecursiveTask<Integer> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String[] fc;
    private final int start, end;
    
    public WordCountTask(String[] fc, int start, int end) {
        this.fc = fc;
        this.start = start;
        this.end = end;
    }
    
    @Override
    protected Integer compute() {
        if (end - start <= 1) {
            // 对单行数据进行统计
            return countWords(fc[start]);
        } else {
            int mid = (start + end) / 2;
            WordCountTask mr1 = new WordCountTask(fc, start, mid);
            mr1.fork();
            WordCountTask mr2 = new WordCountTask(fc, mid, end);
            int result2 = mr2.compute();
            int result1 = mr1.join();
            // 汇总结果
            return result1 + result2;
        }
    }
    
    private int countWords(String line) {
        String[] words = line.split(" ");
        return words.length;
    }
}
