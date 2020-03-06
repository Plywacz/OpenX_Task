package plywacz.openx.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataDownloaderImplTest {

    DataDownloader dataDownloader;

    @BeforeEach
    void setUp() {
        dataDownloader=new DataDownloaderImpl();
    }

    @Test
    void fetchUserData_Success() {
        var set=dataDownloader.fetchUserData();
        assertNotNull(set);
    }

    @Test
    void fetchPostData_Success() {
        var set=dataDownloader.fetchPostData();
        assertNotNull(set);
    }
}