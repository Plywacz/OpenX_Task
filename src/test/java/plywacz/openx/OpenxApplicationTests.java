package plywacz.openx;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import plywacz.openx.service.DataServiceFacade;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class OpenxApplicationTests {
    public static final String API_PREFIX = "/api";
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    DataServiceFacade dataServiceFacade;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getJoinedData() throws Exception {
        mockMvc
                .perform(get(API_PREFIX + "/data"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].user.id", Matchers.is(Matchers.greaterThanOrEqualTo(0))))
                .andExpect(jsonPath("$.[0].posts[0].id", Matchers.is(Matchers.greaterThanOrEqualTo(0))));
    }

    @Test
    public void getPostsCount() throws Exception {
        mockMvc
                .perform(get(API_PREFIX + "/posts-count"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0]", Matchers.notNullValue(String.class)));
    }

    @Test
    public void getClosestUsers() throws Exception {

        mockMvc
                .perform(get(API_PREFIX + "/closest-users"))
                .andDo(MockMvcResultHandlers.print())
                //ids of one pair of closest users (checked in google maps)
                .andExpect(jsonPath("$.[0].firstUser.id", Matchers.is(Matchers.equalTo(8))))
                .andExpect(jsonPath("$.[0].secondUser.id", Matchers.is(Matchers.equalTo(4))));
    }

    @Test
    public void getDuplicatePostTitles() throws Exception {
        mockMvc
                .perform(get(API_PREFIX + "/duplicate-post-titles"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
