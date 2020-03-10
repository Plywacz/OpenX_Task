package plywacz.openx.service;
/*
Author: BeGieU
Date: 05.03.2020
*/

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import plywacz.openx.exceptions.RemoteApiException;
import plywacz.openx.exceptions.UrlException;
import plywacz.openx.model.Post;
import plywacz.openx.model.User;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

@Component
public class DataDownloaderImpl implements DataDownloader {
    private final ObjectMapper mapper;
    private URL userDataUrl;
    private URL postDataUrl;

    public DataDownloaderImpl() {
        mapper = new ObjectMapper();

        try {
            userDataUrl = new URL(USER_SOURCE);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new UrlException("couldnt create URL with address: " + USER_SOURCE, e);
        }

        try {
            postDataUrl = new URL(POST_SOURCE);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new UrlException("couldnt create URL with address: " + POST_SOURCE, e);
        }
    }

    @Override
    public Set<User> fetchUserData() {
        Set<User> userSet;
        try {
            userSet = mapper.readValue(userDataUrl, new TypeReference<Set<User>>() {
            });
        }
        catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
            throw new RemoteApiException("couldnt parse obtained data from URL: \n " + userDataUrl, e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RemoteApiException("couldnt fetch user data from Api with URL: \n" + userDataUrl,e);
        }
        if (userSet == null) {
            throw new RemoteApiException("remote api returned no user data from URL: \n" + userDataUrl);
        }

        return userSet;
    }

    @Override
    public Set<Post> fetchPostData() {
        Set<Post> postSet;
        try {
            postSet = mapper.readValue(postDataUrl, new TypeReference<Set<Post>>() {
            });
        }
        catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
            throw new RemoteApiException("couldnt parse obtained data from URL: \n " + postDataUrl, e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RemoteApiException("couldnt fetch post data from  Api with URL: \n" + postDataUrl,e);
        }

        if (postSet == null) {
            throw new RemoteApiException("remote api returned no user data from URL: \n" + postDataUrl);
        }

        return postSet;
    }

}
