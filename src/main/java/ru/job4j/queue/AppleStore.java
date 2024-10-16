package ru.job4j.queue;

import java.util.LinkedList;
import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        /* копируем - чтобы не портить исходную очередь */
        Queue<Customer> result = new LinkedList<>();
        for (Customer items : this.queue) {
            result.add(items);
        }
        System.out.println(result);
        Customer customer = result.poll();
        for (int i = 0; i < this.count - 1; i++) {
            customer =  result.poll();
        }
        return customer.name();
    }

    public String getFirstUpsetCustomer() {
        Queue<Customer> result = new LinkedList<>();
        for (Customer items : this.queue) {
            result.add(items);
        }
        System.out.println(result);
        Customer customer = result.poll();
        for (int i = 0; i < this.count; i++) {
            customer =  result.poll();
        }
        return customer.name();
    }
}
