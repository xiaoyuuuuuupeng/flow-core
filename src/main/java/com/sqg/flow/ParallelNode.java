package com.sqg.flow;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ParallelNode extends Node{

    private List<Node> nodes;
    private int queueSize = 1000;
    private int threads = 0;
    ThreadFactory threadFactory;
    ThreadPoolExecutor pool ;

    public ParallelNode(String name) {
        super(name);
        if (threads <= 0){
            threads = Runtime.getRuntime().availableProcessors();
        }
        assert nodes.size() > 0;
        threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setDaemon(true);
                return t;
            }
        };
        pool = new ThreadPoolExecutor(this.threads, this.threads, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(this.queueSize), this.threadFactory);
        pool.prestartAllCoreThreads();
    }

    public void setNodes(List<Node> nodes){
        this.nodes = nodes;
    }
    public List<Node> getNodes(){
        return this.nodes;
    }
    public void addNode(Node node){
        this.nodes.add(node);
    }

    @Override
    public void execute(Map<String, Object> context) {
        CompletableFuture<?>[] futureList = new CompletableFuture[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                node.execute(context);
            }, pool);
            futureList[i] = completableFuture;
        }
        try {
            CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futureList);
            completableFuture.get();
        }catch (Exception e){
            System.out.println("ParallelNode execute error");
        }
    }
}
