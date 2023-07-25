/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.widebot_dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ahmed
 */
public class Main {
    static BinarySearchTree bst = new BinarySearchTree();

    public static void search(String word){
        Node node = bst.search(word);
        if (node == null) {
            String predecessor = bst.findPredecessor(word);
            String prePredecessor = bst.findPredecessor(predecessor);
            String successor = bst.findSuccessor(word);
            String postSuccessor = bst.findSuccessor(successor);
            System.out.println(prePredecessor + ", " + predecessor + ", " + successor + ", " + postSuccessor);
        } else {
            System.out.println(node.value);
        }
    }

    public static void insert(String word){
        bst.insert(word);
    }

    public static String removeSpecialCharactersAndNewlines(String inputString) {
        // Use a regular expression pattern to remove special characters
        Pattern pattern = Pattern.compile("[^\\w\\s]");
        Matcher matcher = pattern.matcher(inputString);
        String cleanedString = matcher.replaceAll("");

        // Remove newlines
        cleanedString = cleanedString.replace("\n", "");

        return cleanedString;
    }
        public static void main(String[] args) {

        // Implement the remove_special_characters_and_newlines method in Java if needed

        List<String> dictionary = new ArrayList<>();

        String fileName = "/home/ahmed/Downloads/dictionary.txt";      // change it 

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String cleanedWord = removeSpecialCharactersAndNewlines(line);
                dictionary.add(cleanedWord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sorting the dictionary list
        dictionary.sort(String::compareTo);

        // Balancing the BST
        bst.balanceBst(dictionary);

        // Example usage
        String word = "ahmed";
        search(word);
        //insert(word);

    }
}