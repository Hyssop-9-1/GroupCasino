package com.github.zipcodewilmington.casino;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {

    static final String DBNAME = "/Users/taylor/LocalProjects/GroupCasino/src/main/java/com/github/zipcodewilmington/casino/Accounts.db";
    ArrayList<CasinoAccount> accounts = new ArrayList();



    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        for(CasinoAccount ca : accounts){
            if (ca.getUsername().equals(accountName) && ca.getPassword().equals(accountPassword)){
                return ca;
            }
        }
        return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
        return new CasinoAccount(accountName, accountPassword);
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        accounts.add(casinoAccount);
    }


    public void load() throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        InputStream fileInputStream = new FileInputStream("post.json");
        //TypeReference reference = new TypeReference(new Account()){};
        //this.data.putAll(mapper.readValue(fileInputStream, HashMap.class);
        this.accounts.addAll(mapper.readValue(fileInputStream, new TypeReference<ArrayList<CasinoAccount>>(){}));
    }
    public void save() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        //Followed a guide, this is reading in HashMap object into json format
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(accounts);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Write to file
        FileOutputStream fileOutputStream = new FileOutputStream("post.json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(fileOutputStream, accounts);
        fileOutputStream.close();

    }


}
