package plywacz.openx.service;
/*
Author: BeGieU
Date: 06.03.2020
*/

import org.springframework.stereotype.Component;
import plywacz.openx.dto.ClosestUserPairDto;
import plywacz.openx.model.UserPostContainer;

import java.util.List;
import java.util.Set;

@Component
public class DataServiceFacadeImpl implements DataServiceFacade {
    private final DataDownloader dataDownloader;
    private final DataManipulator dataManipulator;

    public DataServiceFacadeImpl(DataDownloader dataDownloader, DataManipulator dataManipulator) {
        this.dataDownloader = dataDownloader;
        this.dataManipulator = dataManipulator;
    }

    @Override public Set<UserPostContainer> getJoinedData() {
        return dataManipulator.joinData(dataDownloader.fetchUserData(),
                dataDownloader.fetchPostData());
    }

    @Override public List<String> getPostsCount() {
        return dataManipulator.countPosts(
                dataManipulator.joinData(dataDownloader.fetchUserData(),
                        dataDownloader.fetchPostData()));
    }

    @Override public List<String> findDuplicateTitles() {
        return dataManipulator.findDuplicateTitles(dataDownloader.fetchPostData());
    }

    @Override public Set<ClosestUserPairDto> findClosestUsers() {
        return dataManipulator.findClosestUser(dataDownloader.fetchUserData());
    }
}
