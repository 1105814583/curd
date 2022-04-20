import com.github.pagehelper.PageInfo;
import com.lee.ssm.entity.Emp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author lee
 * @version 2022/4/19 13:14
 * @since JDK8
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestController {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void initMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void testSelectByPage() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/").param("pageNo", "100")).andReturn();
        MockHttpServletRequest request = mvcResult.getRequest();
        PageInfo page = (PageInfo<Emp>) request.getAttribute("pageInfo");
        System.out.println("当前页码" + page.getPageNum());
        System.out.println("总页码" + page.getPages());
        System.out.println("数据总数" + page.getTotal());
        System.out.println("页码列表" + Arrays.toString(page.getNavigatepageNums()));
         List<Emp> list = page.getList();
        for (Emp emp : list) {
            System.out.println(emp);
        }
        

    }
}