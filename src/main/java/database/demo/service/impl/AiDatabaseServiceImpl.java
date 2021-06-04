package database.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zaxxer.hikari.HikariDataSource;
import database.demo.entity.AiDatabase;
import database.demo.mapper.AiDatabaseMapper;
import database.demo.service.IAiDatabaseService;
import database.demo.util.datasource.DataSourceManager;
import database.demo.vo.TableField;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 数据库表 服务实现类
 * </p>
 *
 * @author zhang
 * @since 2021-06-04
 */
@Service
public class AiDatabaseServiceImpl extends ServiceImpl<AiDatabaseMapper, AiDatabase> implements IAiDatabaseService {

    /**
     * 查询所有数据库信息
     *
     * @return 数据库列表
     */
    @Override
    public ResponseEntity<List<AiDatabase>> queryAll() {
        return ResponseEntity.ok(baseMapper.selectList(null));
    }

    /**
     * 根据ID查询详情
     *
     * @param id id
     * @return 数据库列表
     */
    @Override
    public ResponseEntity<AiDatabase> queryById(String id) {
        return ResponseEntity.ok(baseMapper.selectById(id));
    }

    /**
     * 建立数据库连接
     *
     * @param id id
     * @return 结果
     */
    @Override
    public ResponseEntity<String> connection(String id) {
        AiDatabase database = baseMapper.selectById(id);
        if (database != null) {
            //获取指定数据库连接
            HikariDataSource hikariDataSource = DataSourceManager.getHikariDataSource(database);
            //建立连接
            NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(hikariDataSource);
            //进行连接测试
            Integer query = jdbcTemplate.queryForObject("select 1 from dual", new HashMap<>(16),
                    Integer.class);
            System.out.println(query);
            //查看所有表
            List<String> tables = jdbcTemplate.queryForList("show tables", new HashMap<>(16), String.class);
            System.out.println(tables);
            //查看表结构
            List<TableField> tableFields = jdbcTemplate.query("desc " + tables.get(0),
                    new BeanPropertyRowMapper<>(TableField.class));
            System.out.println(tableFields);
            //TODO 更多操作直接发送指令即可
            return ResponseEntity.ok("成功");
        }
        return ResponseEntity.ok("出现错误，请刷新页面后重试");
    }
}
