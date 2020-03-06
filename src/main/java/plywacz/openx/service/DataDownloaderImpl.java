package plywacz.openx.service;
/*
Author: BeGieU
Date: 05.03.2020
*/

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import plywacz.openx.model.Post;
import plywacz.openx.model.User;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class DataDownloaderImpl implements DataDownloader {
    private final ObjectMapper mapper;
    private URL userDataUrl;
    private URL postDataUrl;

    public DataDownloaderImpl() {
        mapper = new ObjectMapper();

        try {
            userDataUrl = new URL(USER_SOURCE);
            postDataUrl = new URL(POST_SOURCE);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("MalformedURLException occured, shutting down application");
            System.exit(1);
        }
    }

    @Override
    public Set<User> fetchUserData() {
        Set<User> userSet = null;
        try {
            userSet = mapper.readValue(userDataUrl, new TypeReference<Set<User>>() {});
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't fetch user data from remote service, shutting down application");
        }
        return userSet;
    }

    @Override
    public Set<Post> fetchPostData() {
        Set<Post> postSet = null;
        try {
            postSet = mapper.readValue(postDataUrl, new TypeReference<Set<Post>>() {});
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't fetch post data from remote service, shutting down application");
        }
        return postSet;
    }

}
