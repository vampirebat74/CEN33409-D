package deployment;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SDLCtest {
	
	
	
	
    public static List<String> readFileIntoListOfWords() {
        try {
            return Files.readAllLines(Paths.get("C:\\Users\\dawud\\Desktop\\text1.txt"))
                .stream()
                .map(l -> l.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
	
	
	
	public static void main(String[] args){
	
	
		readFileIntoListOfWords();
		
		
		System.out.println(readFileIntoListOfWords());
		
	
		//Paths.get("C:\\Users\\dawud\\Desktop\\text1.txt"
	
	
	
	
	
	
	

}}
