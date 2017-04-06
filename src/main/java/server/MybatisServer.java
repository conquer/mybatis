package server;

import com.google.common.util.concurrent.AbstractIdleService;
import com.mybatis.dao.UserDao;
import com.mybatis.data.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * Created by xionggp on 17/4/5.
 */
public class MybatisServer extends AbstractIdleService {

    private static final Logger LOG = LoggerFactory.getLogger(MybatisServer.class);

    private static SqlSessionFactory sqlSessionFactory;

    @Override
    protected void startUp() throws Exception {
        createSqlSessionFactory();
        List<User> userList = getUserList("xionggp");
        if (userList != null  && !userList.isEmpty()) {
            LOG.info("Success get user!");
        } else {
            LOG.info("Fail get user!");
        }
    }

    private List<User> getUserList(String username) {
        try {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            return userDao.getUserByName(username);
        } catch (Exception e) {
            LOG.error("getUserList", e);
        }

        return null;
    }


    private synchronized void createSqlSessionFactory() throws Exception {
        // create an SqlSessionFactory
        if (sqlSessionFactory == null) {
            try {
                Resource resource = new ClassPathResource("mybatis-config.xml");
                if (resource.exists()) {
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource.getFilename()));
                    sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
                }
            } catch (Exception e) {
                LOG.error("createSqlSessionFactory", e);
            }
        }
    }

    @Override
    protected void shutDown() throws Exception {

    }

    public static void main(String[] args) {
        LOG.info("Starting mybatis server!");
        MybatisServer mybatisServer = new MybatisServer();
        mybatisServer.startAsync().awaitRunning();
    }
}
