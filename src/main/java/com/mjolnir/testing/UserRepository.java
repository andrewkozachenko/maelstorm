package com.mjolnir.testing;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
    private static String fileName = "score.txt";


    public static void save(User user){
        try {
            writeToFile(user.toString());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<User> getUser(){
        List<User> users = new ArrayList<>();
        try {
            users = readFromFile().stream().map(e -> parseToUser(e)).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return users;
    }

    private static File getFile() throws IOException {
        File scoreFile = new File(fileName);
        if(!scoreFile.exists()){
            scoreFile.createNewFile();
        }
        return scoreFile;
    }

     private static void writeToFile(String message) throws IOException {
        message = message + System.lineSeparator();
         Files.write(Paths.get(fileName), message.getBytes(),StandardOpenOption.CREATE, StandardOpenOption.APPEND);
     }

     private static List<String> readFromFile() throws IOException {
         File file  = getFile();
         BufferedReader br = new BufferedReader(new FileReader(file));
         List<String> messageList = br.lines().collect(Collectors.toList());
         return messageList;
     }
     /**
      *
      * "User{name:Bob, score:98};
      *
      * */


     private static User parseToUser(String str){
        User user = new User();
        final String nameLabel = "name:";
        final String scoreLabel = "score:";
        String name = str.substring(str.indexOf(":")+1,str.indexOf(","));
        String score = str.substring(str.indexOf(scoreLabel)+scoreLabel.length(),str.indexOf("}"));
        user.setName(name);
        user.setScore(Integer.parseInt(score));
        return user;
     }

}
