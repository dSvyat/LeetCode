package LeetCode.EasyLevel;

import jdk.jshell.Snippet;

import java.util.*;

/*
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing
 */
public class DesignHashSet{
        List<Integer> list = new ArrayList<>();
        public DesignHashSet() {

        }

        public void add(int key) {
                if (!list.contains(key)) list.add(key);
        }

        public void remove(int key) {
                list.remove((Integer) key);
        }

        public boolean contains(int key) {
                return list.contains(key);
        }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
